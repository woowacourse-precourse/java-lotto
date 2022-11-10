package lotto;

class CheckInputException {

    public static void checkBuyerInputIsMinus(final String input) throws IllegalArgumentException{

        final Long money = Long.valueOf(input);

        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] 입력하신 돈이 음수입니다.");
        }
    }

    public static void checkBuyerInputIsNotNumber(final String input) throws IllegalArgumentException{
        if (Util.isNumberic(input) == false)
            throw new IllegalArgumentException("[ERROR] 입력하신 문자열은 숫자열이 아닙니다.");
    }


}