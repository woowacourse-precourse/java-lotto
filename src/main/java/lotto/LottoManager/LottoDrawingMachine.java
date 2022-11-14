package lotto.LottoManager;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.Enum.Constant.*;
import static lotto.Enum.Error.*;

public class LottoDrawingMachine {
    private static List<Integer> winning_numbers;
    private static int bonus_number;

    public static void drawLotto() {
        List<String> drawn_lines = drawLottoNumbers();

        validateDrawnNumbersPattern(drawn_lines);

        validateAllDrawnNumbers(drawn_lines);
    }

    public static void drawLottoForTest(List<String> drawn_lines) {
        validateDrawnNumbersPattern(drawn_lines);

        validateAllDrawnNumbers(drawn_lines);
    }

    private static List<String> drawLottoNumbers() {
        String winning_number_line = Console.readLine();
        String bonus_number_line = Console.readLine();
        return List.of(winning_number_line, bonus_number_line);
    }

    private static void validateDrawnNumbersPattern(List<String> drawn_lines) {
        String winning_number_line = drawn_lines.get(ZERO.getIntValue()).trim();
        String bonus_number_line = drawn_lines.get(ONE.getIntValue()).trim();

        if (!winning_number_line.matches(REGEX_WINNING_NUMBER_FORMAT.getValue())) {
            throw new IllegalArgumentException(DRAW_LOTTO_FORMAT_ERROR.getMessage());
        }
        if (!bonus_number_line.matches(REGEX_BONUS_NUMBER_FORMAT.getValue())) {
            throw new IllegalArgumentException(DRAW_LOTTO_BONUS_ERROR.getMessage());
        }
    }

    private static void validateAllDrawnNumbers(List<String> drawn_lines) {
        List<Integer> all_drawn_numbers = makeDrawnLinesToNumbers(drawn_lines);

        if (all_drawn_numbers.stream()
                .filter(LottoDrawingMachine::validateDrawnNumberRange)
                .count() != FIVE.getIntValue()) {
            throw new IllegalArgumentException(DRAW_LOTTO_RANGE_ERROR.getMessage());
        }
    }

    private static List<Integer> makeDrawnLinesToNumbers(List<String> drawn_lines) {
        winning_numbers =
                Arrays.stream(drawn_lines.get(ZERO.getIntValue()).split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        bonus_number = Integer.parseInt(drawn_lines.get(ONE.getIntValue()));

        return Stream.concat(
                winning_numbers.stream(), Stream.of(bonus_number)
                ).collect(Collectors.toList());
    }

    private static boolean validateDrawnNumberRange(Integer num) {
        return num > ZERO.getIntValue() && num <= FOURTY_FIVE.getIntValue();
    }
}
