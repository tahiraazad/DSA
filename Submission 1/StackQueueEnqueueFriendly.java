import java.util.Stack;

class StackQueueEnqueueFriendly {

    static class StackQueueEnqueue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        void enqueue(int x) {
            s1.push(x);
        }

        void dequeue() {
            if (s1.isEmpty() && s2.isEmpty()) {
                return;
            }
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            s2.pop();
        }
        void display() {
            if (s1.isEmpty() && s2.isEmpty()) {
                System.out.println("queue is empty");
                return;
            }
            for (int i = s2.size() - 1; i >= 0; i--) {
                System.out.print(s2.get(i));
            }
            for (int i = 0; i < s1.size(); i++) {
                System.out.print(s1.get(i));
            }
        }
    }

    public static void main(String[] args) {
        StackQueueEnqueue q = new StackQueueEnqueue();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println("elements: ");
        q.display(); 
        System.out.println();
        q.dequeue();          
        System.out.println("elements after dequeue: ");
        q.display();
    }
}
