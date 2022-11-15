package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static lotto.domain.Preset.*;
import static lotto.view.OutputView.*;

public class InputView {

    public static int readInputMoney() {
        System.out.println(READ_INPUT_MESSAGE);

        int inputMoney;
        try {
            inputMoney = convertStrToInt(Console.readLine());
            validateInputMoney(inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new NoSuchElementException();
        }
        return inputMoney;
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println(LINE_FEED + READ_WINNING_NUMBERS_MESSAGE);

        try {
            return convertStrToIntList(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new NoSuchElementException();
        }
    }

    public static int readBonusNumber() {
        System.out.println(LINE_FEED + READ_BONUS_NUMBER_MESSAGE);

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
            for (String word : splitInput) {
                int number = convertStrToInt(word);
                validateLottoNumber(number);
                integers.add(number);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_WINNING_MESSAGE);
        }

        return integers;
    }

    public static void validateInputMoney(int money) {
        checkOverThousand(money);
        checkModuloThousand(money);
    }

    public static void validateLottoNumber(int number) {
        if (number < LOTTO_MIN_VALUE || number > LOTTO_MAX_VALUE)
            throw new IllegalArgumentException(ERROR_FORMAT_MESSAGE);
    }

    public static void checkOverThousand(int money) {
        if (money < LOTTO_PRICE)
            throw new IllegalArgumentException(ERROR_FORMAT_MESSAGE);
    }

    public static void checkModuloThousand(int money) {
        if (money % LOTTO_PRICE != 0)
            throw new IllegalArgumentException(ERROR_FORMAT_MESSAGE);
    }
}
