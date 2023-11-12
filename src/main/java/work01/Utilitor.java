package work01;

public final class Utilitor {
    
    public static String testString(String value){
        if (value == null) {
            throw new NullPointerException();
        } else if (value.isBlank()) {
            throw new IllegalArgumentException();
        } return value;
    }

    public static double testPositive(double value){
        if (value <= 0) {
            throw new IllegalArgumentException();
        } return value;
    }

    public static long computeIsbn10(long isbn10){
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += (isbn10 % 10) * i;
            isbn10 /= 10;
        }
        long checkDigit = sum % 11;
        return checkDigit == 10 ? 'X' : checkDigit;
    }
}
