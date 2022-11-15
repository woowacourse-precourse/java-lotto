package lotto.LottoManagement;

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
        System.out.println("당첨 번호를 입력해 주세요.");
        String winning_number_line =
                Console.readLine()
                        .replace(SPACE.getValue(), EMPTY.getValue());

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus_number_line =
                Console.readLine()
                        .replace(SPACE.getValue(), EMPTY.getValue());
        return List.of(winning_number_line, bonus_number_line);
    }

    private static void validateDrawnNumbersPattern(List<String> drawn_lines) {
        String winning_number_line = drawn_lines.get(ZERO_INDEX.getIntValue());
        String bonus_number_line = drawn_lines.get(ONE_INDEX.getIntValue());

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
                .count() != ALL_DRAWN_NUMBERS_LENGTH.getIntValue()) {
            throw new IllegalArgumentException(DRAW_LOTTO_RANGE_ERROR.getMessage());
        }
    }

    private static List<Integer> makeDrawnLinesToNumbers(List<String> drawn_lines) {
        List<Integer> winning_line = makeWinning_numbers(drawn_lines);
        int bonus_line = makeBonus_number(drawn_lines);

        return Stream.concat(winning_line.stream(), Stream.of(bonus_line))
                .collect(Collectors.toList());
    }

    private static List<Integer> makeWinning_numbers(List<String> drawn_lines) {
        return Arrays.stream(drawn_lines.get(ZERO_INDEX.getIntValue()).split(","))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    private static int makeBonus_number(List<String> drawn_lines) {
        return Integer.parseInt(drawn_lines.get(ONE_INDEX.getIntValue()));
    }

    private static boolean validateDrawnNumberRange(int num) {
        return num >= LOTTO_NUMBER_MIN.getIntValue() && num <= LOTTO_NUMBER_MAX.getIntValue();
    }

    public static int calculatePrize(Lotto lotto) {
        List<Integer> lotto_numbers = lotto.getNumbers();

        List<Integer> concat_numbers =
                Stream.concat(lotto_numbers.stream(), winning_numbers.stream())
                        .collect(Collectors.toList());

        int matched_count = countLottoNumberDistinct(concat_numbers);

        if (matched_count == THIRD_GRADE_COUNT.getIntValue()) {
            return checkBonusNumber(lotto_numbers);
        }
        return matched_count;
    }

    private static int checkBonusNumber(List<Integer> lotto_numbers) {
        int bonus_matched =
                (int) lotto_numbers.stream()
                        .filter(num -> num == bonus_number)
                        .count();

        if (bonus_matched == BONUS_NUMBER_MATCHED.getIntValue()) {
            return SECOND_GRADE_COUNT.getIntValue();
        }
        return THIRD_GRADE_COUNT.getIntValue();
    }


    private static int countLottoNumberDistinct(List<Integer> concat_numbers) {
        return concat_numbers.size() -
                (int) concat_numbers.stream()
                        .distinct()
                        .count();
    }
}
