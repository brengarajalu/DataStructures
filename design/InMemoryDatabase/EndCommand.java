package InMemoryDatabase;

public class EndCommand implements Command {

	 @Override
	    public void execute(DataContainer dataContainer) {
	        System.exit(0);
	    }

}
