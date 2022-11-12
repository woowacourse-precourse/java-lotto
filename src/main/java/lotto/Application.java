package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Generator;
import lotto.domain.Purchase;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = askPurchaseAmount();
        int lottoCount = Purchase.getLottoCount(purchaseAmount);
        Generator generator = new Generator(lottoCount);
        List<List<Integer>> lottos = generator.createLotto();
        System.out.println(lottos);
    }

    private static int askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
