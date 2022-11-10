package lotto;

public class Exception {
    public boolean validMoney(int money) {
        if(money < 1000)
            throw new IllegalArgumentException("[ERROR] 1000원 이상의 금액을 입력하세요.");
        if(money % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 유효한 값을 입력하세요.");
        return true;
    }
    public boolean validUserInputMoney(String userInputMoney){
        for(int i = 0; i < userInputMoney.length(); i++){
            if(!Character.isDigit(userInputMoney.charAt(i)))
                throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.")
        }
        return true;
    }

}
