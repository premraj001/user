import java.util.Stack;

// Node class representing a node in the linked list
class Node {
    char data;
    Node next;

    // Constructor to initialize the node with data
    public Node(char data) {
        this.data = data;
        this.next = null;
    }
}

// StackLinkedList class representing a stack using linked list
class StackLinkedList {
    private Node top;

    // Constructor to initialize an empty stack
    public StackLinkedList() {
        this.top = null;
    }

    // Method to push a new node with given data onto the stack
    public void push(char data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Method to pop and return the top element from the stack
    public char pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        char data = top.data;
        top = top.next;
        return data;
    }

    // Method to peek and return the top element of the stack without popping
    public char peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }


// Method to evaluate a postfix expression
public static double evaluatePostfix(String postfix) {
    Stack<Double> stack = new Stack<>();

    // Iterate through each character in the postfix expression
    for (char ch : postfix.toCharArray()) {
        if (isOperand(ch)) {
            stack.push((double) Character.getNumericValue(ch));
        } else {
            // Pop operands, perform the operation, and push the result back onto the stack
            double operand2 = stack.pop();
            double operand1 = stack.pop();
            double result;

            switch (ch) {
                case '+':
                    result = operand1 + operand2;
                    break;
                case '-':
                    result = operand1 - operand2;
                    break;
                case '*':
                    result = operand1 * operand2;
                    break;
                case '/':
                    result = operand1 / operand2;
                    break;
                case '^':
                    result = Math.pow(operand1, operand2);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + ch);
            }

            stack.push(result);
        }
    }

    return stack.pop(); // The final result
}


    private static boolean isOperand(char ch) {
    return false;
}

    // Main method for testing the infix to postfix conversion and postfix evaluation
    public static void main(String[] args) {
        String infixExpression = "3+4*2/(1-5)^2";
        String postfixExpression = infixToPostfix(infixExpression);

        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);

        int result = (int) evaluatePostfix(postfixExpression);
        System.out.println("Result of Postfix Evaluation: " + result);
    }

    private static String infixToPostfix(String infixExpression) {
        return null;
    }
}
