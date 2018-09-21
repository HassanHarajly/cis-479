import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int NUMBEROFROWS=6,NUMBEROFCOLUMNS=6;
		String Matrix[][] = new String[6][6];
		for (int rows=0;rows<NUMBEROFROWS;rows++)
		{
			for (int columns=0;columns<NUMBEROFCOLUMNS;columns++)
			{
				Matrix[rows][columns]="[]";
			}
		}
		Matrix[1][1]="##";Matrix[1][2]="##";Matrix[1][3]="##";Matrix[1][4]="##";
		Matrix[2][4]="##";Matrix[3][4]="##";Matrix[0][5]="G";
		Matrix[3][2]="00";
		/*for (int rows=0;rows<NUMBEROFROWS;rows++)
		{
			for (int columns=0;columns<NUMBEROFCOLUMNS;columns++)
			{
				System.out.print(Matrix[rows][columns]);
			}
			System.out.println('\n');
		}*/
		
		bfs(Matrix,3,2);
		PrintMatrix(Matrix,NUMBEROFROWS,NUMBEROFCOLUMNS);
		
	}

	public static void bfs(String[][] m, int rows, int columns)
	{
		
		boolean Boxedin=true;
		int MATRIXSIZE=m.length-1;
		int count=1;
		   Queue<Integer> intPQ = new LinkedList<Integer>();
		
		intPQ.add(rows);
		intPQ.add(columns);
		for (int i=0;i<1;)
		{	
			 Boxedin=true;
		if (columns-1<=MATRIXSIZE && columns-1>=0)
		{	if(m[rows][columns-1]=="[]" || m[rows][columns-1]=="G" )
			{
			if (m[rows][columns-1]=="G")
			{
				m[rows][columns-1]= Integer.toString(count);
				break;
			}
			intPQ.add(rows);
			intPQ.add(columns-1);
				m[rows][columns-1]= Integer.toString(count);
				count++;
				Boxedin=false;
				
			}
		}
		if (rows-1 <=MATRIXSIZE && rows-1>=0)
		{		if(m[rows-1][columns]=="[]" || m[rows-1][columns]=="G")
				{
			if (m[rows-1][columns]=="G")
			{
				m[rows-1][columns]= Integer.toString(count);
				break;
			}
			intPQ.add(rows-1);
			intPQ.add(columns);
				m[rows-1][columns]= Integer.toString(count);
				count++;
				Boxedin=false;
				
				}
				
		}
		if (columns+1<=MATRIXSIZE)
		{
				if(m[rows][columns+1]=="[]"|| m[rows][columns+1]=="G")
				{
					if (m[rows][columns+1]=="G")
					{
						m[rows][columns+1]= Integer.toString(count);
						break;
					}
					intPQ.add(rows);
					intPQ.add(columns+1);
				m[rows][columns+1]= Integer.toString(count);
				count++;
				Boxedin=false;
				
				}
		}
		if (rows+1<=MATRIXSIZE)
		{
				if(m[rows+1][columns]=="[]"|| m[rows+1][columns]=="G")
				{
					if (m[rows+1][columns]=="G")
					{
						m[rows+1][columns]= Integer.toString(count);
						break;
					}
					intPQ.add(rows+1);
					intPQ.add(columns);
				m[rows+1][columns]= Integer.toString(count);
				count++;
				Boxedin=false;
				
				}
		}
		if(Boxedin)
		{		
				if (intPQ.size()>=0 && m[rows][columns]!="G")
				{
					
					
					rows=intPQ.remove();
					columns=intPQ.remove();
				}
		}
			
		
	
		}
		
		
	}
	public static void PrintMatrix(String[][] m, int rowsize, int columnsize)
	{
		
		for (int rows=0;rows<rowsize;rows++)
		{
			for (int columns=0;columns<columnsize;columns++)
			{
				//String temp;
				//temp=m[rows][columns].toString();
				//Integer x = Integer.valueOf(temp);
				if (m[rows][columns]!="[]" && m[rows][columns]!="##" && m[rows][columns]!="G" &&m[rows][columns]!="00" )
				{
					String temp;
					temp=m[rows][columns].toString();
					//Integer x = Integer.valueOf(temp);
					int x=Integer.valueOf(temp);
					if (x<10)
				{
					System.out.print(" 0"+m[rows][columns]);
				}
					else
					{
						System.out.print(" "+m[rows][columns]);
					}
				}
				else
					{
						System.out.print(" "+m[rows][columns]);
					}
			}
			System.out.println('\n');
		}
	}
		
}
