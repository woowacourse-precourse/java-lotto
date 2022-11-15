package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Purchase {

    private final long purchaseAmount;
    private final long purchaseQuantity;
    private final List<Lotto> lotteries;

    public Purchase(String purchaseAmount) {
        this.purchaseAmount = Long.parseLong(purchaseAmount);
        this.purchaseQuantity = calculatePurchaseQuantity(this.purchaseAmount);
        this.lotteries = createLotteries(this.purchaseQuantity);

    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }
    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public Long calculatePurchaseQuantity(final long purchaseAmount) {
        return purchaseAmount / 1000;
    }


    public List<Lotto> createLotteries(final long purchaseQuantity) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i=0; i < purchaseQuantity; i++) {
            Lotto lotto = lottoCreator();
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public Lotto lottoCreator() {
        List<Integer> lottoNumbers = createLottoNumbers();
        return new Lotto(lottoNumbers);
    }

    public List<Integer> createLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }

    // For input UI
    public static String purchaseAmountInput() {
        System.out.println(MSG.INPUT_PURCHASE.getMsg());
        String purchaseAmount = Console.readLine();
        System.out.println();
        validatePurchaseInput(purchaseAmount);
        return purchaseAmount;
    }

    // For Print the Lotteries list purchased
    public void printPurchaseLotteries() {
        System.out.println(String.format(MSG.OUTPUT_PURCHASE.getMsg(), purchaseQuantity));
        for (Lotto lotto : lotteries) {
            lotto.printLotto();
        }
        System.out.println();
    }

    public static void validatePurchaseInput(final String purchaseAmountInput) {
        final String pattern = "[1-9]+[0-9]*0{3}";
        if (!purchaseAmountInput.matches(pattern)) {
            throw new IllegalArgumentException(MSG.ERR_PURCHASE.getMsg());
        }
    }
}
