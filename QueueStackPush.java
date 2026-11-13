import java.util.LinkedList;
import java.util.Queue;

class QueueStackPushFriendly {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    void push(int x) {
        queue1.add(x);
    }

    void pop() {
        if (queue1.isEmpty())
            return;

        while (queue1.size() != 1) {
            queue2.add(queue1.peek());
            queue1.remove();
        }
        queue1.remove();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    void display() {
        if (queue1.isEmpty()) {
            System.out.println("stack is empty");
            return;
        }

        for (int x : queue1) {
            System.out.println(x);
        }
    }

}

public class QueueStackPush {
    public static void main(String[] args) {
        QueueStackPushFriendly st = new QueueStackPushFriendly();
        st.push(1);
        st.push(2);
        st.push(3);

        System.out.println("stack elements:");
        st.display();
        st.pop();
        System.out.println("after popping:");
        st.display();

    }
}
