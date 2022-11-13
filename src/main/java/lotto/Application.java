package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import lotto.domain.Ticket;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Money purchasePrice = new Money(askPurchasePrice());
        Ticket tickets = new Ticket(purchasePrice);
    }

    public static String askPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchasePrice = Console.readLine();
        return purchasePrice;
    }
}
