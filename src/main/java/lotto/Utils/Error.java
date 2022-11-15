package lotto.Utils;

public class Error {
    public static void amountInput() {
        throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해 주세요.");
    }

    public static void duplicated() {
        throw new IllegalArgumentException("[ERROR] 중복되지 않은 숫자를 입력해 주세요");
    }

    public static void outOfRange() {
        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
