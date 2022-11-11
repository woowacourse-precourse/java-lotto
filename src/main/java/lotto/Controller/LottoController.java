package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Lotto;
import lotto.Model.LottoData;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoController {
    LottoData lottoData = new LottoData();
    OutputView output = new OutputView();

    private void setLottoCount(){
        output.askPurchasePrice();
        lottoData.setCountOfLotto(Integer.parseInt(readLine()));
    }

    private void makeLottoNumber(){
        List<Lotto> lottos = new ArrayList<Lotto>();
        for(int i = 0; i < lottoData.getCountOfLotto(); i++){
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumber);
            lottos.add(lotto);
        }
        lottoData.setLottos(lottos);
    }
}