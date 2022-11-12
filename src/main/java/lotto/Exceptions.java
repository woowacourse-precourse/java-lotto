package lotto;

public class Exceptions {
    public void inputPriceError() throws IllegalArgumentException{
        throw new IllegalArgumentException("[ERROR] 숫자를 입력하지 않으셨습니다.");
    }
    public void notDivisionPrice() throws IllegalArgumentException {
        throw new IllegalArgumentException("[ERROR] 입력 받은 금액은 1,000원으로 나눌 수 없습니다.");
    }
    public void notSplitNumbers() throws IllegalArgumentException {
        throw new IllegalArgumentException("[ERROR] 쉼표를 제대로 입력하지 않으셨습니다.");
    }
}
