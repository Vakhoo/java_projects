public class MyClass implements Comparable<MyClass> {


    @Override
    public String toString() {
        return "MyClass{" +
                "value=" + value +
                '}';
    }

    public MyClass(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private int value;

//    @Override
//    public int compareTo(Int o) {
//        if (o > this.value){
//            return 1;
//        } else if (o < this.value) {
//            return -1;
//        }else{
//            return 0;
//        }
//    }

    @Override
    public int compareTo(MyClass myClass) {
        return myClass.value - value;
    }
}
