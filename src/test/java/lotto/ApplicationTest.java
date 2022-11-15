package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("통합 테스트1")
    void 기능_테스트() {
        List<String> input = List.of("8000", "1,2,3,4,5,6", "7");
        List<String> output = List.of(
                "8개를 구매했습니다.",
                "[8, 21, 23, 41, 42, 43]",
                "[3, 5, 11, 16, 32, 38]",
                "[7, 11, 16, 35, 36, 44]",
                "[1, 8, 11, 31, 41, 42]",
                "[13, 14, 16, 38, 42, 45]",
                "[7, 11, 30, 40, 42, 43]",
                "[2, 13, 22, 32, 38, 45]",
                "[1, 3, 5, 14, 22, 45]",
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 62.5%입니다.");
        List<List<Integer>> mockedNumbers = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45));
    }


    @Test
    @DisplayName("통합 테스트2")
    void 기능_테스트2() {
        List<String> input = List.of("10000", "6,7,9,11,17,18", "45");
        List<String> output = List.of(
                "10개를 구매했습니다.",
                "[8, 21, 23, 41, 42, 43]",
                "[3, 5, 11, 16, 32, 38]",
                "[7, 11, 16, 35, 36, 44]",
                "[1, 8, 11, 31, 41, 42]",
                "[13, 14, 16, 38, 42, 45]",
                "[7, 11, 30, 40, 42, 43]",
                "[2, 13, 22, 32, 38, 45]",
                "[6, 7, 9, 11, 18, 45]",
                "[6, 7, 12, 18, 32, 45]",
                "[1, 3, 5, 14, 22, 45]",
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 300050.0%입니다.");
        List<List<Integer>> mockedNumbers = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(6, 7, 9, 11, 18, 45),
                List.of(6, 7, 12, 18, 32, 45),
                List.of(1, 3, 5, 14, 22, 45));

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run(input.toArray(new String[0]));
                    assertThat(output()).contains(output);
                },
                mockedNumbers.get(0),
                mockedNumbers.get(1),
                mockedNumbers.get(2),
                mockedNumbers.get(3),
                mockedNumbers.get(4),
                mockedNumbers.get(5),
                mockedNumbers.get(6),
                mockedNumbers.get(7),
                mockedNumbers.get(8),
                mockedNumbers.get(9));
    }

    @Test
    @DisplayName("통합 테스트3")
    void 기능_테스트3() {
        List<String> input = List.of("100000", "1,2,3,4,5,6", "7");
        List<String> output = new ArrayList<>();
        output.add("100개를 구매했습니다.");
        output.add("[8, 21, 23, 41, 42, 43]");
        output.add("[3, 5, 11, 16, 32, 38]");
        output.add("[7, 11, 16, 35, 36, 44]");
        output.add("[1, 8, 11, 31, 41, 42]");
        output.add("[13, 14, 16, 38, 42, 45]");
        output.add("[7, 11, 30, 40, 42, 43]");
        output.add("[2, 13, 22, 32, 38, 45]");
        for (int count = 8; count <= 100; count++) {
            output.add("[1, 2, 3, 4, 5, 6]");
        }
        output.add("3개 일치 (5,000원) - 0");
        output.add("4개 일치 (50,000원) - 0개");
        output.add("5개 일치 (1,500,000원) - 0개");
        output.add("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
        output.add("6개 일치 (2,000,000,000원) - 93");
        output.add("총 수익률은 186000000.0%입니다.");
        List<List<Integer>> mockedNumbers = new ArrayList<>();
        mockedNumbers.add(List.of(8, 21, 23, 41, 42, 43));
        mockedNumbers.add(List.of(3, 5, 11, 16, 32, 38));
        mockedNumbers.add(List.of(7, 11, 16, 35, 36, 44));
        mockedNumbers.add(List.of(1, 8, 11, 31, 41, 42));
        mockedNumbers.add(List.of(13, 14, 16, 38, 42, 45));
        mockedNumbers.add(List.of(7, 11, 30, 40, 42, 43));
        mockedNumbers.add(List.of(2, 13, 22, 32, 38, 45));

        for (int count = 8; count <= 100; count++) {
            mockedNumbers.add(List.of(1, 2, 3, 4, 5, 6));
        }

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run(input.toArray(new String[0]));
                    assertThat(output()).contains(output);
                },
                mockedNumbers.get(0),
                mockedNumbers.get(1),
                mockedNumbers.get(2),
                mockedNumbers.get(3),
                mockedNumbers.get(4),
                mockedNumbers.get(5),
                mockedNumbers.get(6),
                mockedNumbers.get(7),
                mockedNumbers.get(8),
                mockedNumbers.get(9),
                mockedNumbers.get(10),
                mockedNumbers.get(11),
                mockedNumbers.get(12),
                mockedNumbers.get(13),
                mockedNumbers.get(14),
                mockedNumbers.get(15),
                mockedNumbers.get(16),
                mockedNumbers.get(17),
                mockedNumbers.get(18),
                mockedNumbers.get(19),
                mockedNumbers.get(20),
                mockedNumbers.get(21),
                mockedNumbers.get(22),
                mockedNumbers.get(23),
                mockedNumbers.get(24),
                mockedNumbers.get(25),
                mockedNumbers.get(26),
                mockedNumbers.get(26),
                mockedNumbers.get(27),
                mockedNumbers.get(28),
                mockedNumbers.get(29),
                mockedNumbers.get(30),
                mockedNumbers.get(31),
                mockedNumbers.get(32),
                mockedNumbers.get(33),
                mockedNumbers.get(34),
                mockedNumbers.get(35),
                mockedNumbers.get(36),
                mockedNumbers.get(36),
                mockedNumbers.get(37),
                mockedNumbers.get(38),
                mockedNumbers.get(39),
                mockedNumbers.get(40),
                mockedNumbers.get(41),
                mockedNumbers.get(42),
                mockedNumbers.get(43),
                mockedNumbers.get(44),
                mockedNumbers.get(45),
                mockedNumbers.get(46),
                mockedNumbers.get(46),
                mockedNumbers.get(47),
                mockedNumbers.get(48),
                mockedNumbers.get(49),
                mockedNumbers.get(50),
                mockedNumbers.get(51),
                mockedNumbers.get(52),
                mockedNumbers.get(53),
                mockedNumbers.get(54),
                mockedNumbers.get(55),
                mockedNumbers.get(56),
                mockedNumbers.get(56),
                mockedNumbers.get(57),
                mockedNumbers.get(58),
                mockedNumbers.get(59),
                mockedNumbers.get(60),
                mockedNumbers.get(61),
                mockedNumbers.get(62),
                mockedNumbers.get(63),
                mockedNumbers.get(64),
                mockedNumbers.get(65),
                mockedNumbers.get(66),
                mockedNumbers.get(66),
                mockedNumbers.get(67),
                mockedNumbers.get(68),
                mockedNumbers.get(69),
                mockedNumbers.get(70),
                mockedNumbers.get(71),
                mockedNumbers.get(72),
                mockedNumbers.get(73),
                mockedNumbers.get(74),
                mockedNumbers.get(75),
                mockedNumbers.get(76),
                mockedNumbers.get(76),
                mockedNumbers.get(77),
                mockedNumbers.get(78),
                mockedNumbers.get(79),
                mockedNumbers.get(80),
                mockedNumbers.get(81),
                mockedNumbers.get(82),
                mockedNumbers.get(83),
                mockedNumbers.get(84),
                mockedNumbers.get(85),
                mockedNumbers.get(86),
                mockedNumbers.get(86),
                mockedNumbers.get(87),
                mockedNumbers.get(88),
                mockedNumbers.get(89),
                mockedNumbers.get(90),
                mockedNumbers.get(91),
                mockedNumbers.get(92),
                mockedNumbers.get(93),
                mockedNumbers.get(94),
                mockedNumbers.get(95),
                mockedNumbers.get(96),
                mockedNumbers.get(96),
                mockedNumbers.get(97),
                mockedNumbers.get(98),
                mockedNumbers.get(99));
    }


    @ParameterizedTest(name = "잘못된 값 입력시 예외 발생 테스트")
    @CsvSource({"1000j", "2200, 0"})
    void 예외_테스트(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
