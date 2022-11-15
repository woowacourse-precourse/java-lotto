package lotto.domain;

public class UserPay {
    private final String userInput;

    public UserPay(String userInput){
        this.userInput = userInput;
        userPaymentInput();
    }
    public void userPaymentInput(){
        for(int i=0; i<userInput.length(); i++) {
            char userNumberChar = userInput.charAt(i);
            userPayment(userNumberChar);
        }
    }
    private void userPayment(char userNumberChar) {
        if(!Character.isDigit(userNumberChar)){
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_MONEY_TYPE.getErrorMessage());
        }
    }

    public int lottoCount() {
        int count = Integer.parseInt(userInput)/1000;

        if(Integer.parseInt(userInput)%1000 != 0){
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_MONEY_UNIT.getErrorMessage());
        }

        return count;
    }
}
