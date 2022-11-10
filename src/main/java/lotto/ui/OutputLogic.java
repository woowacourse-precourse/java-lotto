package lotto.ui;

import lotto.Lotto;

import java.util.List;

public class OutputLogic {
    public static void printLottoPurchaseInformation(List<Lotto> myLotto) {
        int lottoIssueCount = InputLogic.getLottoIssueCount();
        System.out.println(lottoIssueCount + "개를 구매했습니다.");

        for (int count = 0; count < lottoIssueCount; count++) {
            System.out.println(myLotto.get(count).getLottoNumbers().toString());
        }
        System.out.println();
    }
}
