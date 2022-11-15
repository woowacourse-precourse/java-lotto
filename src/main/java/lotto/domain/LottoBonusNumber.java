package lotto.domain;
public class LottoBonusNumber {
    private static final String ERROR_RANGE_MONEY = "[ERROR]1부터 45까지만 입력해주세요.";

    private final int bonusNumber;

    public LottoBonusNumber(String bonusNumber){
        validateNumber(bonusNumber);
        this.bonusNumber = Money.convertToInt(bonusNumber);

    }

    public void validateNumber(String bonusNumber){
        if(!isDigit(bonusNumber)){
            System.out.println(Money.ERROR_INPUT_MONEY);
            throw new IllegalArgumentException(Money.ERROR_INPUT_MONEY);
        }
        if(!correctNumber(bonusNumber)){
            System.out.println(ERROR_RANGE_MONEY);
            throw new IllegalArgumentException(ERROR_RANGE_MONEY);
        }
    }

    public static boolean isDigit(String money) {
        if (money != null && !money.matches("-?\\d+")) {
            return false;
        }
        return true;
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
