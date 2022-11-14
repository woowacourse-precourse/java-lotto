package lotto;

public class BonusNumber {

    private final Integer bonusNumber;

    public BonusNumber(Integer bonusNumber, Lotto lotto) {
        validateBonusNumberDuplicate(bonusNumber, lotto);
        this.bonusNumber = bonusNumber;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }

    public boolean bonusMatch(Lotto lotto) {
        checkBonusNumberSet();
        return lotto.getNumbers().contains(this.getBonusNumber());
    }

    private void checkBonusNumberSet() {
        if (this.getBonusNumber() == null) {
            System.out.println("[ERROR]보너스 번호가 입력되어 있지 않습니다.");
            throw new IllegalArgumentException("[ERROR]보너스 번호가 입력되어 있지 않습니다.");
        }
    }

    private void validateBonusNumberDuplicate(Integer bonusNumber, Lotto lotto) {
        try {
            if (lotto.getNumbers().contains(bonusNumber)) {
                System.out.println("[ERROR]보너스 번호가 기존 당첨 번호와 중복됩니다.");
                throw new IllegalArgumentException("[ERROR]보너스 번호가 기존 당첨 번호와 중복됩니다.");
            }
        } catch (NullPointerException e) {
            System.out.println("[ERROR]보너스 번호가 비어있습니다.");
            throw new IllegalArgumentException("[ERROR]보너스 번호가 비여있습니다.");
        }
    }
}
