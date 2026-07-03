import java.util.Stack;

class MyQueue {
    private final Stack<Integer> inputStorage;
    private final Stack<Integer> outputStorage;

    public MyQueue() {
        this.inputStorage = new Stack<>();
        this.outputStorage = new Stack<>();
    }
    
    public void push(int x) {
        inputStorage.push(x);
    }
    
    public int pop() {
        shiftElements();
        if (outputStorage.isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }
        return outputStorage.pop();
    }
    
    public int peek() {
        shiftElements();
        if (outputStorage.isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }
        return outputStorage.peek();
    }
    
    public boolean empty() {
        return inputStorage.isEmpty() && outputStorage.isEmpty();
    }

    private void shiftElements() {
        if (outputStorage.isEmpty()) {
            while (!inputStorage.isEmpty()) {
                outputStorage.push(inputStorage.pop());
            }
        }
    }
}