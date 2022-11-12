package lotto;

public class LottoBonus {

    private int bonusNumber;

    LottoBonus(String input){
        validateRange(input);
        this.bonusNumber = bonusNumber;
    }

    public void validateRange(String input){
        bonusNumber = Integer.parseInt(input);

        if(bonusNumber > 45 || bonusNumber < 0){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45사이 숫자만 입력 가능합니다.");
        }
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}

