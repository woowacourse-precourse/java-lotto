package lotto;

public class Error {
    private static final int ZERO = 0;
    private static final int TICKET_PRICE = 1000;

    // TODO : 입력 값이 1,000으로 나누어 떨어지지 않는 경우 예외 처리 한다.
    public boolean isDividedByTicketPrice(int purchaseAmount) throws IllegalArgumentException{
        if (purchaseAmount % TICKET_PRICE != ZERO)
            throw new IllegalArgumentException("[ERROR] The unit of the purchase amount is not 1,000.");
        return true;
    }

    // TODO : 입력 값에 문자가 포함되어 있는 경우 예외 처리 한다.
    public boolean isContainCharacter(String purchaseAmount) throws IllegalArgumentException{
        try {
            int temp = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] Characters exist in the input value.");
        }
        return true;
    }
}
