package lotto.constants;

public class ExceptionConsole {

    public void nonNumericCharacters() {
        System.out.println(ExceptionMessage.NON_NUMERIC_CHARACTERS);
    }

    public void paymentAmountZero() {
        System.out.println(ExceptionMessage.PAYMENT_AMOUNT_ZERO);
    }

    public void thousandWonUnitException() {
        System.out.println(ExceptionMessage.THOUSAND_WON_UNIT_EXCEPTION);
    }
}
