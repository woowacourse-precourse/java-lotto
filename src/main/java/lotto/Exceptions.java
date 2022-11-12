package lotto;

public class Exceptions {
    public void inputPriceError() throws IllegalArgumentException{
        throw new IllegalArgumentException("[ERROR] 숫자를 입력하지 않으셨습니다.");
    }
}
