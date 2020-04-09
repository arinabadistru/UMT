# Number of rectangles app

 This program receives as inputs a set of points in Cartesian coordinate (X,Y) and returns as output the number of rectangles that can be created by those points. 


# Steps

StackEdit stores your files in your browser, which means all your files are automatically saved locally and are accessible **offline!**

### Read from file

Firstly, I created a method **readFile()** to read from a file the sample input. I assumed that the format of the input is the one given as an example.

### Generate possible corners

Then, I generated two methods:
*    **generateLeftUp**: this method generates a list with all the elements that could be the left up corner of a rectangle that has the left down corner a certain point.
*    **generateRightDown**: this method generates a list with all the elements that could be the right down corner of a rectangle that has the left down corner a certain point.

### Verify last corner

 Using these methods for each point of the array, there is only one point left to generate (using the **leftUp** and the **rightDown**) and verify: the **right up corner**. If the initial array contains this point, a rectangle is formed and a **counter** increments.   

### Printing the result
The final number of rectangles that can be created is printed on the console.


## Visual representation of the solution

     2.leftUp corner ------------------> 4.rightUp corner (using 2. and 3.)
            ^				     ^
            |				     |
            |				     |
            |				     |
            |                                    |
     1. leftDown corner --------------> 3.rightDown corner


