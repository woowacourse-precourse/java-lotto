package lotto.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.lottery.domain.Lotto;
import lotto.lottery.repository.LottoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRepositoryTest {
    @DisplayName("로또 번호생성 후 로또 번호 반환을 확인한다.")
    @Test
    void createLottoByRandomNumberAndGet() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoRepository lottoRepository = new LottoRepository();
        List<Integer> targetNumber = lottoRepository.generateLotto();
        System.out.println(targetNumber);
        lotto.setNumbers(targetNumber);

        assertThat(targetNumber).isEqualTo(lotto.getNumbers());
    }

}