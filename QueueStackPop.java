import java.util.LinkedList;
import java.util.Queue;

class QueueStackPopFriendly {
    
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    
    public void push(int x) {
        queue2.add(x);

        while (!queue1.isEmpty()) {
            queue2.add(queue1.peek());
            queue1.remove();
        }

        Queue<Integer> t = queue1;
        queue1 = queue2;
        queue2 = t;
    }
    
    public void pop() {
        if (queue1.isEmpty())
            return;
        queue1.remove();
    }
    
    public void display() {
    if (queue1.isEmpty()) {
        System.out.println("stack is empty");
        return;
    }

    for (int x : queue1) {
        System.out.println(x);
    }
}  
}

public class QueueStackPop {
    public static void main(String[] args) {
        QueueStackPopFriendly st = new QueueStackPopFriendly();
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