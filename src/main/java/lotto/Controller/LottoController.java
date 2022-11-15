package lotto.Controller;

import lotto.Model.*;
import lotto.View.*;
import net.bytebuddy.pool.TypePool;

import java.util.List;

public class LottoController {
    UserLotto userLotto = new UserLotto();
    WinnerLotto winnerLotto = new WinnerLotto();
    CompareLottoNumber compareLottoNumber = new CompareLottoNumber();
    OutputView output = new OutputView();
    InputView input = new InputView();

    public void start(){
        try {
            userLottoProcessing();
            winnerLottoProcessing();
            compareLottoProcessing();
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR]입력 오류 발생");
        }
    }

    private void userLottoProcessing() throws IllegalArgumentException{
        int purchasePrice = input.purchasePrice();
        userLotto.setLottoCount(purchasePrice);
        userLotto.makeLottoNumber();
        output.showPurchasedLotto(userLotto.countOfLotto(), userLotto.listOfLotto());
    }

    private void winnerLottoProcessing() throws IllegalArgumentException{
        List<Integer> winnerNumber = input.winnerNumbers();
        winnerLotto.setWinnerNumber(winnerNumber);
        int bonusNumber = input.bonusNumber();
        winnerLotto.setBonusNumber(bonusNumber);
    }

    private void compareLottoProcessing(){
        List<List<Integer>> winCountByPrize = compareLottoNumber.getWinCountByPrize();
        output.showLottoPrize(winCountByPrize);
        double yield = compareLottoNumber.calculateYield();
        output.showYield(yield);
    }
}