package data_structures_in_hard_drive;

import java.io.*;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Arrays;

public class My_File 
{
///////////////////////////////////////////////////////////////////////////////////////////	
////////////////////////////METHOD TO CREATE BINARY FILE .bin ////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
	public String initializeAndFillFile(String[][] SecFinalArray) throws IOException
	{
		byte[] transfer = new byte[12];
	    byte[] Buffer = new byte[128]; // Buffer of 128 bytes
	   	int i, j;
	   	System.out.println("A binary file 'BinFile.bin', that contains all the String - Integer pairs from the Dictionary will be created.\n");
	   	System.out.println("***************************************** :) \n");
	   
	   	try
	   	{
	   		RandomAccessFile file= new RandomAccessFile("BinFile.bin", "rw");
		   	for(i=1; i<10; i++)
		   	{
		   		for(j=0; j<2; j++)
		    	{
		    		String temp = SecFinalArray[i][j];
		    		Buffer = temp.getBytes((Charset.defaultCharset()));    //(Charset.defaultCharset())
		    		if(file != null)
		    		{
		    			file.write(Buffer); //write the data of the Buffer into the file
		    		}		    			
		    	}
		    }
		   	//System.out.println("The length of the binary file is :" + file.length());
		    file.close(); //close the binary file
	    }
	    catch(FileNotFoundException e) // EXCEPTIONS
	    {
	    	System.out.println("Problem in opening file. Sorry!"); 
	    	e.printStackTrace();
	    }
	    catch(IOException e)
	    {
	    	System.out.println("Problems with the file I/O.");
	    	e.printStackTrace();
	    }
	    System.out.println("End of procedure. The binary file was successfully created in the hard drive C:/!\n"); 
	    return null;
	 }	 
	 
	/* public void print()
	 {
		 for (int i=0; i<SecFinalArray.length; i++)
		 {
			 for (int j =0; j<2; j++)
			 {
				 System.out.println(SecFinalArray[i][j]);
			 }
		 }
	 }*/
	 
	 //System.arraycopy(SecFinalArray, 0, Buffer, 0, 10);
}
