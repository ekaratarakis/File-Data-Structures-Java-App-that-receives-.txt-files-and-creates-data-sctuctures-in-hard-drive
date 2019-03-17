package data_structures_in_hard_drive;

import java.util.Scanner;
import java.io.File;
//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;			
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class My_Main 
{
	public String My_Array2[];
	public String Dictionary[][];
	static FileInputStream fis = null;
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException
	{
		Read_Files rf = new Read_Files();
		String My_Array2[] = rf.readTheFiles();
		
	    MyLinkedList ml = new MyLinkedList();
		String Dictionary[][] = ml.fillTheList(My_Array2);
		//ml.outputList();
		System.out.println(ml.sizeOfList());	
		//ml.sizeOfList();
		
	    My_File mf = new My_File();
		mf.initializeAndFillFile(Dictionary);
		
		String input;
		byte[] tempInput;
		Scanner in = new Scanner(System.in);
		System.out.println("\nPlease enter the word you would like to search for!");
		input = in.nextLine(); 
		
		BinarySearch bs = new BinarySearch();
		bs.Binary_Search(input);
	
		//System.out.println(Arrays.toString(FinalArray));	
	}
}
