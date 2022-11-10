package lotto;

class CheckInputException {

    private static final String ERROR_MESSAGE = "[ERROR]";
    public static void checkBuyerInputIsMinus(final String input) throws IllegalArgumentException{

        final Long money = Long.valueOf(input);

        if (money < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력하신 돈이 음수입니다.");
        }
    }

    public static void checkBuyerInputIsNotNumber(final String input) throws IllegalArgumentException{
        if (Util.isNumberic(input) == false) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력하신 문자열은 숫자열이 아닙니다.");
        }
    }

    public static void checkBuyerInputIsNotDivided(final String input) throws IllegalArgumentException{
        if (Util.isDividedBuyThousand(input) == false){
            throw new IllegalArgumentException(ERROR_MESSAGE + " 1000으로 나누어 떨어지지 않습니다.");
        }
    }


}