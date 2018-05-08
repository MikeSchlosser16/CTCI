### VI - Big O
* Big O describes upper bound on time.
* Big Omega is the equivalent concept but for a lower bound.
* Big Theta means big O and Omega. If an algorithm is Theta(N) then it is both O(N) and Omega(N). Theta gives a tight bound on run time.

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
Here we do B chunks of work for each element in A. Therefor, the total work is O(A*B).

Basically,
* If algorithm is in the form of "do this, then, when you're all done, do that" you add runtimes.
* If algorithm is of the form "do this for each time you do that", then you multiply runtimes.

* Amortized time allows us to describe that yes, this worst case happens every once in a while. But once it happens, it wont happen again for so long the cost is "amortized". Example was an arrayList that doubles in size when it needs to dynamically allocate more space.  

##### Log N runtimes

Consider binary search. We start with an N-element array to search. Then, after the first step we have N/2 elements. Then N/4...we stop when we find the value or we are down to 1 element. The total runtime is then a matter of how many steps we can take until N becomes 1. This ends up being how many times can be multiply by 2(starting with 1) until we get N. Thus, `2^k = N` and `N = Log(N)`

Important takeaway: when you see a problem where the number of elements in the problem space gets halved in each, that will likely be a O(log N) runtime.

##### Recursive Runtimes
```
int f(int n){
  if (n <= 1) {
    return 1;
  }
  return f(n-1) + f(n - 1);
}
```
Common incorrect answer here after seeing two calls of F is O(n^2). This is wrong. We can derive the runtime by walking through the code, with f(4). This calls f(3) twice, and each of those calls to f(3) call f(2) twice, until we get to f(1):
```
                    f(4)
              f(3)            f(3)
        f(2)       f(2)     f(2)    f(2)
    f(1)  f(1)  f(1)f(1) f(1)f(1) f(1)f(1)
```
How many calls are in this tree? Well, the tree will have depth N. Each node has two children, so each level will have twice as many calls as the one above it. This tells us at Level 0, we have 1 node. At level 1, we have 2, 2 we get 4, 3 is 8...This also works out to 2^0, 2^1 2^2, 2^3...Therefore, there will be 2^0 + 2^1 + 2^2 + ... + 2^N

Important takeaway: When you have a recursive function that makes multiple calls, the runtime will often (but not always) look like O(branches^depth), where branches it the number of times each recursive call branches. In this case, we get O(2^N).

#### Practice
```
void foo(int[] array){
  int sum = 0;
  int product = 1;
  for (int i = 0; i < array.length; i++){
    sum += array[i];
  }
  for(int i = 0; i < array.length; i++){
    product *= array[i];
  }
  System.out.println(sum + ", " + product);
}
```
This will take O(n). The fact that we iterate twice does not matter(we exclude constants).

```
void printPairs(int[] array){
  for(int i = 0; i < array.length; i++){
    for(int j = 0; j < array.length; j++){
      System.out.println(array[i] + "," array[j]);
    }
  }
}
```
The inner loop has O(N) iterations and is called N times. Therefore, runtime is O(N^2).

```
void printUnorderedPairs(int[] array){
  for(int i = 0; i < array.length; i++){
    for(int j = i + 1; j < array.length; j++){
      System.out.println(array[i] + "," + array[j]);
    }
  }
}
```
First loop through j runs N-1, then N-2, then N-3 + ... + 2 + 1
= 1 + 2 + 3 + ... + N-1
== sum of 1 through N - 1
=== The sum of 1 through N - 1 is (N(N-1)) / 2
==== (N^2 - n) / 2 == O(N^2) <-- Notice we get rid of constant(1/2) as well as non major term(n).
We can also think about what this code does. there are N^2 total pairs, and roughly half of those will have i < j and the other half will have i > j. This code will go through N^2/2 pairs, so O(n^2).
We can also think about the problem in another way, the average work. The outer loop runs N times. The inner loop, however, varies by iteration. Lets think about the average iteration. For 1,2,3..N, the average is N/2. Therefore, since the inner loop does N/2 work on average, and the outer loop is run N times, the total work is (n^2)/2 = O(n^2).

