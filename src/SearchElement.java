public class SearchElement {
    Node head;

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
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

    public void searchEle(int ele) {
        Node copyHead = head;
        boolean isFound = false;
        while (copyHead != null) {
            if (copyHead.data == ele) {
                isFound = true;
                break;
            }
            copyHead = copyHead.next;
        }

        if (isFound) {
            System.out.println("Element is found : " + ele);
        } else {
            System.out.println("Elements not found..");
        }
    }

    public static void main(String[] args) {
        SearchElement list = new SearchElement();

        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.printList();

        list.searchEle(2);
    }

}
