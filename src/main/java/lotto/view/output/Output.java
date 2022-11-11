package lotto.view.output;

import lotto.domain.Lotto;
import lotto.message.ErrorMessage;
import lotto.message.GuideMessage;

import java.util.List;

public class Output {

    public void printLottoCountForBuy(int count) {
        System.out.println(count + GuideMessage.BUY_LOTTO_MESSAGE.getGuideMessage());
    }

    public void printAllLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();
    }
}
