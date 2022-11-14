package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    private Result result = new Result();

    @DisplayName("로또 번호가 {1,2,3,4,5,6}이고 당첨 번호가 {1,2,3,4,5,7}이면 5를 반환한다.")
    @Test
    void calculateMatchCount() {
        // given
        Lotto perchasedLotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        Lotto winningLotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 7)));

        // when
        int matchCount = result.checkMatchCount(perchasedLotto, winningLotto);

        // then
        assertThat(matchCount).isEqualTo(5);
    }

}