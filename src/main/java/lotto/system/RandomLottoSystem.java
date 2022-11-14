package lotto.system;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.money.Money;

public class RandomLottoSystem {
    private static final String PRINT_MESSAGE_INPUT_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String PRINT_MESSAGE_BUY_AMOUNT = "%d 개를 입력했습니다.";
    private static final Integer START_INCLUSIVE = 1;
    private static final Integer END_INCLUSIVE = 45;
    private static final Integer COUNT = 6;

    private final IoSystem io;
    private final Money purchaseLottoMoney;

    public RandomLottoSystem(IoSystem ioSystem) {
        this.io = ioSystem;
        this.printMessageInputPurchaseMoney();
        this.purchaseLottoMoney = this.inputMoneyByUser();
    }

    public LottoBundle generateLottoBundle() {
        var purchaseCount = purchaseLottoMoney.calculateAvailablePurchaseCount();
        var numbers = this.generateRandomNumbers(purchaseCount);

        var lottoBundle = new LottoBundle(numbers);

        this.printPurchaseLottoAmount(purchaseCount);
        this.printLottoBundleListUp(lottoBundle);

        return lottoBundle;
    }

    private List<List<Integer>> generateRandomNumbers(final Long repeatCount) {
        List<List<Integer>> numbers = new ArrayList<>();

        for (int i = 0; i < repeatCount; i++) {
            numbers.add(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT));
        }
        return numbers;
    }

    public Money getPurchaseLottoMoney() {
        return this.purchaseLottoMoney;
    }

    private void printPurchaseLottoAmount(Long purchaseCount) {
        io.println(String.format(PRINT_MESSAGE_BUY_AMOUNT, purchaseCount));
    }

    private void printLottoBundleListUp(LottoBundle lottoBundle) {
        io.println(lottoBundle.listUpLotto());
    }

    private void printMessageInputPurchaseMoney() {
        io.println(PRINT_MESSAGE_INPUT_PURCHASE_MONEY);
    }

    private Money inputMoneyByUser() {
        return Money.generatePurchaseLottoMoney(io.input());
    }


}
