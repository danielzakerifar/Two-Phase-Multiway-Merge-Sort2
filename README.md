# Two-Phase-Multiway-Merge-Sort2
The task is to sort a large input file of tuples (records). The input file is given as a text-file in which
each line of the file contains multiple positive integers (with possibly duplicated values), separate by
a single space. Each integer represents a tuple. The task is to compare the tuples in the input, and
to output a file with the same tuples sorted in ascending order. The first line of the input file will
indicate the number of tuples in it and the amount of allowed maximum main memory. The second
line of the input file is blank and from the third line the tuples start. All the tuples are in a single
line. Example-
1000000 5MB
111111 234566 22 ... ...
The sorting algorithm is the Two-Phase Multiway Merge-Sort with possibly several rounds of
merging in Phase 2, and based on the given input information your algorithm should determine the
best buffer size before it starts the actual sorting.
The project will be graded based on correctness, wall-clock execution time and optimization on the
size of buffer and number of rounds.
There are a few considerations:
 Programming language is restricted to Java.
   Use Xmxkm to restrict the main memory usage to k MB. for example Xmx5m will restrict the
main memory to 5MB. it  needs  to  set it up on Eclipse.
 the work with any input size.
