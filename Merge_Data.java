import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Merge_Data {

	public static void main(String[] args) {
		
		try
		{
			BufferedReader br=new BufferedReader(new FileReader("data/u.data"));			
			BufferedWriter bw=new BufferedWriter(new FileWriter("data/MoviesFinal.csv"));
			
			String line;
			while((line= br.readLine()) != null )
			{
				String[] values=line.split("\\t",-1);
				//user_id	,	movie_id	,	rating	
				bw.write(values[0] + "," + values[1] + "," + values[2] +"\n");
		
			}
			
			br.close();
			bw.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}

}
