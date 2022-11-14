package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoRepository;
import lotto.domain.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void init() {
        lottoService = new LottoService(new LottoRepository());
    }

    @Test
    @DisplayName("Money 10000 을 받으면 로또 10개가 생성되고 repo 에 저장이 되고 랜덤으로 생성된 정수리스트 10개가 반환")
    public void 로또생성_테스트() throws Exception {
        //given
        //when
        List<List<Integer>> lottos = lottoService.createLottos(Money.of(10000L));
        //then
        assertThat(lottos.size()).isEqualTo(10);
    }
}