package data_structures_in_hard_drive;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MyLinkedList 
{
	private Node head;  //head node of the list
	FileInputStream fis = null;
	File file1 = new File("C:/Obama.txt"); //The 3 files that will be opened
	File file2 = new File("C:/Kennedy.txt");
	File file3 = new File("C:/MartinLutherKing.txt");
	private String str1 = "Obama.txt"; //strings inputs for the 1st row of the dictionary array
	private String str2 = "Kennedy.txt";
	private String str3 = "MartinLutherKing.txt";
	private String[][] FinalArray; //dictionary with string - integer pairs

    public MyLinkedList()
    {
    	this.head = null; //initialize head
    }
    
    //method for adding nodes to the list
    public void addToStart(String[] itemName, int[] itemNum)
    {
    	head = new Node(itemName, itemNum, head); //call constructor of internal class Node
    }
    
  //calculate the final size of the list if needed
    public int sizeOfList()
    {
    	int count = 0;
    	Node position = head;
    	while(position != null)
    	{
    		count++;
    		position = position.getNext();
    	}
    	return count;
    }
    
    //prints all the nodes of the list
    public void outputList()
    {
    	Node position = head;
    	while(position != null)
    	{
    		String[] titem = position.getItem();
    		int[] tnor = position.getNumOfReferences();
    		
    		for(int k=0;k<titem.length;k++)
    		{
    			System.out.println("("+titem[k]+", "+tnor[k]+")");
    		}
    		System.out.println("("+position.getItem()+", "+position.getNumOfReferences()+")");
    		position = position.getNext();
    	}
    }

//////////////////////////////////////////////////////////////////////
/////////////////////// INTERNAL CLASS NODE //////////////////////////    
//////////////////////////////////////////////////////////////////////
    
    public class Node 
    {
    	private String[] item ; //array of Strings : "nameOfFile.txt"
    	private int[] numOfReferences; //array of integer : number of a specific page
        private Node next; //points to the next node

        public Node() //CONSTRUCTOR of class Node - NO arguments
        {
        	next = null;
        	item = null;
        	Arrays.fill(numOfReferences , 0); //bytes from the start of the file
        }
        
        //CONSTRUCTOR called by addToStart() method
        public Node(String[] newItem, int[] newNumOfReferences, Node nextValue)
        {
        	setData(newItem, newNumOfReferences);
        	next = nextValue;
        }
        
        ////////////// SETTERS - GETTERS //////////////
        public void setData(String[] newItem, int[] newNumOfReferences)
        {
        	item = newItem;
        	numOfReferences = newNumOfReferences;
        }
        
        public void setNext(Node newNext)
        {
        	next = newNext;
        }
        
        public String[] getItem()
        {
        	return item;
        }
        
        public int[] getNumOfReferences()
        {
        	return numOfReferences;
        }
        
        public Node getNext()
        {
        	return next;
        }
    } //END OF CLASS NODE
    
///////////////////////////////////////////////////////////////////////
///////////////////////// FILL THE LIST ///////////////////////////////
///////////////////////////////////////////////////////////////////////
    
    public String[][] fillTheList(String My_Array2[])
    {
    	System.out.println("\n******************** Start creating the list - index ********************");
    	int currentNode = 0;
    	String[] txt = new String[10]; 
    	int[] bytesFromStart = new int[10];
        FinalArray = new String[My_Array2.length][2];
    	
    	for(int i = 1; i < My_Array2.length; i++) //because My_Array2[0] = ""
    	{
    		int timesCounter = 0;
    		int foundFirst=0; //flag
    		try
	    	{
	    		fis = new FileInputStream(file1); //opening the 1st file 
	    		Scanner sc = new Scanner(new File("C:/Obama.txt"));
	    		int  count1 = 0;
	    		String token1;
				while(sc.hasNextLine()) //reading the file with Scanner.util and its methods
				{
					token1 = sc.nextLine();
				    
				    if(token1.isEmpty()) //check for empty line of the file
				    {
				    	count1++;
				    }
				    else
				    {
					    String[] words = token1.split(" "); //split the tokens of each line
					    for(int j = 0; j < words.length; j++)
					    {
					    	//we use replace("[^a-zA-Z ]","") to remove commas, dots, etc 
					    	//we use equalsIgnoreCase() to ignore the UpperCase letters
					    	if(words[j].replaceAll("[^a-zA-Z ]","").equalsIgnoreCase(My_Array2[i]))
						    {
					    		txt[timesCounter] = str1; //Obama.txt
					    		bytesFromStart[timesCounter] = count1+1;
					    		timesCounter++;
					    		if(foundFirst == 0)
					    		{
					    			//add the 2nd row with the integers to the dictionary
					    			FinalArray[i][1] = Integer.toString(currentNode);
					    			foundFirst = 1;
					    		}
					    		if(timesCounter == 10)
					    		{
					    			timesCounter = 0;
					    			currentNode++;
					    			addToStart(txt, bytesFromStart); //add the nodes to the list
					    			Arrays.fill(txt, null); //initialize again the temporary txt and bytesFromStart arrays
					    			Arrays.fill(bytesFromStart, -1);
					    		}
						    }
					    	count1 = count1 + 1 + words[j].length(); //calculate number of bytes
					    }
					    Arrays.fill(words, null); //fill words array with null so that we can reuse it
				    }
				}
				sc.close(); //close the 1st file
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
	    		catch (IOException ex)
	    		{
	    			ex.printStackTrace();
	    		}
	    	}
    	
    		try
	    	{
	    		fis = new FileInputStream(file2); //opening the 2nd file
	    		Scanner sc = new Scanner(new File("C:/Kennedy.txt"));
	    		int  count2 = 0; 
	    		String token2;
	    		
				while(sc.hasNextLine()) //reading the file again with Scanner.util and its methods
				{
					token2 = sc.nextLine();
				    
				    if(token2.isEmpty()) //check for empty line of the file
				    {
				    	count2++; //increase counter
				    }
				    else
				    {				    	
					    String[] words = token2.split(" "); //split the tokens of each line
					    for(int j = 0; j < words.length; j++)
					    {
					    	//we use replace("[^a-zA-Z ]","") to remove commas, dots, etc 
					    	//we use equalsIgnoreCase() to ignore the UpperCase letters
					    	if(words[j].replaceAll("[^a-zA-Z ]","").equalsIgnoreCase(My_Array2[i]))
						    {
					    		txt[timesCounter] = str2; //Kennedy.txt
					    		bytesFromStart[timesCounter] = count2+1;
					    		timesCounter++;
					    		if(foundFirst == 0)
					    		{
					    			//continue adding the 2nd row with the integers to the dictionary
					    			FinalArray[i][1] = Integer.toString(currentNode);
					    			foundFirst = 1;
					    		}
					    		if(timesCounter == 10)
					    		{
					    			timesCounter = 0;
					    			currentNode++; // increase currentNode to the next Node
					    			addToStart(txt, bytesFromStart); //add the nodes to the list
					    			Arrays.fill(txt, null);
					    			Arrays.fill(bytesFromStart, -1);
					    		}					    		
						    }
					    	count2 = count2 + 1 + words[j].length(); //calculate number of bytes
					    }
					    Arrays.fill(words, null); //fill words array with null so that we can reuse it
				    }		 				    
				}
				sc.close(); //close file Kennedy.txt
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
	    		catch (IOException ex)
	    		{
	    			ex.printStackTrace();
	    		}
	    	}
	    	
    		try
	    	{
	    		fis = new FileInputStream(file2); //opening the 3nd file
	    		Scanner sc = new Scanner(new File("C:/MartinLutherKing.txt"));
	    		int  count3 = 0;
	    		String token3;
	    		
				while(sc.hasNextLine()) //reading the file again with Scanner.util and its methods
				{
					token3 = sc.nextLine();
				    
				    if(token3.isEmpty()) //check for empty line of the file
				    {
				    	count3++; //increase counter
				    }
				    else
				    {				    	
					    String[] words = token3.split(" ");
					    for(int j = 0; j < words.length; j++)
					    {
					    	//we use replace("[^a-zA-Z ]","") to remove commas, dots, etc 
					    	//we use equalsIgnoreCase() to ignore the UpperCase letters
					    	if(words[j].replaceAll("[^a-zA-Z ]","").equalsIgnoreCase(My_Array2[i]))
						    {
					    		txt[timesCounter] = str3; //"MartinLutherKing.txt"
					    		bytesFromStart[timesCounter] = count3+1;
					    		timesCounter++;
					    		if(foundFirst == 0)
					    		{
					    			//continue adding the 2nd row with the integers to the dictionary
					    			FinalArray[i][1] = Integer.toString(currentNode);
					    			foundFirst = 1;
					    		}
					    		if(timesCounter == 10)
					    		{
					    			timesCounter = 0;
					    			currentNode++; // increase currentNode to the next Node
					    			addToStart(txt, bytesFromStart); //add the nodes to the list
					    			Arrays.fill(txt, null);
					    			Arrays.fill(bytesFromStart, -1);
					    		}					    		
						    }
					    	count3 = count3 + 1 + words[j].length(); //calculate number of bytes
					    }
					    Arrays.fill(words, null); //fill words array with null so that we can reuse it
				    }		 				    
				}
				sc.close();
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
	    		catch (IOException ex)
	    		{
	    			ex.printStackTrace();
	    		}
	    	}
    	}
    	System.out.println("\nThe list was successfully created");
    	System.out.println("The Dictionary is ready to use!\n");
    	
    	/*This for - loop fills the 1st row of the FinalArray/Dictionary
    	with all the words of all the files with no duplicates and in alphabetical order.
    	The words are stored into My_Array2, which has the values of My_Array1, which 
    	was created by readTheFiles() method in Read_Files class.*/    	
    	for(int j = 0; j < My_Array2.length; j++)
    	{
    		FinalArray[j][0] = My_Array2[j];    		
    	}
    	
    	//We can print all the elements of the Dictionary with this loop if needed
    	for(int j = 0; j < My_Array2.length; j++)
    	{
    		//System.out.println(FinalArray[j][0]+" "+FinalArray[j][1]); 
    	}
    	return FinalArray; //return item of this method
    }   
}
