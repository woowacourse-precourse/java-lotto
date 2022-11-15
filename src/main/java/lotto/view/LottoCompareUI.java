package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoCompareUI {
    public String takeWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = readLine();
        System.out.println();
        return winningNumber;
    }

    public String takeBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = readLine();
        System.out.println();
        return bonusNumber;
    }
}
