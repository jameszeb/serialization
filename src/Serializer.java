import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Serializer {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean flag = true;
        ArrayList ar = new ArrayList();

        Employee e = new Employee();
        while(flag) {
            System.out.println("Enter a name: ");
            e.name = s.nextLine();
            System.out.println("Address default set.");
            e.address = "";
            System.out.println("Enter a social security number: ");
            e.SSN = s.nextLine();

            e.uuid = UUID.randomUUID();
            System.out.println("Random uuid number assigned as employee number.");

            ar.add(e);
            System.out.println("Do you wish to continue?");


            if(s.nextLine().substring(0,1).equals('n')){
                System.out.println("System exit.");
                System.exit(1);
            } else{
                SerializeObject(e);
            }

        }

    }

    private static void SerializeObject(Employee e) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("/tmp/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
class Employee implements Serializable{
    String name;
    String address;
    String SSN;
    UUID uuid;

}