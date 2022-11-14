package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.LottoResult.getResult;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    LottoIssuer lottoIssuer = new LottoIssuer();

    @DisplayName("결과 반환 테스트")
    @Nested
    class getResultTest {

        @DisplayName("정상 실행 테스트1")
        @Test
        void success() {
            List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            Integer bonusNumber = 7;
            List<Lotto> lottoInHand = new ArrayList<>();
            lottoInHand.add(lottoIssuer.issueLotto());
            lottoInHand.add(lottoIssuer.issueLotto());
            lottoInHand.add(lottoIssuer.issueLotto());
            lottoInHand.add(lottoIssuer.issueLotto());
            lottoInHand.add(lottoIssuer.issueLotto());
            assertThat(getResult(lottoInHand, winningNumbers, bonusNumber)).isEqualTo(Arrays.asList(5, 0, 0, 0, 0, 0));
        }
    }
}
