public class SinglyLinkedList {
    
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    void insertFirst(int data) {
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
    }

    void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    void insertAtPosition(int data, int pos) {
        if (pos < 0) {
            System.out.println("invalid position");
            return;
        }

        if (pos == 0) {
            insertFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 0; i < pos -1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("invalid position");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    void insertAfter(int key, int data) {
        Node temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("key not found");
            return;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        temp.next = newNode;
    }

    void insertBefore(int key, int data) {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        if (head.data == key) {
            insertFirst(data);
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("key not found");
            return;
        }

        Node newNode = new Node(data);
        
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteFirst() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        head = head.next;
    }

    void deleteLast() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next; 
        }

        temp.next = null;
    }

    void deleteAtPosition(int pos) {
        if (pos < 0 || head == null) {
            System.out.println("invalid position");
            return;
        } 

        if (pos == 0) {
            deleteFirst();
            return;
        }

        Node temp = head;

        for (int i = 0; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("invalid position");
            return;
        }

        temp.next = temp.next.next;
    }

    void deleteByValue(int key) {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        if (head.data == key) {
            deleteFirst();
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("key not found");
            return;
        }

        temp.next = temp.next.next;
    }

    void display() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ->");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertFirst(20);
        list.insertFirst(30);
        list.insertFirst(40);
        list.insertAtPosition(50, 2);
        System.out.println("original list: ");
        list.display();

        list.insertAfter(20, 25);
        System.out.println("after insertAfter: ");
        list.display();

        list.insertBefore(40, 35);
        System.out.println("after insertBefore:");
        list.display();

        list.deleteFirst();
        System.out.println("after deleteFirst:");
        list.display();

        list.deleteLast();
        System.out.println("after deleteLast:");
        list.display();

        list.deleteAtPosition(1);
        System.out.println("after deleteAtPosition:");
        list.display();

        list.deleteByValue(25);
        System.out.println("after deleteByValue:");
        list.display();
    }
}
