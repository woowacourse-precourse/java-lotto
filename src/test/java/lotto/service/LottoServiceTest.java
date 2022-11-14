package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    private LottoService lottoService = new LottoService();

    @Test
    @DisplayName("로또 번호 매칭된 개수 테스트")
    void matchLottoNumberTest() {
        List<Integer> winningNumbers = List.of(30, 24, 13, 4, 5, 6);
        List<Integer> lottoNumbers = List.of(30, 24, 13, 4, 1, 6);

        int matchCount = lottoService.matchLottoCount(winningNumbers, lottoNumbers);

        assertThat(matchCount).isEqualTo(5);
    }

}
