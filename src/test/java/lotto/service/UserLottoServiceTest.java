package lotto.service;

import lotto.Lotto;
import lotto.LottoGenerator;
import lotto.reposiotory.LottoRepository;
import lotto.reposiotory.PrizeRepository;
import lotto.reposiotory.Repository;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;

class ServiceTest {

    private static final LottoRepository repo= LottoRepository.createRepository();
    private static final Service service=new Service(repo, PrizeRepository.createRepository());
    @Test
    void genLottos() {
        try(final MockedStatic<LottoGenerator> mock=mockStatic(LottoGenerator.class)) {
            List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
            mock.when(()->LottoGenerator.generatLottos(anyString())).thenReturn(lottos);
            assertThat(service.genLottos("1000")).isEqualTo(lottos);
        }
    }
}