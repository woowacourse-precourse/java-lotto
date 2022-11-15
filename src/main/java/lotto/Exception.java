package lotto;

import view.Message;

public class Exception {

    public void checkPurchaseAmount(String purchaseAmount) {
        checkPurchaseAmountRange(purchaseAmount);
        checkNoRemainder(purchaseAmount);
    }

    public void checkPurchaseAmountRange(String purchaseAmount) {
        if(purchaseAmount.charAt(0)=='0'){
            throw new IllegalArgumentException(Message.ERROR_START_ZERO.getMessage());
        }
        for (int i = 1; i < purchaseAmount.length(); i++) {
            if (!(purchaseAmount.charAt(i) >= '0' && purchaseAmount.charAt(i) <= '9')) {
                throw new IllegalArgumentException(Message.ERRROR_NUMBER_RANGE.getMessage());
            }
        }
    }

    public void checkNoRemainder(String purchaseAmount) {
        int Amount = Integer.parseInt(purchaseAmount);
        if (Amount % 1000 != 0) {
            throw new IllegalArgumentException(Message.ERROR_NOT_ZERO_REMAINDER.getMessage());
        }
    }



    public void checkBonusNumberSize(String bonusNumber) {
        if (!(bonusNumber.length() >= 1 && bonusNumber.length() <= 2)) {
            throw new IllegalArgumentException(Message.ERROR_BONUS_SIZE.getMessage());
        }
    }

    public void checkBonusNumberRange(String bonusNumber) {
        int bonus=Integer.parseInt(bonusNumber);
        if(!(bonus>=1&&bonus<=45)){
            throw new IllegalArgumentException(Message.ERRROR_NUMBER_RANGE.getMessage());
        }
    }




}
