package lotto;

import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.LottoCompany;
import lotto.model.LottoNumber;
import lotto.model.LottoNumberGenerator;
import lotto.model.LottoSeller;
import lotto.model.MatchResult;
import lotto.model.PurchasePrice;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void run() {
        PurchasePrice purchasePrice = new PurchasePrice(InputView.inputPurchasePrice());
        LottoSeller lottoSeller = new LottoSeller(new LottoNumberGenerator());
        OutputView.printQuantity(lottoSeller.calculateQuantity(purchasePrice));

        Customer customer = new Customer(purchasePrice);
        lottoSeller.sellLotteriesTo(customer);
        OutputView.printLotteries(customer.getLotteries());

        MatchResult matchResult = customer.checkMyLottoNumbers(generateLottoCompany());
        OutputView.printResult(matchResult, customer.calculateProfit(matchResult));
    }

    private static LottoCompany generateLottoCompany() {
        Lotto winningLotto = new WinningLotto(InputView.inputWinningLotto()).toLotto();
        LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusNumber());
        return new LottoCompany(winningLotto, bonusNumber);
    }
}
