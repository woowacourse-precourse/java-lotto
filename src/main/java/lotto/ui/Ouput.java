package lotto.ui;

import java.util.List;

import lotto.domain.Lotto;

public class Ouput {
    static final String PURCAHSED_N_LOTTOS_NOTICE = "%d개를 구매했습니다.\n";
    static final String ENTER_AMOUNT_OF_MONEY_NOTICE = "구입금액을 입력해 주세요.";
    static final String ENTER_WINNNG_LOTTO_NUMBERS_NOTICE = "당첨 번호를 입력해 주세요.";
    static final String ENTER_BOUNUS_NUMBER_NOTICE = "보너스 번호를 입력해 주세요.";
    static final String RATE_OF_RETURN_IS_N_NOTICE = "총 수익률은 %.1f%%입니다.\n";
    static final String WIN_STATISTICS_NOTICE = "당첨 통계";
    static final String LINE_NOTICE = "---";

    enum PlaceNotice {
        FIRST("6개 일치 (2,000,000,000원) - 0개\n"),
        SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"),
        THIRD("5개 일치 (1,500,000원) - 0개\n"),
        FOURTH("4개 일치 (50,000원) - %d개\n"),
        FIFTH("3개 일치 (5,000원) - %d개\n");
        private final String notice;

        PlaceNotice(String string) {
            notice = string;
        }
    }

    public void notifyPurchasedLottoTable(List<Lotto> lottoTable) {
        System.out.printf(PURCAHSED_N_LOTTOS_NOTICE, lottoTable.size());
        for (int order = 0; order < lottoTable.size(); order++) {
            System.out.println(lottoTable.get(order).getNumbers());
        }
    }

    public void notifyHowMuchInput() {
        System.out.println(ENTER_AMOUNT_OF_MONEY_NOTICE);
    }

    public void notifyWinningLottoNumbersInput() {
        System.out.println(ENTER_WINNNG_LOTTO_NUMBERS_NOTICE);
    }

    public void notifyBonusNumberInput() {
        System.out.println(ENTER_BOUNUS_NUMBER_NOTICE);
    }

    public void notifyRateOfReturn(float rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_IS_N_NOTICE, rateOfReturn);
    }

    public void notifySumOfResult(List<Integer> sumOfResult) {
        System.out.println(WIN_STATISTICS_NOTICE);
        System.out.println(LINE_NOTICE);
        PlaceNotice[] place = PlaceNotice.values();
        for (int order = 0; order < 5; order++) {
            System.out.printf(place[order].notice, sumOfResult.get(order));
        }
    }
}
