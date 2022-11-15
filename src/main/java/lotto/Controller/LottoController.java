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
        userLottoProcessing();
        winnerLottoProcessing();
        compareLottoProcessing();
    }

    private void userLottoProcessing(){
    try {
        int purchasePrice = input.purchasePrice();
        userLotto.setLottoCount(purchasePrice);
        userLotto.makeLottoNumber();
        output.showPurchasedLotto(userLotto.countOfLotto(), userLotto.listOfLotto());
    }catch(IllegalArgumentException e) {
        System.out.println("[ERROR]구입 가격이 잘못 입력되었습니다.");
    }
    }

    private void winnerLottoProcessing(){
    try {
        List<Integer> winnerNumber = input.winnerNumbers();
        winnerLotto.setWinnerNumber(winnerNumber);
        int bonusNumber = input.bonusNumber();
        winnerLotto.setBonusNumber(bonusNumber);
    }catch(IllegalArgumentException e) {
        System.out.println("[ERROR]당첨 번호 혹은 보너스 번호가 잘못 입력되었습니다.");
    }
    }

    private void compareLottoProcessing(){
        List<List<Integer>> winCountByPrize = compareLottoNumber.getWinCountByPrize();
        output.showLottoPrize(winCountByPrize);
        double yield = compareLottoNumber.calculateYield();
        output.showYield(yield);
    }
}