package lotto;

public class BonusNumber {
    private final Integer bonusNumber;

    public BonusNumber(String bonusNumber) {
        try {
            Integer number = Integer.parseInt(bonusNumber);
            validation(number);
            this.bonusNumber = number;
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자를 입력하셔야 합니다..");
        }

    }

    private void validation(Integer bonusNumber){
        if(bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이에 존재해야합니다.");
        }
    }
    public Integer getBonusNumber(){
        return bonusNumber;
    }
}
