# **Lambda**

**Definition** : _A lambda expression can be understood as a concise representation of an anonymous function that can be passed around: it doesn’t have a name, but it has a list of parameters, a body, a return type, and also possibly a list of exceptions that can be thrown._

1. **Anonymous** - No name for lambda

2. **Function** - It is not associated with a particular class like method, But like method it has
                    a) List of parameters
                    b) A body
                    c) A return Type
                    d) Possible List of Exception
                    
3.  **Passed around**  -   A lambda expression can be passed as argument to a method or stored in a variable.    


---------------------------------------------------------------

**Structure of Lambda**

**`(parameters) -> expression`**

**`(parameters) -> { statements; }`**

eg. Example of invalid lambda

1. **`(Integer i) -> return "Alan" + i;`**

   **Reason** : `return` is a control-flow statement. To make this lambda valid, curly braces are required as follows: `(Integer i) -> {return "Alan" + i;}`.
   
2. `(String s) -> {"Iron Man";}`

    **Reason** :  “Iron Man” is an expression, not a statement. To make this lambda valid, you can remove the curly braces and semicolon as follows: `(String s) -> "Iron Man"`. Or if you prefer, you can use an explicit return statement as follows: `(String s) -> {return "Iron Man";`}.
    

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

#### **1. Where can we use lambda ?**

    We can use a lambda expression in the context of a functional interface.
   

#### **2. If we have Predicate<T> then why we need IntPredicate and LongPredicate etc?**

    Java 8 brings a specialized version of the functional interfaces  in order to avoid autoboxing operations when the inputs or outputs are primitives. 
    Because  Boxed values are essentially a wrapper around primitive types and are stored on the heap. Therefore, boxed values use more memory and require additional memory lookups to fetch the wrapped primitive value.
    

##### **3. capturing lambdas**

    Lambda expression which are using free variables (variables that aren’t the parameters and defined in an outer scope)
    is called capturing lambdas.
    
    eg. int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber);
        
**Following variables we can use inside the lambda**
1. Instance variables
2. Static variables
3. Local variables have to be explicitly declared final or are effectively final
    
    **_Why local variables have to be final?_**  
    **Ans**: Instance variables are stored on the heap, whereas local variables live on the stack. If a lambda could access 
         the local variable directly and the lambda were used in a thread, then the thread using the lambda could try to 
         access the variable after the thread that allocated the variable had deallocated it. Hence, Java implements access 
         to a free local variable as access to a copy of it rather than access to the original variable. This makes no 
         difference if the local variable is assigned to only once—hence the restriction.
