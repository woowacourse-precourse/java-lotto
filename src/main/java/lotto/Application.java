package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorCode;
import lotto.exception.MyIllegalArgumentException;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Lotto> lottos;
        Receipt receipt;
        int money;
        try {
            money = askMoney();
            receipt = new Receipt(money);
            lottos = receipt.buy();
            print(receipt, lottos);
        } catch (MyIllegalArgumentException e) {
            e.printErrorMessage();
            return;
        }
    }

    private static void print(Receipt receipt, List<Lotto> lottos) {
        receipt.printReceipt();
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
        throw new MyIllegalArgumentException(ErrorCode.MONEY_ERROR);
    }
}
