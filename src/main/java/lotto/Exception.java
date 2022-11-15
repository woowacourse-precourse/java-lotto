package lotto;

public class Exception {
    private static final int ZERO = 0;
    private static final int TICKET_PRICE = 1000;

    // TODO : 로또 구매 금액을 입력 받아 검증 후 반환한다.
    public static int isCorrectAmount(String purchaseAmount) {
        int amount = isContainCharacter(purchaseAmount);
        isDividedByTicketPrice(amount);
        return amount;
    }

    // TODO : 입력 값이 1,000으로 나누어 떨어지지 않는 경우 예외 처리 한다.
    static void isDividedByTicketPrice(int purchaseAmount) throws IllegalArgumentException{
        if (purchaseAmount % TICKET_PRICE != ZERO)
            throw new IllegalArgumentException("[ERROR] The unit of the purchase amount is not 1,000.");
    }

    // TODO : 입력 값에 문자가 포함되어 있는 경우 예외 처리 한다.
    static int isContainCharacter(String number) throws IllegalArgumentException{
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] Characters exist in the input value.");
        }
    }
}
