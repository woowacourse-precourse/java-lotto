package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoTest {

    @DisplayName("count 개수 만큼 로또가 생성되는지 확인")
    @Test
    public void lottoCountTest() {
        RandomLotto randomLotto = new RandomLotto();
        List<Lotto> randomLottos = randomLotto.getRandomLottos(10);

        assertThat(randomLottos.size()).isEqualTo(10);
    }
}