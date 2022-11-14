package lotto.domain.lottomachine.ranking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTableTest {

    private RankingTable rankingTable;

    @BeforeEach
    void setUp() {
        Map<Ranking, Integer> frequenciesByRank = Map.of(
                Ranking.FIRST_PLACE, 2,
                Ranking.SECOND_PLACE, 1,
                Ranking.THIRD_PLACE, 0,
                Ranking.FOURTH_PLACE, 2,
                Ranking.FIFTH_PLACE, 1);
        rankingTable = new RankingTable(frequenciesByRank);
    }

    @DisplayName("calculateCurrentValue 메소드가 로또 당첨금의 총수익을 BigDecimal 객체로 반환하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"4030105000"})
    void calculateCurrentValue_test(String bigNumber) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = rankingTable.getClass().getDeclaredMethod("calculateCurrentValue");
        method.setAccessible(true);
        BigDecimal expected = new BigDecimal(bigNumber);

        assertThat(method.invoke(rankingTable)).isEqualTo(expected);
    }

    @DisplayName("changeToRateOfReturnFormat 메소드에 BigDecimal 객체를 입력했을 때 수익률 형식(\"###,###.0%\")의 String으로 반환하는지 확인")
    @ParameterizedTest
    @MethodSource("provideArgumentsForChangingTest")
    void changeToRateOfReturnFormat_test(String bigNumber, String expected) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = rankingTable.getClass().getDeclaredMethod("changeToRateOfReturnFormat", BigDecimal.class);
        method.setAccessible(true);
        BigDecimal input = new BigDecimal(bigNumber);

        String actual = (String) method.invoke(rankingTable, input);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("calculateRateOfReturn 메소드에 로또 구입가격을 int로 입력했을 때 수익률을 String으로 반환하는지 확인")
    @ParameterizedTest
    @MethodSource("provideArgumentsForRateOfReturnTest")
    void calculateRateOfReturn_test(int money, String expected) {
        String actual = rankingTable.calculateRateOfReturn(money);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("getAllByAscendingRanking 메소드가 로또 번호가 맞춘 개수, 당첨 금액, 티켓 매수를 리스트에 담아 반환하는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"[[3, 5,000, 1], [4, 50,000, 2], [5, 1,500,000, 0], [5B, 30,000,000, 1], [6, 2,000,000,000, 2]]"})
    void getAllByAscendingRanking_test(String expected) {
        List<List<String>> actual = rankingTable.getAllByAscendingRanking();

        assertThat(actual.toString()).isEqualTo(expected);
    }

    static Stream<Arguments> provideArgumentsForChangingTest() {
        return Stream.of(
                Arguments.of("403010.512", "40,301,051.2%"),
                Arguments.of("100.000", "10,000.0%"),
                Arguments.of("0.032", "3.2%")
        );
    }

    static Stream<Arguments> provideArgumentsForRateOfReturnTest() {
        return Stream.of(
                Arguments.of(6000, "67,168,416.7%"),
                Arguments.of(10000, "40,301,050.0%"),
                Arguments.of(100000, "4,030,105.0%")
        );
    }
}