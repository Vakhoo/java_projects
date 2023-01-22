import java.util.*;

public class Main {
    public static void main(String[] args) {
//        List<String> cars = new ArrayList<String>();
//        cars.add("BMW");
//        cars.add("Honda");
//        cars.add("Toyota");
//        cars.set(1, "Mercedes");
//        cars.remove(1);
//        System.out.println(cars.get(1));
////        cars.clear();
//        System.out.println(cars.size());
//
//        Iterator<String> it = cars.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }

//        LinkedList<String> cars = new LinkedList<>();
//        cars.add("BMW");
//        cars.add("Honda");
//        cars.add("Toyota");
//        cars.set(1, "Mercedes");
//        cars.addFirst("LADA");
//        System.out.println(cars);


//        Stack<String> cars = new Stack<>();
//        cars.add("BMW");
//        cars.add("Honda");
//        cars.add("Toyota");
//
//        System.out.println(cars.pop());
//        System.out.println(cars.pop());
//        System.out.println(cars.push("LADA"));



//        Set<String> cars = new Set<>();
//        cars.add("BMW");
//        cars.add("Honda");
//        cars.add("Toyota");
//
//        System.out.println(cars.pop());
//        System.out.println(cars.pop());
//        System.out.println(cars.push("LADA"));


//        Map<String, String> cities = new HashMap<>();
//        cities.put("ff", "fz");
//        System.out.println(cities);
        List<MyClass> myClasses = new ArrayList<>();
        myClasses.add((new MyClass(1)));
        myClasses.add((new MyClass(2)));
        myClasses.add((new MyClass(3)));
        System.out.println(myClasses);
        Collections.sort(myClasses);
        System.out.println(myClasses);




    }
}