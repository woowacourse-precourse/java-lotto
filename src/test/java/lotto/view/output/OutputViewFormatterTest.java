package lotto.view.output;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.exception.LottoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class OutputViewFormatterTest {
    private OutputViewFormatter outputViewFormatter;

    @BeforeEach
    void setUp() {
        this.outputViewFormatter = new OutputViewFormatter();
    }

    @DisplayName("로또 번호는 오름차순으로 정렬하여 보여준다.")
    @Test
    void outputLotto() {
        assertThat(outputViewFormatter.outputLottoFormat(new Lotto(List.of(45, 16, 26, 2, 34, 7))))
                .isEqualTo("[2, 7, 16, 26, 34, 45]");
    }

    private static Stream<Arguments> provideForOutputRank() {
        return Stream.of(
                Arguments.of(Rank.FIRST, "6개 일치 (2,000,000,000원) - 0개"),
                Arguments.of(Rank.SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개"),
                Arguments.of(Rank.THIRD, "5개 일치 (1,500,000원) - 0개"),
                Arguments.of(Rank.FOURTH, "4개 일치 (50,000원) - 0개"),
                Arguments.of(Rank.FIFTH, "3개 일치 (5,000원) - 0개")
        );
    }

    @ParameterizedTest(name = "순위에 따른 결과를 문자열로 반환한다.")
    @MethodSource("provideForOutputRank")
    void outputRank(Rank rank, String expected) {
        assertThat(outputViewFormatter.outputRankFormat(rank, 0)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "3자리마다 콤마(,)를 붙인다.")
    @CsvSource(value = {"5000:5,000", "50000:50,000", "1500000:1,500,000",
            "30000000:30,000,000", "2000000000:2,000,000,000"}, delimiter = ':')
    void outputRank(long number, String expected) {
        assertThat(outputViewFormatter.outputMoneyFormat(new Money(number))).isEqualTo(expected);
    }

    @ParameterizedTest(name = "수익률은 소수점 둘째 자리에서 반올림한다")
    @CsvSource(value = {"100.02:총 수익률은 100.0%입니다.",
            "51.54:총 수익률은 51.5%입니다.",
            "51.56:총 수익률은 51.6%입니다.",
            "1000000.02:총 수익률은 1,000,000.0%입니다."}, delimiter = ':')
    void outputYield(Double value, String expected) {
        assertThat(outputViewFormatter.outputYieldFormat(value)).isEqualTo(expected);
    }

    @DisplayName("에러 문구는 “[ERROR]”로 시작해야 한다")
    @Test
    void outputExceptionFormat() {
        assertThat(outputViewFormatter.outputExceptionFormat(new LottoException("에러 메세지"))).contains("[ERROR]");
    }
}
