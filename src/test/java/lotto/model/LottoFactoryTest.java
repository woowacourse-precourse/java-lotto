package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {
    private static final LottoFactory lottoFactory = new LottoFactory();

    @DisplayName("로또 공장이 입력한 개수만큼의 로또를 생성하였는지 확인한다.")
    @Test
    void createLottosNumberOfUserInput() {
        List<Lotto> lottos = lottoFactory.createLottos(6);

        Assertions.assertThat(lottos.size()).isEqualTo(6);
    }
}