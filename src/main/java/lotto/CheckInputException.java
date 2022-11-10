package lotto;

class CheckInputException {

    public static void checkBuyerInputIsMinus(String inputMoney) throws IllegalArgumentException{

        Long money = Long.valueOf(inputMoney);

        if (money > 0) {
            throw new IllegalArgumentException("[ERROR] 입력하신 돈이 음수입니다.");
        }
    }


}