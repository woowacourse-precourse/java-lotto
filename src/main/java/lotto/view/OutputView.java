package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.message.Messages;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printLottoList(List<Lotto> lottoList) {
        System.out.printf(Messages.OUTPUT_LOTTO_COUNT.get(), lottoList.size());
        for (Lotto lotto : lottoList)
            System.out.println(lotto.getNumbers());
    }

    public static void printWinList(Map<String, Integer> winList) {
        System.out.printf(Messages.OUTPUT_WIN_LIST.get(),
                winList.get("5등"), winList.get("4등"), winList.get("3등"), winList.get("2등"), winList.get("1등"));
    }

    public static void printBenefitRatio(String ratio) {
        System.out.printf(Messages.OUTPUT_BENEFIT_RATIO.get(), ratio);
    }
}
