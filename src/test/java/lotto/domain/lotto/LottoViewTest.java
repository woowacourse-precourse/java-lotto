package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoViewTest {
    @DisplayName("로또 번호를 배열 형태의 문자열로 반환한다.")
    @Test
    void getPrintByNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 4, 3, 5, 6));
        
        assertThat(LottoView.getNumbersTextByArrayFormat(new Lotto(lottoNumbers)))
                .isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
