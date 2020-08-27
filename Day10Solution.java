import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Day10Solution{
	public static void main(String[] args){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try{
			int t=Integer.parseInt(br.readLine().trim());
			for(int i=0; i<t; i++){
				int n=Integer.parseInt(br.readLine().trim());
				float[] GPA=new float[n];
				float total=0.0f;
				String[] words=br.readLine().trim().split(" ");
				for(int j=0; j<n; j++){
					GPA[j]=Float.parseFloat(words[j]);
					total+=GPA[j];
				}
				float GPAAvg=total/n;
				float[][] at=new float[5][n];
				float[] atAvg=new float[5];
				for(int j=0; j<5; j++){
					total=0.0f;
					words=br.readLine().trim().split(" ");
					for(int k=0; k<words.length; k++){
						at[j][k]=Float.parseFloat(words[k]);
						total+=at[j][k];
					}
					atAvg[j]=total/n;
				}
				float[] var=new float[5];
				for(int j=0; j<5; j++){
					total=0.0f;
					for(int k=0; k<words.length; k++){
						total+=(at[j][k]-atAvg[j])*(GPA[k]-GPAAvg);
					}
					var[j]=total/n;
				}
				float arr=var[0];
				int arrIndex=0;
				for(int j=1; j<5; j++){
					if(var[j]>arr){
						arr=var[j];
						arrIndex=j;
					}
				}
				System.out.println((arrIndex+1));
			}
		}catch(NumberFormatException nfe){
			System.out.println("NumberFormatException message:"+nfe.getMessage());
		}catch(IOException ioe){
			System.out.println("IOException message:"+ioe.getMessage());
		}
	}
}
