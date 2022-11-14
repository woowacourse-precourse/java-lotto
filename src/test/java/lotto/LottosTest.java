package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @Test
    @DisplayName("삽입 후 개수 비교")
    void addAndGetSize() throws Exception {
        //given
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        int expect = 4;
        //when
        int result = lottos.size();
        //then
        assertThat(result).isEqualTo(expect);
    }
}