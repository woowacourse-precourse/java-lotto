package lotto.application;

import lotto.application.config.LottoApplicationConfig;
import lotto.domain.lotto.Lotto;
import lotto.domain.money.Money;
import lotto.domain.rank.Rank;
import lotto.domain.salesman.LottoSalesman;
import lotto.domain.statistics.Statistics;
import lotto.domain.winningnumber.WinningNumber;
import lotto.infra.log.Logger;
import lotto.step.PurchaseLotto;
import lotto.step.Step;

import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static lotto.domain.rank.Rank.*;
import static lotto.infra.port.inbound.StandardInput.readLine;
import static lotto.infra.port.outbound.StandardOutput.println;

public class LottoApplicationContext {

    private static final List<Rank> RANKS = List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);

    private final Logger log = new Logger();

    private final LottoSalesman salesman;

    private Step step;
    private List<Lotto> lottos;
    private WinningNumber winningNumber;
    private Money principal;
    private Statistics statistics;

    public LottoApplicationContext(LottoApplicationConfig config) {
        this.salesman = new LottoSalesman(config.pricePerLotto(), config.lottoGenerator());
        this.step = new PurchaseLotto(this);
    }

    public boolean finish() {
        return !step.executable();
    }

    public void progress() {
        try {
            step.execute();
            step = step.next();
        } catch (RuntimeException e) {
            log.error(e.getMessage(), e.getClass());
        }
    }

    public void purchaseLotto() {
        println("구입금액을 입력해 주세요.");
        this.principal = Money.valueOf(inputNumber());
        lottos = salesman.salesLotto(principal);
        println("");
    }

    public void showPurchasedLotto() {
        println(format("%d개를 구매했습니다.", lottos.size()));
        lottos.forEach(lotto -> println(lotto.toString()));
        println("");
    }

    public void inputWinnerNumber() {
        println("당첨 번호를 입력해 주세요.");
        List<Integer> inputNumbers = toIntegers(readLine());
        Lotto winningLotto = new Lotto(inputNumbers);
        println("");

        println("보너스 번호를 입력해 주세요.");
        int bonusNumber = inputNumber();
        println("");

        this.winningNumber = new WinningNumber(winningLotto, bonusNumber);
    }

    public void calculateWin() {
        List<Rank> result = lottos.stream()
                .map(winningNumber::judge)
                .collect(toList());

        this.statistics = Statistics.of(principal, result);
    }

    private static int inputNumber() {
        try {
            return parseInt(readLine());
        } catch (RuntimeException e) {
            throw new NoSuchElementException();
        }
    }

    private List<Integer> toIntegers(String input) {
        return stream(input.split(","))
                .map(Integer::parseInt)
                .collect(toList());
    }

    public void showStatistics() {
        println("당첨 통계");
        println("---");
        RANKS.forEach(this::printRank);
        printYield();
    }

    private void printRank(Rank rank) {
        if (rank == SECOND) {
            printSecondRank(rank);
            return;
        }
        printDefaultRank(rank);
    }

    private void printDefaultRank(Rank rank) {
        println(format(
                "%d개 일치 (%s원) - %d개",
                rank.getMatchCount(),
                rank.getReward(),
                statistics.count(rank)));
    }

    private void printSecondRank(Rank rank) {
        println(format(
                "%d개 일치, 보너스 볼 일치 (%s원) - %d개",
                rank.getMatchCount(),
                rank.getReward(),
                statistics.count(rank)));
    }

    private void printYield() {
        println(format("총 수익률은 %.1f%%입니다.", statistics.yield()));
    }
}
