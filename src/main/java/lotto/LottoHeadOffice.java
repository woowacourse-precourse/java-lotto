package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoHeadOffice {
    private List<Integer> winningNum = new ArrayList<>();
    private int bonusNum;

    LottoHeadOffice() {
    }

    public void inputWinningNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String s = Console.readLine();
        for (String digit : s.split(",")) {
            this.winningNum.add(Integer.valueOf(digit));
        }
    }

    public void inputBonusNum() {
    }
}
