package lotto;

import lotto.domain.Bag;
import lotto.domain.Bank;
import lotto.domain.BankTeller;
import lotto.domain.Customer;
import lotto.domain.LottoCompany;
import lotto.domain.LottoPrinter;
import lotto.domain.LottoReader;
import lotto.domain.LottoStore;
import lotto.domain.LottoStoreClerk;
import lotto.domain.PrizeCalculator;

public class Application {
    public static void main(String[] args) {
        try {
            // 로또 구입
            Customer customer = new Customer(new Bag());
            LottoStoreClerk clerk = new LottoStoreClerk(new LottoPrinter());
            LottoStore lottoStore = new LottoStore(clerk);
            lottoStore.sellLotto(customer);

            // 당첨 번호 추첨
            LottoCompany lottoCompany = new LottoCompany();
            lottoCompany.draw();

            // 당첨금 확인
            BankTeller bankTeller = new BankTeller(new PrizeCalculator(), new LottoReader());
            Bank bank = new Bank(bankTeller);
            bank.givePrize(customer, lottoCompany);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
