package lotto.Controller;

import lotto.Model.*;
import lotto.Model.Number;
import lotto.Utils.Match;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.Utils.Util.calculateYield;

public class InputController {

    private final Price price;
    private final List<List<Integer>> lottoBox;
    private final Lotto lotto;
    private final Number num;

    public InputController() {
        this.price = new Price();
        this.lottoBox = generateLotto();
        viewLottoBox();
        this.num = new Number();
        this.lotto = new Lotto(num.getWinningNumberList());
    }

    public void inputController() {
        List<Integer> yieldList = CalculateLotto();
        viewYieldResult(yieldList);
    }

    public List<Integer> CalculateLotto() {
        List<Integer> yieldList = new ArrayList<>();
        for (List<Integer> lottoTicket : lottoBox) {
            Match match = new Match(lotto.getLottoNumbers(), lottoTicket, num.getBonusNumber());
            yieldList.add(match.getResults());
        }
        return yieldList;
    }

    public List<List<Integer>> generateLotto() {
        LottoGenerator lottoGenerator = new LottoGenerator(price.getLottoTicketCount());
        return (lottoGenerator.getlottoBox());
    }

    public void viewLottoBox() {
        InputView.lottoCount(price.getLottoTicketCount());
        OutputView.lottoNumber(lottoBox);
    }

    public void viewYieldResult(List<Integer> yieldList) {
        OutputView.prizes(yieldList);
        OutputView.yield(calculateYield(price.getInputPrice(), yieldList.stream().reduce(Integer::sum).get()));
    }

}
