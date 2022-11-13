package lotto.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class LottoRepositoryTest {
    private final LottoRepository lottoRepository = LottoRepository.getInstance();

    @DisplayName("1개의 로또 생성시 중복 없는지 반복 테스트")
    @RepeatedTest(100)
    void 로또1_중복번호_반복_테스트() {
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

    @DisplayName("생성된 로또의 번호가 1~45의 숫자인지 반복 테스트")
    @RepeatedTest(100)
    void 로또1_숫자범위_반복_테스트() {
        // given
        lottoRepository.generateLottos(1);
        List<Lotto> lottos = lottoRepository.findAll();

        // when
        int max = lottos.get(0)
                .getNumbers()
                .get(5);
        int min = lottos.get(0)
                .getNumbers()
                .get(0);

        // then
        Assertions.assertAll(
                () -> {
                    assertThat(max).isLessThanOrEqualTo(45);
                    assertThat(min).isGreaterThanOrEqualTo(1);
                }
        );
    }
}