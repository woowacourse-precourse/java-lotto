package utils;

import statements.ErrorClark;

public class Validatior {
    public static void isValidNumber(int number){
        if(number<1||number>45){
            IllegalArgumentException exit_Program
                    = new IllegalArgumentException(ErrorClark.SHOUT_NUMBER_RANGE_ERROR.alarmed());
            throw exit_Program;
        }
    }
}
