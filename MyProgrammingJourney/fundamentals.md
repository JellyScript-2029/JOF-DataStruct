# JAVA FUNDAMENTALS CHEATSHEET
## For 1st Year BSIT Students | Master the Basics

---

## 1. What is Java?

- **Object-Oriented Programming (OOP)** language
- **"Write Once, Run Anywhere"** (WORA) - Works on any device with Java Virtual Machine (JVM)
- Used for: Web apps, mobile apps (Android), desktop apps, games, enterprise software
- **Similar concepts to:** Python, C++, C# (but stricter syntax)

---

## 2. Basic Program Structure

Every Java program needs:
1. A **class** (template for objects)
2. A **main() method** (entry point - where program starts)

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

**Key Points:**
- `public` = accessible from anywhere
- `static` = doesn't need object creation to run
- `void` = method returns nothing
- `main()` = always required to run program
- `String[] args` = command-line arguments

---

## 3. Variables & Data Types

### **Primitive Data Types (Basic Types)**

| Type | Size | Range | Example |
|------|------|-------|---------|
| **byte** | 1 byte | -128 to 127 | `byte x = 100;` |
| **short** | 2 bytes | -32,768 to 32,767 | `short age = 25;` |
| **int** | 4 bytes | -2B to 2B | `int count = 1000;` |
| **long** | 8 bytes | Very large numbers | `long pop = 8000000L;` |
| **float** | 4 bytes | Decimal (6-7 digits) | `float price = 19.99f;` |
| **double** | 8 bytes | Decimal (15-16 digits) | `double salary = 5000.50;` |
| **boolean** | 1 bit | true/false | `boolean isStudent = true;` |
| **char** | 2 bytes | Single character | `char grade = 'A';` |
| **String** | Variable | Text/words | `String name = "Alice";` |

### **Declaring Variables**

```java
// Syntax: dataType variableName = value;

int age = 20;
String name = "Alice";
double price = 99.99;
boolean isActive = true;
char gender = 'F';

// Multiple variables same type
int x = 5, y = 10, z = 15;
```

---

## 4. Operators

### **Arithmetic Operators**
```java
int a = 10, b = 3;

a + b   // Addition = 13
a - b   // Subtraction = 7
a * b   // Multiplication = 30
a / b   // Division = 3
a % b   // Modulo (remainder) = 1
```

### **Comparison Operators** (Return true/false)
```java
a == b   // Equal to
a != b   // Not equal to
a > b    // Greater than
a < b    // Less than
a >= b   // Greater or equal
a <= b   // Less or equal
```

### **Logical Operators** (Combine conditions)
```java
if (age > 18 && hasLicense) {
    // AND - both must be true
}

if (isWeekend || holiday) {
    // OR - at least one must be true
}

if (!isRaining) {
    // NOT - reverses condition
}
```

### **Assignment Operators**
```java
x = 5;      // Assign
x += 3;     // x = x + 3 â†’ 8
x -= 2;     // x = x - 2 â†’ 6
x *= 2;     // x = x * 2 â†’ 12
x /= 3;     // x = x / 3 â†’ 4
```

---

## 5. Control Flow (If/Else)

### **Simple If**
```java
if (age > 18) {
    System.out.println("You are an adult");
}
```

### **If-Else**
```java
if (score >= 50) {
    System.out.println("Pass");
} else {
    System.out.println("Fail");
}
```

### **If-Else If-Else**
```java
if (grade == 'A') {
    System.out.println("Excellent");
} else if (grade == 'B') {
    System.out.println("Good");
} else if (grade == 'C') {
    System.out.println("Average");
} else {
    System.out.println("Need improvement");
}
```

### **Switch Statement** (Cleaner when checking one variable)
```java
int day = 1;

switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    default:
        System.out.println("Other day");
}
```

---

## 6. Loops

### **For Loop** (Use when you know how many times to repeat)
```java
// Traditional for loop
for (int i = 0; i < 5; i++) {
    System.out.println("Number: " + i);
}
// Output: 0, 1, 2, 3, 4

// Enhanced for loop (for arrays/collections)
int[] numbers = {10, 20, 30, 40};
for (int num : numbers) {
    System.out.println(num);
}
```

### **While Loop** (Repeat while condition is true)
```java
int count = 0;
while (count < 5) {
    System.out.println("Count: " + count);
    count++;  // IMPORTANT: increment to avoid infinite loop!
}
```

### **Do-While Loop** (Executes at least once)
```java
int x = 0;
do {
    System.out.println("x = " + x);
    x++;
} while (x < 3);
// Runs even if condition is false initially
```

