# Project207

1.	Problem Statement

     We are looking to design an application which will help users help sort multiple 
electronic devices by price and other metrics. Using these metrics, our application will make it easy for users to navigate their way through these different brands and models by allowing them to filter and sort different products based on price, model, year, warranty information, and other specifications.

     This application will make use of modern and efficient data structures to provide users with a fast and effective way to see which options they have available, helping them make an informed purchasing decision which they will not regret down the road. By making use of sophisticated data structures like AVL trees, B-Trees, and use of fast sorting algorithms, the application will cut down on searching time and make selecting a new electronic device a much more user-friendly experience.

We have divided the problem into following different problems:

1.	Sorting on basis of price.
2.	Sorting on basis of name. 
3.	Sorting on basis of year. 
4.	Sorting on basis of model. 

The type of data which will be required for this purpose is:

•	List of items with following information:
•	Product Model
•	Manufacturer Name
•	Category
•	Manufacture year
•	Price










2.	Problem Solution

     We devise use of different data structures for each different functionality defined in the above section to solve the problem in an efficient manner. 

2.1.	Sorting the inventory

      To save items in an inventory, we needed a data structure which allows quick addition/deletion of items without wasting a lot of space and time. Due to large number of items in a production database, space is a particular concern. For that purpose, we evaluated use of both arrays and linked lists and decided to go with Linked List as they allow addition and deletion in constant time. Also, there is no space wastage like in arrays.


2.2.	Efficient sorting

     The application needs to quickly sort and return the items list based on the metric.
We considered the use of a MinHeap. A MinHeap, through bubble up/down techniques employed during insertion/deletion of elements, maintains a structure which returns the lowest priced item in constant time (Big Oh of 1).
