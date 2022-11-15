package lotto;

import view.Message;

public class Exception {

    public void checkPurchaseAmountRange(String purchaseAmount) {
        for (int i = 0; i < purchaseAmount.length(); i++) {
            if (!(purchaseAmount.charAt(i) >= '0' && purchaseAmount.charAt(i) <= '9')) {
                throw new IllegalArgumentException(Message.ERRROR_NUMBER_RANGE.getMessage());
            }
        }
    }

    public void checkZeroRemainder(String purchaseAmount) {
        int Amount = Integer.parseInt(purchaseAmount);
        if (Amount % 1000 != 0) {
            throw new IllegalArgumentException(Message.ERROR_NOT_ZERO_REMAINDER.getMessage());
        }
    }

    public void checkBonusNumber(String bonusNumber){
        if(bonusNumber.length()!=1){
            throw new IllegalArgumentException(Message.ERROR_BONUS_SIZE.getMessage());
        }
        if(!(bonusNumber.charAt(0)>='0'&&bonusNumber.charAt(0)<='9')){
            throw new IllegalArgumentException(Message.ERRROR_NUMBER_RANGE.getMessage());
        }
    }
}
