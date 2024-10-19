package DataStructure;

import java.util.Comparator;

// Define the parent class double linked list
public class List<T> {

    private static class Node<U> {
        public U data;

        Node<U> prev;
        Node<U> next;

        public Node(U data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        public U getData() {
            return data;
        }

        public void setData(U data) {
            this.data = data;
        }
    }

    public Node<T> head;

    public List() {
        this.head = null;
    }

    // Add a node to the end of the list
    public void addLast(T data) {
        Node<T> i = new Node<>(data);
        if (head == null) {
            head = i;
        } else {
            Node<T> p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = i;
            i.prev = p;
        }
    }

    // Add a node to the end of the list
    public void addFirst(T data) {
        Node<T> i = new Node<>(data);
        i.next = head;
        if (head != null) {
            head.prev = i;
        }
        head = i;
    }

    public void delete(T data) {
        Node<T> p = head;

        while (p != null) {
            if (p.data.equals(data)) {
                if (p.prev != null) {
                    p.prev.next = p.next;
                } else {
                    head = p.next;
                }

                if (p.next != null) {
                    p.next.prev = p.prev;
                }

                return; // Insert a node at the head of the list. After the node is found and deleted, the function ends
            }
            p = p.next;
        }
    }

    public Node<T> find(T data) {
        Node<T> p = head;

        while (p != null) {
            if (p.data.equals(data)) {
                return p;
            }

            p = p.next;
        }

        return null; // Find the node for the specified data.If not found, null is returned
    }

    // print
    public void print() {
        Node<T> p = head;

        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }

        System.out.println();
    }

    //  Get the node value based on the node location
    public T getDataByIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index should be positive: " + index);
        }

        Node<T> p = head;
        int i = 0;

        while (p != null) {
            if (i == index) {
                return p.data;
            }
            p = p.next;
            i++;
        }

        return null;
    }

    // Get the number of linked list nodes
    public int size() {
        Node<T> p = head;
        int i = 0;

        while (p != null) {
            i++;
            p = p.next;
        }
        return i;
    }

    public T last() {
        if (head == null) {
            return null;
        }

        Node<T> p = head;
        while (p.next != null) {
            p = p.next;
        }

        return p.data;
    }

    // clear the list
    public void clear() {
        head = null;
    }

    public int getIndexByData(T data) {
        Node<T> p = head;
        int i = 0;

        while (p != null) {
            if (p.data == data) {
                return i;
            }
            p = p.next;
            i++;
        }

        return -1;
    }

    public void quickSort(Comparator<T> comparator) {
        head = quickSort(head, comparator);
    }

    // quick sort
    private Node<T> quickSort(Node<T> head, Comparator<T> comparator) {
        if (head == null || head.next == null) {
            return head;
        }

        Node<T> middle = getMiddle(head);
        Node<T> left = head;
        Node<T> right = middle.next;
        middle.next = null;
        left = quickSort(left, comparator);
        right = quickSort(right, comparator);
        return merge(left, right, comparator);
    }

    private Node<T> getMiddle(Node<T> head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node<T> slow = head;
        Node<T> fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private Node<T> merge(Node<T> left, Node<T> right, Comparator<T> comparator) {
        Node<T> dummy = new Node<>(null);
        Node<T> current = dummy;

        while (left != null && right != null) {
            if (comparator.compare(left.data, right.data) < 0) {
                current.next = left;
                left.prev = current;
                left = left.next;
            } else {
                current.next = right;
                right.prev = current;
                right = right.next;
            }
            current = current.next;
        }

        if (left != null) {
            current.next = left;
            left.prev = current;
        }

        if (right != null) {
            current.next = right;
            right.prev = current;
        }

        return dummy.next;
    }

    public String toString() {
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            content.append(this.getDataByIndex(i).toString());
            content.append("\n");
        }
        return content.toString();
    }

}


