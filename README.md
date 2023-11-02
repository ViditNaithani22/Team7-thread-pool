# Team7-thread-pool
Members :
Vidit Naithani (vn9591),
Zoe DeTrani (zd9575),
Aayush Panchal (ap9115).

In this project, the sum of a queue of n integers, called "theArray," which holds values ranging from 1 to n, is effectively calculated. Using 'theArray' directly is
the traditional method, which makes it a long operation. We reduce the amount of time required to compute the sum by a significant amount by using 10 threads to run the sum calculation via the'sumOfAll()' function concurrently.

![image](https://github.com/ViditNaithani22/Team7-thread-pool/assets/40785339/da0517ca-1915-4a2a-b388-84152e1ef39c)


The Goal:
Our objective is to compute the sum of the first n integers within 'theArray' by aggregating all the integers it contains.

Using sumOfAll() Method:
To accomplish this goal, we rely on the 'sumOfAll()' method, as direct access to 'theArray' is restricted due to its private nature.

sumOfAll() Method:
The 'sumOfAll()' method follows a process of extracting the first two integers from the queue, adding them together, and subsequently appending the result to the end of the queue.

In addition there was a synchronised block added to prevent null pointer exceptions by grabbing the first two integers when the length of the queue is more than one.

Time Consumption:
This whole process consumes 1 second to complete each iteration.

Iterative Process:
The process iterates until only one integer remains in the queue, representing the sum of all integers.

Time Complexity:
For a queue housing n integers, the 'sumOfAll()' method will take n-1 seconds to finish since it takes 1 second for every pair of integers.

Original Speed:
For example, in a scenario with 1000 integers in 'theArray,' the traditional 'sumOfAll()' approach would require 999 seconds, which is notably inefficient and time-consuming.

Multi-Threading for Speed:
To address this inefficiency, we implement a solution involving 10 threads that simultaneously invoke the 'sumOfAll()' method ten times concurrently.

Enhanced Speed:
Through this multi-threading approach, we transform the process from performing one addition per second to accomplishing 10 additions every second, resulting in significantly enhanced speed.

Improved Efficiency:
The utilization of 10 threads substantially improves the efficiency and execution speed of the sum calculation. Multiple threads operate in parallel to reduce the overall time required for the computation.
