package lotto;

import java.util.List;

public class LottoRaffler {

    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoRaffler(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private Long checkWinningNumbers(List<Integer> raffleNumbers) {
        return raffleNumbers.stream().filter(winningNumbers::contains).count();
    }

    private boolean checkBonusNumber(int raffleNumber) {
        return bonusNumber == raffleNumber;
    }
}
