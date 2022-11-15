package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserMissCheckingTest {

    private final List<Integer> dummyLotto = new ArrayList<>(List.of(1,3,4,6,12,15));
    private final Lotto lotto = new Lotto(dummyLotto);

    @Test
    public void 보너스숫자_선택한로또_중복여부(){
        assertThatThrownBy(() -> lotto.addBonus(4))
                .isInstanceOf(IllegalArgumentException.class);
    }
}