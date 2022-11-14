package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputTest {

    @DisplayName("로또를 제대로 출력하는지 확인한다.")
    @Test
    void printLotto() {
        Lotto lotto = new Lotto(List.of(8, 21, 23, 41, 42 ,43));

        assertThat(lotto.toString()).isEqualTo("[8, 21, 23, 41, 42, 43]");
    }

    @DisplayName("로또를 오름차순으로 정렬 후 출력하는지 확인한다.")
    @Test
    void printLottoByASC() {
        Lotto lotto = new Lotto(List.of(42, 16, 45, 13, 38 ,14));

        assertThat(lotto.toString()).isEqualTo("[13, 14, 16, 38, 42, 45]");
    }
}
