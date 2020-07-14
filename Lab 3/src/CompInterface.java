public class CompInterface {
        public static void main (String[] args) {
            {

                Student s1_1 = new Student("Tom", "Oshawa", "Computer Science");
                Student s1_2 = new Student("Tom", "Oshawa");

                Student s2_1 = new Student("Jean", "Toronto", "Chemistry");
                Student s2_2 = new Student("Jean", "Toronto");

                Student s3_1 = new Student("Tom", "Toronto");
                Student s3_2 = new Student("Tom", "Oshawa");

                Student s4_1 = new Student("Kate", "Whitby");
                Student s4_2 = new Student("Tom", "Whitby");


                int result = s1_1.compareTo(s1_2);
                int result1 = s2_1.compareTo(s2_2);
                int result2 = s3_1.compareTo(s3_2);
                int result3 = s4_1.compareTo(s4_2);

                if (result > 0) {
                   System.out.println("1");

                }
                else if (result < 0) {
                    System.out.println("-1");

                }
                 if (result1 > 0) {
                    System.out.println("2");

                }
                else if (result1 < 0) {
                    System.out.println("-2");

                }
                if (result2 > 0) {
                    System.out.println("3");

                }
                else if (result2 < 0) {
                    System.out.println("-3");

                }
                 if (result3 > 0) {
                    System.out.println("4");

                }
                else if (result3 < 0) {
                    System.out.println("-4" );

                }
                else {
                    System.out.print("0");
                }
            }
        }
    }
