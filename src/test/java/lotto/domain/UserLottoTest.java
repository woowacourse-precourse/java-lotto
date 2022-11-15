package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class UserLottoTest {

    @DisplayName("복권 구입금액 예외처리 테스트")
    @ParameterizedTest(name = "[{index}] {0}, {1}")
    @CsvSource({"1000a,'[ERROR] 복권 구입 금액은 양의 정수 형태이어야 합니다.'",
            "-1000, '[ERROR] 복권 구입 금액은 양의 정수 형태이어야 합니다.'",
            "1200, '[ERROR] 복권 구입 금액은 1000 으로 나누어 떨어져야 합니다.'"})
    void lottoAmountExceptionTest(String lottoAmount, String errorMessage) {
        assertThatThrownBy(() -> new UserLotto(lottoAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    @DisplayName("복권 구입 개수 테스트")
    @ParameterizedTest(name = "[{index}] 구입금액 : {0}, 구입개수 : {1}")
    @CsvSource({"'5000', 5", "'123000', 123"})
    void getLottoCountTest(String lottoAmount, int lottoCount) {
        UserLotto user = new UserLotto(lottoAmount);

        assertThat(user.getLottoCount()).isEqualTo(lottoCount);
    }

    static Stream<Arguments> setParametersForRateOfReturn() {
        return Stream.of(
                Arguments.arguments(new ArrayList<Integer>(List.of(1, 0, 0, 0, 0)),
                        200000000.0, "1000"),
                Arguments.arguments(new ArrayList<Integer>(List.of(0, 0, 0, 2, 0)),
                        1000.0, "10000"),
                Arguments.arguments(new ArrayList<Integer>(List.of(0, 0, 0, 1, 1)),
                        5.5, "1000000"));
    }

    @DisplayName("로또 수익률 계산 테스트")
    @MethodSource("setParametersForRateOfReturn")
    @ParameterizedTest(name = "[{index}] 수익률 테스트 - 금액 : {2}, 결과 : {0}, 수익률 : {1}")
    void createLottoByOtherWords(List<Integer> lottoResult, double lottoRateOfReturn,
                                 String lottoAmount) {
        UserLotto user = new UserLotto(lottoAmount);

        assertThat(user.getRateOfReturn(lottoResult)).isEqualTo(lottoRateOfReturn);
    }

    @DisplayName("로또 결과 리스트 반환")
    @Test
    void createLottoResult() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 1등
        Lotto lotto2 = new Lotto(List.of(1, 3, 5, 7, 9, 11)); // 5등
        Lotto lotto3 = new Lotto(List.of(11, 12, 13, 14, 15, 16)); // 꽝
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 2등
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 4, 5, 8)); // 3등

        List<Lotto> lottos = new ArrayList<Lotto>();
        List<Integer> winningNumbers = new ArrayList<Integer>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);
        lottos.add(lotto4);
        lottos.add(lotto5);

        assertThat(UserLotto.createLottoResult(lottos, winningNumbers, bonusNumber)).
                isEqualTo(new ArrayList<Integer>(List.of(1, 1, 1, 0, 1)));
    }
}