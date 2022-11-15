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
        Customer customer = new Customer(new PurchasePrice(InputView.inputPurchasePrice()));
        LottoSeller lottoSeller = new LottoSeller(new LottoNumberGenerator());
        OutputView.printQuantity(lottoSeller.calculateQuantity(customer.getPurchasePrice()));

        lottoSeller.sellLotteriesTo(customer);
        OutputView.printLotteries(customer.getLotteries());

        Lotto winningLotto = new WinningLotto(InputView.inputWinningLotto()).toLotto();
        LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusNumber());
        LottoCompany lottoCompany = new LottoCompany(winningLotto, bonusNumber);

        MatchResult matchResult = customer.checkMyLottoNumbers(lottoCompany);
        OutputView.printResult(matchResult, customer.calculateProfit(matchResult));
    }
}
