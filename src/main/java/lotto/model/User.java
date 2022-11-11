package lotto.model;

public class User {

    public boolean isNumber(String str){
        try {
            int value = Integer.parseInt(str);
        }catch (NumberFormatException e) {
            inputError();
        }
        return true;
    }

    public void inputError() {
        throw new IllegalArgumentException();
    }
}
