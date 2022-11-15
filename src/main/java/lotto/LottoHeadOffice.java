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

        validateBonusNum(s);

        this.bonusNum = s.charAt(0);
    }

    private void validateBonusNum(String s) {
        // 숫자가 아닌 문자가 입력되었을 때
        char[] arrCh = s.toCharArray();
        for (char ch : arrCh) {
            if (!Character.isDigit(ch))
                throw new IllegalArgumentException();
        }

        // 숫자 범위가 1~45가 아닐 때
        int bonusNum = Integer.parseInt(s);
        if (bonusNum < 1 || 45 < bonusNum)
            throw new IllegalArgumentException();

        // winningNum과 중복되지 않는지
        if (winningNum.contains(bonusNum))
            throw new IllegalArgumentException();
    }

    public List<Integer> getWinningNum() {
        return winningNum;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
