package lotto.domain;

import static lotto.domain.constant.WinningStatisticsValueConstant.MATCHED_FIVE_AND_BONUS_BALL;
import static lotto.domain.constant.WinningStatisticsValueConstant.MATCHED_SIX;
import static lotto.domain.constant.WinningStatisticsValueConstant.NOTHING;
import static lotto.domain.constant.WinningStatisticsValueConstant.values;
import static lotto.exception.ExceptionHandler.ILLEGAL_VALUE;
import static lotto.printer.InputPrinter.INPUT_BUYING_MONEY;
import static lotto.printer.InputPrinter.WINNING_STATISTICS;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import lotto.printer.ResultsPrinter;

public class Buyer {

    private Long money;
    private List<Lotto> lottoNumbers;
    private List<Result> results;
    private Long reward = 0L;
    private Double rateOfReturn;

    public void readyForBuyLotto() {
        INPUT_BUYING_MONEY.print();

        try {
            this.money = Long.valueOf(Console.readLine());
        } catch (Exception exception) {
            ILLEGAL_VALUE.error();
        }

        this.buyLotto();
    }

    private void buyLotto() {
        this.lottoNumbers = LottoPublisher.publishLotto(this);
    }

    public Long getMoney() {
        return money;
    }

    public Double getRateOfReturn() {
        return rateOfReturn;
    }

    public void calculateWinningResult(Set<Integer> winningNumber, List<Integer> bonusNumber) {
        WINNING_STATISTICS.print();

        this.results = new ArrayList<>();

        for (Lotto lottoNumber : lottoNumbers) {
            contrastResult(lottoNumber, winningNumber, bonusNumber);
        }

        this.analyzeTotalReward();
        this.analyzeRateOfReturn();
    }

    private void contrastResult(Lotto lottoNumber, Set<Integer> winningNumber, List<Integer> bonusNumber) {
        int correctNumber = 0;
        boolean checkBonusNumber = false;

        for (Integer number : lottoNumber.getNumbers()) {
            if (winningNumber.contains(number)) {
                ++correctNumber;
            }

            if (bonusNumber.contains(number)) {
                ++correctNumber;
                checkBonusNumber = true;
            }
        }

        results.add(new Result(correctNumber, checkBonusNumber));
    }

    public void analyzeTotalReward() {
        for (Result result : this.results) {
            memoRewards(result);
        }
    }

    private void memoRewards(Result result) {
        if (Objects.equals(result.getCorrectNumber(), MATCHED_SIX.getNumber()) && result.isExistenceBonusNumber()) {
            this.reward += MATCHED_FIVE_AND_BONUS_BALL.getReward();

            return;
        }

        this.reward += Arrays.stream(values())
                             .filter(i -> i.getNumber().equals(result.getCorrectNumber()))
                             .findFirst()
                             .orElse(NOTHING)
                             .getReward();
    }

    private void analyzeRateOfReturn() {
        this.rateOfReturn = Math.round(((double) this.reward / this.money) * 1000) / 10.0;
    }

    public void printStatics() {
        List<Integer> rankingCnt = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));

        for (Result result : results) {
            rankingCnt.set(result.getRanking(), rankingCnt.get(result.getRanking()) + 1);
        }

        for (int i = rankingCnt.size() - 1; i >= 1; --i) {
            int rank = i;
            ResultsPrinter resultsPrinter = Arrays.stream(ResultsPrinter.values()).filter(x -> x.getRanking() == rank)
                                                  .findFirst().orElseThrow(NullPointerException::new);

            resultsPrinter.print(rankingCnt.get(i));
        }
    }

    public void printRateOfReturn() {
        ResultsPrinter.GROSS_RETURN.print(this.rateOfReturn);
    }

}
