package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {
    LottoFactory lottoFactory = new LottoFactory();

    @Test
    @DisplayName("로또 랜덤으로 원하는 개수만큼 생성한다.")
    void createRandomWantCount() throws Exception {
        //given
        int lottoCount = 10;
        //when
        Lottos lottos = lottoFactory.create(lottoCount);
        //then
        assertThat(lottos.size()).isEqualTo(lottoCount);
    }
}