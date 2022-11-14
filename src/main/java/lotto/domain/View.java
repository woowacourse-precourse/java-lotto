package lotto.domain;

import lotto.config.LottoStatus;

import static lotto.config.LottoStatus.*;

public class View {

    private static final String INSERT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INSERT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATS = "당첨 통계\n---";
    private static final String SAME_THREE_WINNING = "3개 일치 (5,000원) - ";
    private static final String SAME_FOUR_WINNING = "4개 일치 (50,000원) - ";
    private static final String SAME_FIVE_WINNING = "5개 일치 (1,500,000원) - ";
    private static final String SAME_SIX_WITH_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SAME_SIX_WINNING = "6개 일치 (2,000,000,000원) - ";
    private static final String SHOW_SAME_NUMBER = "개";
    private static final String SHOW_RETURN_RATE_FRONT = "총 수익률은 ";
    private static final String SHOW_RETURN_RATE_BACK = "%입니다.";

    public void insertWinningNumber() {
        System.out.println(INSERT_WINNING_NUMBER);
    }

    public void insertBonusNumber() {
        System.out.println(INSERT_BONUS_NUMBER);
    }
    public void startWinningStats() {
        System.out.println(WINNING_STATS);
    }

    public void showWinningStatsValueByKey(LottoStatus status, int count) {
        if (status == THREE) {
            System.out.println(SAME_THREE_WINNING + count + SHOW_SAME_NUMBER);
        }

        if (status == FOUR) {
            System.out.println(SAME_FOUR_WINNING + count + SHOW_SAME_NUMBER);
        }

        if (status == FIVE) {
            System.out.println(SAME_FIVE_WINNING + count + SHOW_SAME_NUMBER);
        }

        if (status == SIX_WITH_BONUS) {
            System.out.println(SAME_SIX_WITH_BONUS + count + SHOW_SAME_NUMBER);
        }

        if (status == SIX) {
            System.out.println(SAME_SIX_WINNING + count + SHOW_SAME_NUMBER);
        }
    }

    public void setShowReturnRate(double returnRate) {
        System.out.println(SHOW_RETURN_RATE_FRONT + returnRate + SHOW_RETURN_RATE_BACK);
    }

}
