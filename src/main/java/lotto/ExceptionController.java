package lotto;

public class ExceptionController {

    public ExceptionController() {
    }
    /**
     * judge money is constructed by digits
     * @param money served by setUserMoney
     * @return Is money variable is constructed by digits
     */
    private boolean validateMoneyIsInt(String money) {
        for(int i = 0; i < money.length(); i++) {
            if(!Character.isDigit(money.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    private boolean validateMoneyHasHundreds(int money) {
        return money % 1000 <= 0;
    }

    public void validateMoney(String money){
        if(!this.validateMoneyIsInt(money)) {
            throw new IllegalArgumentException("[ERROR] Please input Number only");
        }
        int moneyInt = Integer.parseInt(money);
        if(!this.validateMoneyHasHundreds(moneyInt)) {
            throw new IllegalArgumentException("[ERROR] Please enter in thousands");
        }
    }
}
