package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {



    public int inputMoney(){
        System.out.println("금액을 입력해주세요");
        String money = Console.readLine();
        InputValidator inputValidator = new InputValidator(money);
        return inputValidator.getLottosAmount();
    }

    public List<Integer> inputWinningLottosNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        InputValidator inputValidator = new InputValidator(winningNumber);
        return inputValidator.getWinningNumbers();
    }

    public int inputBonusNumber(List<Integer> winningLottos){
        System.out.println("보너스 번호를 입력 해 주세요.");
        String bonusNumber = Console.readLine();
        InputValidator inputValidator = new InputValidator(bonusNumber);
        return inputValidator.getBonusNumbers(winningLottos);
    }

}
