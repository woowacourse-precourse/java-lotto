package lotto;

public class Exceptions {
    public void inputPriceError() {
        throw new IllegalArgumentException("[ERROR] 숫자를 입력하지 않으셨습니다.");
    }

    public void notDivisionPrice() {
        throw new IllegalArgumentException("[ERROR] 입력 받은 금액은 1,000원으로 나눌 수 없습니다.");
    }

    public void notSplitNumbers() {
        throw new IllegalArgumentException("[ERROR] 쉼표를 제대로 입력하지 않으셨습니다.");
    }

    public void notScopeNumbers() {
        throw new IllegalArgumentException("[ERROR] 1~45까지의 숫자가 아닙니다.");
    }

    public void duplicationNumbers() {
        throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자 6개를 입력하지 않으셨습니다.");
    }
}

