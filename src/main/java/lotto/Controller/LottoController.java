package lotto.Controller;

import lotto.Model.LottoData;
import lotto.View.OutputView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoController {
    LottoData lottoData = new LottoData();
    OutputView output = new OutputView();

    private void setLottoCount(){
        output.askPurchasePrice();
        lottoData.setCountOfLotto(Integer.parseInt(readLine()));
    }
}