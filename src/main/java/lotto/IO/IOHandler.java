package lotto.IO;

import camp.nextstep.edu.missionutils.Console;

public abstract class IOHandler {
    String input;
    // get user's input
    public String getUserInput(){
        input = Console.readLine();
        return input;
    }
    public abstract void validateInput(String input);
}
