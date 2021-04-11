package basic.algorithm.symbolTable;

/***
 * 符号表（Symbol Table）是一种存储键值对的数据结构，可以支持快速查找操作。
 *
 * 符号表分为有序和无序两种，有序符号表主要指支持 min()、max() 等根据键的大小关系来实现的操作。
 *
 * 有序符号表的键需要实现 Comparable 接口。
 * @param <Key>
 * @param <Value>
 */
public interface UnorderedST<Key, Value> {

    int size();

    Value get(Key key);

    void put(Key key, Value value);

    void delete(Key key);
}