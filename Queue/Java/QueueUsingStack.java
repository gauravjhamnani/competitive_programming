import java.util.Stack;

public class QueueUsingStack {

    private Stack<String> s1 = new Stack<>();
    private Stack<String> s2 = new Stack<>();

    public void enqueue(String item) {
        s1.push(item);
    }

    public String deque() {
        if (size() == 0) {
            return null;
        }
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int size() {
        return s1.size() + s2.size();
    }
}
