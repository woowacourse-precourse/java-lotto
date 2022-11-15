package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    private Lottos lottos = new Lottos();

    @DisplayName("로또 리스트에 로또를 2개 추가하면 로또 리스트의 길이는 2이다")
    @Test
    void createTwoLotto() {
        // given
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto1 = new Lotto(lottoGenerator.createLotto());
        Lotto lotto2 = new Lotto(lottoGenerator.createLotto());

        // when
        lottos.addLotto(lotto1);
        lottos.addLotto(lotto2);

        // then
        assertThat(lottos.getLottos().size()).isEqualTo(2);
    }
}