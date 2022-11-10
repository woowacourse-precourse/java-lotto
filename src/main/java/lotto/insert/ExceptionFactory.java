package lotto.insert;

public class Exception {



    public Exception exception() {
        return new Exception();
    }



    public static void amountException() {

        throw new IllegalArgumentException("[ERROR] 잘못된 값을 입력했습니다. '로또 구입 금액은 1000원 단위여야 합니다.");

    }
    public static Exception InvalidException() {

        throw new IllegalArgumentException("[ERROR] 잘못된 값을 입력했습니다. 입력할 '로또 구입 금액, 당첨 번호, 보너스 번호'는 숫자여야 합니다.");

    }
}
