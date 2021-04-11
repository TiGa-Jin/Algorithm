package basic.algorithm.symbolTable;

/***
 * 初级实现
 * 1. 链表实现无序符号表
 */

public class ListUnorderedST<Key, Value> implements UnorderedST<Key, Value> {

    private class Node{

        Key key;
        Value value;
        Node next;

        Node(Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node first;

    @Override
    public int size() {

        int size = 0;
        Node cur = first;
        while (cur != null){
            size++;
            cur = cur.next;
        }
        return size;
    }

    @Override
    public Value get(Key key) {

        Node cur = first;
        while (cur != null){
            if(cur.key.equals(key))
                return cur.value;

            cur = cur.next;
        }
        return null;
    }

    @Override
    public void put(Key key, Value value) {

        Node cur = first;

        // 如果在链表中找到节点的键等于key，就更新这个节点的值为value
        while (cur != null){
            if (cur.key.equals(key)){
                cur.value = value;
                return;
            }

            cur = cur.next;
        }
        // 否则使用头插法插入一个新节点
        first = new Node(key, value, first);

    }

    @Override
    public void delete(Key key) {

        if (first == null)
            return;
        if (first.key.equals(key))
            first = first.next;
        Node pre = first;
        Node cur = first.next;
        while (cur != null){
            if (cur.key.equals(key)){
                pre.next = cur.next;
                return;
            }
            pre = pre.next;
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        ListUnorderedST listUnorderedST = new ListUnorderedST();
        listUnorderedST.put(1, 'A');
        listUnorderedST.put(2, 'B');
        listUnorderedST.put(3, 'X');
        System.out.println(listUnorderedST.size());
        System.out.println(listUnorderedST.get(2));
        listUnorderedST.delete(1);
        System.out.println(listUnorderedST.get(1));


    }
}
