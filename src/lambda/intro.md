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







