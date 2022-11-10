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

    public static void isDuplicatedNumberInList(List<Integer> inputPrizeNumbers) {
        boolean duplicated = inputPrizeNumbers.stream()
                .distinct()
                .count() != inputPrizeNumbers.size();

        if (duplicated) {
            throw new IllegalArgumentException("[ERROR] 중복되는 수는 입력할 수 없습니다.");
        }
    }
}
