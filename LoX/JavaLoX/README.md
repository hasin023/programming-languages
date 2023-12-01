# JavaLoX

A Dynamic typed High-level Scripting language with automatic memory management, based on the syntax of C & C#. The language is implemented in Java and inspireed from the book [**Crafting Interpreters**](https://craftinginterpreters.com) by [**Robert Nystrom**](https://github.com/munificent).

## Goodbye JavaLoX ?

Convey your final words with first taste of the language JavaLoX.

```java
print "Goodbye World ✨";
```

## Declaration

JavaLoX is a dynamically typed language, so you don't need to specify the type of a variable when you declare it. The JavaLoX interpreter will get the type of the variable from the value you assign to it.

```java
var name = "JavaLoX";
var version = 1.0;
var isAwesome = true;
```

## Data Types

JavaLoX has 4 data types built into the language.

- **Boolean** - `true` or `false`
- **Number** - `1`, `2.5`, `3.14`, `0.0`
- **String** - `"Hello World"`, `"JavaLoX"`
- **Nil** - `nil`

## Expressions

JavaLoX has the same expression syntax as C and Java.

### Arithmetic Operators

```java
print 10 + 20; // 30
print 10 - 20; // -10
print 10 * 20; // 200
print 10 / 20; // 0.5
```

### Comparison Operators

```java
print 10 < 20;  // true
print 10 > 20;  // false
print 10 <= 20; // true
print 10 >= 20; // false
print 10 == 20; // false
print 10 != 20; // true
```

### Logical Operators

```java
print true and false; // false
print true or false;  // true
print !true;   // false
print true xor false; // true
```

### Grouping

```java
print (10 + 20) * 10; // 300
```

### No Implicit Conversions

JavaLoX does not do any implicit conversions between types. If you try to use a value of one type where you need a different type, the interpreter will give you an error.

```java
print 10 == "10"; // false
```

## Statements

A print statement evaluates a single expression and displays the result to the user.

```java
print "Goodbye World";
```

If you want to pack a series of statements where a single one is expected, you can wrap them up in a block. Blocks also affect scoping.

```java
{
  print "First Statement";
  print "Second Statement";
}
```

## Variables

You declare variables using **var** statements. If you omit the initializer, the variable’s value defaults to **nil**.

```java
var imAVariable = "here is my value";
var iAmNil;
```

Once declared, you can, naturally, access and assign a variable using its name.

```java
var breakfast = "bagels";
print breakfast; // "bagels".
breakfast = "beignets";
print breakfast; // "beignets"
```

## Control Flow

It’s hard to write useful programs if you can’t skip some code or execute some more than once. That means control flow. In addition to the logical operators we already covered, JavaLoX lifts three statements straight from C.

### If Conditions

An if statement executes one of two statements based on some condition.

```java
if (condition) {
  print "yes";
} else {
  print "no";
}
```

### Ternary Operators

A ternary operator is a short-hand for an if statement. It evaluates an expression and then returns one of two values based on that result.

```java
print condition ? "yes" : "no";
```

### While Loop

A while loop executes the body repeatedly as long as the condition expression evaluates to true.

```java
var a = 1;
while (a < 10) {
  print a;
  a = a + 1;
}
```

### Do-While Loop

A do-while loop is like a while loop, except that it tests the condition at the end of the loop instead of the beginning.

```java
var a = 1;
do {
  print a;
  a = a + 1;
} while (a < 10);
```

### For Loop

Finally, we have for loops.

```java
for (var a = 1; a < 10; a = a + 1) {
  print a;
}
```

Break and continue work just like they do in C.

```java
for (var a = 1; a < 10; a = a + 1) {
  if (a == 5) {
    break;
  }
  print a;
}
```

```java
for (var a = 1; a < 10; a = a + 1) {
  if (a == 5) {
    continue;
  }
  print a;
}
```

## Functions

Functions are the primary way to package logic and reuse it. They are also one of the few places where JavaLoX breaks its “everything is an expression” rule.

A function call expression looks the same as it does in C.

```java
makeBreakfast(bacon, eggs, toast);
makeBreakfast(); // No arguments.
```

### Defining Functions

