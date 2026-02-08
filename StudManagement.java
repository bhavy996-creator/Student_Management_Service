import java.util.ArrayList;
import java.util.Scanner;

class Student{
    private String name;
    private int roll;
    private double cgpa;

    public Student(String name, int roll, double cgpa){
        this.name = name;
        this.roll = roll;
        this.cgpa = cgpa;
    }
        public void setName(String name){
            this.name = name;
        }
        public boolean setRoll(int roll){
            if(roll>0){
                this.roll = roll;
                return true;
            }
            System.out.println("Invalid entry...");
            return false;

        }
            public boolean setCgpa(double cgpa) {
        if (cgpa >= 0 && cgpa <= 10) {
            this.cgpa = cgpa;
            return true;
        }
        System.out.println("CGPA must be between 0 and 10.");
        return false;
    }

    // Getters
    public int getRoll() {
        return roll;
    }

    // Display
    public void display() {
        System.out.println("Name : " + name);
        System.out.println("Roll : " + roll);
        System.out.println("CGPA : " + cgpa);
    }
}
    public class StudManagement{
          //  safe integer input menu
          static int safeIntInput(Scanner sc, String msg, int min, int max){
            int value;
            while (true) {
                try {
                    System.out.print(msg);
                    value = sc.nextInt();
                    sc.nextLine();
                    if(value>=min && value<=max){
                        return value;
                    }
                    else{
                        System.out.println("enter value between " + min + " and " + max);
                    }
                } catch (Exception e) {
                    System.out.println("Invalid entry!!!");
                    sc.nextLine();
                }
            }
          }
          // safe roll input
          static int safeRollInput(Scanner sc){
            int roll;
            while (true) {
                try {
                    System.out.print("Enter RollNo.:- ");
                    roll = sc.nextInt();
                    sc.nextLine();
                    if(roll > 0){
                        return roll;
                    }
                    else{
                        System.out.println("RollNO. must be positive");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid entry!!");
                    sc.nextLine();
                }
            }

          }

          //safe cgpa input
          static double safeCgpaInput(Scanner sc){
             double cgpa;
             while (true) {
                try {
                    System.out.print("Enter CGPA:- ");
                    cgpa = sc.nextDouble();
                    sc.nextLine();
                    if(cgpa >= 0 && cgpa<= 10){
                        return cgpa;
                    }
                    else{
                        System.out.println("CGPA must lie between 0 and 10");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid entry");
                    sc.nextLine();
                }
             }

          }
          public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            ArrayList<Student> students = new ArrayList<>();

            int choice ;
            do {
                
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Update Student");
            System.out.println("5. Exit");

            choice = safeIntInput(sc, "Enter choice:- " , 1, 5);

            switch (choice) {
                case 1:
                    System.out.print("Enter name:- ");
                    String name = sc.nextLine();

                    int roll = safeRollInput(sc);
                    double cgpa = safeCgpaInput(sc);

                    students.add(new Student(name, roll, cgpa));
                    break;

                case 2:
                    if(students.size() == 0){
                        System.out.println("EMPTY!!!");
                    }    
                    else{
                        System.out.println("\n.... Student entries are as follows....");
                    for(Student st : students){
                       st.display();
                       System.out.println("--------");
                    }
                }
                break;

                case 3:
                    if (students.size() == 0) {
                        System.out.println("EMPTY!!!");
                    }
                    
                    int rollTodelete = safeRollInput(sc);
                    boolean deleted = false;
                    for(int i = 0; i<students.size(); i++){
                        if(students.get(i).getRoll() == rollTodelete){
                            students.remove(i);
                            deleted = true;
                            System.out.println("Entry deleted!!!");
                        }
                    }
                    if(!deleted){
                        System.out.println("no matching record found !!!");
                    }
                    break;

                case 4:
                    if (students.size() == 0) {
                        System.out.println("EMPTY!!!");
                    }
                    int rollToUpdate = safeRollInput(sc);
                    Student target = null;
                    for(Student st : students){
                        if(st.getRoll() == rollToUpdate){
                            target = st;
                            break;
                        }
                    }
                    if(target == null){
                        System.out.println("No matching record found...");
                        break;
                    }    

                    System.out.println("\n RollNo. matched!!! What you want to upgrade?");
                    System.out.println("1. Update Name.");
                    System.out.println("2. Update CGPA.");

                    int choiceUpdate = safeIntInput(sc, "Enter Choice:- ", 1, 2);
                    if(choiceUpdate == 1){
                        System.out.print("Enter new Name:- ");
                        target.setName(sc.nextLine());
                        System.out.println(".....Name has been upgraded....");
                    }
                    else{
                        System.out.print("Enter new CGPA:- ");
                        target.setCgpa(sc.nextDouble());
                        System.out.println(".....CGPA has been upgraded.....");
                    }
                    break;

                case 5:
                    System.out.println("...... EXITING PROGRAM ......");   
                    break; 
                default:
                    System.out.println("INVALID CHOICE!!!!");
                    break;
            }

            } while (choice != 5);
            sc.close();
          }
    }