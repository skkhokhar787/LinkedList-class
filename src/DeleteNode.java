public class DeleteNode {
    Node head;

    public static class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst (int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast (int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    public void printList () {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public Node deleteByValue(Node head, int target) {
        if (head == null) {
            return null;
        }

        // Case: target is at the head
        if (head.data == target) {
            return head.next;
        }

        Node current = head;
        while (current.next != null && current.next.data != target) {
            current = current.next;
        }

        // If the next node is the one to delete
        if (current.next != null) {
            current.next = current.next.next;
        }

        return head;
    }

    public void removeFirst() {
        if (head.next == null) {
            return;
        }
        head = head.next;
    }

    public void removeLast() {
        Node currHead = head;
        if (head == null) {
            return;
        }
        Node currNode = null;
        while (currHead.next != null) {
            currNode = currHead;
            currHead = currHead.next;
        }
        currNode.next = null;
    }

    public static void main (String [] args) {
        DeleteNode list = new DeleteNode();

        list.addFirst(1);
        list.addLast(4);
        list.addLast(6);
        list.addLast(9);
        list.addLast(7);
        list.addLast(5);
        list.addLast(2);

        list.printList();

        list.head =  list.deleteByValue(list.head,7);
        list.removeFirst();
        list.removeLast();
        list.printList();

    }

}
