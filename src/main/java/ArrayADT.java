public class ArrayADT {

    private int array[];
    // capacity
    private int size;
    // number of elements
    private int length;

    public ArrayADT(int size) {
        this.size = size;
        this.array = new int[size];
        this.length = 0;
    }

    public void display() {
        System.out.println("Elements are: ");
        for (int i = 0; i < this.length; i++) {
            System.out.printf("%d ", this.array[i]);
        }
    }

    public void add(int x) {
        this.array[this.length] = x;
        this.length++;
    }
}
