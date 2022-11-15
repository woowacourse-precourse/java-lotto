package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


class LottoReaderTest {

    @DisplayName("로또에 숫자가 포함되어 있는지 판단하는 기능 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 로또에_해당_숫자가_포함되어_있는지_판단하는_기능_테스트(int intArg) {
        Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(LottoReader.isIncludedNumber(testLotto, intArg)).isTrue();
    }

    @DisplayName("로또에 숫자가 포함되지 않았다고 판단하는 기능 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 500, 9, 10, 11, 2000})
    void 로또에_해당_숫자가_포함되지_않았다고_판단하는_기능_테스트(int intArg) {
        Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(LottoReader.isIncludedNumber(testLotto, intArg)).isFalse();
    }

    @DisplayName("로또 두 개를 입력받아서 몇개의 숫자가 같은지 반환하는 기능 테스트")
    @ParameterizedTest
    @MethodSource("lottoSourceGetter")
    void 두개의_로또에서_같은_숫자의_갯수를_반환하는_기능_테스트(List<Integer> lottoSource, int expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto compareLotto = new Lotto(lottoSource);
        assertThat(LottoReader.countMatchingNumber(lotto, compareLotto)).isEqualTo(expected);
    }

    @DisplayName("정답 로또와 보너스 번호를 입력했을 때 로또의 결과 값을 제대로 반환하는지 테스트")
    @ParameterizedTest
    @MethodSource("resultLottoSourceGetter")
    void 로또_결과_반환_테스트(List<Integer> lottoSource, LottoRanking expected) {
        Lotto compareLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoSource);
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(compareLotto, bonusNumber);
        assertThat(LottoReader.getLottoRanking(lotto, winningLotto)).isEqualTo(expected);
    }

    @DisplayName("정답 로또와 보너스 번호를 입력했을 때 로또 여러장의 결과 값을 제대로 반환하는지 테스트")
    @ParameterizedTest
    @MethodSource("resultsLottoSourceGetter")
    void 여러개의_로또_결과_반환_테스트(List<Lotto> lottoSource) {
        Lotto compareLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(compareLotto, bonusNumber);
        Map<LottoRanking, Integer> result = LottoReader.getLottoRankings(lottoSource, winningLotto);

        assertThat(result).contains(
                entry(LottoRanking.FIRST, 1),
                entry(LottoRanking.SECOND, 1),
                entry(LottoRanking.THIRD, 1),
                entry(LottoRanking.FOURTH, 1),
                entry(LottoRanking.FIFTH, 1),
                entry(LottoRanking.MISS, 3));
    }

    private static Stream<Arguments> lottoSourceGetter() {
        return Stream.of(
                Arguments.of(List.of(7, 8, 9, 10, 11, 12), 0),
                Arguments.of(List.of(1, 7, 8, 9, 10, 11), 1),
                Arguments.of(List.of(1, 2, 8, 9, 10, 11), 2),
                Arguments.of(List.of(1, 2, 3, 9, 10, 11), 3),
                Arguments.of(List.of(1, 2, 3, 4, 10, 11), 4),
                Arguments.of(List.of(1, 2, 3, 4, 5, 11), 5),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6)
        );
    }

    private static Stream<Arguments> resultLottoSourceGetter() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), LottoRanking.FIRST),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), LottoRanking.SECOND),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), LottoRanking.THIRD),
                Arguments.of(List.of(1, 2, 3, 4, 8, 9), LottoRanking.FOURTH),
                Arguments.of(List.of(1, 2, 3, 8, 9, 10), LottoRanking.FIFTH),
                Arguments.of(List.of(1, 2, 8, 9, 10, 11), LottoRanking.MISS),
                Arguments.of(List.of(1, 8, 9, 10, 11, 12), LottoRanking.MISS),
                Arguments.of(List.of(8, 9, 10, 11, 12, 13), LottoRanking.MISS)
        );
    }

    private static Stream<Arguments> resultsLottoSourceGetter() {
        return Stream.of(
                Arguments.of(List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                        new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                        new Lotto(List.of(1, 2, 3, 8, 9, 10)),
                        new Lotto(List.of(1, 2, 8, 9, 10, 11)),
                        new Lotto(List.of(1, 8, 9, 10, 11, 12)),
                        new Lotto(List.of(8, 9, 10, 11, 12, 13))
                )));


    }

}
