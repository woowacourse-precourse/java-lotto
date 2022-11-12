package lotto.model;

public class User {

    public boolean isNumber(String str){
        try {
            int value = Integer.parseInt(str);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]숫자를 입력해주세요.");
        }
        return true;
    }

    public boolean unitError(String str) {
        int value = Integer.parseInt(str);
        if(value % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]1000원으로 나누어 떨어지지 않습니다.");
        }
        return true;
    }

    public void inputError(String error) {
        throw new IllegalArgumentException(error);
    }
}
