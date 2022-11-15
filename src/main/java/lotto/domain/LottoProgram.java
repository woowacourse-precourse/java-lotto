package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.commons.InformationLines;
import lotto.commons.Lotto;
import lotto.commons.WinLotto;

public class LottoProgram {

    InputOutput inputOutput = new InputOutput();
    NumberGenerator numberGenerator = new NumberGenerator();
    Referee referee = new Referee();
    Calculate calculate = new Calculate();

    List<Lotto> lottos = new ArrayList<>();
    WinLotto winLotto;


    public LottoProgram() {
        int buyAmount = buyLotto();
        //getWinLotto();
        //winStats(buyAmount);
    }

    private int buyLotto() {
        System.out.println(InformationLines.BUY_AMOUNT_LINE.getLine());
        int buyAmount = inputOutput.getLottoBuyAmount();
        inputOutput.printLottoBuyAmount(buyAmount);

        for (int index = 0; index < buyAmount; index++) {
            lottos.add(new Lotto(numberGenerator.createRandomNumbers()));
            System.out.println(lottos.get(index).getNumbers());
        }
        return buyAmount;
    }


}
