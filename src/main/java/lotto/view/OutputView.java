package lotto.view;

import lotto.domain.LottoMachine;

public class OutputView {

    public static final String BUY_RESULT_MESSAGE = "개를 구매했습니다.";
    public static final String STATISTIC_RESULT_MESSAGE = "당첨 통계";
    public static final String LINE_CHANGE_MESSAGE = "---";

    public static void showLottos(LottoMachine lottoMachine) {
        System.out.println(lottoMachine.getCount() + BUY_RESULT_MESSAGE);
        lottoMachine.getLottos().stream()
                .forEach(lotto -> System.out.println(lotto));
    }
}
