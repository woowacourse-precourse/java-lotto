package lotto;

import lotto.controller.Customer;
import lotto.controller.LottoBroadcast;
import lotto.controller.LottoShop;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Customer customer = new Customer();

            customer.buy(new LottoShop());
            customer.watch(LottoBroadcast.onAir());

            customer.printResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
