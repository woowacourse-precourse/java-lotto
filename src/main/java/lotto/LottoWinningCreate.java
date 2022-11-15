package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningCreate {

    private List<Integer> winningNumbers = new ArrayList<>();

    private Integer bonusNumber;

    public List<Integer> getWinningNumbers() {
        return winningNumbers;

    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public LottoWinningCreate(String winningNumbers) {
        int cur = 0;
        for(char x : winningNumbers.toCharArray()){
            if(x == ' ') continue;

            if(Character.isDigit(x)){
                cur = (x-'0') + cur * 10;
            }
            else if(x == ','){
                validateNumber(cur);
                this.winningNumbers.add(cur);
                cur = 0;
            }
        }
        if(cur!=0)
            this.winningNumbers.add(cur);
        if(this.winningNumbers.size() !=6){
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMBER_ERROR);
        }

    }

    public void setBonusNumber(String bonusNumber) {
        int cur = 0;
        for(char x : bonusNumber.toCharArray()){
            if(Character.isDigit(x)){
                cur = (x-'0') + cur * 10;
            }
        }
        validateNumber(cur);
        this.bonusNumber = cur;
    }

    public void validateNumber(int x){
        if(x < 0 || x > 45) throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMBER_BOUND_ERROR);
    }
}
