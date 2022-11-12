package lotto;

public class UserMoney {
    private final int userInputMoney;

    public UserMoney(String userInputMoney) {
        checkError(userInputMoney);
        this.userInputMoney = Integer.parseInt(userInputMoney);
    }

    private void checkError(String userInputMoney) {
        try{
            for (int i = 0; i < userInputMoney.length(); i++) {
                if(userInputMoney.charAt(i)<48||userInputMoney.charAt(i)>57){
                    throw new IllegalArgumentException();
                }
            }
            if(Integer.parseInt(userInputMoney)%1000!=0){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] ");
        }
    }
    public int getLottoNumber(){
        return this.userInputMoney/1000;
    }

    public int getUserInputMoney() {
        return userInputMoney;
    }
}
