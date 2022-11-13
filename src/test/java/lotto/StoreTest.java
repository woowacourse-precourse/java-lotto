package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Const.SIZE;
import static org.assertj.core.api.Assertions.assertThat;

public class StoreTest {

    @DisplayName("정상적인 로또 번호를 발행")
    @Test
    void issue() {
        // 6 글자인지
        // 또 중복된 숫자는 없는지
        // given
        Store = new Store();
        List<Integer> lotto = Store.issue();

        // when
        Set<Integer> duplicateCheck = new HashSet<>();
        duplicateCheck.addAll(lotto);

        // then
        assertThat(SIZE.equals(lotto.size())).isTrue();
        assertThat(SIZE.equals(duplicateCheck.size())).isTrue();
    }
}
