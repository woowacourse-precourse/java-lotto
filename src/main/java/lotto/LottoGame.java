package lotto;

import ui.Input;
import ui.Output;

import java.util.List;

public class LottoGame {
    public static void start(){
        Output.enterPurchaseMoney();
        int seedMoney = Input.inputSeedMoney();
        System.out.println();

        MyLotto myLotto = new MyLotto(seedMoney);
        Output.howManyLottoBought(myLotto.getCountNumsOfLotto());
        Output.boughtMyLotto(myLotto.getMyPocket());
        System.out.println();

        Output.enterWinningNumbers();
        List<Integer> winningNumbers = Input.inputWinningNumbers();
        System.out.println();

        Output.enterBonusNumber();
        int bonusNumber = Input.inputBonusNumber();
        System.out.println();

        for (List<Integer> lotto : myLotto.getMyPocket()){
            int numsOfMatchedNumber = LottoCheck.checkNumsOfMatchedNumber(winningNumbers, lotto);
            boolean containBonus = LottoCheck.containBonus(bonusNumber, lotto);
            Prize.checkRanking(numsOfMatchedNumber, containBonus);
        }

        Output.stats(seedMoney);
    }
}
