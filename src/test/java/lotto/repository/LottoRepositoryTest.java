package lotto.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class LottoRepositoryTest {
    private final LottoRepository lottoRepository = LottoRepository.getInstance();

    @BeforeEach
    void clearRepository() {
        lottoRepository.clearStore();
    }

    @DisplayName("1개의 로또 생성시 중복 없는지 반복 테스트")
    @RepeatedTest(100)
    void 로또1_발행_반복_테스트() {
        // given
        lottoRepository.generateLottos(1);
        List<Lotto> lottos = lottoRepository.findAll();

        // when
        List<Integer> distinctLotto = lottos.get(0)
                .getNumbers()
                .stream()
                .distinct()
                .collect(Collectors.toList());

        // then
        assertThat(distinctLotto.size()).isEqualTo(6);
    }
}