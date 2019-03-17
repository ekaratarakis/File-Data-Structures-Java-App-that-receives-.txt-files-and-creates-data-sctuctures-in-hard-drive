# File-Data-Structures-Java-App-that-receives-.txt-files-and-creates-data-sctuctures-in-hard-drive
This application gets as an input any .txt file and creates a data structure in the hard drive directly. This data structure answers in questions like "Can you find items containing this word?" or "Can you find items containing that word?". Also, the data structure is composed of a **Dictionary** and an **Index**.

## Building the data structure in main memory
At first we have to find all the words containing the the .txt files and build the data structure in the main memory. The dictionary is an array that contains all the words from all the .txt files. Dublicates are not allowed. The array is sorted alphabetically. Every word is represented as a string together with an integer. The value of the integer is decided as soon as the data structure is copied to the hard drive. Every word points to a different location in the index. In main memory the index is a list.

## Building the data structure in the hard drive
Now its time to copy the data structure to the hard drive directly using the instructions below.
* Every file page has a size of 128 bytes. We have to build a buffer in the main memory and start filling it with words (pairs of String - integer) from the dictionary. When the buffer is full we can write a new file page at the end of the file. Subsequently we are emptying the buffer and start over until every word from the dictionary is copied to the file.
* The index is a file whose pages contain stored elements of type **("Name of file".txt - #bytes from the beginning of the document)**. For example the word "Apple" is a pair with the integer "2" meaning that it points to the 2nd page of the index. If a word exist in the dictionary then there must be at least one page for it in the index.
