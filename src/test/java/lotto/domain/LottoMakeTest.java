package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMakeTest {

    @DisplayName("로또 발행 수만큼 로또 번호르 생성")
    @ParameterizedTest
    @CsvSource({"5,5", "20,20", "52,52"})
    void createRightLottoMake(int lottoCount, int expected) {
        LottoMake lottoMake = new LottoMake(lottoCount);
        assertThat(lottoMake.getLottoPapers().size()).isEqualTo(expected);
    }
}