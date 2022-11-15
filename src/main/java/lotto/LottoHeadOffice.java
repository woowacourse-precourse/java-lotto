package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
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

        validateWinningNum(s);

        for (String digit : s.split(",")) {
            this.winningNum.add(Integer.valueOf(digit));
        }
    }

    private void validateWinningNum(String s) {
        String[] split = s.split(",");
        for (String num : split) {
            // 숫자가 아닌 문자가 입력되었을 때
            char[] arrCh = num.toCharArray();
            for (char ch : arrCh) {
                if (!Character.isDigit(ch))
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자로 이루어져야 합니다.");
            }
            // 숫자 범위가 1~45가 아닐 때
            int winningNum = Integer.parseInt(num);
            if (winningNum < 1 || 45 < winningNum)
                throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1~45입니다.");
        }

        // 중복된 숫자가 없는지
        List<String> toList = Arrays.asList(split);
        if (toList.size() != toList.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않은 수들로 이루어져야 합니다.");
        }

        // 6개의 숫자로 이루어졌는지
        if (toList.size() != 6)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자로 이루어져야 합니다.");

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
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }

        // 숫자 범위가 1~45가 아닐 때
        int bonusNum = Integer.parseInt(s);
        if (bonusNum < 1 || 45 < bonusNum)
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 범위는 1~45입니다.");

        // winningNum과 중복되지 않는지
        if (winningNum.contains(bonusNum))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되어서는 안됩니다.");
    }

    public List<Integer> getWinningNum() {
        return winningNum;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
