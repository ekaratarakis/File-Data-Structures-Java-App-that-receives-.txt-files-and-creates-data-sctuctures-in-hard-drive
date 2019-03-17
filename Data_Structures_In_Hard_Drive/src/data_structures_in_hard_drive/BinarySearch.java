package data_structures_in_hard_drive;

import java.util.Scanner;
import java.io.File;
//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;			
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class BinarySearch 
{
	FileInputStream fis = null;
	File inFile = new File("BinFile.bin");
	
	public String Binary_Search(String input)
	{
		byte[] tempInput;
		tempInput = input.getBytes();
		//System.out.println(tempInput);
		String stringToken = null;
		
		try
		{
			fis = new FileInputStream(inFile);
			Scanner sc = new Scanner(new File("C:/BinFile.bin"));
			byte token;
			int counter = 0;
			while(sc.hasNextByte())
			{
				System.out.println("testing");
				token = sc.nextByte();
				if(token == 0) //check for empty line of the file
			    {
			    	counter++;
			    }
				else 
				{
					for(int i = 0; i < tempInput.length; i++)
					{
						if(token == tempInput[i])
						{
							System.out.println("The input word was found ");
							stringToken = Byte.toString(token);
							System.out.println(stringToken);
						}
					}
				}
			}
			
		}
		catch(IOException ex)
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
		return stringToken;
	}
}
