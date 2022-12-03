package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

public class InputView {
    public  Integer inputCost() {
        return Convert.costConvert(Console.readLine());
    }
    public  Lotto inputWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Convert.winningConvert(Console.readLine());
    }
    public  Integer inputBonusNumber(Lotto winningNumber){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Convert.bonusConvert(Console.readLine(),winningNumber);
    }
}
