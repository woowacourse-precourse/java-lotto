package lotto.domain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Game {

    static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    static final String LOTTO_BUY_COUNT_MESSAGE = "%d개를 구매했습니다.";
    static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    static final String WINNING_RESULT_MESSAGE = "당첨 통계";
    static final String DIVISION_LINE = "---";
    static final String LOTTO_WINNING_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    static final String LOTTO_WINNING_RESULT_BONUS_BALL_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    static final int LOTTO_NUMBERS_COUNT = 6;
    static final int LOTTO_PRICE = 1000;
    static final int PERCENT = 100;

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

    public void startGame() {
        System.out.println(INPUT_MONEY_MESSAGE);
        this.userMoney = user.inputMoney();
        this.lottoCount = userMoney / LOTTO_PRICE;

        pickAndPrintLottoNumbersCount();

        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        this.winningNumbers = user.inputWinningNumbers();

        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        this.bonusNumber = user.inputBonusNumber();

        computeWinningResults();
        this.rateOfReturn = computeRateOfReturn();

        System.out.println(WINNING_RESULT_MESSAGE);
        System.out.println(DIVISION_LINE);

        printWinningResult();
        printRateOfReturn();

    }

    public void pickAndPrintLottoNumbersCount() {
        System.out.println(String.format(LOTTO_BUY_COUNT_MESSAGE, lottoCount));

        for (int index = 0; index < lottoCount; index++) {
            Lotto lotto = new Lotto(Lotto.pickLottoNumbers());
            lottoNumbers.add(lotto);
            lotto.printLottoNumbers();
        }
    }

    public void computeWinningResults() {
        for (int index = 0; index < lottoCount; index++) {
            Lotto lottoNumber = lottoNumbers.get(index);
            LottoRank rank = compareLottoNumbersAndWinningNumbers(lottoNumber);
            winningResults.updateWinningResult(rank);
        }
    }


    public LottoRank compareLottoNumbersAndWinningNumbers(Lotto lottoNumber) {
        int totalCorrect = 0;
        List<Integer> numbers = lottoNumber.getLottoNumbers();

        for (int index = 0; index < LOTTO_NUMBERS_COUNT; index++) {
            if (winningNumbers.contains(numbers.get(index))) {
                totalCorrect += 1;
            }
        }
        return LottoRank.getRank(totalCorrect, isHaveBonusNumber(numbers));
    }

    public boolean isHaveBonusNumber(List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public double computeRateOfReturn() {
        double totalMoney = 0;
        for (LottoRank rank : LottoRank.values()) {
            totalMoney += winningResults.getWinningResult(rank) * rank.getLottoReward();
        }
        totalMoney /= (double) userMoney;
        totalMoney *= PERCENT;

        return totalMoney;
    }

    public void printWinningResult() {
        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.MISS_PRIZE) {
                break;
            }
            String rewardDecFormat = new DecimalFormat().format(rank.getLottoReward());
            if (rank == LottoRank.SECOND_PRIZE) {
                System.out.println(String.format(LOTTO_WINNING_RESULT_BONUS_BALL_MESSAGE, rank.getCorrectCount(), rewardDecFormat, winningResults.getWinningResult(rank)));
                continue;
            }
            System.out.println(String.format(LOTTO_WINNING_RESULT_MESSAGE, rank.getCorrectCount(), rewardDecFormat, winningResults.getWinningResult(rank)));
        }
    }

    public void printRateOfReturn() {
        System.out.println(String.format(RATE_OF_RETURN_MESSAGE, rateOfReturn));
    }
}
