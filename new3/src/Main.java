public class Main {
    public static void main(String[] args) {
        Integer[] array1 = {2, 3, 4};
        printArray(array1);
        Long[] array2 = {2L, 3L, 4L};
        printArray(array2);
        Box<Integer> box1 = new Box<Integer>(new Integer(2));
        Box<String> box2 = new Box<String>("ff");
        System.out.println(box1.getField());
        System.out.println(box2.getField());

    }

    public static <T>void printArray(T[] array){
        for (int i = 0; i< array.length; i++) {
            System.out.println(array[i]);
        }
    }
}