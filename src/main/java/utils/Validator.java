package utils;

import statements.ErrorStatements;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Validator {
    private static IllegalArgumentException exit_Program = new IllegalArgumentException();
    public static void hasNoDuplication(List<Integer> sixWinningNumbers){
        Set<Integer> noDuplication = new TreeSet<>(sixWinningNumbers);
        if(noDuplication.size()!=sixWinningNumbers.size()){
            throw exit_Program;
        }
    }
    public static void tryAndCatchHasNoDuplication(List<Integer> sixWinningNumbers){
        try{
            hasNoDuplication(sixWinningNumbers);
        }catch(IllegalArgumentException e){
            System.out.println(ErrorStatements.SHOUT_DUPLICATED_NUMBERS.alarmed());
            throw exit_Program;
        }
    }
    public static void isValidFormatWithComma(String input) {
        int count = 0;
        count = countCommaInString(input);
        if (count != 5) {
            throw exit_Program;
        }
    }

    public static void tryAndCatchIsValidFormatWithComma(String input){
        try{
            isValidFormatWithComma(input);
        }catch(IllegalArgumentException e){
            System.out.println(ErrorStatements.SHOUT_INVALID_FORMAT_ERROR.alarmed());
            throw exit_Program;
        }
    }

    public static int countCommaInString(String input){
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',') {
                count++;
            }
        }
        return count;
    }
    public static void isInValidRange(int number) {
        if (number < 1 || number > 45) {
            throw exit_Program;
        }
    }

    public static void tryAndCatchIsInValidRange(int number){
        try{
            isInValidRange(number);
        }catch (IllegalArgumentException e){
            System.out.println(ErrorStatements.SHOUT_NUMBER_RANGE_ERROR.alarmed());
            throw exit_Program;
        }
    }
    public static void isValidInput(String input) {
        char[] inputCharacters = input.toCharArray();
        char[] inputCharactersWithoutComma = new char[inputCharacters.length];
        for (int i = 0; i < inputCharacters.length; i++) {
            if(inputCharacters[i]!=','){
                inputCharactersWithoutComma[i]= inputCharacters[i];
            }
            if (inputCharactersWithoutComma==null &&((int) inputCharactersWithoutComma[i] < 48
                    || (int) inputCharactersWithoutComma[i] > 57)) {
                throw exit_Program;
            }
        }
    }

    public static void tryAndCatchIsValidInput(String input){
        try{
            isValidInput(input);
        }catch(IllegalArgumentException e){
            System.out.println(ErrorStatements.SHOUT_NOT_NUMBER_ERROR.alarmed());
            throw exit_Program;
        }
    }

    public static void isValidLength(String input, int givenLength) {
        if (input.length() > givenLength) {
            throw exit_Program;
        }
    }

    public static void tryAndCatchIsValidLength(String input, int givenLength){
        try{
            isValidLength(input, givenLength);
        }catch(IllegalArgumentException e){
            System.out.println(ErrorStatements.SHOUT_INVALID_LENGTH_ERROR.alarmed());
            throw exit_Program;
        }
    }

    public static void isValidUnitForPayment(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw exit_Program;
        }
    }

    public static void tryAndCatchIsValidUnitForPayment(String input){
        try{
            isValidUnitForPayment(input);
        }catch(IllegalArgumentException e){
            System.out.println(ErrorStatements.SHOUT_PAYMENT_UNIT_ERROR.alarmed());
            throw exit_Program;
        }
    }

    public static void isValidInputForPayment(String input) {
        IllegalArgumentException exit_Program = new IllegalArgumentException();
        char[] inputCharacters = input.toCharArray();
        for (int i = 0; i < inputCharacters.length; i += 1) {
            if ((int) inputCharacters[i] < 48 || (int) inputCharacters[i] > 57) {
                throw exit_Program;
            }
        }
    }

    public static void tryAndCatchIsValidInputForPayment(String input){
        try{
            isValidInputForPayment(input);
        }catch (IllegalArgumentException e){
            System.out.println(ErrorStatements.SHOUT_NOT_NUMBER_ERROR.alarmed());
            throw exit_Program;
        }
    }

    public static void isBonusDifferentWithWinningNumbers(List<Integer> winningNumbers, int bonus){
        for(int winningNumber:winningNumbers){
            if(winningNumber==bonus){
                throw exit_Program;
            }
        }
    }

    public static void tryAndCatchIsBonusDifferentWithWinningNumbers(List<Integer> winningNumbers, int bonus){
        try{
            isBonusDifferentWithWinningNumbers(winningNumbers, bonus);
        }catch(IllegalArgumentException e){
            System.out.println(ErrorStatements.SHOUT_BONUS_SHOUlD_NOT_BE_SAME.alarmed());
            throw exit_Program;
        }
    }
    public static void hasNoMoney(String money){
        if(Integer.parseInt(money)==0){
            throw exit_Program;
        }
    }

    public static void tryAndCatchHasNoMoney(String money){
        try{
            hasNoMoney(money);
        }catch(IllegalArgumentException e){
            System.out.println(ErrorStatements.SHOUT_NO_PAY_NO_GAME.alarmed());
            throw exit_Program;
        }
    }
}
