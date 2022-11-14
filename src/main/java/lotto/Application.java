package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입 금액을 입력해주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        int lottoQuantity = purchaseAmount/1000;
        try {
            if(purchaseAmount%1000!=0)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
        }

        LottoGenerator generator = new LottoGenerator();
        List[] mylottos = generator.buyLottos(lottoQuantity);
    }
}
