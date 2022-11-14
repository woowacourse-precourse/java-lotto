package lotto.domain;

import lotto.config.LottoStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.config.LottoStatus.*;

public class View {

    private static final String INPUT_MONEY = "구입 금액을 입력해주세요.";
    private static final String BUY_LOTTO_NUMBER = "개를 구매했습니다.";
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

    public void insertMoney() {
        System.out.println(INPUT_MONEY);
    }

    public void showHasLotto(int hasLotto) {
        System.out.println(hasLotto + BUY_LOTTO_NUMBER);
    }

    public void insertWinningNumber() {
        System.out.println(INSERT_WINNING_NUMBER);
    }

    public void insertBonusNumber() {
        System.out.println(INSERT_BONUS_NUMBER);
    }

    public void startWinningStats() {
        System.out.println(WINNING_STATS);
    }

    public void showLotto(Lotto lotto) {
        System.out.println(lotto.getLotto());
    }

    public void showWinningStats(HashMap<LottoStatus, Integer> winningStats) {

        startWinningStats();

        for (Map.Entry<LottoStatus, Integer> entry : winningStats.entrySet()) {

            LottoStatus status = entry.getKey();
            int count = entry.getValue();

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

    }


    public void showReturnRate(double returnRate) {
        System.out.println(SHOW_RETURN_RATE_FRONT + returnRate + SHOW_RETURN_RATE_BACK);
    }

}
