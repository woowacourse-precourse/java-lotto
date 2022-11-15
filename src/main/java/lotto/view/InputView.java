package lotto.view;

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
        printMessage("당첨 번호를 입력해주세요.");
        return readLine();
    }

    public String requestBonusNumber(){
        printMessage("보너스 번호를 입력해주세요.");
        return readLine();
    }
}
