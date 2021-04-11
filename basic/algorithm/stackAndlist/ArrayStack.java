package basic.algorithm.stackAndlist;

import java.util.Iterator;

/***
 * 数组实现栈
 * @param <Item>
 */
public class ArrayStack<Item> implements MyStack<Item> {

    // 栈元素数组，只能通过转型来创建泛型数组
    private Item[] a = (Item[]) new Object[1];

    // 元素数量
    private int N = 0;

    private void check() {

        if (N >= a.length) {
            resize(2 * a.length);

        } else if (N > 0 && N <= a.length / 4) {
            resize(a.length / 2);
        }
    }

    /**
     * 调整数组大小，使得栈具有伸缩性
     */
    private void resize(int size) {

        Item[] tmp = (Item[]) new Object[size];

        for (int i = 0; i < N; i++) {
            tmp[i] = a[i];
        }

        a = tmp;
    }

    @Override
    public MyStack<Item> push(Item item) {
        check();
        a[N++] = item;
        return this;
    }


    @Override
    public Item pop() throws Exception {

        if (isEmpty()) {
            throw new Exception("stack is empty");
        }

        Item item = a[--N];

        check();

        // 避免对象游离
        a[N] = null;

        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }


    @Override
    public int size() {
        return N;
    }


    @Override
    public Iterator<Item> iterator() {

        // 返回逆序遍历的迭代器
        return new Iterator<Item>() {

            int i = N;
            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public Item next() {
                return a[--i];
            }
        };

    }

    public static void main(String[] args) throws Exception {

        ArrayStack arrayStack = new ArrayStack();

        arrayStack.push(5);
        arrayStack.push(4);
        arrayStack.push(3);
        arrayStack.push(2);

        Iterator iterator = arrayStack.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

       // Object a = arrayStack.pop();
        //System.out.println(a);
    }
}