### **Break & Continue**
```java
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        break;  // Exit loop completely
    }
    if (i == 2) {
        continue;  // Skip to next iteration
    }
    System.out.println(i);
}
```

---

## 7. Methods (Functions)

A method is a reusable block of code.

### **Method Syntax**
```java
// accessModifier returnType methodName(parameters) {
//     method body
//     return value (if returnType is not void)
// }
```

### **Examples**

```java
// Method with parameters and return value
public static int add(int a, int b) {
    return a + b;
}

// Method with no return value (void)
public static void greet(String name) {
    System.out.println("Hello, " + name);
}

// Method with no parameters
public static String getMessage() {
    return "Welcome!";
}

// Using the methods
public static void main(String[] args) {
    int sum = add(5, 3);
    System.out.println("Sum: " + sum);  // Output: 8
    
    greet("Alice");  // Output: Hello, Alice
    
    String msg = getMessage();
    System.out.println(msg);  // Output: Welcome!
}
```

### **Method Key Points**
- **public** = accessible from other classes
- **static** = doesn't need object to call
- **void** = returns nothing
- **return** = sends value back to caller
- Parameters go inside `()`
- Method body goes inside `{}`

---

## 8. Arrays

An array stores multiple values of the same type in one variable.

### **Creating & Using Arrays**
```java
// Method 1: Declare and initialize
int[] numbers = {10, 20, 30, 40, 50};

// Method 2: Declare size, then fill
String[] names = new String[3];
names[0] = "Alice";
names[1] = "Bob";
names[2] = "Charlie";

// Accessing elements (index starts at 0)
System.out.println(numbers[0]);    // 10
System.out.println(numbers[2]);    // 30

// Array length
System.out.println(numbers.length);  // 5

// Looping through array
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}

// Enhanced for loop
for (int num : numbers) {
    System.out.println(num);
}
```

### **2D Arrays** (Array of Arrays)
```java
// Matrix/Grid
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

System.out.println(matrix[0][0]);  // 1
System.out.println(matrix[1][2]);  // 6
```

---

## 9. Classes & Objects (OOP Basics)

A **class** is a blueprint. An **object** is an instance of that class.

### **Simple Class Example**
```java
public class Student {
    // Attributes (properties/variables)
    String name;
    int age;
    double gpa;
    
    // Constructor (initializes object when created)
    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }
    
    // Method
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + gpa);
    }
}

// Creating and using an object
Student student1 = new Student("Alice", 20, 3.8);
student1.displayInfo();
// Output:
// Name: Alice
// Age: 20
// GPA: 3.8
```

### **Key Concepts**
- **Attributes** = what the object has (variables)
- **Methods** = what the object does (functions)
- **Constructor** = special method that runs when object is created (no return type)
- **this** = refers to current object

---

## 10. String Operations

Strings are objects that represent text.

```java
String text = "Hello World";

// Length
text.length()           // Returns 11

// Case conversion
text.toUpperCase()      // "HELLO WORLD"
text.toLowerCase()      // "hello world"

// Character at position
text.charAt(0)          // 'H'

// Substring (portion of string)
text.substring(0, 5)    // "Hello"

// Check if contains text
text.contains("World")  // true

// Replace text
text.replace("World", "Java")  // "Hello Java"

// Compare strings (IMPORTANT! Use .equals())
String a = "hello";
String b = "hello";
a.equals(b)             // true
a == b                  // May be false! Don't use ==

// Concatenation
String name = "Alice";
String greeting = "Hello " + name;      // "Hello Alice"
String greeting2 = "Hello ".concat(name); // "Hello Alice"

// Trim whitespace
"  hello  ".trim()      // "hello"
```

---

## 11. Input & Output

### **Output (Print to Console)**
```java
System.out.println("Hello");      // Prints with newline
System.out.print("Hello");         // Prints without newline
System.out.printf("%.2f", 19.995); // Formatted: 20.00
```

### **Input (Read from User)**
```java
import java.util.Scanner;  // IMPORTANT: Add at top of file

Scanner scanner = new Scanner(System.in);

// Read a string
System.out.print("Enter your name: ");
String name = scanner.nextLine();

// Read an integer
System.out.print("Enter your age: ");
int age = scanner.nextInt();

// Read a double
System.out.print("Enter your GPA: ");
double gpa = scanner.nextDouble();

System.out.println("Name: " + name + ", Age: " + age + ", GPA: " + gpa);
```

---

