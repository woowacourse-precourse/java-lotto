package lotto;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(String bonusNumber, WinNumber winNumber) {
        int tmpBonusNumber = validateBonusNumberType(bonusNumber);
        validateBonusNumberRange(tmpBonusNumber);
        validateBonusNumberReplicate(tmpBonusNumber, winNumber);
        this.bonusNumber = tmpBonusNumber;
        System.out.println();
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public int validateBonusNumberType(String bonusNumber) {
        try {
            Double.parseDouble(bonusNumber);
        } catch (NumberFormatException e) {
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

    public void validateBonusNumberReplicate(int bonusNumber, WinNumber numbers) {
        if (numbers.getWinNumber().getLotto().contains(bonusNumber)) {
            System.out.println("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }
}
