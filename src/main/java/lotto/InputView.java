package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView{

    private void printMessage(String message) {
        System.out.println(message);
    }

    public String requestUserMoney(){
        printMessage("구입 금액을 입력해주세요.");
        return readLine();
    }

    public String requestWinningNumbers(){

    }

    public String requestBonusNumber(){

    }
}
