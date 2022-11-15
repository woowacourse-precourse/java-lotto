package lotto.ExceptionChecker;

import java.util.List;
import java.util.NoSuchElementException;

public class BonusNumberChecker {

    private final int bonusNumber;


    public BonusNumberChecker(int bonusNumber, List<Integer> lottoWinList) {
        validateRange(bonusNumber);
        validateOverlap(bonusNumber, lottoWinList);

        this.bonusNumber = bonusNumber;

    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateOverlap(int bonusNumber, List<Integer> lottoWinList) {
        try {
            if (lottoWinList.contains(bonusNumber)) {
                throw new IllegalArgumentException();
            }

        } catch (Exception IllegalArgumentException) {
            System.out.println("[ERROR] 보너스 숫자와 로또 번호와 중복되지 않는 값을 넣어주세요. ");
            IllegalArgumentException.printStackTrace();
            throw new NoSuchElementException();
        }

    }

    public void validateRange(int bonusNumber) {
        try {
            if (bonusNumber > 45 || bonusNumber == 0) {
                throw new IllegalArgumentException();
            }

        } catch (Exception IllegalArgumentException) {
            System.out.println("[ERROR] 당첨 번호의 범위를 1~45사이에서 입력해주세요. ");
            IllegalArgumentException.printStackTrace();
            throw new NoSuchElementException();
        }
    }
}
