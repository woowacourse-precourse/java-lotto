package utils;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String input() throws IllegalArgumentException{
        String textInput = Console.readLine();

        boolean result = textInput.chars().allMatch(ch -> ( Character.isDigit(ch) || ch == ','));

        if(!result){
            throw new IllegalArgumentException("입력이 잘못 되었습니다.");
        }

        return textInput;
    }

}
