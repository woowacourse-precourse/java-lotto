package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.Extraction;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExtractionTest {

    @DisplayName("당첨번호 입력문자열에서 숫자 추출 예외발생")
    @Test
    void 숫자추출_예외발생() {
        assertThatThrownBy(() -> Extraction.extractWinningNumbers("1,a,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력문자열에서 숫자 추출 리스트 크기 예외발생")
    @Test
    void 숫자추출_리스트크기_예외발생() {
        assertThat(Extraction.extractWinningNumbers("1,2,3,4,5,6").size()).isEqualTo(6);
    }
}
