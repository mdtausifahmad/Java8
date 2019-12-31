##### **Why Use Generics?**

1. Stronger type checks at compile time.
2. Elimination of casts.
```
    List list = new ArrayList();
    list.add("hello");
    String s = (String) list.get(0);
    
    List<String> list = new ArrayList<String>();
    list.add("hello");
    String s = list.get(0);   // no cast
```
    
3. Enabling programmers to implement generic algorithms.

