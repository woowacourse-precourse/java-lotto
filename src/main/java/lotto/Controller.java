package lotto;

import lotto.Purchase;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    Purchase purchase;
    List<Integer> lottoAnswer = new ArrayList<>();
    String bonusNumber;

    public void buyLotto(){
        purchase = new Purchase(Console.readLine());

        String inputAnswer = Console.readLine();
        for(int i=0; i<inputAnswer.length(); i++){
            if(inputAnswer.charAt(i)>=48 && inputAnswer.charAt(i)<=57) {
                lottoAnswer.add(inputAnswer.charAt(i)-'0');
            }
        }

        Lotto lotto = new Lotto(lottoAnswer);
        bonusNumber = Console.readLine();
        lotto.getLottoBonusNumber(bonusNumber);
    }

    public void publishLotto(){
        User user = new User();
        user.getUserLotto(purchase.price);
        user.printUserLotto(purchase.price);
        user.printWinningResult(lottoAnswer,bonusNumber);
        user.printWinningRatio(user.correctLottoNum,purchase.price);
    }
}
