public class LinearEquation {
    // Instance variables
    private int x1, y1, x2, y2;

    // Constructor
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // Calculate the slope, m, and reduce the fraction if needed
    public String getSlope() {
        int numerator = y2 - y1;
        int denominator = x2 - x1;
        if (denominator == 0) {
            return "undefined";  // vertical line
        } else {
            return reduceFraction(numerator, denominator);
        }
    }

    // Helper method to reduce the fraction
    private String reduceFraction(int numerator, int denominator) {
        int gcd = gcd(numerator, denominator);  // Calculate greatest common divisor
        numerator /= gcd;
        denominator /= gcd;

        // Handle cases where the denominator is negative
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        // If the denominator is 1, return the numerator as a whole number
        if (denominator == 1) {
            return String.valueOf(numerator);
        }

        // Return the reduced fraction
        return numerator + "/" + denominator;
    }

    // Helper method to calculate the greatest common divisor (gcd)
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Calculate the y-intercept, b
    public double getYIntercept() {
        return (double) y1 - (getSlopeAsDouble() * x1);
    }

    // Helper method to get slope as a double
    private double getSlopeAsDouble() {
        return (double) (y2 - y1) / (x2 - x1);
    }

    // Return the linear equation in y = mx + b form
    public String getEquation() {
        if (x1 == x2) {
            return "x = " + x1;  // vertical line
        } else {
            double b = getYIntercept();
            String slope = getSlope();
            return "y = " + slope + "x + " + String.format("%.2f", b);
        }
    }

    // Calculate the distance between the two points
    public double getDistance() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Calculate the y-coordinate for a given x
    public double getYCoordinate(double x) {
        return getSlopeAsDouble() * x + getYIntercept();
    }

    // toString method to display information
    public String toString() {
        return "Points: (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ")\n" +
                "Equation of line: " + getEquation() + "\n" +
                "Distance between points: " + String.format("%.2f", getDistance());
    }
}
