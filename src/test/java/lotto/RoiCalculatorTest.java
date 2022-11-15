package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RoiCalculatorTest {

    @ParameterizedTest
    @MethodSource("variousRoi")
    @DisplayName("정확한 수익률을 계산하여 반환한다")
    public void validateWinningNumbers(
        final int totalMoneyWasted,
        final int totalMoneyGained,
        final double expectedRoi
    ) {
        final var sut = new RoiCalculator();

        final double roi = sut.roi(totalMoneyWasted, totalMoneyGained);

        double epsilon = 0.000001d;
        assertEquals(expectedRoi, roi, epsilon);
    }

    static Stream<Arguments> variousRoi() throws Throwable {
        return Stream.of(
            Arguments.of(10000, 6000, 60.00d),
            Arguments.of(8000, 5000, 62.50d),
            Arguments.of(8000, 0, 0.00d)
        );
    }
}
