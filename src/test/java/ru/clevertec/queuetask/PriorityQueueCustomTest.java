package ru.clevertec.queuetask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueCustomTest {

    @Test
    void pushTest() {
        PriorityQueueCustom<Integer> queue = new PriorityQueueCustom<Integer>((a,b)->a-b);
        queue.push(3);
        queue.push(5);
        queue.push(1);
        queue.push(4);
        queue.push(2);
        queue.showElements();
        int res = queue.peek();
        Assertions.assertEquals(res, 1);
    }

    @Test
    void pollTest() {
        PriorityQueueCustom<Integer> queue = new PriorityQueueCustom<Integer>();
        queue.push(3);
        queue.push(5);
        queue.push(1);
        queue.push(4);
        queue.push(2);
        queue.showElements();
        System.out.println(queue.poll());
        queue.showElements();
        System.out.println(queue.poll());
        queue.showElements();
        int res = queue.poll();
        queue.showElements();
        Assertions.assertEquals(res, 3);
    }

    @Test
    void peekTest() {
        PriorityQueueCustom<Integer> queue = new PriorityQueueCustom<Integer>(Comparator.naturalOrder());
        queue.push(5);
        queue.push(3);
        queue.peek();
        int res = queue.peek();
        Assertions.assertEquals(res, 3);
    }

    @Test
    void usingNotComparableTypeTest(){
        PriorityQueueCustom<List<Object>> queue = new PriorityQueueCustom();
        queue.push(List.of(2,4));
        Assertions.assertThrows(ClassCastException.class, ()->queue.push(List.of(3,5)));
    }

    @Test
    void pushBigSizeTest() {
        PriorityQueueCustom<Integer> queue = new PriorityQueueCustom<Integer>();
        queue.push(50);
        queue.push(39);
        queue.push(21);
        queue.push(6);
        queue.push(10);
        queue.push(75);
        queue.push(60);
        queue.push(40);
        queue.push(17);
        queue.showElements();
        System.out.println(queue.poll());
        queue.showElements();
        System.out.println(queue.poll());
        queue.showElements();
        System.out.println(queue.poll());
        int res = queue.poll();
        queue.showElements();
        Assertions.assertEquals(res, 21);
    }

    @Test
    void pollWithEqualsElementsTest() {
        PriorityQueueCustom<String> queue = new PriorityQueueCustom<String>();
        queue.push("bd");
        queue.push("cv");
        queue.push("ac");
        queue.push("bd");
        queue.push("bd");
        queue.showElements();
        System.out.println(queue.poll());
        queue.showElements();
        System.out.println(queue.poll());
        queue.showElements();
        String res = queue.poll();
        queue.showElements();
        Assertions.assertEquals(res, "bd");
    }
}