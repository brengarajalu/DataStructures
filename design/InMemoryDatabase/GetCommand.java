package InMemoryDatabase;

import java.io.IOException;

public class GetCommand implements Command {
    private String name;

    private static final String VALUE_NOT_FOUND = "NULL";

    public GetCommand(String name) {
        this.name = name;
    }

    @Override
    public void execute(DataContainer container) {
        Data data = container.getData();
        TransactionManager transactionManager = container.getTransactionManager();

        if (data.isKeyDeleted(name)) {
            //key is marked as deleted in a transaction
            System.out.println(VALUE_NOT_FOUND);
        } else {
            //find key in most recent transaction
            String value = data.getKeyValue(name);
            if (value == null) {
                value = transactionManager.getMostRecentValueForKey(name);
            }

            if (value == null) {
                System.out.println(VALUE_NOT_FOUND);
            } else {
                System.out.println(value);
                //cache found value
                try {
					data.setData(name, value);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
    }

}