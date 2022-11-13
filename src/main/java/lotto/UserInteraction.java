package lotto;

import camp.nextstep.edu.missionutils.*;

public class UserInteraction {

    private final String askText = " 입력해 주세요.";

    public void askInput(String askTarget) {
        System.out.println(askTarget + this.askText);
    }

    public String getInput() {
        String input = "";
        input = Console.readLine();
        return input;
    }

}
