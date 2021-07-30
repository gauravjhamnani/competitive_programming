import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    private Queue<String> q1 = new LinkedList<>();
    private Queue<String> q2 = new LinkedList<>();

    public void push(String item) {
        if (!q1.isEmpty()) {
            q1.add(item);
        } else {
            q2.add(item);
        }
    }

    public String pop() {
        if (size() == 0) {
            return null;
        }
        Queue<String> from = q2, to = q1;
        if (!q1.isEmpty()) {
            from = q1;
            to = q2;
        }
        while (from.size() != 1) {
            to.add(from.remove());
        }
        return from.remove();
    }

    public int size() {
        return q1.size() + q2.size();
    }
}