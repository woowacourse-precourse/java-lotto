package lotto.domain.utils;

import java.util.Collections;
import java.util.List;

public class InputValidator {

    public static void validateMoney(String moneyInput) {
        if (moneyInput.length() <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력의 길이가 잘못됐습니다.");
        }

        long money;

        try {
            money = Integer.parseInt(moneyInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자만 입력해주세요.");
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 돈은 1000원 단위로 입력해주세요.");
        }
    }

    public static void validateDuplicatedLotteryNumber(List<Integer> winningNumbers) {
        Collections.sort(winningNumbers);

        for (int i = 1; i < winningNumbers.size(); i++) {
            int prev = winningNumbers.get(i - 1);
            int cur = winningNumbers.get(i);

            if (prev == cur) {
                throw new IllegalArgumentException("[ERROR] 추첨 번호에는 중복이 있으면 안됩니다.");
            }
        }
    }

    public static void validateLotteryFormat(String numberInput) {
        String pattern = "\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}";
        if (!numberInput.matches(pattern)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호 입력이 잘못됐습니다.");
        }
    }

    public static void validateLotteryNumber(String token) {
        int number = Integer.parseInt(token);

        if (1 > number || 45 < number) {
            throw new IllegalArgumentException("[ERROR] 당첨번호 입력이 잘못됐습니다.");
        }
    }

}
