package lotto.view;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView {
    public int readInteger() {
        String inputText = Console.readLine();
        if(isNotInt(inputText)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        inputText = inputText.trim();
        return Integer.parseInt(inputText);
    }

    public List<Integer> readIntegers() {
        List<Integer> output = new ArrayList<>();

        String inputText = Console.readLine();
        if(isNotIntegerList(inputText)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        inputText = inputText.trim();
        String[] splitByComma = inputText.split(",");

        for(String piece: splitByComma) {
            output.add(Integer.parseInt(piece));
        }
        return output;
    }

    private boolean isNotInt(String input) {
        input = input.trim();
        return !input.matches("-?\\d+");
    }

    private boolean isNotIntegerList(String input) {
        input = input.trim();
        if(input.startsWith(",") || input.endsWith(",")) {
            return true;
        }

        String[] splitByComma = input.split(",");
        for (String piece : splitByComma) {
            piece = piece.trim();
            if(isNotInt(piece)) {
                return true;
            }
        }
        return false;
    }
}
