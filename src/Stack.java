public class Stack<T extends Comparable<T>>{
    private int length;
    private Node<T> top;

    public Stack(){
        this.top = null;
        this.length = 0;

    }
    public void putOnTop(T disk){
        Node<T> temp = new Node<T>(disk);
        if(isEmpty()){
            
            this.top = temp;
        
        }else{
            temp.setPrevious(this.top);
            this.top = temp;
        }

        this.length ++;
    } 

    public String print(){
        Node<T> temp = this.top;
        String test = "";
        while(temp != null){

            test += "\n" + temp.getInfo();
            temp = temp.getPrevious(); 
        }   
        test += "\n";
        return test; 
    }

    public T pop(){
        if(!isEmpty()){
            Node<T> temp = this.top;
            
            this.top = this.top.getPrevious();
            this.length --;

            return temp.getInfo();
        }

        return null;
    }


    public boolean isEmpty(){
        return this.length == 0;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public Node<T> getTop() {
        return top;
    }
    public void setTop(Node<T> top) {
        this.top = top;
    }
}