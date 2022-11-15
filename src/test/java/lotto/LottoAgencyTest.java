package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoAgencyTest {

    @DisplayName("티켓 5매를 전달받아서 로또를 5회 발행한다")
    @Test
    void issueLottoBy5000() {
        Assertions.assertThat(new LottoAgency(5, new NumberGeneratorRandom()).issue()).hasSize(5);
    }

    @DisplayName("발행된 로또 번호에 중복된 번호가 있다면 재발행한다")
    @Test
    void reissueLottoWhenDuplicated() {
        Assertions.assertThat(new LottoAgency(1000, () -> generateDuplicatedNumbers()).issue().get(0))
                .isNotEqualTo(generateDuplicatedNumbers());
    }

    private List<Integer> generateDuplicatedNumbers() {
        return List.of(1, 2, 3, 4, 5, 5);
    }
}
