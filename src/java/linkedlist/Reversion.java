package linkedlist;

import linkedlist.bean.Node;

/**
 * @author moxingxing
 * @Date 2016/10/2
 */
public class Reversion {

    public static void main(String[] args) {
        Node n = Node.getRandomInstance(8);
        System.out.println(n.toString());

        Node head = reverse(n, 1, 8);

        System.out.println(head.toString());
    }

    public static Node reverse(Node head, int from, int to){
        if (head == null || head.next == null)
            return head;

        Node pHead = new Node(0);
        pHead.next = head;
        Node cPre = null;
        Node curr = null;
        int i = 0;

        if (from == 1)
            cPre = pHead;
        else {
            for (i=0; i<from-1; i++) {
                curr = head;
                head = curr.next;
            }
            cPre = curr;
        }

        curr = head;
        Node cNext;
        Node cTemp;

        for (; i<to-1; i++) {
            cTemp = curr.next;
            cNext = cTemp.next;

            curr.next = cNext;
            cPre.next = cTemp;
            cTemp.next = head;
            head = cTemp;
        }

        return pHead.next;
    }
}
