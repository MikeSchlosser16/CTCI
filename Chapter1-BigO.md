### VI - Big O
* Big O describes upper bound on time.
* Big Omega is the equivalent concept but for a lower bound.
* Big Theta means bot O and Omega. Of an algorithm is Theta(N) then it is both O(N) and Omega(N). Theta gives a tight bound on run time.

Big O is what is traditionally used in industry, and it tries to use it to offer the tightest description of run time.  We rarely discuss best case time complexity. For many algorithms, the worst case and the expected case are the same.

Space complexity is a parallel to time complexity. We may also care about the amount of memory required by an algorithm. If we need to create an array of size n, this will require O(n) space. If we need a 2D array of size n*n, we get O(n^2) space.

* Stack space in recursive calls matters also. For example.
```
int sum(int n){
  if (n <= 0){
    return 0;
  }
  return n + sum(n-1);
}
```
Each call adds a level to the Stack
```
sum(4)
--> sum(3)
----> sum(2)
------> sum(1)
--------> sum(0)
```

* Because Big O just describes rate of increase, we drop constants in runtime. For example,
`O(2N) is just described as O(N)` For example, 2 non=nested loops are O(N), not O(2N).

* Drop the non-dominant terms. For example, O(n^2 + N) is just O(N^2) because the second N, while not a constant, isn't important.

* Some common runtimes in order of efficiency:
`O(n!) < O(2^n) < O(n^2) < O(n log n) < O(n) < O(log n)`

* When do we know to add or multiply for multi-part algorithms?
Add the run times:
```
for(int a: arrA){
  print(a);
}
for(int b: arrB){
  print(b);
}
```
Here we do A chunks of work then B chunks of work. Therefor the total amount of work is O(A + B).
```
for(int a: arrA){
  for(int b: arrB){
    print(a + "," + b);
  }
}
```
Here we do B chinks of work for each element in A. Therefor, the total work is O(A*B).

Basically,
* If algorithm is in the form of "do this, then, when you're all done, do that" you add runtimes.
* If algorithm is of the form "do this for each time you do that", then you multiply runtimes.

* Amortized time allows us to describe that yes, this worst case happens every once in a while. But once it happens, it wont happen again for so long the cost is "amortized". Example was an arrayList that doubles in size when it needs to dynamically allocate more space.  

* Log N runtimes
Consider binary search. We start with an N-element array to search. Then, after the first step we have N/2 elements. Then N/4...we stop when we find the value or we are down to 1 element. The total runtime is then a matter of how many steps we can take until N becomes 1. This ends up being how many times can be multiply by 2(starting with 1) until we get N. Thus, `2^k = N` and `N = Log(N)`

Important takeaway: when you see a problem where the number of elements in the problem space gets halved in each, that will likely be a O(log N) runtime.

* Recursive Runtimes
```
int f(int n){
  if (n <= 1) {
    return 1;
  }
  return f(n-1) + f(n - 1);
}
```
Common incorrect answer here after seeing two calls of F is O(n^2). This is wrong. We can derive the runtime by walking through the code, with f(4). This calls f(3) twice, and each of those calls to f(3) call f(2) twice, until we get to f(1)
```
                    f(4)
              f(3)            f(3)
        f(2)       f(2)     f(2)    f(2)
    f(1)  f(1)  f(1)f(1) f(1)f(1) f(1)f(1)
```
How many calls are in this tree? Well, the tree will have depth N. Each node has two children, so each level will have twice as many calls as the one above it. This tells us at Level 0, we have 1 node. At level 1, we have 2, 2 we get 4, 3 is 8...This also works out to 2^0, 2^1 2^2, 2^3...Therefore, there will be 2^0 + 2^1 + 2^2 + ... + 2^N

Important takeaway: When you ahve a recurisve function taht makes multiple calls, the runtime will often (but not always) look like O(branches^depth), where branches it the number of times each recursive call branches. In this case, we get O(2^N).
