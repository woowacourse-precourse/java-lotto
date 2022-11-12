package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int requestUserAmount(){
        String userInput = Console.readLine();
        //validate
        return Integer.parseInt(userInput);
    }
}
