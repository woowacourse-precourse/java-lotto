package lotto.service;

import camp.nextstep.edu.missionutils.Console;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.User;
import lotto.printer.RequestInputPrinter;
import lotto.printer.SystemGuidePrinter;

import java.util.List;

public class LottoPurchaseService {

    private User user;

    public void startLotto() {
        int paymentAmount = enterPaymentAmount();
        int lottoGameCount = calculateLottoCount(paymentAmount);

        generateUser(generateLottos(lottoGameCount),paymentAmount);
    }

    private void generateUser(List<Lotto> lottos, int amount) {
        user = new User(lottos, amount);
    }

    private Integer enterPaymentAmount() {
        RequestInputPrinter.paymentAmountInputGuide();
        return Integer.parseInt(Console.readLine());
    }

    private Integer calculateLottoCount(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException();
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return amount / 1000;
    }

    private List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = LottoFactory.generateLotto(count);
        SystemGuidePrinter.purchaseHistoryMessage(lottos);

        return lottos;
    }

}
