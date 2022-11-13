package lotto;

import java.util.List;

public class LottoBonus {
    private int bonusNumber;

    public LottoBonus(String input,List<Integer> winningNumber){
        validateRange(input);
        validateDuplication(input,winningNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validateRange(String input){
        bonusNumber = Integer.parseInt(input);

        if(bonusNumber > 45 || bonusNumber < 0){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45사이 숫자만 입력 가능합니다.");
        }
    }

    public void validateDuplication(String input, List<Integer> winningNumber){
        bonusNumber = Integer.parseInt(input);

        if(winningNumber.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복 불가능합니다.");
        }
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}

