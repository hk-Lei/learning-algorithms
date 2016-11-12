package linkedlist;

import linkedlist.bean.Node;

import java.util.Random;

/**
 * @author moxingxing
 * @Date 2016/7/31
 */
public class Add {

    public static void main(String[] args) {
        Node n1 = Node.getRandomInstance(6);
        Node n2 = Node.getRandomInstance(6);

        System.out.println(n1.toString());
        System.out.println(n2.toString());

        Node r = add(n1, n2);

        System.out.println(r.toString());
    }

    public static Node add(Node n1, Node n2){
        if (n1 == null)
            return n2;
        if (n2 == null)
            return n1;

        Node result;
        Node curr;

        int sum = n1.value + n2.value;
        int value = sum % 10;
        int carry = sum / 10;
        curr = new Node(value);

        result = curr;

        Node n1Next = n1.next;
        Node n2Next = n2.next;


        while (n1Next != null && n2Next != null) {
            sum = n1Next.value + n2Next.value + carry;
            value = sum % 10;
            carry = sum / 10;

            curr.next = new Node(value);

            curr = curr.next;

            n1Next = n1Next.next;
            n2Next = n2Next.next;
        }

        Node node = n1Next != null ? n1Next : n2Next;

        while (node != null) {
            sum = node.value + carry;
            value = sum % 10;
            carry = sum / 10;

            curr.next = new Node(value);

            curr = curr.next;

            node = node.next;
        }

        if (carry != 0) {
            curr.next = new Node(carry);
        }

        return result;
    }
}
