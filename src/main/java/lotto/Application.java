package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Money;
import lotto.domain.Ticket;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Money purchasePrice = new Money(askPurchasePrice());
        Ticket tickets = new Ticket(purchasePrice);

        LottoGenerator generator = new LottoGenerator();
        List<Lotto> lottos = generator.createLottos(tickets);
        printPurchasedLottos(lottos);

    }

    public static String askPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchasePrice = Console.readLine();
        System.out.println();
        return purchasePrice;
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
