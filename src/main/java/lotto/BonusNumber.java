package lotto;

import java.util.List;

public class BonusNumber {

    private int bonusNumber;

    public void requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public BonusNumber(String bonusNumber, List<Integer> winNumber) {
        int tmpBonusNumber = validateBonusNumberType(bonusNumber);
        validateBonusNumberRange(tmpBonusNumber);
        validateBonusNumberReplicate(tmpBonusNumber, winNumber);
        this.bonusNumber = tmpBonusNumber;
    }

    public int validateBonusNumberType(String bonusNumber) {
        try {
            Double.parseDouble(bonusNumber);
        } catch(NumberFormatException e) {
            System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }

        return Integer.valueOf(bonusNumber);
    }

    public void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            System.out.println("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateBonusNumberReplicate(int bonusNumber, List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            System.out.println("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }
}
