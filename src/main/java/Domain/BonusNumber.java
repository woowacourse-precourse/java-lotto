package Domain;

public class BonusNumber {

    String bonusNumber;

    public BonusNumber(String bonusNumber){
        validInputBonusNumber(bonusNumber);
        outOfRangeBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validInputBonusNumber(String bonus) {
        try {
            Integer.parseInt(bonus);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        }
    }

    private void outOfRangeBonusNumber(String bonus){
        int number = Integer.parseInt(bonus);
        if (number < 1 || number > 45)
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

}

