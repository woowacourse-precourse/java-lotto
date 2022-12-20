package lotto;

import Model.Rank;
import Utils.Exceptions;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static Views.InputView.INPUT_VIEW;
import static Views.OutputView.OUTPUT_VIEW;


public class Application {
    public static void main(String[] args) {
        try {
            Play();
//            printResult(Referee.Compare(LottoMachine.pickLottoNumbers(inputCash()), inputWinningNumbers()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int inputCash() {
        int countLotto;
        System.out.println("구입금액을 입력해 주세요.");
        countLotto = Cash.countPurchaseQuantity(Console.readLine());
        System.out.println(countLotto + "개를 구매했습니다.");
        return countLotto;
    }

    public static List<List<String>> inputWinningNumbers() {
        List<List<String>> winningNumbers = new ArrayList<>();

        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumbers.add(LottoMachine.getWinningNumbers(Console.readLine()));
        System.out.println("보너스 번호를 입력해 주세요.");
        winningNumbers.add(LottoMachine.getBonusNumber(Console.readLine()));
        Exceptions.compareWinningNumbersWithBonusNumbers(winningNumbers);
        return winningNumbers;
    }

    public static void printResult(List<List<Integer>> totalResult) {
        int prize = 0;
        int index = 0;

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + totalResult.get(0).get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + totalResult.get(0).get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + totalResult.get(0).get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + totalResult.get(0).get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + totalResult.get(0).get(4) + "개");
        for (Rank rank : Rank.values()) {
            prize += rank.getPrize() * totalResult.get(0).get(index);
            index++;
        }
        System.out.println(printEarningsRate(totalResult.get(1), prize));
    }

    public static String printEarningsRate(List<Integer> cashResult, double prize) {
        double sumPrize = (prize / (cashResult.get(0) * 1000)) * 100;
        return "총 수익률은 " + sumPrize + "%입니다.";
    }

    public static void Play() {
        OUTPUT_VIEW.PrintPurchaseAmount();
        OUTPUT_VIEW.PrintCountPurchasingLotto(INPUT_VIEW.InputCash(Console.readLine()));
    }

}


















