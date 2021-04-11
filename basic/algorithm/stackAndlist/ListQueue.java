package basic.algorithm.stackAndlist;


import java.util.Iterator;

/**
 * 队列
 * 下面是队列的链表实现，需要维护 first 和 last 节点指针，分别指向队首和队尾。
 *
 * 这里需要考虑 first 和 last 指针哪个作为链表的开头。因为出队列操作需要让队首元素的下一个元素成为队首，所以需要容易获取下一个元素，而链表的头部节点的 next 指针指向下一个元素，因此可以让 first 指针链表的开头。
 * @param <Item>
 */
public class ListQueue<Item> implements MyQueue<Item> {

    private  class Node{
        Item item;
        Node next;
    }

    private  Node first;
    private  Node last;
    int N = 0;

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public MyQueue<Item> add(Item item) {

        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;

        if (isEmpty()){
            last = newNode;
            first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        N++;
        return this;
    }

    @Override
    public Item remove() throws Exception {

        if (isEmpty()){
            throw new Exception("Queue is empty!");
        }
        Node node = first;
        first = first.next;
        N--;
        if (isEmpty()){
            last =null;
        }

        return node.item;
    }

    @Override
    public Iterator<Item> iterator() {

        return new Iterator<Item>() {

            Node cur = first;

            @Override
            public boolean hasNext() {

                return cur != null;
            }

            @Override
            public Item next() {
                Item itm = cur.item;
                cur = cur.next;
                return itm;
            }
        };
    }
    public static void main(String[] args) throws Exception {

        ListQueue listQueue = new ListQueue();

        listQueue.add(5);
        listQueue.add(4);
        listQueue.add(3);
        listQueue.add(2);

        Iterator iterator = listQueue.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
