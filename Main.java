/*
Name:
Date: 11/30/2025
Assignment: Matrix Addition Pt.1 
Purpose: Get input from file.  Parse into arrays.  Setup multi-threaded program.
FileNames: "Main.java, ThreadOperation.java"


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

A1: Threads share the same memory space so memory between threads can be shared. This is in contrast to the overhead of spawning new processes which require their own memory space.  Additionally, if a thread is blocked by waiting for I/O, or user input, another thread in the same application that is ready for processing can use the CPU, maximizing CPU.

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
		
		System.out.println("Printing matrix A: ");
		printMatrix(matrixA);
		System.out.println("Printing matrix B: ");
		printMatrix(matrixB);
		
		ThreadOperation t1 = new ThreadOperation(matrixA,matrixB,1);
		ThreadOperation t2 = new ThreadOperation(matrixA,matrixB,2);
		ThreadOperation t3 = new ThreadOperation(matrixA,matrixB,3);
		ThreadOperation t4 = new ThreadOperation(matrixA,matrixB,4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
		
	}
	
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) { 
            for (int j = 0; j < matrix[i].length; j++) { 
                System.out.print(matrix[i][j] + " "); 
            }
            System.out.println();
		}//Endfor
		System.out.println();
		
	}//End method printMatrix

}