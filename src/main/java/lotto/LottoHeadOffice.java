package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoHeadOffice {
    private List<Integer> winningNum = new ArrayList<>();
    private int bonusNum;

    LottoHeadOffice() {
        inputWinningNum();
        System.out.println();
        inputBonusNum();
    }

    private void inputWinningNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String s = Console.readLine();
        // validate 검사 (입력형식, 중복되지 않는지)
        for (String digit : s.split(",")) {
            this.winningNum.add(Integer.valueOf(digit));
        }
    }

    private void inputBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String s = Console.readLine();
        // validate 검사 (입력형식, winningnum이랑 중복되지 않는지)
        this.bonusNum = s.charAt(0);
    }

    public List<Integer> getWinningNum() {
        return winningNum;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
