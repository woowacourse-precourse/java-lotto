package lotto;

import lotto.controller.Bank;
import lotto.controller.LottoDraw;
import lotto.controller.LottoStore;
import lotto.model.BankTeller;
import lotto.model.Customer;
import lotto.model.LottoCompany;
import lotto.model.LottoStoreClerk;

public class Application {
    public static void main(String[] args) {
        try {
            // 로또 구입
            Customer customer = new Customer();
            LottoStoreClerk clerk = new LottoStoreClerk();
            LottoStore lottoStore = new LottoStore(clerk);
            lottoStore.sellLottoTo(customer);

            // 당첨 번호 추첨
            LottoCompany lottoCompany = new LottoCompany();
            LottoDraw lottoDraw = new LottoDraw(lottoCompany);
            lottoDraw.draw();

            // 당첨금 확인
            BankTeller bankTeller = new BankTeller();
            Bank bank = new Bank(bankTeller);
            bank.givePrize(customer, lottoCompany);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
