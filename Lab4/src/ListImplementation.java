import java.util.*;

class CustomList<E> implements List<E> {
    private Node<E> head;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }
    public class CustomIterator implements Iterator<E>{
        private Node<E> current = head;

        @Override
        public boolean hasNext() {

            return current != null;
        }

        @Override
        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(Node<E> current = head; current != null; current = current.next){
            if((o == null && current.data == null) || (o != null && o.equals(current.data))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {

        return new CustomIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for(Node<E> current = head; current != null; current = current.next){
            array[index] = current.data;
            index++;
        }
        return array;
    }

    @Override
    public <E> E[] toArray(E[] a) {
       return null;
    }

    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>(e);
        if(head == null){
            head = newNode;
        }
        else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(o == null){
            for(Node<E> current = head, previous = null; current != null; previous = current, current = current.next ){
                if(current.data == null){
                    if(previous == null){
                        head = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    size--;
                    return true;
                }
            }
        } else{
            for(Node<E> current = head, previous = null; current != null; previous = current, current = current.next ){
                if(o.equals(current.data)){
                    if(previous == null){
                        head = current.next;
                    } else{
                        previous.next = current.next;
                    }
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object element : c){
            if(contains(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E element : c) {
            add(element);
        }
        return true;
    }


    @Override
    public boolean addAll(int index, Collection<? extends E> c) {

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object element : c) {
            for (Node<E> current = head, previous = null; current != null; previous = current, current = current.next) {
                if ((element == null && current.data == null) || (element != null && element.equals(current.data))) {
                    if (previous == null) {
                        head = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    size--;
                    modified = true;
                }
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (Node<E> current = head, previous = null; current != null; previous = current, current = current.next) {
            if (!c.contains(current.data)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        while (head != null){
            Node<E> nextNode = head.next;
            head.data = null;
            head.next = null;
            head = nextNode;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

    @Override
    public E set(int index, E element) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        E previousData = current.data;
        current.data = element;
        return previousData;
    }

    @Override
    public void add(int index, E element) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node<E> newNode = new Node<>(element);

        if(index == 0){
            newNode.next = head;
            head = newNode;
        }
        else{
            Node<E> current = head;
            for(int i = 0; i < index - 1; i++){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            E removedData = head.data;
            head = head.next;
            size--;
            return removedData;
        }
        else {
            Node<E> current = head;
            for(int i = 0; i < index - 1; i++){
                current = current.next;
            }
            E removedData = current.next.data;
            current.next = current.next.next;
            size--;
            return removedData;
        }
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for(Node<E> current = head; current != null; current = current.next){
            if((o == null && current.data == null) || (o != null && o.equals(current.data))){
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = 0;
        int lastIndex = -1;
        for(Node<E> current = head; current != null; current = current.next){
            if((o == null && current.data == null) || (o != null && o.equals(current.data))){
                lastIndex = index;
            }
            index++;
        }
        return lastIndex;
    }
    private class CustomListIterator implements ListIterator<E>{
        private Node<E> nextNode;
        private Node<E> lastReturned;
        private int nextIndex;

        public CustomListIterator(int index) {
            if(index < 0 || index > size){
                throw new IndexOutOfBoundsException();
            }
            nextNode = head;
            for(int i = 0 ; i < index; i++){
                nextNode = nextNode.next;
            }
            lastReturned = null;
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            lastReturned = nextNode;
            nextNode = nextNode.next;
            nextIndex++;
            return lastReturned.data;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (nextNode == null) {
                nextNode = lastReturned;
            } else {
                return null;
            }
            lastReturned = nextNode;
            nextIndex--;
            return lastReturned.data;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(E e) {
            if(lastReturned == null){
                throw new IllegalStateException("ERROR");
            }
            lastReturned.data = e;
        }

        @Override
        public void add(E e) {
                lastReturned = null;
                if(nextNode == null) {
                    return;
                }
                else {
                    nextIndex++;
                }
        }
    }
    @Override
    public ListIterator<E> listIterator() {
        return new CustomListIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        return new CustomListIterator(index);
    }


    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

}
