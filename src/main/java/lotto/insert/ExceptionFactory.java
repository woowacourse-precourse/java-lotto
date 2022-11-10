package lotto.insert;

public class ExceptionFactory {



    // 1,000원으로 나누어 떨어지지 않는 경우 예외 처리
    public static void amountException() {

        throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");

    }

    // 잘못된 값 입력 예외처리
    public static void invalidException() {

        throw new IllegalArgumentException("[ERROR] '로또 구입 금액, 당첨 번호, 보너스 번호'는 숫자여야 합니다.");

    }
}