## 12. Common Beginner Mistakes (AVOID THESE!)

| âŒ Wrong | âœ… Correct | Explanation |
|----------|-----------|-------------|
| `int x = 5` (no semicolon) | `int x = 5;` | Always end with semicolon |
| `if (x = 5)` | `if (x == 5)` | = is assignment, == is comparison |
| `while (true) { }` | `while (true) { count++; }` | Add logic to break loop |
| `int[] arr[3]` | `int[] arr = new int[3];` | Wrong bracket placement |
| `names[5]` (size is 5) | `names[4]` | Arrays start at 0; last index is size-1 |
| `String a = new String("hi"); if (a == "hi")` | `if (a.equals("hi"))` | Compare strings with .equals() |
| `System.out.println(names);` (for array) | `for (String n : names) System.out.println(n);` | Can't print array directly |
| `public static void main(String args)` | `public static void main(String[] args)` | args must be array |
| No import | `import java.util.Scanner;` | Scanner needs import statement |
| `int x, y = 5;` (expects both 5) | `int x = 5, y = 5;` | Each needs initialization |

---

## 13. Pro Tips for Success

### ðŸ’¡ Learning Tips
- **Start simple** - Write "Hello World" first, then build up
- **Use meaningful names** - Use `age` not `a`, `name` not `n`
- **Add comments** - Explain your logic
- **Test with different inputs** - Don't just test happy path
- **Practice coding** - Build small projects (calculator, grade system, to-do list)
- **Debug step by step** - Use print statements to see what's happening
- **Ask for help** - Don't struggle alone; ask professors/peers/Stack Overflow

### ðŸŽ¯ Practice Projects (Easy to Hard)
1. **Calculator** - Take two numbers, perform operations
2. **Student Grade System** - Store students, calculate GPA
3. **Loan Calculator** - Calculate monthly payment
4. **Simple Game** - Guessing game, Tic-Tac-Toe
5. **TODO List** - Add, remove, display tasks

### ðŸ“š Resources
- **Official Documentation** - oracle.com/java/technologies/javadocs
- **YouTube Channels** - Brackeys, Programming with Mosh, Tech with Tim
- **Practice Sites** - HackerRank, LeetCode, CodeSignal
- **IDE** - Use IntelliJ IDEA Community Edition or Eclipse (free)

---

## 14. Quick Reference: Data Type Selection

```
Use int for:        whole numbers (age, count, score)
Use double for:     decimals (price, GPA, salary)
Use boolean for:    true/false (isStudent, isActive)
Use char for:       single character (grade, initial)
Use String for:     text (names, messages)
Use long for:       very large numbers (population, ID)
Use byte/short for: memory-critical applications (rare)
```

---

## 15. Memory Aid: Variable Declaration Order

```
[modifier] [dataType] [variableName] = [value];

Example:
public    int           age              = 20;
modifier  dataType      variableName     value
```

---

## 16. Common Method Names (Convention)

```java
getName()          // Get value
setName(String)    // Set value
isActive()         // Check boolean
calculateTotal()   // Do calculation
displayInfo()      // Show output
validateInput()    // Check if valid
```

---

## 17. Keyboard Shortcuts (IntelliJ IDEA)

| Shortcut | Action |
|----------|--------|
| `Ctrl + /` | Comment/uncomment line |
| `Ctrl + D` | Duplicate line |
| `Ctrl + L` | Go to line |
| `Shift + F6` | Rename variable |
| `Alt + Enter` | Quick fix suggestions |
| `Ctrl + Shift + Enter` | Complete statement |

---

## ðŸŽ“ Final Advice

> **"The only way to learn programming is by writing code."**
> 
> Don't just read this cheatsheetâ€”TYPE the examples into your IDE and RUN them. 
> Make mistakes. Debug. Learn from errors. This is how real programmers learn!

---

## Quick Checklist: Are You Ready?

- [ ] I can create a Java class with a main() method
- [ ] I understand different data types and when to use them
- [ ] I can use if/else to make decisions
- [ ] I can write loops (for, while, do-while)
- [ ] I can create and use methods
- [ ] I can work with arrays
- [ ] I can create classes and objects
- [ ] I can read user input with Scanner
- [ ] I can work with Strings and their methods
- [ ] I understand what OOP is (basics)

**If you checked â‰¥ 8 boxes, you have a solid foundation!** ðŸŽ‰

---

**Remember:** Every expert Java programmer started where you are. Keep practicing, and you'll get there! ðŸ’ª

---

*Last Updated: March 2026*
*Good luck with your BSIT studies!*