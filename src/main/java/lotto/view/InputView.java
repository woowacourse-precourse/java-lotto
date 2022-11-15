package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static lotto.domain.Preset.ERROR_FORMAT_MESSAGE;
import static lotto.domain.Preset.INPUT_REGEX;
import static lotto.view.OutputView.*;

public class InputView {

    public static int readInputMoney() {
        System.out.println(READ_INPUT_MESSAGE);

        try {
            return convertStrToInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new NoSuchElementException();
        }
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println(READ_WINNING_NUMBERS_MESSAGE);

        try {
            return convertStrToIntList(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new NoSuchElementException();
        }
    }

    public static int readBonusNumber() {
        System.out.println(READ_BONUS_NUMBER_MESSAGE);

        try {
            return convertStrToInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new NoSuchElementException();
        }
    }

    public static int convertStrToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_FORMAT_MESSAGE);
        }
    }

    public static List<Integer> convertStrToIntList(String input) {
        List<Integer> integers = new ArrayList<>();

        try {
            String[] splitInput = input.split(INPUT_REGEX);
            for (String word : splitInput)
                integers.add(convertStrToInt(word));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_FORMAT_MESSAGE);
        }

        return integers;
    }

}
