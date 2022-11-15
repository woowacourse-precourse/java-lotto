package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static final Integer PURCHASING_UNIT = 1000;
    public static final Integer MINIMUM_PURCHASING_AMOUNT = 1000;
    public static final Integer MAXIMUM_PURCHASING_AMOUNT = 2_000_000_000;

    private final Integer purchasingAmount;
    private final Integer lottoAmount;
    private final List<List<Integer>> lottos;

    public User(String userInput) {
        Integer purchasingAmount = Converter.StringToInteger(userInput);
        validatePurchasingAmount(purchasingAmount);
        this.purchasingAmount = purchasingAmount;
        this.lottoAmount = createLottoAmount(this.purchasingAmount);
        this.lottos = createLotto(this.lottoAmount);
    }

    private void validatePurchasingAmount(Integer userInput) {
        if (!isValidatePurchasingAmountRange(userInput)) {
            String message = Error.getErrorMessage(Error.Messages.PURCHASING_AMOUNT_RANGE_ERROR);
            throw new IllegalArgumentException(message);
        }
        if (!isValidatePurchasingAmountUnit(userInput)) {
            String message = Error.getErrorMessage(Error.Messages.PURCHASING_AMOUNT_UNIT_ERROR);
            throw new IllegalArgumentException(message);
        }
    }

    private boolean isValidatePurchasingAmountRange(Integer purchasingAmount) {
        return purchasingAmount >= MINIMUM_PURCHASING_AMOUNT && purchasingAmount <= MAXIMUM_PURCHASING_AMOUNT;
    }

    private boolean isValidatePurchasingAmountUnit(Integer purchasingAmount) {
        return purchasingAmount % PURCHASING_UNIT == 0;
    }

    private Integer createLottoAmount(Integer purchasingAmount) {
        return purchasingAmount / PURCHASING_UNIT;
    }

    public Integer getLottoAmount() {
        return lottoAmount;
    }

    public Integer getPurchasingAmount() { return purchasingAmount; }

    public List<List<Integer>> getLottos() { return lottos; }

    private List<List<Integer>> createLotto(Integer lottoAmount) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            UserLotto newLotto = new UserLotto();
            lottos.add(newLotto.getNumbers());
        }
        return lottos;
    }
}
