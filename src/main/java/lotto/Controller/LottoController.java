package lotto.Controller;

import lotto.View.input;
import lotto.View.output;
import lotto.Model.lottoGenerator;
import java.util.ArrayList;
import java.util.List;

public class LottoController {
    List<List<Integer>> groupLotto = new ArrayList<>();
    lottoGenerator lottogenerator = new lottoGenerator();

    public void start() {
        int amountLotto = input.inputMoney();
        output.printAmount(amountLotto);
        groupLotto = lottogenerator.getGroupLotto(amountLotto);

    }


}
