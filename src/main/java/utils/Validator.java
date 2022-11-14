package utils;

import statements.ErrorStatements;

public class Validator {

    public static void isValidFormatWithComma(String input) {
        int count = 0;
        IllegalArgumentException exit_Program
                = new IllegalArgumentException(ErrorStatements.SHOUT_INVALID_FORMAT_ERROR.alarmed());
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',') {
                count++;
            }
        }
        if (count != 5) {
            throw exit_Program;
        }
    }

    public static void isInValidRange(int number) {
        IllegalArgumentException exit_Program
                = new IllegalArgumentException(ErrorStatements.SHOUT_NUMBER_RANGE_ERROR.alarmed());
        if (number < 1 || number > 45) {
            throw exit_Program;
        }
    }

    public static void isValidInput(String input) {
        IllegalArgumentException exit_Program
                = new IllegalArgumentException(ErrorStatements.SHOUT_NOT_NUMBER_ERROR.alarmed());
        char[] inputCharacters = input.toCharArray();
        for (int i = 0; i < inputCharacters.length; i += 2) {
            if ((int) inputCharacters[i] < 48 || (int) inputCharacters[i] > 57) {
                throw exit_Program;
            }
        }
    }

    public static void isValidLength(String input, int givenLength) {
        IllegalArgumentException exit_Program
                = new IllegalArgumentException(ErrorStatements.SHOUT_INVALID_LENGTH_ERROR.alarmed());
        if (input.length() > givenLength) {
            throw exit_Program;
        }
    }

    public static void isValidUnitForPayment(String input) {
        IllegalArgumentException exit_Program
                = new IllegalArgumentException(ErrorStatements.SHOUT_PAYMENT_UNIT_ERROR.alarmed());
        if (Integer.parseInt(input) % 1000 != 0) {
            throw exit_Program;
        }
    }

    public static void isValidInputForPayment(String input) {
        IllegalArgumentException exit_Program
                = new IllegalArgumentException(ErrorStatements.SHOUT_NOT_NUMBER_ERROR.alarmed());
        char[] inputCharacters = input.toCharArray();
        for (int i = 0; i < inputCharacters.length; i += 1) {
            if ((int) inputCharacters[i] < 48 || (int) inputCharacters[i] > 57) {
                throw exit_Program;
            }
        }
    }
}
