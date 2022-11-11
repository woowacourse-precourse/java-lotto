package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class ComputerView {

    private static final String REQUEST_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";

    public String getNumbers(){
        return "";
    }

    public String getBonusNumber(){
        return "";
    }

    private void printRequest(String statement){
        System.out.println(statement);
    }

    private String scanInput(){
        return Console.readLine();
    }
}
