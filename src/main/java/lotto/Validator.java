package lotto;

public class Validator {
    public static void isNumber(String number){
        for (int i = 0; i < number.length(); i++) {
            if (i == 0 && (number.charAt(i) == '0' || !Character.isDigit(number.charAt(i)))) {
                throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER.getMessage());

            }
            if (i != 0 && !Character.isDigit(number.charAt(i))) {
                throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER.getMessage());
            }
        }
    }

    public static void checkAmount(int amount) {
        if (amount % Constant.PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(ExceptionMessage.AMOUNT_NOT_DIVIDED.getMessage());
        }
    }

}
