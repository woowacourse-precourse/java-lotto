package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.enumtype.LottoNumberInclusive;
import lotto.constant.enumtype.LottoRule;
import lotto.constant.enumtype.UserInterfaceMessage;
import lotto.domain.lotto.repository.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoPublishServiceTest {
    LottoPublishService lottoPublishService;
    @BeforeEach
    void setup() {
        lottoPublishService = LottoPublishService.getRenewInstance();
    }

    /**
     * @SEE: '학습테스트를 통해 JUnit 학습하기.pdf'
     * -> 'Set Collection에 대한 학습 테스트'
     * -> '요구사항 1'
     */
    @Test
    void 중복되지_않는_6개의_숫자_생성() {
        // give
        lottoPublishService.lottoPublish("1000");
        List<Lotto> lottos = lottoPublishService.getPublishedLottoNumbers();
        // when
        Set<Integer> lottoDistinct = new HashSet<>(lottos.get(0).getNumbers());
        // then
        assertThat(lottoDistinct.size()).isEqualTo(LottoRule.LOTTO_MAX_COUNT.getValue());
    }

    @Test
    void 잘못된_형식의_구매금액() {
        assertThatThrownBy(() ->lottoPublishService.lottoPublish("1000j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(UserInterfaceMessage.ERROR_INPUT_BONUS_NUMBER_INCLUSIVE.getValue(),
                        LottoNumberInclusive.START.getValue(), LottoNumberInclusive.END.getValue()));

    }

    @Test
    void 구매_복권의_게임수_테스트() {
        // give
        lottoPublishService.lottoPublish("5000");
        Integer lottoPublishedSize = 5;
        // when
        List<Lotto> lottos = lottoPublishService.getPublishedLottoNumbers();
        // then
        assertThat(lottos.size()).isEqualTo(lottoPublishedSize);
    }
}