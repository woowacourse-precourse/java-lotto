package lotto;

public class Exception {


    public void checkPurchaseInput(String str) {
        if (!isNumberFormat(str)) {
            throw new IllegalArgumentException(ExceptionType.INVALID_FORMAT.getErrorMsg());
        }

        if (!isValidPurchaseCost(str)) {
            throw new IllegalArgumentException(ExceptionType.INVALID_PURCHASE_COST.getErrorMsg());
        }
    }

    private boolean isValidPurchaseCost(String str) {
        int cost = Integer.parseInt(str);

        return (cost % 1000) == 0;
    }

    private boolean isNumberFormat(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!isNumber(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }

}
