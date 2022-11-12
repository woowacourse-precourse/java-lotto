package lotto;

import java.util.List;

public class BonusNumber {

    private int bonusNumber;

    public void requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public BonusNumber(String bonusNumber) {
        int tmpBonusNumber = validateBonusNumberType(bonusNumber);

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
}
