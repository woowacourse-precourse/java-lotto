package lotto.domain;

public class Purchase {

    public int checkAmount(String amount){
        validateNumber(amount);
        validateUnit(Integer.parseInt(amount));
        return Integer.parseInt(amount);
    }

    private void validateUnit(int amount){
        if(amount%1000!=0){
            throw new IllegalArgumentException("[ERROR] 구입 금액이 1000원 단위로 나누어떨어지지 않습니다.");
        }
    }
    private void validateNumber(String amount){
        if(!amount.matches("^[0-9]*$"))
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
    }
}