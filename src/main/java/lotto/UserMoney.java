package lotto;

public class UserMoney {
    private final int userInputMoney;

    public UserMoney(int userInputMoney) {
        checkError(userInputMoney);
        this.userInputMoney = userInputMoney;
    }

    private void checkError(int userInputMoney) {
        if(userInputMoney%1000!=0){
            throw new IllegalArgumentException("[ERROR]");
        }
    }
    public int getLottoNumber(){
        return this.userInputMoney/1000;
    }
}
