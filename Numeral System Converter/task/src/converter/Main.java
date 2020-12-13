package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int sourceRadix = scanner.nextInt();
            String sourceNumber = scanner.next();
            int targetRadix = scanner.nextInt();
            if (sourceRadix < 1 || sourceRadix > 36 || targetRadix < 1 || targetRadix > 36 ) {
                System.out.println("error");
            } else {
                int index;
                int i;
                for (i = 0; i < sourceNumber.length(); i++) {
                    if (sourceNumber.charAt(i) == '.') {
                        index = i;
                        break;
                    }
                }
                String integerPart = sourceNumber.substring(0, i);
                String fractionalPart = "";
                if (i + 1 < sourceNumber.length()) {
                    fractionalPart = sourceNumber.substring(i + 1);
                }
                String integerAnswer = integerConversion(sourceRadix, integerPart, targetRadix);
                String fractionalAnswer = fractionConversion(sourceRadix, fractionalPart, targetRadix);
                if (fractionalAnswer.equals("0")) {
                    System.out.println(integerAnswer);
                } else {
                    System.out.println(integerAnswer + "." + fractionalAnswer);
                }
            }
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public static String fractionConversion(int sourceRadix, String sourceNumber, int targetRadix) {
        double decimalValue = 0;
        for (int i = 0; i < sourceNumber.length(); i++) {
            decimalValue += Integer.parseInt(String.valueOf(sourceNumber.charAt(i)), sourceRadix) / Math.pow(sourceRadix, i + 1);
        }
        double multiply;
        int integerPart;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            multiply = decimalValue * targetRadix;
            integerPart = (int) multiply;
            decimalValue = multiply - integerPart;
            result.append(Integer.toString(integerPart, targetRadix));
        }
        return result.toString();
    }

    public static String integerConversion(int sourceRadix, String sourceNumber, int targetRadix) {
        int decimal;
        StringBuilder result = new StringBuilder();
        if (sourceRadix == 1 || targetRadix == 1) {
            if (sourceRadix == 1) {
                decimal = sourceNumber.length();
                result.append(Integer.toString(decimal, targetRadix));
                return result.toString();
            } else {
                decimal = Integer.parseInt(sourceNumber, sourceRadix);
                for (int i = 0; i < decimal; i++) {
                    result.append("1");
                }
                return result.toString();
            }
        }
        decimal = Integer.parseInt(String.valueOf(sourceNumber), sourceRadix);
        String targetNumber = Integer.toString(decimal, targetRadix);
        return targetNumber;
    }

    public static String toConvert(int decimal, int radix) {
        String result = null;
        switch (radix) {
            case 2:
                result = "0b" + Integer.toBinaryString(decimal);
                break;
            case 8:
                result = "0" + Integer.toOctalString(decimal);
                break;
            case 16:
                result = "0x" + Integer.toHexString(decimal);
                break;
        }
        return result;
    }
}
