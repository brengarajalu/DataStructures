package DynamicProgramming;

public class RodCutting {

	public RodCutting() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] value = { 2, 3, 7, 8, 9 };
		int len = 5;
		System.out.println("Max profit for length is " + len + ":"
				+ NumOfWaysToCutRodWithProfit(value, len));

	}
	
	private static int NumOfWaysToCutRodWithProfit(int[] value, int length)
	{
		
		int[] solution = new int[length+1];	
		
		solution[0] = 0;
		
		for(int i=1; i<= length ; i++)
		{
			int max = -1;
			for(int j=0; j< i;j++)
			{
				max  = Math.max(max, value[j]+solution[i-(j+1)]);
				solution[i] = max;
			}
			
			
			
			
		}
		
		return solution[length];
		
		
	}

}
