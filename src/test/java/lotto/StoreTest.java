package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static lotto.Const.SIZE;
public class StoreTest {

    @DisplayName("정상적인 로또 번호를 발행")
    @Test
    void issue() {
        // given
        Store store = new Store();
        List<Integer> lotto = store.issue();

        // when
        Set<Integer> duplicateCheck = new HashSet<>();
        duplicateCheck.addAll(lotto);

        // then
        assertThat(lotto.size()).isEqualTo(SIZE);
        assertThat(duplicateCheck.size()).isEqualTo(SIZE);
    }
}
