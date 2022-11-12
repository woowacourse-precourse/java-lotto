package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {
    LottoFactory lottoFactory = new LottoFactory();
    @Test
    @DisplayName("로또 랜덤으로 원하는 개수만큼 생성되는지")
    void createRandom() throws Exception {
        //given
        int lottoCount = 10;

        //when
        List<Lotto> lottos = lottoFactory.create(lottoCount);
        lottos.forEach(System.out::println);
        //then
        assertThat(lottos.size()).isEqualTo(lottoCount);
    }
}