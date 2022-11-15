package lotto.Controller;


import lotto.Model.*;
import lotto.Model.Number;
import lotto.Utils.Match;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.Utils.Util.calculateIncome;

public class InputController {

    private final Price price;
    private final List<List<Integer>> lottoBox;

    public InputController() {
        this.price = new Price();
        this.lottoBox = generateLotto();
    }

    public boolean inputController() {
        if(price.getInputPrice()==0){return false;}
        showLottoBox();
        List<Integer> inComeList = CalculateLotto();
        showStaticsResult(inComeList);
        return true;
    }

    public List<Integer> CalculateLotto() {
        List<Integer> inComeList = new ArrayList<>();
        Number num = new Number();
        Lotto lotto = new Lotto(num.getWinningNumberList());
        for (List<Integer> lottoTicket : lottoBox) {
            Match match = new Match(lotto.getLottoNumbers(), lottoTicket, num.getBonusNumber());
            inComeList.add(match.getResults());
        }
        return inComeList;
    }



    public List<List<Integer>> generateLotto() {
        LottoGenerator lottoGenerator = new LottoGenerator(price.getLottoTicketCount());
        return (lottoGenerator.getlottoBox());
    }

    public void showLottoBox() {
        InputView.lottoCount(price.getLottoTicketCount());
        OutputView.lottoNumber(lottoBox);
    }

    public void showStaticsResult(List<Integer> yieldList) {
        OutputView.prizes(yieldList);
        OutputView.yield(calculateIncome(price.getInputPrice(), yieldList.stream().reduce(Integer::sum).get()));
    }

}