A language isn’t very fun if you can’t define your own functions. In JavaLoX, you do that with **function**.

```java
function printSum(a, b) {
  print a + b;
}
```

### Returning Values

Functions can also return values back to their caller using the **return** keyword.

```java
function sum(a, b) {
  return a + b;
}
```

### Closures

Functions are first-class values in JavaLoX. You can pass them to other functions, return them from functions, and assign them to variables. A function that does that is called a closure.

```java
function makeCounter() {
  var i = 0;
  function count() {
    i = i + 1;
    print i;
  }
  return count;
}

var counter = makeCounter();
counter(); // "1".
counter(); // "2".
```

## Classes

Classes are the other big way to package up logic and data in JavaLoX. They are also the only way to define new types.

### Defining Classes

You define a class with the **class** keyword.

```java
class Breakfast {
  cook() {
    print "Eggs a-fryin'!";
  }

  serve(who) {
    print "Enjoy your breakfast, " + who + ".";
  }
}
```

### Creating Instances

To create an instance of a class, you call the class like it’s a function.

```java
var breakfast = Breakfast();
```

### Instance Methods

Instance methods are functions that are defined inside of a class and attached to instances of that class.

```java
breakfast.cook();
breakfast.serve("Bob");
```

### Initializers

Initializers are optional methods that are called when you create a new instance of a class.

```java
class Breakfast {
  init() {
    print "Breakfast is served!";
  }
}
```

### Fields

Fields are variables that are attached to a particular instance of a class.

```java
class Breakfast {
  init() {
    this.food = "eggs";
  }
}
```

### Class Methods

Class methods are functions that are defined inside of a class and attached to the class itself.

```java
class Breakfast {
  static make() {
    return Breakfast();
  }
}
```

### Inheritance

JavaLoX supports single inheritance. You specify a superclass when you define a class with the **:** operator.

```java
class Brunch : Breakfast {
  init() {
    base.init();
    print "Pass the mimosas!";
  }
}
```

## Standard Library

JavaLoX comes with a small standard library built in. It’s written in Java and is available to all JavaLoX programs.

### Scanner

The **Scanner** class provides a simple way to read text from a stream.

```java
var line = Scanner.readLine();
print "You said: " + line;
```

### Clock

The **clock** function returns the number of seconds since the first call to clock.

```java
var start = clock();
// Do some stuff.
var end = clock();
print end - start;
```

## File Library

The **File** class provides a few useful file functions.

```java
var file = File.open("file.txt");
print File.read(file); // Hello World
File.write(file, "Goodbye World");
File.close(file);
```

## Math Library

The **Math** class provides a few useful mathematical functions.

```java
print Math.abs(-10); // 10
print Math.min(10, 20); // 10
print Math.max(10, 20); // 20
print Math.pow(2, 8); // 256
print Math.sqrt(16); // 4
```

## String Library

The **String** class provides a few useful string functions.

- **charAt** - Returns the character at the specified index.
- **concat** - Appends one string to another.
- **contains** - Returns true if the string contains the specified substring.
- **endsWith** - Returns true if the string ends with the specified suffix.
- **indexOf** - Returns the index of the first occurrence of the specified substring.
- **isEmpty** - Returns true if the string is empty.
- **length** - Returns the length of the string.
- **replace** - Replaces all occurrences of the specified old character with the specified new character.
- **replaceFirst** - Replaces the first occurrence of the specified old character with the specified new character.
- **replaceAll** - Replaces all occurrences of the specified old substring with the specified new substring.
- **startsWith** - Returns true if the string starts with the specified prefix.
- **substring** - Returns a substring of the string.
- **toLowerCase** - Converts all of the characters in the string to lower case.
- **toUpperCase** - Converts all of the characters in the string to upper case.
- **trim** - Removes leading and trailing whitespace from the string.

## Conclusion

For now, that’s all there is to JavaLoX. It’s a small language, but it’s enough to build some interesting programs. If you want to learn more about the language, check out the [**Crafting Interpreters**](https://craftinginterpreters.com) book by [**Robert Nystrom**](https://github.com/munificent).

## License

MIT License

```
MIT License
===========
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the ""Software""), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
```
