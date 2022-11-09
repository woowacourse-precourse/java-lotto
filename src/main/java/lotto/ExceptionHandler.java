package lotto;

public class ExceptionHandler extends IllegalArgumentException{

    public void foolExceaption(String aoptions) {
        if (aoptions.equals("amount")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
