import java.util.Scanner;

public class EquationRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the Linear Equation Solver!");

        // Get first point
        System.out.print("Enter the first coordinate point (x1,y1): ");
        String[] point1 = scanner.next().replaceAll("[()]", "").split(",");
        int x1 = Integer.parseInt(point1[0]);
        int y1 = Integer.parseInt(point1[1]);

        // Get second point
        System.out.print("Enter the second coordinate point (x2,y2): ");
        String[] point2 = scanner.next().replaceAll("[()]", "").split(",");
        int x2 = Integer.parseInt(point2[0]);
        int y2 = Integer.parseInt(point2[1]);

        // Create LinearEquation object
        LinearEquation equation = new LinearEquation(x1, y1, x2, y2);

        // Output all the required information
        System.out.println(equation);

        // Get an x-value from the user to solve for y
        System.out.print("Enter an x-value to solve for y: ");
        double xValue = scanner.nextDouble();
        System.out.println("The corresponding point on the line is: (" + xValue + "," +
                String.format("%.2f", equation.getYCoordinate(xValue)) + ")");

        scanner.close();
    }
}
