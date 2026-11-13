import java.util.ArrayList;

class UnboundedArrayStack {
    ArrayList<Integer> arr = new ArrayList<>();

    void push(int x) {
        arr.add(x);
    }

    int pop() {
        if (arr.isEmpty()) {
            System.out.println("stack underflow");
            return -1;
        }
        int val = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        return val;
    }

    int peek() {
        if (arr.isEmpty()) {
            System.out.println("stack empty");
            return -1;
        }
        return arr.get(arr.size() - 1);
    }

    boolean isEmpty() {
        return arr.isEmpty();
    }

    int size() {
        return arr.size();
    }

    public static void main(String[] args) {
        UnboundedArrayStack st = new UnboundedArrayStack();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4); 

        System.out.println("popped: " + st.pop());
        System.out.println("top element: " + st.peek());
        System.out.println("is stack empty: " + (st.isEmpty() ? "yes" : "no"));
        System.out.println("current size: " + st.size());
    }
}
