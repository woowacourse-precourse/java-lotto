package lotto.gameSetting;

public class UserInput {
    public static void moneyNumberCheck(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액을 숫자로 입력하세요.");
        }
    }
    
    public static void moneyPriceCheck(String money) {
        int checkMoney = Integer.parseInt(money);
        
        if (checkMoney%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위이어야 합니다.");
        }
    }

    public static void winningNumberNumberCheck(String[] winningNumber) {
        try {
            for(int i=0; i<winningNumber.length; i++) {
                Integer.parseInt(winningNumber[i]);    
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
    }

    public static void bonusNumberNumberCheck(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
    }

    public static void bonusNumberRangeCheck(String bonusNumber) {
        int check = Integer.parseInt(bonusNumber);
        if (check<1 || check>45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45이내의 숫자 입니다.");
        }
    }

    public static void bonusNumberOverlapCheck(String bonusNumber, String[] winningNumber) {
        for(int i=0; i<6; i++) {
            if (bonusNumber.equals(winningNumber[i])) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않습니다.");
            }
        }
    }

    public static void moneyCheck(String money) {
        moneyNumberCheck(money);
        moneyPriceCheck(money);
    }

    public static void bonusNumberCheck(String bonusNumber, String[] winningNumber) {
        bonusNumberNumberCheck(bonusNumber);
        bonusNumberRangeCheck(bonusNumber);
        bonusNumberOverlapCheck(bonusNumber, winningNumber);
    }
}
