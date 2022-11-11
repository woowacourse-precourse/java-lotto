package utils;

import camp.nextstep.edu.missionutils.Console;
import system.process.exception.IllegalArgument;

public class Input {

    public static String input() throws IllegalArgumentException{
        String textInput = Console.readLine();

        if(!IsCollection.isDigitOrCommaText(textInput)){
            IllegalArgument.handleException(IllegalArgument.NOT_DIGIT_OR_COMMA_TEXT.getMessage());
        }

        return textInput;
    }

}
