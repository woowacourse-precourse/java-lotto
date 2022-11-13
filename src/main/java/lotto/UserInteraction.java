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
    public int tryParseInt(String input){
        int changedInput=0;
        input = input.trim();
        try {
            changedInput=Integer.parseInt(input);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야만 합니다.");
        }
        return changedInput;
    }

}
