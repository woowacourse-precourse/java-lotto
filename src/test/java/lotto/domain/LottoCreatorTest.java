package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoCreatorTest {
    @DisplayName("로또 생성기는 생성시 null을 받으면 예외가 발생한다")
    @Test
    void LottoCreator_생성자_null_예외() {
        assertThrows(IllegalArgumentException.class, () -> new LottoCreator(null));
    }

    @DisplayName("로또 생성기는 돈을 받아 그만큼의 로또를 생성해줌")
    @ValueSource(ints = {1000, 2000, 1234000})
    @ParameterizedTest
    void createLottos_메서드_정상작동(int input) {
        PickNumbers missionRandom = new RandomPicker();
        LottoCreator lottoCreator = new LottoCreator(missionRandom);
        assertThat(lottoCreator.createLottos(new Money(input)).size()).isEqualTo(input / 1000);
    }
}
