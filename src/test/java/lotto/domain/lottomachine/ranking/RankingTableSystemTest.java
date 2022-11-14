package lotto.domain.lottomachine.ranking;

import lotto.domain.lottomachine.lottoticket.Lotto;
import lotto.domain.lottomachine.lottoticket.LottoTickets;
import lotto.domain.lottomachine.winningnumber.WinningNumber;
import lotto.domain.lottomachine.winningnumber.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTableSystemTest {

    private RankingTableSystem rankingTableSystem;

    @BeforeEach
    void setUp() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumber bonus = new WinningNumber(7);
        WinningNumbers winningNumbers = new WinningNumbers(numbers.stream()
                .map(WinningNumber::new)
                .collect(Collectors.toList()));

        rankingTableSystem = RankingTableSystem.of(winningNumbers, bonus);
    }

    @DisplayName("countMatchingNumbersOf 메소드에 LottoTickets을 입력하면 일치하는 숫자를 리스트로 반환하는지 확인")
    @ParameterizedTest
    @MethodSource("provideArgumentsForCountingTest")
    void countMatchingNumbersOf_test(List<List<Integer>> lottoNumbers, List<String> expected) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = rankingTableSystem.getClass().getDeclaredMethod("countMatchingNumbersOf", LottoTickets.class);
        method.setAccessible(true);
        LottoTickets tickets = new LottoTickets(lottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList()));

        assertThat(method.invoke(rankingTableSystem, tickets)).isEqualTo(expected);
    }

    @DisplayName("classifyByRank 메소드에 LottoTickets을 입력하면 순위별로 일치하는 수가 정리된 Map 객체를 반환하는지 확인")
    @ParameterizedTest
    @MethodSource("provideArgumentsForClassifyingTest")
    void classifyByRank_test(List<List<Integer>> lottoNumbers, Map<Ranking, Integer> expected) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = rankingTableSystem.getClass().getDeclaredMethod("classifyByRank", LottoTickets.class);
        method.setAccessible(true);
        LottoTickets tickets = new LottoTickets(lottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList()));

        assertThat(method.invoke(rankingTableSystem, tickets)).isEqualTo(expected);
    }

    @DisplayName("createRankingTable 메소드에 LottoTickets을 입력하면 RankingTable을 생성해 반환하는지 확인")
    @ParameterizedTest
    @MethodSource("provideArgumentsForCreatingTest")
    void createRankingTable_test(List<List<Integer>> lottoNumbers) {
        LottoTickets tickets = new LottoTickets(lottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList()));

        assertThat(rankingTableSystem.createRankingTable(tickets)).isInstanceOf(RankingTable.class);
    }

    static Stream<Arguments> provideArgumentsForCountingTest() {
        return Stream.of(
                Arguments.of(List.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 7),
                        List.of(1, 2, 3, 4, 7, 8)), List.of("6", "5B", "4"))
        );
    }

    static Stream<Arguments> provideArgumentsForClassifyingTest() {
        return Stream.of(
                Arguments.of(List.of(
                                List.of(1, 2, 3, 4, 5, 6),
                                List.of(1, 2, 3, 4, 5, 6),
                                List.of(1, 2, 3, 4, 6, 7),
                                List.of(1, 2, 3, 7, 8, 9)),
                        Map.of(
                                Ranking.FIRST_PLACE, 2,
                                Ranking.SECOND_PLACE, 1,
                                Ranking.THIRD_PLACE, 0,
                                Ranking.FOURTH_PLACE, 0,
                                Ranking.FIFTH_PLACE, 1))
        );
    }

    static Stream<Arguments> provideArgumentsForCreatingTest() {
        return Stream.of(
                Arguments.of(List.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 7),
                        List.of(1, 2, 3, 4, 7, 8)))
        );
    }
}