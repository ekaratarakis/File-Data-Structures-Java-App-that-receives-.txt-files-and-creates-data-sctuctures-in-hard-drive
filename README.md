# File-Data-Structures-Java-App-that-receives-.txt-files-and-creates-data-sctuctures-in-hard-drive
This application gets as an input any .txt file and creates a data structure in the hard drive directly. This data structure answers in questions like "Can you find items containing this word?" or "Can you find items containing that word?". Also, the data structure is composed of a **Dictionary** and an **Index**.

## Building the data structure in main memory
At first we have to find all the words containing the the .txt files and build the data structure in the main memory. The dictionary is an array that contains all the words from all the .txt files. Dublicates are not allowed. The array is sorted alphabetically. Every word is represented as a string together with an integer. The value of the integer is decided as soon as the data structure is copied to the hard drive. Every word points to a different location in the index. In main memory the index is a list.

## Building the data structure in the hard drive
Now its time to copy the data structure to the hard drive directly using the instructions below.
* Every file page has a size of 128 bytes. We have to build a buffer in the main memory and start filling it with words (pairs of String - integer) from the dictionary. When the buffer is full we can write a new file page at the end of the file. Subsequently we are emptying the buffer and start over until every word from the dictionary is copied to the file.
* The index is a file whose pages contain stored elements of type **("Name of file".txt - "#bytes from the beginning of the document")**. For example the word "Apple" is a pair with the integer "2" meaning that it points to the 2nd page of the index. If a word exist in the dictionary then there must be at least one page for it in the index.
* Every entry in the index has a size of 12 bytes thus 8 bytes for the "Name of file.txt" and 4 bytes for the "#bytes from the beginning of the document". The index is composed of pages of 128 bytes. Thus, every page fits 10 entries and we have 8 extra bytes spare space. 4 of these extra bytes will be used to connect the file pages.
* If a word is repeated frequentlly in the .txt files then it might has many entries in the index that cannot fit in one file page. As soon as a page is full, a new page is created at the end of the file and this new page is connected to that full page.

## Search in the data structure
Finally, we need a part of this Java app to support the functionality of searching the data structure by entering a specific word as an input and get all the files that contain it and all the positions of the word in them as an output. This will be done using the instructions below
* At first we have to write a function that performs **Binary Search** in a file and finds any word in the dictionary. In order to do that we can read the middle page from the dictionary by bringing it to the main memory (sth that costs 1 drive access) and perform the binary search in to that page (sth that does not cost anything in drive accesses). If the word is found then the function returns the "Name of file.txt" and the integer "#bytes from the beginning of the document". If the word is not found then we keep searching in the middle page from the left or the right half of the file depending on if the word we are lookin for is alphabetically before or after the words in the middle page of the file. We continue the same procedure if needed.
* Every page reading costs a hard drive access. Every page reading in the index also costs a hard drive access. The output on the screen must be like this,  
    **document "c.txt" contains the word apple in position 3**  
    **document "a.txt" contains the word apple in position 5**  
    **document "b.txt" contains the word apple in position 18**  
    **document "c.txt" contains the word apple in position 120** 
* For every search a number **k** should be returned that stands for how many hard drive accesses costed that search.
