package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.OutputView.*;

public class InputView {

    public static int readInputMoney() {

        System.out.println(getReadInputMessage());
        return convertStrToInt(Console.readLine());
    }

    public static Lotto readWinningNumbers() {

        System.out.println(getReadWinningNumbersMessage());
        String winningNumberInput = Console.readLine();

        List<Integer> winningNumbers = convertStrToIntList(winningNumberInput);

        return new Lotto(winningNumbers);
    }

    public static int readBonusNumber() {

        System.out.println(getReadBonusNumberMessage());
        return convertStrToInt(Console.readLine());
    }

    public static int convertStrToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자여야 합니다");
        }
    }

    public static List<Integer> convertStrToIntList(String input) {

        List<Integer> integers = new ArrayList<>();

        try {
            String[] splitInput = input.split(",");
            for(String i : splitInput)
                integers.add(convertStrToInt(i));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] Winning number error");
        }
        return integers;
    }

}
