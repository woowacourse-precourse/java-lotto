package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {

    public static final int CHEON_WON = 1000;

    public int inputMoney(){
        String amountOfMoney = Console.readLine();
        return Integer.parseInt(amountOfMoney);
    }

    public String inputWinningLottosNumber(){
        return Console.readLine();
    }

    public String inputBonusNumber(){
        return Console.readLine();
    }



    public void checkMoneyUnit(int money){
        if(!(money / CHEON_WON == 0)){
            throw new IllegalArgumentException("[ERROR] 금액은 천원 단위로 입력해주세요");
        }
    }

    public void containsComma(String winningNumbers){
        if(!winningNumbers.contains(",")){
            throw new IllegalArgumentException("[ERROR] 숫자는 ,로 구분해서 입력해주세요");
        }
    }

    public void checkOverlap(String winningNumbers){
        String [] numberCheck = winningNumbers.split(",");
        numberCheck = Arrays.stream(numberCheck).distinct().toArray(String[]::new);
        if(!(numberCheck.length == 6)){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    public void bonusOverlapWithWinning(String winningNumbers, String bonusNumber){
        if(winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 번호와 중복 될 수 없습니다.");
        }
    }

    public void checkBonusNumberLength(String bonusNumber){
        if(!(bonusNumber.length() == 1)){
            throw new IllegalArgumentException("[ERROR] 한개의 보너스 숫자를 입력해주세요.");
        }
    }


}
