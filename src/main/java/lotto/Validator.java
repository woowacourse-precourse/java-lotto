package lotto;

public class Validator {

    public Integer moneyValidate(String money){
        if (!isMoney(money)){
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(money);
    }

    private boolean isMoney(String money){
        char[] chars = money.toCharArray();
        for (char c : chars) {
            if(!isDigit(c)){
                return false;
            }
        }
        return true;
    }

    private boolean isDigit(char c){
        if (c < '0' && c > '9'){
            return false;
        }
        return true;
    }
}
