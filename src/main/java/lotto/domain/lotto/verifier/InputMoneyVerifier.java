package lotto.domain.lotto.verifier;

import java.util.List;

public class InputMoneyVerifier {

    public static void isMoneyDividedBy1000(int inputMoney) {
        if (inputMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 돈만 입력할 수 있습니다.");
        }
    }

    public static void isList6Size(List<Integer> inputPrizeNumbers) {
        if (inputPrizeNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자만 입력할 수 있습니다.");
        }
    }
}
