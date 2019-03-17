package data_structures_in_hard_drive;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Read_Files 
{
	File file1 = new File("C:/Obama.txt"); //The 3 files that will be opened
	File file2 = new File("C:/Kennedy.txt");
	File file3 = new File("C:/MartinLutherKing.txt");
	FileInputStream fis = null; //initialize fis to null
	private int WordsOfFile1=0;
	private int WordsOfFile2=0;
	private int WordsOfFile3=0;
	ArrayList <String> temps = new ArrayList <String>(); // ArrayList to store all the words of all files
	public String My_Array1[]; 
	 
	////////////// METHOD TO OPEN AND READ ALL THE 3 FILES //////////////
	public String[] readTheFiles() 
	{
		///////////////////////////////////////
		//// Read the words from Obama.txt ////
		///////////////////////////////////////
		System.out.println("Reading 3 files from C:/\n");
		try
		{
			fis = new FileInputStream(file1); // Obama.txt
			//System.out.println("Total size to read from the first file (in bytes) :" + file1.length());
			Scanner sc = new Scanner(new File("C:/Obama.txt"));
			String token1;
			int count1=0;
			
			while(sc.hasNextLine()) //reading the file with Scanner.util and its methods
			{
			    token1 = sc.nextLine();
			    
			    if(token1.isEmpty())
			    {
			    	count1++;
			    }
			    else
			    {
			    	count1 = count1 +1+token1.length();
			    	// we use replaceAll("[^a-zA-Z ]","") to remove commas, dots, etc
			    	// we use toLowerCase() to ignore UpperCase letters
				    token1 = token1.replaceAll("[^a-zA-Z ]","").toLowerCase();
				    String[] words = token1.split(" "); // split the words of each token		  	    
				    for(int i=0; i<words.length;i++)
				    {
				    	temps.add(words[i]);  //method add() of ArrayList for adding elements to the ArrayList
				    }			    
				    WordsOfFile1=WordsOfFile1 + words.length; // calculate words of 1st file
			    }
			}
			System.out.println("* 1st file was readed! Number of words in file Obama.txt (1st File): " + WordsOfFile1);
			sc.close(); // close the 1st file
		}
		catch (IOException ex) // EXCEPTIONS
		{
			ex.printStackTrace();
			System.out.println("Sorry! File Obama.txt not found");
			System.out.println("Or can't be opened");
		}
		finally
		{
			try
			{
				if(fis != null) {fis.close();} //check for empty or not found file
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
		
		/////////////////////////////////////////
		//// Read the words from Kennedy.txt ////
		/////////////////////////////////////////	
		try
		{
			fis = new FileInputStream(file2); //Kennedy.txt
			//System.out.println("Total size to read from the second file (in bytes) :" + fis.available());
			Scanner sc = new Scanner(new File("C:/Kennedy.txt"));
			String token2;
			int count2 = 0;
			
			while(sc.hasNextLine()) //reading the file with Scanner.util and its methods
			{
			    token2 = sc.nextLine();
			    
			    if(token2.isEmpty())
			    {
			    	count2++;
			    }
			    else
			    {
			    	count2 = count2 +1+token2.length();
			    	// we use replaceAll("[^a-zA-Z ]","") to remove commas, dots, etc
			    	// we use toLowerCase() to ignore UpperCase letters
				    token2 = token2.replaceAll("[^a-zA-Z ]","").toLowerCase();
				    String[] words = token2.split(" ");	// split the words of each token		    
				    for(int i=0; i<words.length;i++)
				    {
				    	temps.add(words[i]);  //method add() of ArrayList for adding elements to the ArrayList
				    }			    
				    WordsOfFile2=WordsOfFile2 + words.length; // calculate words of 2st file
			    }
			}
			System.out.println("* 2st file was readed! Number of words in file Kennedy.txt (2nd File): " + WordsOfFile2);
			sc.close(); // close the 2st file
		}
		catch (IOException ex) // EXCEPTIONS
		{
			ex.printStackTrace();
			System.out.println("Sorry! File Kennedy.txt not found");
			System.out.println("Or can't be opened");
		}
		finally
		{
			try
			{
				if(fis != null) {fis.close();} //check for empty or not found file
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
		
		//////////////////////////////////////////////////
		//// Read the words from MartinLutherKing.txt ////
		//////////////////////////////////////////////////
		try
		{
			fis = new FileInputStream(file3);
			//System.out.println("Total size to read from the third file (in bytes) :" + fis.available());
			Scanner sc = new Scanner(new File("C:/MartinLutherKing.txt"));
			String token3;
			int count3=0;
			
			while(sc.hasNextLine()) //reading the file with Scanner.util and its methods
			{
			    token3 = sc.nextLine(); 
			    
			    if(token3.isEmpty())
			    {
			    	count3++;
			    }
			    else
			    {
			    	count3 = count3 + 1 + token3.length();
			    	// we use replaceAll("[^a-zA-Z ]","") to remove commas, dots, etc
			    	// we use toLowerCase() to ignore UpperCase letters
				    token3 = token3.replaceAll("[^a-zA-Z ]","").toLowerCase();
				    String[] words = token3.split(" "); // split the words of each token			    
				    for(int i=0; i<words.length;i++)
				    {
				    	temps.add(words[i]); //method add() of ArrayList for adding elements to the ArrayList
				    }			    
				    WordsOfFile3 = WordsOfFile3 + words.length; // calculate words of 3st file
			    }
			}
			System.out.println("* 3rd file was readed! Number of words in file MartinLutherKing.txt (3rd File): " + WordsOfFile3);
			sc.close(); // close the 3st file
		}
		catch (IOException ex) // EXCEPTIONS
		{
			ex.printStackTrace();
			System.out.println("Sorry! File MartinLutherKing.txt not found");
			System.out.println("Or can't be opened");
		}
		finally
		{
			try
			{
				if(fis != null) {fis.close();} //check for empty or not found file
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}

////////////////////////////////////////////////////////////////////////////
////////////////////// WORK WITH THE ARRAYLIST /////////////////////////////	
////////////////////////////////////////////////////////////////////////////
		
		int size = WordsOfFile1 + WordsOfFile2 + WordsOfFile3; //total length of ArrayList
		int duplicates = 0; // duplicates flag
		for (int i = 0; i < size - 1; i++)
		{
			for (int j = i + 1; j < size; j++) 
		    {
		        if (!temps.get(j).equals(temps.get(i)))
		            continue;
		            duplicates++;
		            temps.remove(j); //remove duplicates from the ArrayList
		            j--;
		            size--;
		    } 
		} 
		String My_Array1[] = new String[temps.size()];
		My_Array1 = temps.toArray(My_Array1); //convert the ArrayList to a simple Array
	
		Arrays.sort(My_Array1); //sort the words of My_Array1 to alphabetical order
		
		//we can print the sorted My_Array1 using the System.out.println() below if needed
		System.out.println("\nThe sorted array, which has all the words from the files and is the 1st row of the Dictionary is:\n");
		System.out.println(Arrays.toString(My_Array1));
		
		return My_Array1; //return value of this method
	}

}
