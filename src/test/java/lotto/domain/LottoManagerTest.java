package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoManagerTest {
    @DisplayName("발행 가능한 수만큼 로또를 발행하는 기능 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 7, 8, 10})
    void issueLottoSeveralTimesTest(int lottoIssueCount) throws Exception {
        // Reflection Setting
        LottoManager lottoManager = new LottoManager();
        Method privateMethod = lottoManager.getClass().getDeclaredMethod("issueLottoSeveralTimes", int.class, List.class);
        privateMethod.setAccessible(true);

        // Given
        List<Lotto> myLotto = new ArrayList<>();

        // When
        privateMethod.invoke(lottoManager, lottoIssueCount, myLotto);

        // Then
        assertThat(myLotto.size()).isEqualTo(lottoIssueCount);
    }
    @DisplayName("발행받은 로또와 당첨 번호 비교 테스트")
    @ParameterizedTest
    @MethodSource("compareMyLottoWithWinningNumberSource")
    void compareMyLottoWithWinningNumberTest(int resultOfSameCount, List<Integer> myLotto) throws Exception {
        // Reflection Setting
        LottoManager lottoManager = new LottoManager();
        Method privateMethod = lottoManager.getClass().getDeclaredMethod("compareMyLottoWithWinningNumber", List.class, List.class);
        privateMethod.setAccessible(true);

        // Given
        List<Integer> myLottoNumber = myLotto;
        List<Integer> winningNumber = List.of(3, 9, 17, 25, 34, 43);

        // When
        int sameNumberCount = (int) privateMethod.invoke(lottoManager, myLottoNumber, winningNumber);

        // Then
        assertThat(sameNumberCount).isEqualTo(resultOfSameCount);
    }
    private static Stream<Arguments> compareMyLottoWithWinningNumberSource() {
        return Stream.of(
                Arguments.of(0, List.of(1, 2, 5, 7, 26, 38)),
                Arguments.of(1, List.of(3, 10, 18, 26, 38, 45)),
                Arguments.of(2, List.of(3, 9, 18, 26, 35, 44)),
                Arguments.of(3, List.of(3, 9, 17, 26, 35, 44)),
                Arguments.of(4, List.of(3, 9, 17, 25, 35, 44)),
                Arguments.of(5, List.of(3, 9, 17, 25, 34, 44)),
                Arguments.of(6, List.of(3, 9, 17, 25, 34, 43))
        );
    }
    @DisplayName("일치하는 수를 인자로 받아 당첨 등수를 얻는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:5", "4:4", "5:3", "6:1"}, delimiter = ':')
    void getRankTest(int sameNumberCount, int rank) throws Exception {
        // Reflection Setting
        LottoManager lottoManager = new LottoManager();
        Method privateMethod = lottoManager.getClass().getDeclaredMethod("getRank", int.class);
        privateMethod.setAccessible(true);

        assertThat(privateMethod.invoke(lottoManager, sameNumberCount)).isEqualTo(rank);
    }
    @DisplayName("보너스 번호 일치 여부를 확인하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5:true", "7:false", "35:true", "43:false"}, delimiter = ':')
    void checkBonusNumberTest(int bonusNumber, boolean result) throws Exception {
        // Reflection Setting
        LottoManager lottoManager = new LottoManager();
        Method privateMethod = lottoManager.getClass().getDeclaredMethod("checkBonusNumber", List.class, int.class);
        privateMethod.setAccessible(true);

        List<Integer> myLottoNumber = List.of(1, 3, 5, 35, 37, 45);

        assertThat(privateMethod.invoke(lottoManager, myLottoNumber, bonusNumber)).isEqualTo(result);
    }
}
