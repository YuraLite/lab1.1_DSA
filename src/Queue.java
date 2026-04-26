public class Queue {
    private Integer[] array;
    private int last;

    public Queue(int size){
        array = new Integer[size];
        last =-1;
    }
    private boolean isFull(){

        return (last == array.length-1);
    }

    private boolean isEmpty(){

        return (last == -1);
    }
    public boolean enqueue (int value){
        if (value < 0) {
            throw new IllegalArgumentException("Значення мусить бути додатнім");
        }

        if(isFull()){

            return false;

        }

        array [last+1] = value;

        last++;

        return true;

    }

    public Integer dequeue () {//видалення

        if(isEmpty()) {

            return null;

        }

        int temp = array[0];

        for(int i = 0; i < last; i++) {

            array[i] = array [i+1];

        }

        array[last--] = null;

        return temp;

    }
    public void printQueue() {
        Queue temp = new Queue(array.length);

        while (true) {
            Integer val = this.dequeue();
            if (val == null) break;

            System.out.println(val);
            temp.enqueue(val);
        }

        while (true) {
            Integer val = temp.dequeue();
            if (val == null) break;

            this.enqueue(val);
        }
    }
}