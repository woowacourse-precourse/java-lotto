package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class WinningLotto {

    private final int bonusNumber;

    private final List<Integer> winningNumbers;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        String[] winningNum = Console.readLine()
                .replace(" ", "")
                .split(",");
        for (int len = winningNum.length, i = 0; i < len; i++) {
            int winningNumb = Integer.parseInt(winningNum[i]);
            winningNumbers.add(winningNumb);
        }
        return this.winningNumbers;
    }

    public int getBonusNumber() {
        int bonusNum = Integer.parseInt(Console.readLine());
        return this.bonusNumber;
    }
}
