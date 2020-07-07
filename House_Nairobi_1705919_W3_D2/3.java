import java.util.Scanner;

class NegativeNumberException extends Exception {
    public NegativeNumberException(String s) {
        super(s);
    }

    @Override
    public String ToString(NegativeNumberException e) {
        return "One of the number entered is negative!";
    }

}

class MyCalculator {
    long power(int a, int b) {
        long result;

        if (a < 0 || b < 0)
            throw NegativeNumberException;

        return result;
    }
}