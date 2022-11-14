package domain;

public class BonusNumber {
    private final String bonusNumber;

    public BonusNumber(String bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public String getBonusNumber() {
        return bonusNumber;
    }

    public int convertBonusNumber(){
        return Integer.parseInt(bonusNumber);
    }
}
