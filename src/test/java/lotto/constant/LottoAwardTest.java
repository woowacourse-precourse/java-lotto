package lotto.constant;

import lotto.domain.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAwardTest {
    @DisplayName("6개가 다 맞은 결과를 줬을때 그에 맞는 보상을 반환")
    @Test
    void givenResult_whenConvertToAward_thenReturnFirstAward() {
        //given
        LottoResult lottoResult = LottoResult.of(6, 0);

        //when
        LottoAward lottoAward = LottoAward.getAwardFrom(lottoResult);

        //then
        assertThat(lottoAward).isEqualTo(LottoAward.FIRST);
    }

    @DisplayName("일반 숫자 5개, 보너스 1개 맞은 결과를 줬을때 그에 맞는 보상을 반환")
    @Test
    void givenResult_whenConvertToAward_thenReturnSecondAward() {
        //given
        LottoResult lottoResult = LottoResult.of(5, 1);

        //when
        LottoAward lottoAward = LottoAward.getAwardFrom(lottoResult);

        //then
        assertThat(lottoAward).isEqualTo(LottoAward.SECOND);
    }

    @DisplayName("일반 숫자 5개 맞은 결과를 줬을때 그에 맞는 보상을 반환")
    @Test
    void givenResult_whenConvertToAward_thenReturnThirdAward() {
        //given
        LottoResult lottoResult = LottoResult.of(5, 0);

        //when
        LottoAward lottoAward = LottoAward.getAwardFrom(lottoResult);

        //then
        assertThat(lottoAward).isEqualTo(LottoAward.THIRD);
    }

    @DisplayName("일반 숫자 4개 맞은 결과를 줬을때 그에 맞는 보상을 반환")
    @Test
    void givenResult_whenConvertToAward_thenReturnFourthAward() {
        //given
        LottoResult lottoResult = LottoResult.of(4, 1);

        //when
        LottoAward lottoAward = LottoAward.getAwardFrom(lottoResult);

        //then
        assertThat(lottoAward).isEqualTo(LottoAward.FOURTH);
    }

    @DisplayName("일반 숫자 3개, 보너스 0개 결과를 줬을때 그에 맞는 보상을 반환")
    @Test
    void givenResult_whenConvertToAward_thenReturnFifthAward() {
        //given
        LottoResult lottoResult = LottoResult.of(3, 0);

        //when
        LottoAward lottoAward = LottoAward.getAwardFrom(lottoResult);

        //then
        assertThat(lottoAward).isEqualTo(LottoAward.FIFTH);
    }

    @DisplayName("일반 숫자 2개 맞은 결과를 줬을때 그에 맞는 보상을 반환")
    @Test
    void givenResult_whenConvertToAward_thenReturnNONEAward() {
        //given
        LottoResult lottoResult = LottoResult.of(2, 1);

        //when
        LottoAward lottoAward = LottoAward.getAwardFrom(lottoResult);

        //then
        assertThat(lottoAward).isEqualTo(LottoAward.NONE);
    }

}