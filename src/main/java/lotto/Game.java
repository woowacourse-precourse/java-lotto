package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Game {

  private int numOfLotto;
  private List<Lotto> lotteries;
  private final Map<Ranking, Integer> winningResult = new EnumMap<>(Ranking.class);
  private Money money;
  private WinningNumbers winningNumbers;

  public Game() {
    this.lotteries = new ArrayList<>();
  }

  public void setMoney(String input) {
    try {
      this.money = new Money(Integer.parseInt(input));
      numOfLotto = money.getNumOfLotto();
    } catch (NumberFormatException e) {
      System.out.println("[ERROR] 입력 값은 숫자여야 합니다." );
    }
  }

  // 랜덤 번호 생성하기
  public List<Integer> makeLottoNumbers() {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6);
  }

  // 구입 금액에 따라 로또 만들기
  public void makeLotto(int numOfLotto) {
    for (int i = 0; i < numOfLotto; i++) {
      Lotto lotto = new Lotto(makeLottoNumbers());
      lotteries.add(lotto);
    }
  }

  // 1. 구입 금액에 따른 총 로또 만들기
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

  // 2. 당첨 번호와 보너스 번호 입력 받아서 저장
  public WinningNumbers inputNumber(String inputWinningNumber, String inputBonusNum) {
    return this.winningNumbers = new WinningNumbers(inputWinningNumber(inputWinningNumber), inputBonusNum(inputBonusNum));
  }

  // 당첨 번호 입력 받기
  public Lotto inputWinningNumber(String input) {

    List<String> inputNumbers = List.of(input.split(","));
    List<Integer> winningNumbers = new ArrayList<>();

    for (String number : inputNumbers) {
      winningNumbers.add(Integer.parseInt(number));
    }

    return new Lotto(winningNumbers);
  }

  // 보너스 번호 입력 받기
  public int inputBonusNum(String input) {
    return Integer.parseInt(input);
  }

  // 맞춘 개수와 보너스 넘버 포함 여부로 랭킹 알아보기
  public Ranking valueOf(int num, boolean hasBonusNumber) {
    for (Ranking ranking : Ranking.values()) {
      if (ranking.getNumber() == num) {
        if (num == 5) {
          if (hasBonusNumber) {
            return Ranking.SECOND;
          }
          return Ranking.THIRD;
        }
        return ranking;
      }
    }
    return null;
  }

  public boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
    return lotto.getNumbers().contains(bonusNumber);
  }

  // 등수별 0명으로 초기화
  public void initialWinningResult() {
    for (Ranking ranking : Ranking.values()) {
      winningResult.put(ranking, 0);
    }
  }

  // 로또 한 개 당첨 번호와 돌아가면서 비교하고 같은 수의 개수 반환
  public int compare(Lotto lotto, Lotto winningNumber) {
    int sameNumber = lotto.getNumbers().stream()
            .filter(target -> winningNumber.getNumbers().stream().anyMatch(Predicate.isEqual(target)))
            .collect(Collectors.toList())
            .size();
    return sameNumber;
  }

  // 3. 로또 전체를 당첨 번호와 돌아가면서 비교하고 등수당 당첨 개수 구하는 메서드
  public Map<Ranking, Integer> compareAll(List<Lotto> lotteries, Lotto winningNumber, int bonusNumber) {
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

  // 총 당첨금
  public double calculateWinPrize(Map<Ranking, Integer> winningResult) {
    int winPrize = 0;
    for (Ranking ranking : winningResult.keySet()) {
      int money = ranking.getMoney();
      int number = winningResult.get(ranking);
      winPrize += money * number;
    }
    return winPrize;
  }

  // 5. 총 수익률
  public double earningsPercent(double winPrize) {
    double earningsPercent = winPrize / money.getMoney() * 100;
    return Math.round(earningsPercent * 10) / 10.0;
  }

  public void playGame() {
    setLotteries(Console.readLine());
    OutputView.printLottoAmount(numOfLotto);
    printLotteriesNumber();
    inputNumber(InputView.winningNumber(), InputView.bonusNumber());
    compareAll(lotteries, winningNumbers.getWinningNumber(), winningNumbers.getBonusNumber());
    OutputView.printWinningStatistics(winningResult);
    OutputView.printTotalEarningsPercent(earningsPercent(calculateWinPrize(winningResult)));

  }
}