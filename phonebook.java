package task2;

import java.util.*;

public class phonebook {
    static class Details{
        private int houseno;
        private String name;
        private String phoneno;
        Details(int houseno,String name,String phoneno){
            this.houseno=houseno;
            this.name=name;
            this.phoneno=phoneno;
        }
        public int getHouseno(){
            return houseno;
        }
        public String getName(){
            return name;
        }
        public String getPhoneno(){
            return phoneno;
        }
        public String toString(){
            return houseno+" | "+name+" | "+phoneno;
        }
    }

    public static void main(String[] args) {
        List<Details> c = new ArrayList<Details>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        System.out.println("***************Welcome To PhoneBook***************");
        int ch ;
        do {
            System.out.println("------------------------------------");
            System.out.println("            1.Add Details                      \n ");
            System.out.println("            2.Display                      \n ");
            System.out.println("            3.Search                       \n ");
            System.out.println("            4.Delete                       \n ");
            System.out.println("            5.Update                       \n ");

            System.out.print("choice: ");
            ch = s.nextInt();
            System.out.println("------------------------------------");

            switch (ch){
                case 1:
                    System.out.print("Enter the house number: ");
                    int hono = s.nextInt();
                    System.out.print("Enter the name: ");
                    String na = s1.nextLine();
                    System.out.print("Enter the phone number: ");
                    String pn = s1.nextLine();
                    c.add(new Details(hono,na,pn));
                    System.out.println("Details Added Sucessfully...!");
                    System.out.println("------------------------------------");
                    break;
                case 2:
                    Iterator i = c.iterator();
                    System.out.println("Details are...");
                    while (i.hasNext()){
                        Object e = (Details) i.next();
                        System.out.println(e);
                    }
                    System.out.println("------------------------------------");
                    break;
                case 3:
                    boolean found = false;
                    System.out.print("Enter the house no: ");
                     hono = s.nextInt();
                    i = c.iterator();
                    System.out.println("As per your search details are here...");
                    while (i.hasNext()){
                        Object e = (Details) i.next();
                        if (((Details) e).getHouseno()==hono){
                        System.out.println(e);
                        found = true;
                        }
                    } if (!found){
                    System.out.println("Invalid House number");
                }
                    System.out.println("------------------------------------");
                    break;
                case 4:
                    found = false;
                    System.out.print("Enter the house no: ");
                    hono = s.nextInt();
                    i = c.iterator();
                    while (i.hasNext()){
                        Object e = (Details) i.next();
                        if (((Details) e).getHouseno()==hono){
                            i.remove();
                            found = true;
                        }
                        if (!found){
                            System.out.println("Invalid House number");
                        }else {
                            System.out.println("Details are deleted...!");
                        }
                    }
                    System.out.println("------------------------------------");
                    break;
                case 5:
                    found = false;
                    System.out.print("Enter the house no to update: ");
                    hono = s.nextInt();
                    ListIterator<Details> li = c.listIterator();
                    while (li.hasNext()){
                        Object e = (Details) li.next();
                        if (((Details) e).getHouseno()==hono){
                            System.out.print("Enter new name: ");
                            na = s1.nextLine();
                            System.out.print("Enter new phone number: ");
                            pn = s1.nextLine();
                            li.set(new Details(hono,na,pn));
                            found = true;
                        }
                        if (!found){
                            System.out.println("Invalid House number");
                        }else {
                            System.out.println("Details are updated...!");
                        }
                    }
                    System.out.println("------------------------------------");
                    break;
            }
        }while (ch!=0);
    }
}
