package lotto.domain.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.GuideSentences;

public class LottoGuide {

    public int getPurchaseAmount() {
        System.out.println(GuideSentences.INPUT_PURCHASE_AMOUNT.getSentence());

        int purchaseAmount = Integer.parseInt(Console.readLine());

        return purchaseAmount;
    }
}
