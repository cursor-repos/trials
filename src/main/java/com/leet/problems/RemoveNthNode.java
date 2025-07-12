package com.leet.problems;

import com.leet.common.*;

public class RemoveNthNode {


    public static void main(String[] args) {

    }

    public static Node removeNthLastNode(Node head, int n) {

        // Replace this placeholder return statement with your code

        Node temp = head;
        int length =0;

        while(temp!= null) {
            temp = temp.next;
            length++;
        }

        temp = head;
        for (int i=0; i<length-n-1; i++){
            temp = temp.next;
        }

        if( length == n)
            return head.next;

        Node t = temp.next;
        temp.next = t.next;
        t.next= null;

        return head;
    }

}
