# JAVA SWING UI & GUI CHEATSHEET
## Build Interactive Desktop Applications with Colors, Buttons, and Everything

---

## Table of Contents
1. [What is Swing?](#what-is-swing)
2. [Basic Window Setup](#basic-window-setup)
3. [Colors & Styling](#colors--styling)
4. [Fonts & Text Colors](#fonts--text-colors)
5. [Common Components](#common-components)
6. [Layout Managers](#layout-managers)
7. [Events & Button Actions](#events--button-actions)
8. [Complete Examples](#complete-examples)
9. [Common Mistakes](#common-mistakes)
10. [Troubleshooting](#troubleshooting)

---

## What is Swing?

Swing is Java's **UI (User Interface) library** for creating desktop applications.

- **Components** = visual elements (buttons, text fields, labels, windows)
- **Layouts** = how components are arranged on screen
- **Events** = when user interacts (clicks, types, etc.)
- **Colors** = make UI beautiful and functional
- **Fonts** = control text appearance

```
JFrame (Window)
    â”œâ”€â”€ JPanel (Container)
    â”‚   â”œâ”€â”€ JButton (Button)
    â”‚   â”œâ”€â”€ JLabel (Text Display)
    â”‚   â”œâ”€â”€ JTextField (Input Box)
    â”‚   â””â”€â”€ ...
    â””â”€â”€ Components arranged with Layout Manager
```

---

## Basic Window Setup

### **Minimal Window (Hello GUI)**

```java
import javax.swing.*;

public class MyFirstGUI {
    public static void main(String[] args) {
        // Step 1: Create a window (JFrame)
        JFrame frame = new JFrame("My First GUI");
        
        // Step 2: Set window properties
        frame.setSize(400, 300);           // width, height in pixels
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close button closes app
        
        // Step 3: Create content
        JLabel label = new JLabel("Hello, GUI World!");
        frame.add(label);
        
        // Step 4: Show window
        frame.setVisible(true);
    }
}
```

### **Better Window with Panel**

```java
import javax.swing.*;

public class SimpleGUI extends JFrame {
    public SimpleGUI() {
        // Window setup
        setTitle("My Application");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create panel (container for components)
        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 240, 240));  // Light gray
        
        // Add components to panel
        JLabel label = new JLabel("Welcome!");
        panel.add(label);
        
        // Add panel to frame
        add(panel);
        
        // Show window
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleGUI());
    }
}
```

### **JFrame Key Methods**

```java
JFrame frame = new JFrame("Title");

// Window size & position
frame.setSize(800, 600);              // width, height
frame.setLocation(100, 100);          // x, y position
frame.setLocationRelativeTo(null);    // Center on screen
frame.setBounds(100, 100, 800, 600);  // All in one

// Resizable & visibility
frame.setResizable(true);              // Allow user to resize
frame.setVisible(true);                // Show window
frame.setVisible(false);               // Hide window

// Close button behavior
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // Close app
frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);     // Just hide
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Dispose

// Window properties
frame.setTitle("New Title");           // Change title
frame.getWidth();                      // Get width
frame.getHeight();                     // Get height
frame.setIconImage(image);             // Set window icon
frame.setAlwaysOnTop(true);            // Stay on top
```

---

## Colors & Styling

### **Creating Colors**

```java
// Method 1: Pre-made colors
Color red = Color.RED;
Color blue = Color.BLUE;
Color white = Color.WHITE;
Color black = Color.BLACK;

// Common pre-made colors:
Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE,
Color.PINK, Color.CYAN, Color.MAGENTA, Color.LIGHT_GRAY, Color.DARK_GRAY

// Method 2: RGB (Red, Green, Blue) - 0 to 255 each
Color customRed = new Color(255, 0, 0);
Color customGreen = new Color(0, 128, 0);
Color lightPurple = new Color(200, 150, 255);
Color darkBlue = new Color(25, 50, 100);

// Method 3: RGB with Alpha (Transparency) - 0 to 255
Color transparentRed = new Color(255, 0, 0, 128);  // Semi-transparent
Color fullyTransparent = new Color(255, 0, 0, 0);   // Invisible

// Method 4: Hex colors (convert hex to decimal RGB)
// Hex #FF5733 = RGB(255, 87, 51)
Color hexColor = new Color(0xFF5733);  // Using hex notation
Color teal = new Color(0x008080);

// Quick RGB converter online: https://www.rapidtables.com/convert/color/hex-to-rgb.html
```

### **Using Colors on Components**

```java
JPanel panel = new JPanel();
panel.setBackground(new Color(240, 240, 240));  // Panel background

JLabel label = new JLabel("Colored Text");
label.setForeground(new Color(255, 0, 0));      // Text color (red)

JButton button = new JButton("Click Me");
button.setBackground(new Color(0, 150, 255));   // Button background (blue)
button.setForeground(new Color(255, 255, 255)); // Button text color (white)

// Make button background visible
button.setOpaque(true);
button.setBorderPainted(false);

// Text field with colors
JTextField textField = new JTextField(20);
textField.setBackground(new Color(255, 255, 255));  // White background
textField.setForeground(new Color(0, 0, 0));         // Black text
```

### **Common Color Recipes**

```java
// Modern colors
Color lightBlue = new Color(173, 216, 230);
Color darkGray = new Color(64, 64, 64);
Color forestGreen = new Color(34, 139, 34);

// Professional palette
Color primaryBlue = new Color(0, 102, 204);    // Professional blue
Color accentOrange = new Color(255, 140, 0);   // Accent
Color neutralGray = new Color(128, 128, 128);  // Neutral
Color successGreen = new Color(34, 177, 76);   // Success (green)
Color errorRed = new Color(231, 76, 60);       // Error (red)
Color warningYellow = new Color(241, 196, 15); // Warning (yellow)

// Pastel colors
Color pastelBlue = new Color(174, 194, 224);
Color pastelPink = new Color(255, 182, 193);
Color pastelGreen = new Color(144, 238, 144);
```

---

## Fonts & Text Colors

### **Creating Custom Fonts**

```java
// Font(name, style, size)
Font normalFont = new Font("Arial", Font.PLAIN, 14);
Font boldFont = new Font("Arial", Font.BOLD, 16);
Font italicFont = new Font("Arial", Font.ITALIC, 14);
Font boldItalicFont = new Font("Arial", Font.BOLD | Font.ITALIC, 18);

// Common font names (guaranteed to work)
"Arial"
"Times New Roman"
"Courier New"
"Georgia"
"Verdana"
"Comic Sans MS"
"Consolas"

// Font styles
Font.PLAIN       // Normal text
Font.BOLD        // Bold text
Font.ITALIC      // Slanted text
Font.BOLD | Font.ITALIC  // Both

// Size recommendations
8, 10, 12, 14, 16, 18, 20, 24, 28, 32, 36, 48
```

### **Applying Fonts & Colors to Text**

```java
// Label
JLabel label = new JLabel("Welcome to My App");
label.setFont(new Font("Arial", Font.BOLD, 24));
label.setForeground(new Color(0, 102, 204));  // Blue text

// Button
JButton button = new JButton("Click Me");
button.setFont(new Font("Arial", Font.BOLD, 14));
button.setForeground(new Color(255, 255, 255));  // White text
button.setBackground(new Color(0, 102, 204));    // Blue background
button.setOpaque(true);

// Text Field
JTextField textField = new JTextField(20);
textField.setFont(new Font("Consolas", Font.PLAIN, 12));
textField.setForeground(new Color(0, 0, 0));     // Black text
textField.setBackground(new Color(255, 255, 255)); // White background
textField.setCaretColor(new Color(0, 102, 204)); // Cursor color

// Text Area (multi-line text)
JTextArea textArea = new JTextArea(10, 30);
textArea.setFont(new Font("Courier New", Font.PLAIN, 12));
textArea.setForeground(new Color(32, 32, 32));
textArea.setBackground(new Color(240, 240, 240));
textArea.setLineWrap(true);
textArea.setWrapStyleWord(true);
```

### **Complete Styled Label Example**

```java
JLabel styledLabel = new JLabel("Hello, Beautiful World!");
styledLabel.setFont(new Font("Arial", Font.BOLD, 28));
styledLabel.setForeground(new Color(255, 87, 51));  // Orange-red
styledLabel.setHorizontalAlignment(JLabel.CENTER);
styledLabel.setOpaque(true);  // Make background visible
styledLabel.setBackground(new Color(240, 240, 240)); // Light gray background
styledLabel.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 2));
```

---

## Common Components

### **JLabel (Display Text)**

```java
JLabel label = new JLabel("Hello World");
label.setFont(new Font("Arial", Font.BOLD, 16));
label.setForeground(Color.BLUE);

// Text alignment
label.setHorizontalAlignment(JLabel.LEFT);    // Align left
label.setHorizontalAlignment(JLabel.CENTER);  // Center (default)
label.setHorizontalAlignment(JLabel.RIGHT);   // Align right

// Change text later
label.setText("New text");
String text = label.getText();
```

### **JButton (Clickable Button)**

```java
JButton button = new JButton("Click Me");
button.setFont(new Font("Arial", Font.BOLD, 14));
button.setBackground(new Color(0, 150, 255));
button.setForeground(Color.WHITE);
button.setOpaque(true);
button.setBorderPainted(false);

// Button size (optional)
button.setPreferredSize(new Dimension(150, 40));

// Add click action (see Events section below)
button.addActionListener(e -> {
    System.out.println("Button clicked!");
});
```

### **JTextField (Single-line Input)**

```java
JTextField textField = new JTextField(20);  // 20 columns wide
textField.setText("Enter text here");

// Get user input
String input = textField.getText();

// Set/clear text
textField.setText("");
textField.setEditable(false);  // Read-only
textField.setCaretPosition(textField.getText().length());  // Cursor at end
```

### **JTextArea (Multi-line Input)**

```java
JTextArea textArea = new JTextArea(10, 30);  // 10 rows, 30 columns
textArea.setText("Multi-line\ntext\nhere");
textArea.setLineWrap(true);
textArea.setWrapStyleWord(true);

// Get all text
String allText = textArea.getText();

// Append text
textArea.append("\nNew line added");

// Wrap in scroll pane for scrolling
JScrollPane scrollPane = new JScrollPane(textArea);
panel.add(scrollPane);
```

### **JCheckBox (Checkbox)**

```java
JCheckBox checkbox = new JCheckBox("I agree to terms");
checkbox.setSelected(false);

// Check if selected
if (checkbox.isSelected()) {
    System.out.println("Checkbox is checked!");
}

// Set checked
checkbox.setSelected(true);
```

### **JRadioButton (Radio Button - only one selected)**

```java
JRadioButton option1 = new JRadioButton("Option 1");
JRadioButton option2 = new JRadioButton("Option 2");
JRadioButton option3 = new JRadioButton("Option 3");

// Group them (only one can be selected)
ButtonGroup group = new ButtonGroup();
group.add(option1);
group.add(option2);
group.add(option3);

// Check which is selected
if (option1.isSelected()) {
    System.out.println("Option 1 selected");
}
```

### **JComboBox (Dropdown List)**

```java
String[] options = {"Red", "Green", "Blue", "Yellow"};
JComboBox<String> dropdown = new JComboBox<>(options);

// Get selected item
String selected = (String) dropdown.getSelectedItem();

// Add action when selection changes
dropdown.addActionListener(e -> {
    System.out.println("Selected: " + dropdown.getSelectedItem());
});

// Add/remove items
dropdown.addItem("Orange");
dropdown.removeItem("Yellow");
```

### **JList (List of Items)**

```java
String[] items = {"Item 1", "Item 2", "Item 3"};
JList<String> list = new JList<>(items);

// Get selected item
String selected = list.getSelectedValue();

// Wrap in scroll pane
JScrollPane scrollPane = new JScrollPane(list);
panel.add(scrollPane);
```

### **JProgressBar (Progress Indicator)**

```java
JProgressBar progressBar = new JProgressBar(0, 100);
progressBar.setValue(50);  // 50% progress
progressBar.setStringPainted(true);  // Show percentage

// Update progress
for (int i = 0; i <= 100; i++) {
    progressBar.setValue(i);
}
```

---

## Layout Managers

Layout managers control how components are arranged on screen.

### **FlowLayout (Default - Left to Right)**

```java
JPanel panel = new JPanel();
panel.setLayout(new FlowLayout());
// or
panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));  // alignment, hgap, vgap

// Add components - they wrap like text
panel.add(new JButton("Button 1"));
panel.add(new JButton("Button 2"));
panel.add(new JButton("Button 3"));
```

### **BorderLayout (North, South, East, West, Center)**

```java
JPanel panel = new JPanel();
panel.setLayout(new BorderLayout());

panel.add(new JLabel("NORTH"), BorderLayout.NORTH);
panel.add(new JLabel("SOUTH"), BorderLayout.SOUTH);
panel.add(new JLabel("EAST"), BorderLayout.EAST);
panel.add(new JLabel("WEST"), BorderLayout.WEST);
panel.add(new JLabel("CENTER"), BorderLayout.CENTER);

//  â”Œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”
//  â”‚      NORTH          â”‚
//  â”œâ”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”¤
//  â”‚      â”‚          â”‚   â”‚
//  â”‚WEST  â”‚ CENTER   â”‚E  â”‚
//  â”‚      â”‚          â”‚   â”‚
//  â”œâ”€â”€â”€â”€â”€â”€â”´â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”´â”€â”€â”€â”¤
//  â”‚      SOUTH          â”‚
//  â””â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”˜
```

### **GridLayout (Grid - Rows & Columns)**

```java
JPanel panel = new JPanel();
panel.setLayout(new GridLayout(3, 2, 5, 5));  // 3 rows, 2 columns, 5px gaps

// Add components - fills grid automatically
for (int i = 1; i <= 6; i++) {
    panel.add(new JButton("Button " + i));
}

// Output:
// â”Œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”
// â”‚Button 1  â”‚Button 2  â”‚
// â”œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¼â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¤
// â”‚Button 3  â”‚Button 4  â”‚
// â”œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¼â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¤
// â”‚Button 5  â”‚Button 6  â”‚
// â””â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”´â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”˜
```

### **GridBagLayout (Advanced Grid)**

```java
JPanel panel = new JPanel();
panel.setLayout(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();

// Button 1 at (0,0)
gbc.gridx = 0;
gbc.gridy = 0;
gbc.gridwidth = 1;
gbc.gridheight = 1;
panel.add(new JButton("Button 1"), gbc);

// Button 2 at (1,0), spans 2 columns
gbc.gridx = 1;
gbc.gridwidth = 2;
panel.add(new JButton("Button 2"), gbc);

// Button 3 at (0,1), spans all width
gbc.gridx = 0;
gbc.gridy = 1;
gbc.gridwidth = 3;
panel.add(new JButton("Button 3"), gbc);
```

### **BoxLayout (Horizontal or Vertical)**

```java
// Vertical layout
JPanel panel = new JPanel();
panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
panel.add(new JButton("Top"));
panel.add(new JButton("Middle"));
panel.add(new JButton("Bottom"));

// Horizontal layout
JPanel panelH = new JPanel();
panelH.setLayout(new BoxLayout(panelH, BoxLayout.X_AXIS));
panelH.add(new JButton("Left"));
panelH.add(new JButton("Right"));
```

---

## Events & Button Actions

Events happen when user interacts with GUI (clicks, types, etc.).

### **Button Click Events**

```java
JButton button = new JButton("Click Me");

// Method 1: Lambda expression (Modern, easiest)
button.addActionListener(e -> {
    System.out.println("Button clicked!");
    JOptionPane.showMessageDialog(null, "Button was clicked!");
});

// Method 2: Anonymous class
button.addActionListener(new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
    }
});

// Method 3: Implement ActionListener (old way)
public class MyGUI implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
    }
}
```

### **Text Field Events**

```java
JTextField textField = new JTextField(20);

// When user presses Enter
textField.addActionListener(e -> {
    String input = textField.getText();
    System.out.println("User entered: " + input);
});

// When user types (on each key)
textField.addKeyListener(new KeyAdapter() {
    public void keyReleased(KeyEvent e) {
        System.out.println("Current text: " + textField.getText());
    }
});
```

### **ComboBox Selection Events**

```java
JComboBox<String> dropdown = new JComboBox<>(new String[]{"Red", "Green", "Blue"});

dropdown.addActionListener(e -> {
    String selected = (String) dropdown.getSelectedItem();
    System.out.println("Selected: " + selected);
});
```

### **Pop-up Dialog Windows**

```java
// Simple message
JOptionPane.showMessageDialog(null, "Hello!");

// Message with title
JOptionPane.showMessageDialog(null, "This is a message", "Title", JOptionPane.INFORMATION_MESSAGE);

// Confirmation (Yes/No)
int result = JOptionPane.showConfirmDialog(null, "Are you sure?");
if (result == JOptionPane.YES_OPTION) {
    System.out.println("User said YES");
} else if (result == JOptionPane.NO_OPTION) {
    System.out.println("User said NO");
}

// Input dialog
String input = JOptionPane.showInputDialog("Enter your name:");
System.out.println("You entered: " + input);

// Error message
JOptionPane.showMessageDialog(null, "An error occurred!", "Error", JOptionPane.ERROR_MESSAGE);

// Warning message
JOptionPane.showMessageDialog(null, "Warning!", "Warning", JOptionPane.WARNING_MESSAGE);
```

---

## Complete Examples

### **Example 1: Simple Calculator UI**

```java
import javax.swing.*;
import java.awt.*;

public class SimpleCalculator extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;
    
    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(240, 240, 240));
        
        // Title
        JLabel title = new JLabel("Calculator");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(0, 102, 204));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(20));
        panel.add(title);
        panel.add(Box.createVerticalStrut(20));
        
        // Input field
        JLabel label = new JLabel("Number 1:");
        inputField = new JTextField(15);
        inputField.setMaximumSize(new Dimension(300, 30));
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        
        panel.add(label);
        panel.add(inputField);
        panel.add(Box.createVerticalStrut(10));
        
        // Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 240, 240));
        
        JButton addButton = new JButton("+");
        addButton.setBackground(new Color(34, 177, 76));  // Green
        addButton.setForeground(Color.WHITE);
        addButton.setOpaque(true);
        addButton.addActionListener(e -> {
            int num = Integer.parseInt(inputField.getText());
            resultLabel.setText("You entered: " + num);
        });
        
        buttonPanel.add(addButton);
        panel.add(buttonPanel);
        
        // Result label
        resultLabel = new JLabel("Result: ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setForeground(new Color(231, 76, 60));  // Red
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(20));
        panel.add(resultLabel);
        
        add(panel);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleCalculator());
    }
}
```

### **Example 2: Login Form**

```java
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class LoginForm extends JFrame {
    public LoginForm() {
        setTitle("Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        // Panel with padding
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(245, 245, 245));
        mainPanel.setBorder(new EmptyBorder(30, 40, 30, 40));
        
        // Title
        JLabel title = new JLabel("Login");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(new Color(0, 102, 204));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(title);
        mainPanel.add(Box.createVerticalStrut(20));
        
        // Username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        JTextField userField = new JTextField();
        userField.setMaximumSize(new Dimension(300, 35));
        userField.setFont(new Font("Arial", Font.PLAIN, 14));
        userField.setBorder(new LineBorder(new Color(200, 200, 200), 1));
        
        mainPanel.add(userLabel);
        mainPanel.add(userField);
        mainPanel.add(Box.createVerticalStrut(10));
        
        // Password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        JPasswordField passField = new JPasswordField();
        passField.setMaximumSize(new Dimension(300, 35));
        passField.setFont(new Font("Arial", Font.PLAIN, 14));
        passField.setBorder(new LineBorder(new Color(200, 200, 200), 1));
        
        mainPanel.add(passLabel);
        mainPanel.add(passField);
        mainPanel.add(Box.createVerticalStrut(20));
        
        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(0, 102, 204));  // Blue
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setMaximumSize(new Dimension(300, 40));
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        mainPanel.add(loginButton);
        mainPanel.add(Box.createVerticalStrut(15));
        
        // Sign up link
        JLabel signupLabel = new JLabel("Don't have account? Sign Up");
        signupLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        signupLabel.setForeground(new Color(0, 102, 204));
        signupLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(signupLabel);
        
        add(mainPanel);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm());
    }
}
```

### **Example 3: Todo List with Colors**

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TodoApp extends JFrame {
    private JTextField inputField;
    private JPanel taskPanel;
    private ArrayList<String> tasks = new ArrayList<>();
    
    public TodoApp() {
        setTitle("Todo List");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Main layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(250, 250, 250));
        
        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(41, 128, 185));  // Blue
        JLabel title = new JLabel("My Tasks");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        headerPanel.add(title);
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        
        // Input area
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        inputPanel.setLayout(new BorderLayout());
        
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        inputField.setPreferredSize(new Dimension(0, 35));
        
        JButton addButton = new JButton("Add");
        addButton.setBackground(new Color(46, 204, 113));  // Green
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Arial", Font.BOLD, 12));
        addButton.setPreferredSize(new Dimension(60, 35));
        addButton.setOpaque(true);
        addButton.setBorderPainted(false);
        
        addButton.addActionListener(e -> addTask());
        inputField.addActionListener(e -> addTask());
        
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        
        // Task list area
        taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
        taskPanel.setBackground(new Color(250, 250, 250));
        
        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        add(mainPanel);
        setVisible(true);
    }
    
    private void addTask() {
        String taskText = inputField.getText().trim();
        if (taskText.isEmpty()) return;
        
        tasks.add(taskText);
        inputField.setText("");
        refreshTaskList();
    }
    
    private void refreshTaskList() {
        taskPanel.removeAll();
        
        for (int i = 0; i < tasks.size(); i++) {
            JPanel taskItemPanel = new JPanel();
            taskItemPanel.setLayout(new BorderLayout());
            taskItemPanel.setBackground(Color.WHITE);
            taskItemPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230, 230)));
            taskItemPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
            
            // Task text
            JLabel taskLabel = new JLabel("âœ“ " + tasks.get(i));
            taskLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            taskLabel.setForeground(new Color(50, 50, 50));
            
            // Delete button
            JButton deleteBtn = new JButton("Delete");
            deleteBtn.setBackground(new Color(231, 76, 60));  // Red
            deleteBtn.setForeground(Color.WHITE);
            deleteBtn.setFont(new Font("Arial", Font.PLAIN, 11));
            deleteBtn.setOpaque(true);
            deleteBtn.setBorderPainted(false);
            
            int index = i;
            deleteBtn.addActionListener(e -> {
                tasks.remove(index);
                refreshTaskList();
            });
            
            taskItemPanel.add(taskLabel, BorderLayout.WEST);
            taskItemPanel.add(deleteBtn, BorderLayout.EAST);
            taskItemPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
            
            taskPanel.add(taskItemPanel);
        }
        
        taskPanel.revalidate();
        taskPanel.repaint();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TodoApp());
    }
}
```

---

## Common Mistakes

| âŒ Wrong | âœ… Correct | Why |
|----------|-----------|-----|
| `new JFrame()` then forget `setVisible(true)` | `setVisible(true)` at end | Window won't appear |
| `new Color(256, 0, 0)` | `new Color(255, 0, 0)` | RGB values are 0-255 |
| `button.setBackground(Color.BLUE)` without `setOpaque(true)` | Add `button.setOpaque(true)` | Background won't show on buttons |
| `frame.add(button); frame.add(textfield);` no layout | Use `setLayout(new FlowLayout())` | Components won't display properly |
| `JTextField input = new JTextField()` | `JTextField input = new JTextField(20)` | Should specify column width |
| `textfield.getText()` expects Integer | `Integer.parseInt(textfield.getText())` | getText() returns String |
| `button.addActionListener(actionEvent -> { ... })` with empty panel | `panel.add(button);` first | Button needs to be in panel |
| `frame.setSize(400, 300); frame.setVisible(true);` in wrong order | `setSize(); setVisible(true);` at end | Set properties before showing |
| `new Font("Comic Sans", 0, 14)` | `new Font("Comic Sans", Font.PLAIN, 14)` | Use Font constants, not 0 |
| Hardcoding colors | Use variables: `Color primary = new Color(...);` | Makes maintenance easier |

---

## Troubleshooting

### **"Component not showing up"**

```java
// Problem: Button doesn't appear
JFrame frame = new JFrame();
frame.add(new JButton("Click"));
frame.setSize(400, 300);
frame.setVisible(true);

// Solution: Need layout manager
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JPanel panel = new JPanel();  // Create panel
panel.add(new JButton("Click"));
frame.add(panel);  // Add panel to frame
frame.setVisible(true);
```

### **"Text color not showing"**

```java
// Problem: Text not visible
JButton button = new JButton("Click");
button.setForeground(Color.WHITE);
button.setBackground(Color.BLUE);

// Solution: Need setOpaque() for buttons
button.setOpaque(true);
button.setBorderPainted(false);
```

### **"Window appears behind other windows"**

```java
// Solution: Center and bring to front
frame.setLocationRelativeTo(null);
frame.setAlwaysOnTop(true);  // Keep on top (optional)
frame.toFront();  // Bring to front
```

### **"Input field not working"**

```java
// Problem: getText() not reading input
JTextField field = new JTextField();
String input = field.getText();  // Empty string

// Solution: Check after user input (in ActionListener)
field.addActionListener(e -> {
    String input = field.getText();  // Now has user's input
    System.out.println(input);
});
```

### **"Layout looks messy"**

```java
// Solution: Choose right layout manager
JPanel panel = new JPanel(new BorderLayout());  // Use BorderLayout

panel.add(titleLabel, BorderLayout.NORTH);
panel.add(centerContent, BorderLayout.CENTER);
panel.add(buttons, BorderLayout.SOUTH);
```

---

## Quick Color Cheat Sheet

```java
// Predefined colors
Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE,
Color.BLACK, Color.WHITE, Color.GRAY, Color.CYAN, Color.MAGENTA

// Material Design Colors
new Color(63, 81, 181)      // Indigo
new Color(33, 150, 243)     // Blue
new Color(76, 175, 80)      // Green
new Color(255, 193, 7)      // Amber
new Color(255, 87, 34)      // Deep Orange
new Color(156, 39, 176)     // Purple

// UI Colors (Common)
new Color(240, 240, 240)    // Light gray (backgrounds)
new Color(200, 200, 200)    // Medium gray (borders)
new Color(100, 100, 100)    // Dark gray (text)
new Color(0, 102, 204)      // Professional blue
new Color(46, 204, 113)     // Success green
new Color(231, 76, 60)      // Error red
new Color(241, 196, 15)     // Warning yellow
```

---

## Font Cheat Sheet

```java
// Title fonts
new Font("Arial", Font.BOLD, 24)
new Font("Times New Roman", Font.BOLD, 20)

// Button fonts
new Font("Arial", Font.BOLD, 14)

// Label fonts
new Font("Arial", Font.PLAIN, 12)

// Code/mono fonts
new Font("Courier New", Font.PLAIN, 11)
new Font("Consolas", Font.PLAIN, 11)

// Bold & Italic combinations
Font.PLAIN
Font.BOLD
Font.ITALIC
Font.BOLD | Font.ITALIC
```

---

## Next Steps: What to Learn Next

1. **JTable** - Display data in table format
2. **JMenuBar** - Add menus to your app
3. **Graphics2D** - Draw shapes and graphics
4. **File I/O** - Save/load data
5. **Threads** - Make long operations non-blocking
6. **Database** - Connect to MySQL/SQLite
7. **MVC Pattern** - Organize code better

---

## Pro Tips

- ðŸ’¡ **Use SwingUtilities.invokeLater()** for thread safety
- ðŸ’¡ **Test colors locally** before using in production
- ðŸ’¡ **Use consistent fonts** across your app
- ðŸ’¡ **Add tooltips** with button.setToolTipText("Help text")
- ðŸ’¡ **Use icons** for professional look: JButton with ImageIcon
- ðŸ’¡ **Keep color palette small** (2-3 main colors + accents)
- ðŸ’¡ **Test on different screen sizes** with frame.setBounds()
- ðŸ’¡ **Use MigLayout library** for advanced layouts (optional)

---

## Import Statements You'll Need

```java
import javax.swing.*;           // Main GUI components
import javax.swing.border.*;    // Borders
import java.awt.*;              // Colors, Fonts, layouts
import java.awt.event.*;        // Events (ActionListener, etc)
import java.util.*;             // ArrayList, etc
```

---

**Remember:** Building GUIs is about practice. Start with simple examples, test frequently, and gradually add features. Happy coding! ðŸŽ¨âœ¨