#### **What are streams?**
- A sequence of elements from a source that supports data processing operations.
    * **Sequence of elements** 
    * **Source**  
    * **Data processing operations**
    
- The Streams API in Java 8 lets you write code that’s
    * **Declarative** - More concise and readable  
    * **Composable** -  Greater flexibility 
    * **Parallelizable** -  Better performance 
    

#### **Difference between stream and collection**

- **No storage**    
```A stream is not a data structure that stores elements; instead, 
it conveys elements from a source such as a data structure, an array, 
a generator function, or an I/O channel, through a pipeline of computational 
operations.```

- **Functional in nature**  
```An operation on a stream produces a result, but **does not modify its 
 source**.```

- **Laziness-seeking** -   

- **Possibly unbounded.**  
 ``` While collections have a finite size, streams need not. Short-circuiting operations such as limit(n) or findFirst() can allow   
    computations on infinite streams to complete in finite time.```
    
- **Consumable**   
``` The elements of a stream are only visited once during the life of a stream. Like an Iterator,  
    a new stream must be generated to revisit the same elements of the source.```

#### **Stream operations**

**1. Intermediate operations**  

- Stream operations that can be connected to form a query.

- Intermediate operations return a new stream.

- They are always lazy, pipeline source does not begin until the terminal operation of the pipeline is executed.

- There are two types of Intermediate operations
 
   *  **Stateless** - Stateless operations, <stype>such as `filter` and `map`, retain no state from previously seen element when processing a new element -- each element can be processed independently of operations on other elements
   
   *  **Stateful**  - Stateful operations, such as `distinct` and `sorted`, may incorporate state from previously seen elements when processing new elements.  
                    
                    - Stateful operations may need to process the entire input before producing a result.
                   
**2. Terminal operations**

- Operations that close a stream.

- It executes the stream pipeline and produces a result. 

- After the terminal operation is performed, the stream pipeline is considered consumed, and can no longer be used

