package service;

import repository.MoneyRepository;

import java.util.regex.Pattern;

public class MoneyService {
    private final MoneyRepository moneyRepository;

    public MoneyService(MoneyRepository moneyRepository) {
        this.moneyRepository = moneyRepository;
    }

    public void savePurchaseAmount(String amount) {
        validatePurchaseAmount(amount);
        moneyRepository.save(Integer.parseInt(amount));
    }

    private void validatePurchaseAmount(String amount) {
        checkAmountFormat(amount);

        int amountValue = Integer.parseInt(amount);
        checkAmountValue(amountValue);
    }

    private void checkAmountFormat(String amount) {
        Format format = Format.PURCHASE_AMOUNT;

        if (!Pattern.matches(format.getRegex(), amount)) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_FORMAT.getText());
        }
    }

    private void checkAmountValue(int amountValue) {
        Rule lotto = Rule.PER_LOTTO;

        if (amountValue == 0 || amountValue % lotto.getPrice() != 0) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_VALUE.getText());
        }
    }

    public int getPurchaseAmount() {
        return moneyRepository.getMoney();
    }
}
