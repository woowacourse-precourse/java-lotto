package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            Company company = new Company();
            Shop shop = new Shop();
            System.out.println("구매금액을 입력해 주세요.");
            Integer payment = shop.inputMoney();
            List<Lotto> lotto = shop.sellLotto();
            shop.printSellLotto(lotto);
            System.out.println("\n당첨 번호를 입력해 주세요.");
            company.inputWinNumbers();
            System.out.println("\n보너스 번호를 입력해 주세요.");
            company.inputBonusNumber();
            List<Prize> result = company.check(lotto);
            company.printResult(result, payment);
        } catch (Exception ignored) {
        }
    }
}
