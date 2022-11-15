package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
    }

    @Test
    void 로또와_중복되는_보너스번호() {
        List<Integer> numbers = lotto.getNumbers();
        BonusNumber bonusNumber = new BonusNumber(numbers);
    }
}