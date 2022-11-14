package lotto.model;

import java.util.List;
import lotto.bo.Lotto;
import lotto.bo.WinningNumber;

public class Checker {

    private Checker() {
    }

    public enum WinningPlace {
        FIRST("2,000,000,000", 6),
        SECOND("30,000,000", 5),
        THIRD("1,500,000", 5),
        FOURTH("50,000", 4),
        FIFTH("5,000", 3),
        NOTHING("0", 0);

        private final String winningValue;
        private final int corrects;

        WinningPlace(String value, int corrects) {
            this.winningValue = value;
            this.corrects = corrects;
        }

        public String getWinningValue() {
            return this.winningValue;
        }

        public int getCorrects() {
            return corrects;
        }
    }


    public static WinningPlace calcWinningPlace(Lotto lottoNumbers, WinningNumber winningNumbers) {
        List<Integer> winningNumbersWithOutBonus = winningNumbers.getNumbers();
        List<Integer> tmpLottoNumbers = lottoNumbers.getNumbers();
        int bonusNumber = winningNumbers.getBonusNumber();

        int corrects;
        boolean bonusCorrect;

        corrects = checkCorrects(tmpLottoNumbers, winningNumbersWithOutBonus);
        bonusCorrect = isBonus(tmpLottoNumbers, bonusNumber);

        return checkWinningPlace(corrects, bonusCorrect);
    }

    private static int checkCorrects(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int corrects = 0;

        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                corrects++;
            }
        }
        return corrects;
    }

    private static boolean isBonus(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    private static WinningPlace checkWinningPlace(int corrects, boolean bonusCorrect) {
        WinningPlace winningPlace = WinningPlace.NOTHING;

        for (WinningPlace tmpWinningPlace : WinningPlace.values()) {
            if (tmpWinningPlace.getCorrects() == corrects) {
                winningPlace = tmpWinningPlace;
            }
        }
        if (winningPlace == WinningPlace.THIRD) {
            if (bonusCorrect) {
                return WinningPlace.SECOND;
            }
        }
        return winningPlace;
    }


}
