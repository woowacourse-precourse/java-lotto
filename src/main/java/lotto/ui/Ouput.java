package lotto.ui;

import java.util.List;

import lotto.domain.Lotto;

public class Ouput {
    static final String NEW_LINE = "\n";
    static final String PURCAHSED_N_LOTTOS_NOTICE = "%d개를 구매했습니다." + NEW_LINE;
    static final String ENTER_AMOUNT_OF_MONEY_NOTICE = "구입금액을 입력해 주세요.";
    static final String ENTER_WINNNG_LOTTO_NUMBERS_NOTICE = "당첨 번호를 입력해 주세요.";
    static final String ENTER_BOUNUS_NUMBER_NOTICE = "보너스 번호를 입력해 주세요.";
    static final String RATE_OF_PROFIT_IS_N_NOTICE = "총 수익률은 %.1f%%입니다." + NEW_LINE;
    static final String GRADE_STATISTICS_NOTICE = "당첨 통계";
    static final String LINE_NOTICE = "---";

    public static final String ERROR = "[ERROR] ";
    public static final String INVAILD_INPUT_VALUE_ERROR = ERROR + "올바른 입력값이 아닙니다.";
    public static final String MUST_BE_NUMBERS_BETWEEN_1_TO_45_ERROR = ERROR + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String HAD_DUPLICATE_NUMBER_ERROR = ERROR + "중복된 로또 번호 입니다.";
    public static final String MUST_BE_SIX_DIGIT_ERROR = ERROR + "로또 번호는 6자리 이어야합니다.";
    public static final String ENTER_IN_UNITS_OF_1000_WON_ERROR = ERROR + "1000원 단위로 입력해주세요";


    enum GradeNotice {
        FIFTH("3개 일치 (5,000원) - %d개" + NEW_LINE),
        FOURTH("4개 일치 (50,000원) - %d개" + NEW_LINE),
        THIRD("5개 일치 (1,500,000원) - 0개" + NEW_LINE),
        SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개" + NEW_LINE),
        FIRST("6개 일치 (2,000,000,000원) - 0개" + NEW_LINE);
        private final String notice;

        GradeNotice(String string) {
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
        System.out.printf(RATE_OF_PROFIT_IS_N_NOTICE, rateOfReturn);
    }

    public void notifySumOfResult(List<Integer> sumOfResult) {
        System.out.println(GRADE_STATISTICS_NOTICE);
        System.out.println(LINE_NOTICE);
        GradeNotice[] grade = GradeNotice.values();
        for (int order = 0; order < 5; order++) {
            System.out.printf(grade[order].notice, sumOfResult.get(order));
        }
    }

    public void beginNewLine() {
        System.out.print(NEW_LINE);
    }
}
