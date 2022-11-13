package lotto.domain;

/**
 * 은행에서는 당첨금을 수령
 */
public class Bank {
    private BankTeller bankTeller;

    public Bank(BankTeller bankTeller) {
        this.bankTeller = bankTeller;
    }

    public void givePrize(Customer customer, LottoCompany lottoCompany) {
        bankTeller.givePrizeTo(customer, lottoCompany);
    }
}
