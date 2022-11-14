package lotto.LottoManager;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.Enum.Constant.*;
import static lotto.Enum.Error.*;

public class LottoDrawingMachine {
    private final List<Integer> winning_numbers;
    private final int bonus_number;

    public LottoDrawingMachine() {
        List<String> drawn_lines = drawLottoNumbers();

        String winning_number_line = drawn_lines.get(ZERO.getIntValue());
        String bonus_number_line = drawn_lines.get(ONE.getIntValue());

        validateDrawnNumbersPattern(winning_number_line.trim(), bonus_number_line.trim());

        winning_numbers =
                Arrays.stream(winning_number_line.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        bonus_number = Integer.parseInt(bonus_number_line);

        validateDrawnNumbers(winning_numbers, bonus_number);
    }

    // Only For Test
    public LottoDrawingMachine(List<String> drawn_lines) {
        String winning_number_line = drawn_lines.get(ZERO.getIntValue());
        String bonus_number_line = drawn_lines.get(ONE.getIntValue());

        validateDrawnNumbersPattern(winning_number_line.trim(), bonus_number_line.trim());

        winning_numbers =
                Arrays.stream(winning_number_line.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        bonus_number = Integer.parseInt(bonus_number_line);

        validateDrawnNumbers(winning_numbers, bonus_number);
    }

    public List<Integer> getWinning_numbers() {
        return winning_numbers;
    }

    public int getBonus_number() {
        return bonus_number;
    }

    private List<String> drawLottoNumbers() {
        String winning_number_line = Console.readLine();
        String bonus_number_line = Console.readLine();
        return List.of(winning_number_line, bonus_number_line);
    }

    private void validateDrawnNumbersPattern(String winning_number_line, String bonus_number_line) {
        if (!winning_number_line.matches(REGEX_WINNING_NUMBER_FORMAT.getValue())) {
            throw new IllegalArgumentException(DRAW_LOTTO_FORMAT_ERROR.getMessage());
        }
        if (!bonus_number_line.matches(REGEX_BONUS_NUMBER_FORMAT.getValue())) {
            throw new IllegalArgumentException(DRAW_LOTTO_BONUS_ERROR.getMessage());
        }
    }

    private void validateDrawnNumbers(List<Integer> winning_numbers, int bonus_number) {
        List<Integer> drawn_numbers =
                Stream.concat(winning_numbers.stream(), Stream.of(bonus_number))
                        .collect(Collectors.toList());

        if (drawn_numbers.stream()
                .filter(this::validateDrawnNumberRange)
                .count() != FIVE.getIntValue()) {
            throw new IllegalArgumentException(DRAW_LOTTO_RANGE_ERROR.getMessage());
        }
    }

    private boolean validateDrawnNumberRange(Integer num) {
        return num > ZERO.getIntValue() && num <= FOURTY_FIVE.getIntValue();
    }
}
