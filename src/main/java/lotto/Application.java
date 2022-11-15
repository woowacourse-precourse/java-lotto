package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.MyIllegalArgumentException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.exception.ErrorCode.MONEY_ERROR;
import static lotto.exception.ErrorCode.WIN_NUMBER_ERROR;

public class Application {
    public static void main(String[] args) {
        try {
            int money = askMoney();
            Receipt receipt = new Receipt(money);
            List<Lotto> lottos = receipt.buy();
            print(receipt, lottos);
            List<Integer> winNumbers = askWinNumbers();
            Lotto winLotto = new Lotto(winNumbers);
        } catch (MyIllegalArgumentException e) {
            e.printErrorMessage();
        }
    }

    private static void print(Receipt receipt, List<Lotto> lottos) {
        receipt.printReceipt();
        lottos.forEach(Lotto::sortNumbers);
        lottos.forEach(Lotto::printNumbers);
    }

    /**
     * 사용자 입력 메서드
     */
    private static int askMoney() {
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
}
