package lotto;

public class Domain {

    public static int inputMoneyException(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("숫자로만 입력하십시오.");
        }
        int purchaseMoney = Integer.parseInt(input);
        if (purchaseMoney%1000!=0){
            throw new IllegalArgumentException("1000원 단위의 금액을 입력하십시오.");
        }
        return purchaseMoney;
    }

}
