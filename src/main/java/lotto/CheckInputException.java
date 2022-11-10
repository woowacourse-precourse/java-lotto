package lotto;

class CheckInputException {

    public static void checkBuyerInputIsMinus(String inputMoney) throws IllegalArgumentException{

        Long money = Long.valueOf(inputMoney);

        if (money > 0) {
            throw new IllegalArgumentException("입력하신 돈이 마이너스입니다.");
        }
    }
}