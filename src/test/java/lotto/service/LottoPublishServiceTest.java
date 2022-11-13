package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.enumtype.LottoRule;
import lotto.domain.lotto.repository.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPublishServiceTest {
    LottoPublishService lottoPublishService;
    @BeforeEach
    void setup() {
        lottoPublishService = LottoPublishService.getInstance();
    }

    /**
     * @SEE: '학습테스트를 통해 JUnit 학습하기.pdf'
     * -> 'Set Collection에 대한 학습 테스트'
     * -> '요구사항 1'
     */
    @Test
    void 중복되지_않는_6개의_숫자_생성() {
        // give
        lottoPublishService.createLottoNumber();
        List<Lotto> lottos = lottoPublishService.getPublishedLottoNumbers();
        // when
        Set<Integer> lottoDistinct = new HashSet<>(lottos.get(0).getNumbers());
        // then
        assertThat(lottoDistinct.size()).isEqualTo(LottoRule.LOTTO_MAX_COUNT.getValue());
    }
}