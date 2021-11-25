package draft;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class draft {
    public static void main(String[] args) {

//        int age = 90;
//        String name = "петя";
//        char ch1 = 'л';
//        char ch2 = 'е';
//        char ch3 = 'т';
//        int num = 57;
//
//        age = num - age;
//
//        System.out.println(name + " " + age + " " + ch1 + ch2 + ch3);
        int[] num23 = {1,2,3};


        try {

            System.out.println(num23[20]);

        }
        catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }


        System.err.println("Азат смотри завершение кода");

    }
}
