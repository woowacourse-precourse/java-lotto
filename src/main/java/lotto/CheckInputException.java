package lotto;

import java.math.BigInteger;

class CheckInputException {

    private static final String ERROR_MESSAGE = "[ERROR]";
    public static void checkBuyerInputIsMinus(final String input) throws IllegalArgumentException{

        final BigInteger money = new BigInteger(input);
        final BigInteger zero = BigInteger.ZERO;

        if (money.compareTo(zero) == -1 || money.compareTo(zero) == 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력하신 돈이 음수이거나 0입니다.");
        }
    }

    public static void checkBuyerInputIsNotNumber(final String input) throws IllegalArgumentException{
        if (Util.isNumberic(input) == false || input.contains(" ") == true) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력하신 문자열은 숫자열이 아닙니다.");
        }
    }

    public static void checkBuyerInputIsNotDivided(final String input) throws IllegalArgumentException{
        if (Util.isDividedBuyThousand(input) == false){
            throw new IllegalArgumentException(ERROR_MESSAGE + " 1000으로 나누어 떨어지지 않습니다.");
        }
    }

    public static void checkBuyerInputIsNotNumberRange(final String input) throws IllegalArgumentException{
        final BigInteger convertInput = new BigInteger(input);
        final BigInteger numberFortyFive = BigInteger.valueOf(45);
        final BigInteger numberOne = BigInteger.ONE;

        //if (input < 0 || input > 45)와 조건이 같음
        if (convertInput.compareTo(numberOne) == -1 || convertInput.compareTo(numberFortyFive) == 1){
            throw new IllegalArgumentException(ERROR_MESSAGE + " 1~45범위의 숫자가 아닙니다.");
        }
    }

    public static void checkBuyerInputIsNotFiveComma(final String input) throws IllegalArgumentException{
        final int countComma = Util.countChar(input, ',');

        if (countComma != 5){
            throw new IllegalArgumentException(ERROR_MESSAGE + "','의 숫자가 5개가 아닙니다.");
        }
    }

}