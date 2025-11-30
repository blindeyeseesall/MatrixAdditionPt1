/*
This code is provided to give you a
starting place. It should be modified.
No further imports are needed.
To earn full credit, you must also
answer the following question:

Q1: One of the goals of multi-threading
is to minimize the resource usage, such
as memory and processor cycles. In three
sentences, explain how multi-threaded
code accomplishes this goal. Consider
writing about blocking on I/O, multicore 
machines, how sluggish humans are,
threads compared to processes, etcetera,
and connect these issues to 
multi-threading.

*/
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main
{
	public static void main(String[] args) 
	{
		String filename = "";
		 //Check to see if we have an argument provided on the command line.  If not, quit the program.
		 if (args.length > 0) {
            filename = args[0];
			
		 } else {
            System.out.println("Qutting... Provide an input filename on the command line.");
			System.exit(0);
		 }
		 
		int matrixRow = 0;
		int matrixCol = 0;
		int[][] matrixA = null;
		int[][] matrixB = null;
		
		//Read in the input....
		try  {
			
			//Open the file 
            File file = new File(filename);
			Scanner input = new Scanner(file);
			matrixRow = input.nextInt();
			matrixCol = input.nextInt();
			matrixA = new int[matrixRow][matrixCol];
			matrixB = new int[matrixRow][matrixCol];
			
			for (int i = 0; i<matrixRow; i++) {
				for (int j = 0; j<matrixCol; j++) {
					matrixA[i][j] = input.nextInt();
				}
			}
			for (int i = 0; i<matrixRow; i++) {
				for (int j = 0; j<matrixCol; j++) {
					matrixB[i][j] = input.nextInt();
				}
			}
			
		} catch (FileNotFoundException e) {
		  System.out.println("An error occurred.");
		  e.printStackTrace();
		}//End Try-Catch Input block
		
		printMatrix(matrixA);
		printMatrix(matrixB);
		
		ThreadOperation t1 = new ThreadOperation();
		ThreadOperation t2 = new ThreadOperation();
		
		t1.start();
		t2.start();
		
		
	}
	
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) { 
            for (int j = 0; j < matrix[i].length; j++) { 
                System.out.print(matrix[i][j] + " "); 
            }
            System.out.println();
		}//Endfor
	}//End method printMatrix

}