package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Store store = new Store();
        Admin admin = new Admin(store);
        Buyer buyer = new Buyer(store);

        try {
            // 로또 구매금액 입력 및 당첨 번호 입력
            int seedMoney = buyer.inputSeedMoney();
            buyer.buyLotto(seedMoney);
            admin.inputGameNumbers();
            // 당첨 내역 확인
            LottoResult lottoResult = buyer.checkPrize(buyer.getMyLottos());
            buyer.checkRate(seedMoney, (int) lottoResult.getTotalMoney());
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage()); // 에러 구문 전달
        }
    }
}
