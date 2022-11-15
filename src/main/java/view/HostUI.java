package view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class HostUI {

    private final String winningMessage = "당첨 번호를 입력해 주세요.";
    private final String bonusMessage = "보너스 번호를 입력해 주세요.";

    public String getWinningNumbers(){
        System.out.println(winningMessage);
        return readLine();
    }

    public String getBonusNumber(){
        System.out.println(bonusMessage);
        return readLine();
    }
}
