package lotto.gameSetting;

import java.util.Arrays;
import java.util.HashSet;

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

    public static void winningNumberRangeCheck(String[] winningNumber) {
        for(int i=0; i<winningNumber.length; i++) {
            int check = Integer.parseInt(winningNumber[i]);

            if (check<1 || check>45) {
                throw new IllegalArgumentException("[ERROR] 숫자의 범위는 1~45입니다.");
            }
        }
    }

    public static void winningNumberOverlapCheck(String[] winningNumber) {
        HashSet<String> checkOverlap = new HashSet<>(Arrays.asList(winningNumber));
        
        if (winningNumber.length != checkOverlap.size()) {
            throw new IllegalArgumentException("[ERROR] 숫자가 중복되었습니다");
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

    public static void moneyCheck(String money) {
        UserInput.moneyNumberCheck(money);
        UserInput.moneyPriceCheck(money);
    }

    public static void winningNumberCheck(String[] winningNumber) {
        UserInput.winningNumberNumberCheck(winningNumber);
        UserInput.winningNumberRangeCheck(winningNumber);
        UserInput.winningNumberOverlapCheck(winningNumber);
    }

    public static void bonusNumberCheck(String bonusNumber) {
        UserInput.bonusNumberNumberCheck(bonusNumber);
        UserInput.bonusNumberRangeCheck(bonusNumber);
    }
}
