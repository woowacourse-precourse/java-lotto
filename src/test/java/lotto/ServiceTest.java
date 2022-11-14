package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ServiceTest {

    private Service service;

    @BeforeEach
    void setUp() {
        service = new Service();
    }

    @DisplayName("문자열을 정수로 변경시키는 메서드 테스트")
    @Test
    void stringToIntTest_success() {
        assertThat(service.stringToInt("1234"))
                .isEqualTo(1234);
    }

    @DisplayName("문자열이 정수로만 이루어져 있지 않다면 예외 발생")
    @Test
    void stringToIntTest_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.stringToInt("1로또234"));
    }

    @DisplayName("1000으로 나눠 값을 반환하는 메서드")
    @Test
    void numberOfLotteryTest_success() {
        assertThat(service.numberOfLottery(20000))
                .isEqualTo(20);
    }

    @DisplayName("1000으로 나눠 나머지가 있을 경우 예외가 발생")
    @Test
    void numberOfLotteryTest_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.numberOfLottery(20001));
    }

    @DisplayName("로또 티켓을 원하는 개수만큼 생성해 반환하는 메서드 테스트")
    @Test
    void createLotteryTicketsTest() {
        int numberOfLotteryTickets = 10;

        assertThat(service.createLotteryTickets(numberOfLotteryTickets, new LottoGroup()).size())
                .isEqualTo(numberOfLotteryTickets);
    }

    @DisplayName("','를 기준으로 문자열 리스트를 반환하는 기능 테스트")
    @Test
    void splitByCommasTest() {
        String testString = "1,2,3";

        assertThat(service.splitByCommas(testString)).isEqualTo(List.of("1", "2", "3"));
    }

    @DisplayName("문자열 리스트를 정수 리스트로 반환하는 기능 테스트")
    @Test
    void stringsToIntegersTest() {
        assertThat(service.toIntegers(List.of("1", "2", "3"))).isEqualTo(List.of(1, 2, 3));
    }

    @DisplayName("문자열 리스트가 정수가 아니라면 예외 발생")
    @Test
    void stringToIntegerExceptionTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> service.toIntegers(List.of("1", "2", "문자열")));
    }

    @DisplayName("로또의 순위를 반환하는 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoAndWinningNumber")
    void getLotteryRankTest(Lotto lotto, WinningNumber winningNumber, RankType rankType) {
        assertThat(service.getLotteryRank(lotto, winningNumber)).isEqualTo(rankType);
    }

    @DisplayName("모든 로또 당첨금을 반환하는 테스트")
    @ParameterizedTest
    @MethodSource("provideRankTypesAndSumAllWinnings")
    void sumAllWinningsTest(List<RankType> rankTypes, int sumAllWinnings) {
        assertThat(service.sumAllWinnings(rankTypes)).isEqualTo(sumAllWinnings);
    }

    @DisplayName("로또 당첨이 순위별로 몇개가 되었는지 반환하는 테스트")
    @ParameterizedTest
    @MethodSource("provideRankTypesAndCountEachRanks")
    void countByWinningRanks(List<RankType> rankTypes, List<Integer> eachRanksCount) {
        List<Integer> rankCounts = new ArrayList<>();
        for(RankType rankType : RankType.values()) {
            int rankCount = Collections.frequency(rankTypes, rankType);
            rankCounts.add(rankCount);
        }
        assertThat(rankCounts).isEqualTo(eachRanksCount);
    }

    private static Stream<Arguments> provideLottoAndWinningNumber() {
        int bonusNumber = 20;
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), bonusNumber);
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), winningNumber, RankType.FIRST),   //1등
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 20)), winningNumber, RankType.SECOND),  //2등
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), winningNumber, RankType.THIRD),  //3등..
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 9, 8)), winningNumber, RankType.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 10, 11, 20)), winningNumber, RankType.FIFTH)
        );
    }

    private static Stream<Arguments> provideRankTypesAndSumAllWinnings() {
        List<RankType> rankTypes = new ArrayList<>();
        return Stream.of(
                //1, 2, 3등 당첨금 더한 값은 2,031,500,000원
                Arguments.of(List.of(RankType.FIRST, RankType.SECOND, RankType.THIRD), 2_031_500_000),
                //1, 4, 5등 당첨금 더한 값은 2,000,055,000원
                Arguments.of(List.of(RankType.FIRST, RankType.FOURTH, RankType.FIFTH), 2_000_055_000),
                //당첨 안된 경우
                Arguments.of(List.of(RankType.NONE, RankType.NONE, RankType.NONE), 0)
        );
    }

    private static Stream<Arguments> provideRankTypesAndCountEachRanks() {
        List<RankType> rankTypes = new ArrayList<>();
        return Stream.of(
                Arguments.of(List.of(RankType.FIRST,RankType.FIRST, RankType.SECOND, RankType.THIRD), List.of(2, 1, 1, 0, 0, 0)),
                Arguments.of(List.of(RankType.FOURTH, RankType.FOURTH, RankType.FOURTH), List.of(0, 0, 0, 3, 0, 0)),
                Arguments.of(List.of(RankType.NONE, RankType.NONE, RankType.NONE), List.of(0, 0, 0, 0, 0, 3))
        );
    }
}
