package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.dto.GameResultResponseDtos.GameResultResponseDto;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("주어진 매개변수로 올바른 LottoResult enum을 반환하는지 확인")
    @Test
    void createLottoResult() {
        LottoResult secondResult = LottoResult.of(5, true);
        LottoResult elseResult = LottoResult.of(0, false);
        assertThat(secondResult.isSecond()).isTrue();
        assertThat(elseResult.isElse()).isTrue();
    }

    @DisplayName("주어진 로또 결과를 토대로 상금을 계산")
    @Test
    void sumWinnerPrice() {
        List<LottoResult> lottoResults = List.of(
                LottoResult.SECOND,
                LottoResult.ELSE,
                LottoResult.THIRD,
                LottoResult.SECOND);
        assertThat(LottoResult.sumWinnerPrice(lottoResults)).isEqualTo(61500000);
    }

    @DisplayName("LottoResult를 dto로 잘 반환하는지 검증")
    @Test
    void toResponseDto() {
        GameResultResponseDto responseDto = LottoResult.SECOND.toResponseDto(3);
        assertThat(responseDto.getSameNumberCount()).isEqualTo(5);
        assertThat(responseDto.getWinnerPrice()).isEqualTo(30000000);
        assertThat(responseDto.hasBonus()).isTrue();
        assertThat(responseDto.getTotalCount()).isEqualTo(3);
    }

    @DisplayName("LottoResult 필드 is 메소드 검증")
    @Test
    void isField() {
        assertThat(LottoResult.FIRST.isFirst()).isTrue();
        assertThat(LottoResult.SECOND.isSecond()).isTrue();
        assertThat(LottoResult.THIRD.isThird()).isTrue();
        assertThat(LottoResult.FOURTH.isFourth()).isTrue();
        assertThat(LottoResult.FIFTH.isFifth()).isTrue();
        assertThat(LottoResult.ELSE.isElse()).isTrue();
    }

    @DisplayName("LottoResult equals 메소드 검증")
    @Test
    void equals() {
        LottoResult firstResult = LottoResult.FIRST;
        LottoResult elseResult = LottoResult.ELSE;
        assertThat(firstResult.equals(LottoResult.FIRST)).isTrue();
        assertThat(elseResult.equals(LottoResult.SECOND)).isFalse();
    }
}
