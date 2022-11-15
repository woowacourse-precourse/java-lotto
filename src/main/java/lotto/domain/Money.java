package lotto.domain;

import java.text.NumberFormat;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private static final double PROFIT_RATE_MULTIPLIER = 100.0;
    private static final double NUMBER_DECIMAL_CALCULATION = 100.0;
    private final int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public static Money from(String userInputMoney) {
        validateNumeric(userInputMoney);
        int amount = Integer.parseInt(userInputMoney);
        validateSize(amount);
        validateDivisibleByLottoTicketPrice(amount);
        return new Money(amount);
    }

    private static void validateNumeric(String userMoney) {
        try {
            Integer.parseInt(userMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자만 입력할 수 있습니다.");
        }
    }

    private static void validateSize(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 구입 최소 금액은 %d원입니다.", LOTTO_PRICE));
        }
    }

    private static void validateDivisibleByLottoTicketPrice(int amount) {
        if (amount % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(String
                    .format("[ERROR] 로또 구입 금액은 %s원 단위로 나누어 떨어져야합니다.", LOTTO_PRICE));
        }
    }

    public int getCountOfLotto() {
        return amount / LOTTO_PRICE;
    }

    public String calculateProfitRate(int profit) {
        double profitRate = (double) profit / (double) amount * PROFIT_RATE_MULTIPLIER;
        double roundedProfitRate = Math.round(profitRate * NUMBER_DECIMAL_CALCULATION) / NUMBER_DECIMAL_CALCULATION;
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(false);
        return String.valueOf(numberFormat.format(roundedProfitRate));
    }
}