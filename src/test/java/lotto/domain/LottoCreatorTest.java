package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCreatorTest {
    @DisplayName("로또 생성기는 돈을 받아 그만큼의 로또를 생성해줌")
    @ValueSource(ints = {1000, 2000, 1234000})
    @ParameterizedTest
    void case1(int input) {
        PickNumbers missionRandom = new MissionRandom();
        LottoCreator lottoCreator = new LottoCreator(missionRandom);
        assertThat(lottoCreator.createLottos(new Money(input)).getLottos().size()).isEqualTo(input / 1000);
    }
}
