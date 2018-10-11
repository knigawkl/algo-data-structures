package heap;

public class Main {
    public static void main(String[] args) {
        
        Double[] list = {2.3, 22.3, 12.3};
        
        Heap<Double> heap = new Heap<>(list);
        System.out.println(heap.toString());
        heap.put(123.4);
        System.out.println(heap.toString());
        heap.pop();
        System.out.println(heap.toString());
        heap.put(2343973.4);
        System.out.println(heap.toString());
        heap.put(2.1);
        System.out.println(heap.toString());
    }
}
