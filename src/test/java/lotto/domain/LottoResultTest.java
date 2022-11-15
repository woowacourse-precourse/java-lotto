package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.LottoResult.getLottoPlace;
import static lotto.domain.LottoResult.getResult;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    LottoIssuer lottoIssuer = new LottoIssuer();

    @DisplayName("결과 반환 테스트")
    @Nested
    class getResultTest {

        @DisplayName("정상 실행 테스트1")
        @Test
        void success1() {
            List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            Integer bonusNumber = 7;
            List<Lotto> lottoInHand = new ArrayList<>();
            lottoInHand.add(lottoIssuer.issueLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
            lottoInHand.add(lottoIssuer.issueLotto(Arrays.asList(2, 3, 4, 5, 6, 7)));
            lottoInHand.add(lottoIssuer.issueLotto(Arrays.asList(3, 4, 5, 6, 7, 8)));
            lottoInHand.add(lottoIssuer.issueLotto(Arrays.asList(4, 5, 6, 7, 8, 9)));
            lottoInHand.add(lottoIssuer.issueLotto(Arrays.asList(5, 6, 7, 8, 9, 10)));
            lottoInHand.add(lottoIssuer.issueLotto(Arrays.asList(6, 7, 8, 9, 10, 11)));
            lottoInHand.add(lottoIssuer.issueLotto(Arrays.asList(7, 8, 9, 10, 11, 12)));
            assertThat(getResult(lottoInHand, winningNumbers, bonusNumber)).isEqualTo(Arrays.asList(0, 1, 1, 1, 1, 1, 2));
        }
    }

    @DisplayName("순위 결정 테스트")
    @Nested
    class getLottoPlaceTest {

        @DisplayName("정상 실행 테스트: 1등")
        @Test
        void success1() {
            List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            Integer bonusNumber = 7;
            assertThat(getLottoPlace(lottoNumbers, winningNumbers, bonusNumber)).isEqualTo(1);
        }

        @DisplayName("정상 실행 테스트: 2등")
        @Test
        void success2() {
            List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
            Integer bonusNumber = 6;
            assertThat(getLottoPlace(lottoNumbers, winningNumbers, bonusNumber)).isEqualTo(2);
        }

        @DisplayName("정상 실행 테스트: 3등")
        @Test
        void success3() {
            List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 9);
            Integer bonusNumber = 7;
            assertThat(getLottoPlace(lottoNumbers, winningNumbers, bonusNumber)).isEqualTo(3);
        }

        @DisplayName("정상 실행 테스트: 4등")
        @Test
        void success4() {
            List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 9, 10, 4);
            Integer bonusNumber = 6;
            assertThat(getLottoPlace(lottoNumbers, winningNumbers, bonusNumber)).isEqualTo(4);
        }

        @DisplayName("정상 실행 테스트: 4등")
        @Test
        void success5() {
            List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> winningNumbers = Arrays.asList(1, 2, 8, 9, 6, 4);
            Integer bonusNumber = 14;
            assertThat(getLottoPlace(lottoNumbers, winningNumbers, bonusNumber)).isEqualTo(4);
        }

        @DisplayName("정상 실행 테스트: 5등")
        @Test
        void success6() {
            List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> winningNumbers = Arrays.asList(1, 2, 5, 12, 13, 14);
            Integer bonusNumber = 6;
            assertThat(getLottoPlace(lottoNumbers, winningNumbers, bonusNumber)).isEqualTo(5);
        }

        @DisplayName("정상 실행 테스트: 5등")
        @Test
        void success7() {
            List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> winningNumbers = Arrays.asList(1, 2, 6, 12, 13, 14);
            Integer bonusNumber = 21;
            assertThat(getLottoPlace(lottoNumbers, winningNumbers, bonusNumber)).isEqualTo(5);
        }

        @DisplayName("정상 실행 테스트: 낙첨")
        @Test
        void success8() {
            List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> winningNumbers = Arrays.asList(11, 12, 13, 14, 15, 16);
            Integer bonusNumber = 21;
            assertThat(getLottoPlace(lottoNumbers, winningNumbers, bonusNumber)).isEqualTo(6);
        }

        @DisplayName("정상 실행 테스트: 낙첨")
        @Test
        void success9() {
            List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> winningNumbers = Arrays.asList(1, 7, 13, 14, 15, 16);
            Integer bonusNumber = 2;
            assertThat(getLottoPlace(lottoNumbers, winningNumbers, bonusNumber)).isEqualTo(6);
        }

        @DisplayName("정상 실행 테스트: 낙첨")
        @Test
        void success10() {
            List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> winningNumbers = Arrays.asList(9, 7, 13, 14, 15, 16);
            Integer bonusNumber = 2;
            assertThat(getLottoPlace(lottoNumbers, winningNumbers, bonusNumber)).isEqualTo(6);
        }

        @DisplayName("정상 실행 테스트: 낙첨")
        @Test
        void success11() {
            List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> winningNumbers = Arrays.asList(5, 7, 6, 14, 15, 16);
            Integer bonusNumber = 2;
            assertThat(getLottoPlace(lottoNumbers, winningNumbers, bonusNumber)).isEqualTo(6);
        }

    }
}
