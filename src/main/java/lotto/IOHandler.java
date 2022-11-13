package lotto;

import camp.nextstep.edu.missionutils.Console;

public abstract class IOHandler {
    String input;
    // get user's input
    public String getUserInput(){
        input = Console.readLine();
        return input;
    }
    public abstract String validateInput(String input);
}
