package lotto;

import lotto.constant.LottoNumber;
import lotto.util.InputUtil;
import lotto.util.MessageUtil;
import lotto.util.ValidationUtil;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchase {

    private final InputUtil inputUtil = new InputUtil();

    private final MessageUtil messageUtil = new MessageUtil();

    private final ValidationUtil validationUtil = new ValidationUtil();

    private final NumberGenerator numberGenerator = new NumberGenerator();

    public List<Lotto> getPurchaseInfo() {
        int purchaseAmount = getUserPurchaseAmount();
        List<Lotto> userLottos = new ArrayList<>();
        int purchaseCount = getPurchaseCount(purchaseAmount);

        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = generateLottoNumbers();
            userLottos.add(lotto);
        }

        return userLottos;
    }

    private int getUserPurchaseAmount() {
        int purchaseAmount = Integer.parseInt(inputUtil.getUserInput());
        validationUtil.validatePurchase(purchaseAmount);

        return purchaseAmount;
    }

    private int getPurchaseCount(int purchaseAmount) {
        int purchaseCount = purchaseAmount / LottoNumber.PURCHASE_AMOUNT_COND.getNumber();
        messageUtil.printPurchaseCount(purchaseCount);

        return purchaseCount;
    }

    private Lotto generateLottoNumbers() {
        List<Integer> lottoNumbers = numberGenerator.getLottoNumbers();
        Lotto lotto = new Lotto(lottoNumbers);
        messageUtil.printPurchaseInfo(lotto.getLottoNumbers());

        return lotto;
    }
}
