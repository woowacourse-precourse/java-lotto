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

        validateAllDrawnNumbersRange(drawn_lines);

        winning_numbers = makeWinning_numbers(drawn_lines);

        bonus_number = makeBonus_number(drawn_lines);
    }

    public static void drawLottoForTest(List<String> drawn_lines) {
        validateDrawnNumbersPattern(drawn_lines);

        validateAllDrawnNumbersRange(drawn_lines);
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

    private static void validateAllDrawnNumbersRange(List<String> drawn_lines) {
        List<Integer> all_drawn_numbers = makeDrawnLinesToNumbers(drawn_lines);

        if (all_drawn_numbers.stream()
                .filter(LottoDrawingMachine::validateDrawnNumberRange)
                .distinct()
                .count() != SEVEN.getIntValue()) {
            throw new IllegalArgumentException(DRAW_LOTTO_RANGE_ERROR.getMessage());
        }
    }

    private static List<Integer> makeDrawnLinesToNumbers(List<String> drawn_lines) {
        List<Integer> winning_line = makeWinning_numbers(drawn_lines);
        int bonus_line = makeBonus_number(drawn_lines);

        return Stream.concat(
                winning_line.stream(), Stream.of(bonus_line)
                ).collect(Collectors.toList());
    }

    private static List<Integer> makeWinning_numbers(List<String> drawn_lines) {
        return Arrays.stream(drawn_lines.get(ZERO.getIntValue()).split(","))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    private static int makeBonus_number(List<String> drawn_lines) {
        return Integer.parseInt(drawn_lines.get(ONE.getIntValue()));
    }

    private static boolean validateDrawnNumberRange(int num) {
        return num > ZERO.getIntValue() && num <= FOURTY_FIVE.getIntValue();
    }

//    public static int calculatePrize(Lotto lotto) {
//        lotto.getNumbers()
//                .stream().
//
//    }
}
