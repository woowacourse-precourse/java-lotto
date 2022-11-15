package lotto;

public class NumberException {

    public void validateNumeric(String shopMoney) throws IllegalArgumentException {
        boolean numberCheck = true;
        for(int i = 0; i < shopMoney.length(); i++) {
            if (!Character.isDigit(shopMoney.charAt(i))) {
                numberCheck = false;
                break;
            }
        }
        if(!numberCheck) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }
}
