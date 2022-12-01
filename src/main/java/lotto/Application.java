package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.MyIllegalArgumentException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.exception.ErrorCode.MONEY_ERROR;
import static lotto.exception.ErrorCode.WIN_NUMBER_ERROR;
import static lotto.exception.ErrorCode.BONUS_NUMBER_ERROR;

public class Application {
    public static void main(String[] args) {
        try {
            //로또 구매
            int money = askMoney();
            Receipt receipt = new Receipt(money);
            List<Lotto> lottos = receipt.buy();
            print(receipt, lottos);

            //당첨 로또 및 보너스번호 생성
            List<Integer> winNumbers = askWinNumbers();
            int bonusNumber = askBonusNumber();
            Lotto winLotto = new Lotto(winNumbers);

            //당첨 결과 계산 및 출력
            Bank bank = new Bank(winLotto, bonusNumber);
            long totalMoney = bank.getTotalMoney(lottos);
            bank.printPayResult();

            //통계 결과 출력
            printProfit(money, totalMoney);
        } catch (MyIllegalArgumentException e) {
            e.printErrorMessage();
        }
    }

    public static void printProfit(long money, long totalMoney) {
        double profit = Math.round((double) totalMoney * 10000 / (double) money) / 100.0;
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }

    private static void print(Receipt receipt, List<Lotto> lottos) {
        receipt.printReceipt();
        lottos.forEach(Lotto::printSortedNumbers);
        System.out.println();
    }

    /**
     * 사용자 입력 메서드
     */
    public static int askMoney() {
        System.out.println("구매금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException ignored) {
        }
        throw new MyIllegalArgumentException(MONEY_ERROR);
    }

    public static List<Integer> askWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            return Stream.of(Console.readLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        } catch (Exception ignored) {
        }
        throw new MyIllegalArgumentException(WIN_NUMBER_ERROR);
    }

    public static int askBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException ignored) {
        }
        throw new MyIllegalArgumentException(BONUS_NUMBER_ERROR);
    }
}
