package lotto.domain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class Game {

    static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    static final String LOTTO_BUY_COUNT = "%d개를 구매했습니다.";
    static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    static final String WINNING_RESULT = "당첨 통계";
    static final String DIVISION_LINE = "---";
    static final String LOTTO_WINNING_RESULT = "%d개 일치 (%s원) - %d개";
    static final String LOTTO_WINNING_RESULT_BONUS_BALL = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    static final String RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

    static final int LOTTO_NUMBERS_COUNT = 6;

    private final User user;
    private final List<Lotto> lottoNumbers;
    private final LottoWinningResult winningResults;
    private int userMoney;
    private int lottoCount;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private double rateOfReturn;

    public Game() {
        this.user = new User();
        this.lottoNumbers = new ArrayList<>();
        this.winningResults = new LottoWinningResult();
    }

    public double computeRateOfReturn() {
        double totalMoney = 0;
        for (LottoRank rank : LottoRank.values()) {
            totalMoney += winningResults.getWinningResult(rank) * rank.getLottoReward();
        }
        totalMoney /= (double)userMoney;
        totalMoney *= 100;

        return totalMoney;
    }

    public void printWinningResult() {
        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.MISS_PRIZE) {
                break;
            }
            String num =  new DecimalFormat().format(rank.getLottoReward());
            if (rank == LottoRank.SECOND_PRIZE) {
                System.out.println(String.format(LOTTO_WINNING_RESULT_BONUS_BALL, rank.getCorrectCount(), num, winningResults.getWinningResult(rank)));
                continue;
            }
            System.out.println(String.format(LOTTO_WINNING_RESULT, rank.getCorrectCount(), num, winningResults.getWinningResult(rank)));
        }
    }

    public void printRateOfReturn() {
        System.out.println(String.format(RATE_OF_RETURN, rateOfReturn));
    }
}
