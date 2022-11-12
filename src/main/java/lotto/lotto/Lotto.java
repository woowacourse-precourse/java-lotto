package lotto.lotto;

import lotto.message.ExceptionMessage;
import lotto.setting.LottoSetting;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this(numbers, LottoSetting.NORMAL);
    }

    public Lotto(List<Integer> numbers, LottoSetting setting) {
        validate(numbers, setting);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers, LottoSetting setting) {
        if (!setting.isValidNumbers(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_FORM_NOT_MATCHED.toString());
        }
    }

    // TODO: 추가 기능 구현
}
