package linkedlist.bean;

import java.util.Random;

public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this(value, null);
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public boolean hasNext(){
        if (next != null)
            return true;
        else
            return false;
    }

    public static Node getRandomInstance(int length){
        if (length <= 0) {
            return null;
        }

        Node node = null;
        Random random = new Random();
        Node cur = null;

        for (int i = 0; i < length; i ++) {
            Node n = new Node(random.nextInt(20));
            if (i == 0)
                node = n;
            else if (i < length - 1)
                cur.next = n;
            else {
                if (n.value != 0)
                    cur.next = n;
                break;
            }
            cur = n;
        }

        return node;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        Node node = this;
        do {
            buffer.append(node.value);
            node = node.next;
            if (node != null) {
                buffer.append(" -> ");
            }
        } while (node != null);

        return buffer.toString();
    }
}