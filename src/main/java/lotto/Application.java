package lotto;

public class Application {

    private static final int UNIT = 1000;

    public static void main(String[] args) {
        String purchaseAmount = InputView.getPurchaseAmount();
        validatePurchaseAmount(purchaseAmount);
    }

    private static void validatePurchaseAmount(String purchaseAmount) {
        int userPurchaseAmount;
        try {
            userPurchaseAmount = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액을 숫자로 입력해주세요");
        }
        if (!isDivide(userPurchaseAmount, UNIT)) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 구입이 가능합니다");
        }
    }

    private static boolean isDivide(int userPurchaseAmount, int unit) {
        if ((userPurchaseAmount % unit) == 0) {
            return true;
        }
        return false;
    }
}
