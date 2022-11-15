package lotto.view;

import lotto.message.Printer;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static int InputPrice() {
        System.out.println(Printer.START.getMessage());
        String input = readLine();
        IsNumber(input);
        return Integer.valueOf(input);
    }

    public static List<Integer> InputWinNumber() {
        System.out.println(Printer.WIN_NUMBER.getMessage());
        String input = readLine();
        IsNumber(input);
        List<Integer> inputs = List.of(input.split(",")).stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        return inputs;
    }

    public static int InputBonusNumber() {
        System.out.println(Printer.BONUS_NUMBER.getMessage());
        String input = readLine();
        OnlyOne(input);
        IsNumber(input);
        return Integer.valueOf(input);
    }

    private static void OnlyOne(String input) {
        if (input.contains(",") || input.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 1개 이상입니다.");
        }
    }

    private static void IsNumber(String input) {
        for (char charinput : input.toCharArray()) {
            if (Character.isDigit(charinput) == false) {
                throw new IllegalArgumentException("[ERROR] 입력에 숫자가 아닌 값이 있습니다.");
            }
        }
    }
}
