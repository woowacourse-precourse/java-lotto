package utils;

import statements.ErrorStatements;

public class Validator {

    public static void isValidFormatWithComma(String input){
        int count = 0;
        IllegalArgumentException exit_Program
                = new IllegalArgumentException(ErrorStatements.SHOUT_INVALID_FORMAT_ERROR.alarmed());
        for(int i=0; i<input.length(); i++)
        {
            if(input.charAt(i)==','){
                count++;
            }
        }
        if(count!=5){
            throw exit_Program;
        }
    }

    public static void isInValidRange(int number){
        IllegalArgumentException exit_Program
                = new IllegalArgumentException(ErrorStatements.SHOUT_NUMBER_RANGE_ERROR.alarmed());
        if(number<1||number>45){
            throw exit_Program;
        }
    }


}
