package lotto.LottoManager;

import camp.nextstep.edu.missionutils.Console;

import static lotto.Enum.Error.*;

public class LottoDrawingMachine {
    public static void drawLottoNumbers() {
        String winning_number_line = Console.readLine();
        String bonus_number_line = Console.readLine();

        validateDrawnNumbers(winning_number_line.trim(), bonus_number_line.trim());

    }

    public static void validateDrawnNumbers(String winning_number_line, String bonus_number_line) {
        if (!winning_number_line.matches("(\\d+,){5}\\d+")) {
            throw new IllegalArgumentException(WINNING_INPUT_FORMAT_ERROR.getMessage());
        }
        if (!bonus_number_line.matches("\\d+")) {
            throw new IllegalArgumentException(WINNING_INPUT_BONUS_ERROR.getMessage());
        }
//        List<Integer> winning_numbers = Arrays.stream(winning_number_line.split(",")).collect(Collectors.toList());
//        System.out.println(winning_numbers);
    }
}
