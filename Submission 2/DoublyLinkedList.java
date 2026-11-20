public class DoublyLinkedList {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head = null;

    void insertFirst(int data) {
        Node newNode = new Node(data);

        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }

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
        newNode.prev = temp;
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

        Node temp = head;

        for (int i = 0; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("invalid position");
            return;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

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
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }

        temp.next = newNode;
    }

    void insertBefore(int key, int data) {
        Node temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("key not found");
            return;
        }

        if (temp == head) {
            insertFirst(data);
            return;
        }

        Node newNode = new Node(data);

        newNode.prev = temp.prev;
        newNode.next = temp;

        temp.prev.next = newNode;
        temp.prev = newNode;
    }

    void deleteFirst() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        head = head.next;

        if (head != null) {
            head.prev = null;
        }
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

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;
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

        for (int i = 0; i < pos && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("invalid position");
            return;
        }

        temp.prev.next = temp.next;

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }

    void deleteByValue(int key) {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        Node temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("key not found");
            return;
        }

        if (temp == head) {
            deleteFirst();
            return;
        }

        if (temp.next == null) {
            deleteLast();
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    void display() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertFirst(20);
        list.insertFirst(10);
        list.insertLast(40);
        list.insertAtPosition(30, 2);

        System.out.println("original list:");
        list.display();

        list.insertAfter(20, 25);
        System.out.println("after insertAfter:");
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