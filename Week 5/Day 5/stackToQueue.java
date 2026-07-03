import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private final Queue<Integer> dataContainer;

    public MyStack() {
        this.dataContainer = new LinkedList<>();
    }
    
    public void push(int x) {
        int activeElements = dataContainer.size();
        dataContainer.add(x);
        
        while (activeElements > 0) {
            dataContainer.add(dataContainer.poll());
            activeElements--;
        }
    }
    
    public int pop() {
        if (this.empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return dataContainer.poll();
    }
    
    public int top() {
        if (this.empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return dataContainer.peek();
    }
    
    public boolean empty() {
        return dataContainer.isEmpty();
    }
}