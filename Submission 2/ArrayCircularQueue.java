public class ArrayCircularQueue {
    
    int size = 5;
    int[] queue = new int[size];

    int front = -1;
    int rear = -1;

    void enqueue(int x) {
        if ((rear + 1) % size == front) {
            System.out.println("queue is full");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % size;
        queue[rear] = x;        
    }

    void dequeue() {
        if (front == -1) {
            System.out.println("queue is empty");
            return;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    void display() {
        if (front == -1) {
            System.out.println("queue is empty");
            return;
        }
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) {
                break;
            }
            i = (i + 1) % size;
        }
    }

    int getFront() {
        if (front == -1) {
            System.out.println("queue is empty");
            return -1;
        }
        return queue[front];
    }

    int getRear() {
        if (rear == -1) {
            System.out.println("queue is empty");
            return -1;
        }
        return queue[rear];
    }

    int getSize() {
        if (front == -1) {
            return 0;
        }
        if (rear >= front) {
            return rear - front + 1;
        } else {
            return size - front + rear + 1;
        }
    }

    public static void main(String[] args) {
        ArrayCircularQueue q = new ArrayCircularQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50); 
        System.out.println("elements: ");
        q.display(); 
        System.out.println();
        System.out.println("front element: " + q.getFront());
        System.out.println("rear element: " + q.getRear());
        System.out.println("size of queue: " + q.getSize());
        q.dequeue();          
        System.out.println("elements after dequeue: ");
        q.display();
    }
}
