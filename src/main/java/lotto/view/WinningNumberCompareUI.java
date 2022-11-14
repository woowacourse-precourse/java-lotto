package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class WinningNumberCompareUI {
    public String takeWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = readLine();
        return winningNumber;
    }
}
