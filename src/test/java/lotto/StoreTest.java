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
        // given
        Store store = new Store();
        List<Integer> lotto = store.issue();
        System.out.println(lotto);

        // when
        Set<Integer> duplicateCheck = new HashSet<>();
        duplicateCheck.addAll(lotto);

        // then
        assertThat(SIZE.equals(lotto.size())).isTrue();
        assertThat(SIZE.equals(duplicateCheck.size())).isTrue();
    }
}
