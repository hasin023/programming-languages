## Grammar for JavaLoX

For now, we are going to worry about only a handful of expressions:

- Literals. Numbers, strings, Booleans, and nil.
- Unary expressions. A prefix ! to perform a logical not, and - to negate a number.
- Binary expressions. The infix arithmetic (+, -, \*, /) and logic operators (==, !=, <, <=, >, >=) we know and love.
- Parentheses. A pair of ( and ) wrapped around an expression.

### Expressions

```ebnf
expression     → literal | unary | binary | grouping ;
literal        → NUMBER | STRING | "true" | "false" | "nil" ;
grouping       → "(" expression ")" ;
unary          → ( "-" | "!" ) expression ;
binary         → expression operator expression ;
operator       → "==" | "!=" | "<" | "<=" | ">" | ">="
                | "+"  | "-"  | "*" | "/" ;
```

That gives us enough syntax for expressions like:

```java
1 - (2 * 3) < 4 == false
```
