package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Game {

  private static final int LOTTO_RANGE_START = 1;
  private static final int LOTTO_RANGE_END = 45;
  private static final int LOTTO_COUNT = 6;
  public static final String NOT_NUMBER_ERROR = "[ERROR] 입력 값은 숫자여야 합니다.";

  private int numOfLotto;
  private List<Lotto> lotteries;
  private Money money;
  private WinningNumbers winningNumbers;
  private final Map<Ranking, Integer> winningResult = new EnumMap<>(Ranking.class);

  public Game() {
    this.lotteries = new ArrayList<>();
  }

  public void setMoney(String input) {
    try {
      this.money = new Money(Integer.parseInt(input));
      numOfLotto = money.getNumOfLotto();
    } catch (NumberFormatException e) {
      System.out.println(NOT_NUMBER_ERROR);
    }
  }

  public void makeLotto(int numOfLotto) {
    for (int i = 0; i < numOfLotto; i++) {
      Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_COUNT));
      lotteries.add(lotto);
    }
  }

  public void setLotteries(String input) {
    setMoney(input);
    makeLotto(numOfLotto);
  }

  public List<Lotto> getLotteries() {
    return lotteries;
  }

  public void printLotteriesNumber() {
    for (Lotto lotto : lotteries) {
      System.out.println(lotto.getNumbers());
    }
  }

  public WinningNumbers inputNumber(String inputWinningNumber, String inputBonusNum) {
    return this.winningNumbers = new WinningNumbers(inputWinningNumber(inputWinningNumber), inputBonusNum(inputBonusNum));
  }

  public Lotto inputWinningNumber(String input) {

    List<String> inputNumbers = List.of(input.split(","));
    List<Integer> winningNumbers = new ArrayList<>();

    for (String number : inputNumbers) {
      winningNumbers.add(Integer.parseInt(number));
    }

    return new Lotto(winningNumbers);
  }

  public int inputBonusNum(String input) {
    return Integer.parseInt(input);
  }

  public Ranking valueOf(int num, boolean hasBonusNumber) {
    for (Ranking ranking : Ranking.values()) {
      if (ranking.getNumber() == num && num == Ranking.SECOND.getNumber() && hasBonusNumber) {
          return Ranking.SECOND;
      }
      else if (ranking.getNumber() == num && num == Ranking.SECOND.getNumber() ) {
          return Ranking.THIRD;
      }
      else if (ranking.getNumber() == num) {
        return ranking;
      }
    }
    return null;
  }

  public boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
    return lotto.getNumbers().contains(bonusNumber);
  }

  public void initialWinningResult() {
    for (Ranking ranking : Ranking.values()) {
      winningResult.put(ranking, 0);
    }
  }

  public int compare(Lotto lotto, Lotto winningNumber) {
    int sameNumber = lotto.getNumbers().stream()
            .filter(target -> winningNumber.getNumbers().stream().anyMatch(Predicate.isEqual(target)))
            .collect(Collectors.toList())
            .size();
    return sameNumber;
  }

  public Map<Ranking, Integer> getWinningResult(List<Lotto> lotteries, Lotto winningNumber, int bonusNumber) {
    initialWinningResult();
    for (Lotto lotto : lotteries) {
      int number = compare(lotto, winningNumber);
      if (number > 2) {
        Ranking ranking = valueOf(number, hasBonusNumber(lotto, bonusNumber));
        winningResult.put(ranking, winningResult.get(ranking) + 1);
      }
    }
    return winningResult;
  }

  public double calculateWinPrize(Map<Ranking, Integer> winningResult) {
    int winPrize = 0;
    for (Ranking ranking : winningResult.keySet()) {
      int money = ranking.getMoney();
      int number = winningResult.get(ranking);
      winPrize += money * number;
    }
    return winPrize;
  }

  public double earningsPercent(double winPrize) {
    double earningsPercent = winPrize / money.getMoney() * 100;
    return Math.round(earningsPercent * 10) / 10.0;
  }

  public void playGame() {
    setLotteries(InputView.userMoney());
    OutputView.printLottoAmount(numOfLotto);
    printLotteriesNumber();
    inputNumber(InputView.winningNumber(), InputView.bonusNumber());
    getWinningResult(lotteries, winningNumbers.getWinningNumber(), winningNumbers.getBonusNumber());
    OutputView.printWinningStatistics(winningResult);
    OutputView.printTotalEarningsPercent(earningsPercent(calculateWinPrize(winningResult)));

  }
}