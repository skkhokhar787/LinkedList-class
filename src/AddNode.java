public class AddNode {
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

    public void addLast  (int data) {
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

    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public void addOnXNode (int data, int x) {
        Node newNode = new Node(data);

        // Inserting at position 0
        if (x == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node currNode = head;
        int count = 0;

        // Traverse to node just before position x
        while (currNode != null && count < x - 1) {
            currNode = currNode.next;
            count++;
        }

        // If position is beyond list length
        if (currNode == null) {
            System.out.println("Position out of bounds");
            return;
        }

        // Insert new node
        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    public static void main (String [] args) {
        AddNode list = new AddNode();

        list.addFirst(1);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);

        list.printList();

        list.addOnXNode(2,1);

        list.printList();
    }
}
