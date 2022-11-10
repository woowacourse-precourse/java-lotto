package lotto.domain.lotto.verifier;

public class InputMoneyVerifier {

    public static void isMoneyDividedBy1000(int inputMoney) {
        if (inputMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 돈만 입력할 수 있습니다.");
        }
    }
}