```
void printUnorderedPairs(int[] arrayA, int[] arrayB){
  for(int i = 0; i < arrayA.length; i++){
    for(int j = 0; j < arrayB.length; j++){
      if(arrayA[i] < arrayB[j]){
        System.out.println(arrayA[i] + "," + arrayB[j]);
      }
    }
  }
}
```
We can break this up to analyze. The if statement is O(1) since its a sequence of constant time statements. For each element of arrayA, the inner loop goes though b iterations, where b = arrayB.length. If a = arrayA.length, then the runtime is O(ab). Note that this is NOT O(n^2) because there are two different inputs. Both matter.

```
void printUnorderedPairs(int[] arrayA, int[] arrayB){
  for(int i = 0; i < arrayA.length; i++){
    for(int j = 0; j < arrayB.length; j++){
      for(int k = 0; k < 100000; k++){
        System.out.println(arrayA[i] + "," + arrayB[j]);
      }
    }
  }
}
```
Nothing here has really changed from above. 100,000 units of work is still constant time, and we care only about how operations rate of increase. We still have O(ab).

```
void reverse(int[] array){
  for(int i = 0; i < array.length / 2; i++){
    int other = array.length - i - 1;
    int temp = array[i];
    array[i] = array[other];
    array[other] = temp;
  }
}
```
This reversal algorithm runs in O(N) time. The fact that it only goes though half of the array does not impact big O time, because its a constant(N/2) = O(N).

```
Which of the following are equivalent to O(N)? Why?
* O(N + P), where P < N/2
* O(2N)
* O(N + log N)
* O(N+M)
```
1. Yes -- if P < N/2, we know that N is the dominant term so we can drop the O(P). Really O(N)
2. Yes -- we don't care about constants. Really O(N)
3. Yes -- only significant term matters. Really O(N)
4. No -- there is no established relationship between N and M, so we must keep both variables here.

Suppose we had an algorithm that took an array of strings, sorted each string and thens orted the full array. What would the runtime be?

* Many people would say sorting each string is O(N log N) and we do this for each string, so thats O(N * N log N). Then we have to sort this array, so that is an additional O(NLogN), and therefore the total work is O(N^2 Log N + N Log N), which is just O(N^2 Log N) This is INCORRECT. Why? Because we used N in two different ways. In one case, its the length of the string, and in the other case its the length of the array. You can prevent this problem by not using N at all, or by using it only where there is no ambiguity as to what N could represent.
Really, we have
```
S = length of the longest string
A = Length of the array

1. Sort each individual string --> O(S log S)
2. Do this for a strings --> O(A*S log S)
3. Sort all of the strings --> O(A log A)
4. Compare each string, O(S) making 3 --> O(A * S log A)
== O(A*S log S + A*S log A)
=== O(A*S(log S + log A))
```
Important takeaway: Be careful when giving names to variables. It is very easy to forget which ais which and mix them up. Give them representative names if needed.

```
int sum(Node node){
  if(node == null){
    return 0;
  }
  return sum(node.left) + node.value + sum(node.right);
}
```

Just because there is a binary search tree does NOT mean there is a log! We can look at this two ways. What it means, the code touches each node in the tree once and does a constant time amount of work with the touch, therefore the runtime will be linear in terms of the number of nodes. If there are N nodes, we have O(N). We also could use the above algorithm, where typically in recursion we get O(branches ^ depth). There are two branches, so we are looking at O(d^depth)). At this point we may assume we did something wrong, but what is depth? If N is the number of nodes in the tree, the depth is roughly log(N). This gives us O(2^LogN). Recalling what log means, 2^p = Q -> logbase2 Q = P, so we have P = 2 ^ log N == logbase2P = logbase2N P = N, and subbing back in 2^LogN = N. Therefore, the runtime is O(N).

```
boolean isPrime(int n){
  for(int x = 2; x * x <= n; x++){
    if(n % x == 0){
      retun false;
    }
  }
  return true;
}
```

The inside work is constant, so we just need to determine how many iterations the for loop does in the worst case. The loop starts when x = 2 and stops when x*x = n. In other words, it stops when N = X^2, so when x = sqrt(N). We could rewrite it as ```for(int x = 2; x <= sqrt(n); x++)```. Thus, this runs in O(sqrt(N)) time.

```
int factorial(int n){
  if(n < 0){
    return -1;
  } else if (n == 0){
    return 1;
  } else {
    return n * factorial(n-1);
  }
}
```
This is just a straight recursion from n to n-1 to n-2...1, so it will take O(n) time.
