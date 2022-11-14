package lotto;

public class Exception {

    private static final String ERROR_MESSAGE = "[ERROR]";

    public void validatePrice(int price){
        if(price % 1000 != 0){
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 금액은 1000원 단위로 나누어떨어져야합니다.");
        }
    }
}
