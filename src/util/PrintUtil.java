package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PrintUtil {
    /**
     * 打印二维整型数组
     */
    public static void printArray(int[][] ints) {
        for (int[] i : ints) {
            for (int j : i) {
                System.out.print(j);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 打印一维整型数组
     */
    public static <T> void printArray(T[] values) {
        StringBuilder sb = new StringBuilder("[");
        for (T value : values) {
            sb.append(value).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb);
    }

    public static <T> void printArray(int[] values) {
        if (values == null) return;
        StringBuilder sb = new StringBuilder("[");
        for (int value : values) {
            sb.append(value).append(",");
        }
        if (',' == sb.charAt(sb.length() - 1)) sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb);
    }

    public static void printList(List<List<Integer>> list) {
        for (List<Integer> l : list) {
            for (Integer i : l) System.out.print(i + " ");
            System.out.println();
        }
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
