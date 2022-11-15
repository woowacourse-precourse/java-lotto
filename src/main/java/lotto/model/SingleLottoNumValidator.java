package lotto.model;

import static lotto.controller.LottoSystem.LOTTO_MAX;
import static lotto.controller.LottoSystem.LOTTO_MIN;

public class SingleLottoNumValidator {
    public void validate(String input) throws IllegalArgumentException {
        if (input.charAt(0) == '0' && input.length() > 1) {
            throw new IllegalArgumentException("[ERROR] 두 자리 이상 숫자는 0으로 시작할 수 없습니다.");
        }
        try {
            int number = Integer.parseInt(input);
            if (number < LOTTO_MIN || LOTTO_MAX < number) { //TODO try-catch 밖으로 빼는게 나은지 체크
                throw new IllegalArgumentException("[ERROR] 추첨 가능 범위를 넘어서는 숫자가 있습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
