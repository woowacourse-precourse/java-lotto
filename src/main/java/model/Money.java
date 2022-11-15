package model;

public class Money {

    private static int resultMoney;

    public Money(String input) {
        validateDivisibleBy1000(input);
    }

    public void validateDivisibleBy1000(String input) {
        resultMoney = Integer.parseInt(input);

        if (resultMoney % LottoConstant.STANDARD_MONEY.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT1000MONEY_ERROR_MESSAGE.getErrorMessage());
        }
    }

    public static int getTicketCount() {
        return resultMoney / LottoConstant.STANDARD_MONEY.getNumber();
    }

    public static int getResultMoney() {
        return resultMoney;
    }
}
