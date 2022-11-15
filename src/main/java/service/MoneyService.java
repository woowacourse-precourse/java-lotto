package service;

import repository.MoneyRepository;
import view.OutputView;

import java.util.EnumMap;
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
            OutputView.printErrorMessage(Error.PURCHASE_AMOUNT_FORMAT);
            throw new IllegalArgumentException();
        }
    }

    private void checkAmountValue(int amountValue) {
        Rule lotto = Rule.PER_LOTTO;

        if (amountValue == 0 || amountValue % lotto.getPrice() != 0) {
            OutputView.printErrorMessage(Error.PURCHASE_AMOUNT_VALUE);
            throw new IllegalArgumentException();
        }
    }

    public int getPurchaseAmount() {
        return moneyRepository.getMoney();
    }

    public void saveRateOfReturn(EnumMap<Winner, Integer> winners) {
        double rateOfReturn = calculateRateOfReturn(winners);
        moneyRepository.saveRateOfReturn(rateOfReturn);
    }

    private double calculateRateOfReturn(EnumMap<Winner, Integer> winners) {
        double purchaseAmount = moneyRepository.getMoney();

        double sumOfReturn = winners.entrySet().stream()
                .mapToInt(rank -> rank.getKey().getPrize() * rank.getValue())
                .sum();

        return (sumOfReturn / purchaseAmount) * 100;
    }

    public double getRateOfReturn() {
        return moneyRepository.getRateOfReturn();
    }
}
