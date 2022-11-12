package lotto.domain.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.constants.GuideSentences;
import lotto.domain.model.Lotto;

public class LottoGuide {

    public int getPurchaseAmount() {
        System.out.println(GuideSentences.INPUT_PURCHASE_AMOUNT.getSentence());

        int purchaseAmount = Integer.parseInt(Console.readLine());

        return purchaseAmount;
    }

    public void informIssuedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + GuideSentences.OUTPUT_NUMBER_OF_PURCHASES.getSentence());

        lottos.forEach(oneLotto -> System.out.println(oneLotto.getNumbers()));
    }
}
