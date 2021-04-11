package basic.algorithm.symbolTable;

import java.util.List;

public class BinarySearchOrderedST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {
    @Override
    public int size() {
        return 0;
    }

    @Override
    public void put(Key key, Value value) {

    }

    @Override
    public Value get(Key key) {
        return null;
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public List<Key> keys(Key l, Key h) {
        return null;
    }
}
