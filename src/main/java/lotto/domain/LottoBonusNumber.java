package lotto.domain;

import javax.imageio.IIOException;
import lotto.domain.Lotto;
public class LottoBonusNumber {
    private final int bonusNumber;
    private static final String ERROR_INPUT_MONEY = "[ERROR]숫자만 입력해주세요.";
    private static final String ERROR_RANGE_MONEY = "[ERROR]1부터 45까지만 입력해주세요.";

    public LottoBonusNumber(String bonusNumber){
        try {
            validateNumber(bonusNumber);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());

        }
        this.bonusNumber = Money.convertToInt(bonusNumber);

    }

    public void validateNumber(String bonusNumber){
        if(!Money.isDigit(bonusNumber)){
            throw new IllegalArgumentException(ERROR_INPUT_MONEY);
        }
        if(!correctNumber(bonusNumber)){
            throw new IllegalArgumentException(ERROR_RANGE_MONEY);
        }
    }

    public boolean correctNumber(String bonusNumber){
        if(1>Integer.parseInt(bonusNumber) || Integer.parseInt(bonusNumber)>45){
            return false;
        }
        return true;
    }
    public int getBonusNumber(){
        return this.bonusNumber;
    }

}
