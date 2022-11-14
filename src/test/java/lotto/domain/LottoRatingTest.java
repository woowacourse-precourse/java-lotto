package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRatingTest {
    @DisplayName("로또 번호와 당첨 번호 비교 테스트")
    @Test
    void compareLottoTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottoTicket = List.of(lotto);
        WinningLotto winningLotto = new WinningLotto(List.of(1, 5, 6, 33, 39, 43), 7);
        LottoRating lottoRating = new LottoRating(lottoTicket, winningLotto);

        assertThat(lottoRating.compareLotto(lotto)).isEqualTo(3);
    }

    @DisplayName("당첨 기준 확인 테스트")
    @ParameterizedTest
    @MethodSource("generateNumberParameter")
    void checkWinningTest(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber, String rankName) {
        Lotto lotto = new Lotto(lottoNumbers);
        List<Lotto> lottoTicket = List.of(lotto);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoRating lottoRating = new LottoRating(lottoTicket, winningLotto);

        lottoRating.rate();

        assertThat(lottoRating.getWinningCountRepository().keySet().stream().findFirst().orElse(null)).isEqualTo(
                rankName);
    }

    static Stream<Arguments> generateNumberParameter() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 24, 35, 36), winningNumbers, bonusNumber, "FIFTH"),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 33, 40), winningNumbers, bonusNumber, "FOURTH"),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 40), winningNumbers, bonusNumber, "THIRD"),
                Arguments.of(Arrays.asList(1, 2, 3, 5, 6, 7), winningNumbers, bonusNumber, "SECOND"),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), winningNumbers, bonusNumber, "FIRST")
        );
    }
}