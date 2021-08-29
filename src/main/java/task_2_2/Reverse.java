package task_2_2;

import java.util.Iterator;
import java.util.List;

public class Reverse<T> implements Iterator<T>, Iterable<T> {

    private List<T> list;
    private int position;

    public Reverse(List<T> list) {
        this.list = list;
        this.position = list.size() - 1;
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }

    @Override
    public T next() {
        return list.get(position--);
    }

    @Override
    public boolean hasNext() {
        return position >= 0;
    }


    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}
