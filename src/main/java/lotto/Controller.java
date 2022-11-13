package lotto;

import lotto.Purchase;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    Purchase purchase;
    List<Integer> lottoAnswer = new ArrayList<>();
    String bonusNumber;

    public void buyLotto() throws IllegalArgumentException{
        Message.startMessage();
        purchase = new Purchase(Console.readLine());

        Message.inputNumberMessage();
        String inputAnswer = Console.readLine();

        String[] inputSplitAnswer = inputAnswer.split(",");
        for(int i=0; i<inputSplitAnswer.length; i++){
            int num = Integer.parseInt(inputSplitAnswer[i]);
            if(num>=0 && num<=45) {
                lottoAnswer.add(Integer.parseInt(inputSplitAnswer[i]));
                continue;
            }
            throw new IllegalArgumentException("[ERROR] 범위 외의 값 입력");
        }

        Lotto lotto = new Lotto(lottoAnswer);
        Message.inputBonusNumberMessage();
        bonusNumber = Console.readLine();
        lotto.getLottoBonusNumber(bonusNumber);
    }

    public void publishLotto() throws IllegalArgumentException{
        User user = new User();
        user.getUserLotto(purchase.price);
        user.printUserLotto(purchase.price);
        user.printWinningResult(lottoAnswer,bonusNumber);
        user.printWinningRatio(user.correctLottoNum,purchase.price);
    }
}
