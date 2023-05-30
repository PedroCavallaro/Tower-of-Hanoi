package stack;
public class Node<T>{
    private T info;
    private Node<T> previous;

    public Node(T info){
        this.info = info;

    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

}