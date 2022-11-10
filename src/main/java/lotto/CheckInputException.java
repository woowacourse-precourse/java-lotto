package lotto;

class CheckInputException {

    public static void checkBuyerInputIsMinus(String input) throws IllegalArgumentException{

        Long money = Long.valueOf(input);

        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] 입력하신 돈이 음수입니다.");
        }
    }

    public static void checkBuyerInputIsNotNumber(String input) throws IllegalArgumentException{
        input.chars().allMatch(Character::isDigit);
    }


}