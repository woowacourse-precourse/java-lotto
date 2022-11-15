package lotto;

import java.util.List;

public class WinningNumber {
    private static String LOTTO_ALREADY_CONTAIN_BONUS_NUMBER = "[ERROR] 번호가 중복되어 보너스 숫자로 선택할 수 없습니다.";
    private static String BONUS_NUMBER_OUT_OF_NUMBER_RANGE = "[ERROR] 보너스 번호가 범위를 벗어났습니다.";
    private static int LOTTO_NUMBER_START = 1;
    private static int LOTTO_NUMBER_END = 45;
    private Lotto winningNumber;
    private int bonusNumber;

    public WinningNumber(Lotto winningNumber, int bonusNumber) {
        valid(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> copyWinningNumber() {
        return List.copyOf(winningNumber.copyNumbers());
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void valid(Lotto winningNumber, int bonusNumber) {
        validWinNumsContainsBonusNum(winningNumber, bonusNumber);
        validBonusNumberRange(bonusNumber);
    }

    private void validWinNumsContainsBonusNum(Lotto winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_ALREADY_CONTAIN_BONUS_NUMBER);
        }
    }

    private void validBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_START || bonusNumber > LOTTO_NUMBER_END){
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_NUMBER_RANGE);
        }
    }
}
