package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoPublisher lottoPublisher = new LottoPublisher();
        Customer customer = new Customer();
        customer.setAsset();
        lottoPublisher.createLotto(customer.payMoney());
    }
}
