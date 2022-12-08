import java.util.ArrayList;
import java.io.*;

public class lab13 {

	private ArrayList<Integer> num;
	public void readData(String filename)
	{
		num = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));	
			String inn;
			while((inn = br.readLine()) != null) {
				num.add(Integer.valueOf(inn.trim()));
			}	
			br.close();
		}
		catch(Exception e) {
			
		}
	}
	
	public long getTotalCount()
	{
		return num.stream().count();
	}
	public long getOddCount()
	{
		return num.stream()
		.filter(n -> n % 2 != 0).count();
		
	}
	public long getEvenCount()
	{
		return num.stream()
		.filter(n -> n % 2 == 0).count();
		
	}
	public long getDistinctGreaterThanFiveCount()
	{
		return num.stream()
		.distinct()
		.filter(n -> n > 5).count();
	}
	public Integer[] getResult1() 
	{
		return num.stream()
		.filter(n -> n % 2 == 0)
		.filter(n -> n >5)
		.filter(n -> n < 50)
		.sorted()
		.toArray(Integer[]::new);
	}
	public Integer[] getResult2()
	{
		return num.stream()
		.map(n -> n*n*3)
		.limit(50)
		.toArray(Integer[]::new);
	}
	public Integer[] getResult3()
	{
		return num.stream()
		.filter(n -> n % 2 != 0)
		.map(n -> n*2)
		.sorted()
		.skip(20)
		.distinct()
		.toArray(Integer[]::new);
	}
}
