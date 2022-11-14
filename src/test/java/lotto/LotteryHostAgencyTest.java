package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryHostAgencyTest {

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("당첨등수에 관한 테스트 : [1, 2, 3, 4, 5, 6] + 7")
    class WinningCriteriaTest {
        LotteryHostAgency lha = new LotteryHostAgency();

        {
            lha.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
            lha.setBonusNumber(7);
        }

        @ParameterizedTest(name="테스트{index} : {0} => {1}")
        @MethodSource("validateWiningCriteriaTestArgument")
        @DisplayName("검증 테스트")
        void validateWiningCriteriaTest(Lotto challenge, String criteria) {
            assertThat(lha.getResult(challenge).name()).isEqualTo(criteria);
        }

        Stream<Arguments> validateWiningCriteriaTestArgument() {
            return Stream.of(
                    Arguments.arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LotteryHostAgency.WinningCriteria.FIRST.name()),
                    Arguments.arguments(new Lotto(List.of(1, 2, 3, 4, 5, 7)), LotteryHostAgency.WinningCriteria.SECOND.name()),
                    Arguments.arguments(new Lotto(List.of(1, 2, 3, 4, 5, 8)), LotteryHostAgency.WinningCriteria.THIRD.name()),
                    Arguments.arguments(new Lotto(List.of(1, 2, 3, 4, 7, 8)), LotteryHostAgency.WinningCriteria.FORTH.name()),
                    Arguments.arguments(new Lotto(List.of(1, 2, 3, 7, 8, 9)), LotteryHostAgency.WinningCriteria.FIFTH.name()),
                    Arguments.arguments(new Lotto(List.of(40, 41, 42, 43, 44, 45)), LotteryHostAgency.WinningCriteria.NOTHING.name())
            );
        }
    }

    @ParameterizedTest(name="테스트{index} : {0} => Exception")
    @MethodSource("validateInputWiningNumbersArgument")
    @DisplayName("설정하는 당첨 번호에 대한 검증 테스트")
    void validateInputWiningNumbers(List<Integer> x){
        LotteryHostAgency lha = new LotteryHostAgency();

        assertThatThrownBy(() -> {
            lha.setWinningNumbers(x);
        }).isInstanceOf(
                IllegalArgumentException.class
        );
    }

    static Stream<List<Integer>> validateInputWiningNumbersArgument(){
        return Stream.of(
                List.of(1,2,3,4,5,100),
                List.of(1,2,3,4,5),
                List.of(1,2,3,4,5,6,7)
        );
    }
    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("설정하는 당첨 번호에 대한 테스트")
    class BonusNumber {
        LotteryHostAgency lha = new LotteryHostAgency();
        {
            lha.setWinningNumbers(List.of(1,2,3,4,5,6));
        }
        @ParameterizedTest(name="테스트{index} : {0} => Exception")
        @MethodSource("validateInputBonusNumberArgument")
        @DisplayName("검증 테스트")
        void validateInputBonusNumber(int x){


            assertThatThrownBy(() -> {
                lha.setBonusNumber(x);
            }).isInstanceOf(
                    IllegalArgumentException.class
            );
        }

        Stream<Integer> validateInputBonusNumberArgument(){
            return Stream.of(
                    1, 0, 46
            );
        }
    }

}
