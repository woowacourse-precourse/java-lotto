package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.Number;
import lotto.Model.Price;
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
        LottoController lottoController = new LottoController(price.getLottoTicketCount());
        this.lottoBox = lottoController.getlottoBox();
        OutputView.lottoNumber(lottoBox);
        this.num = new Number();
        this.lotto = new Lotto(num.getWinningNumberList());
    }

    public void inputController() {
        List<Integer> yieldList = new ArrayList<>();
        for (List<Integer> lottoTicket : lottoBox) {
            MatchController match = new MatchController(lotto.getLottoNumbers(), lottoTicket, num.getBonusNumber());
            yieldList.add(match.getResults());
        }

        OutputView.prizes(yieldList);
        OutputView.yield(calculateYield(price.getInputPrice(), yieldList.stream().reduce(Integer::sum).get()));
    }

}
