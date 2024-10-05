import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors
import java.util.Scanner;

class Dataset { // Class name starts with uppercase
    public static void main(String[] args) {
        int noOfInstances, noOfAttributes, i;
        String tempStr, classAttributes, data;

        Scanner sc = new Scanner(System.in); // Initialize scanner

        System.out.print("Enter number of attributes (columns): ");
        noOfAttributes = sc.nextInt();
        System.out.print("Enter number of instances (rows): ");
        noOfInstances = sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt()

        try {
            FileWriter myWriter = new FileWriter("exp8.arff");
            myWriter.write("@RELATION DWDM\n");

            for (i = 0; i < noOfAttributes; i++) {
                System.out.print("Enter attribute name " + (i + 1) + ": ");
                tempStr = sc.nextLine(); // Use nextLine() for reading attribute names
                myWriter.write("@ATTRIBUTE " + tempStr + " REAL\n");
            }

            System.out.println("Enter class labels with comma separated values:");
            classAttributes = sc.nextLine(); // Read class labels
            myWriter.write("@ATTRIBUTE class {" + classAttributes + "}\n");
            myWriter.write("@DATA\n");

            System.out.println("Enter data (rows) line by line with comma separated values:");
            for (i = 1; i <= noOfInstances; i++) {
                System.out.print("Enter row " + i + ": ");
                data = sc.nextLine(); // Read data for each row
                myWriter.write(data + "\n");
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            sc.close(); // Close the scanner
        }
    }
}