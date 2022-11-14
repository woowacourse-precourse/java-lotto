package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class View {
    private void validateIsDivisible(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000으로 나눠떨어져야 합니다");
        }
    }
    private void validateIsNumber(String input) {
        String[] splitInput = input.split(",");
        for (String value : splitInput) {
            try {
                int numbers = Integer.parseInt(value);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력이 가능합니다");
            }
        }
    }
    private void validateUniqueNumberInput(List<Integer> numbers) {
        List<Integer> noDuplicates = new ArrayList<>();
        for (int num : numbers) {
            if (noDuplicates.contains(num)) {
                throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자만 입력이 가능합니다");
            }
            noDuplicates.add(num);
        }
    }
}
