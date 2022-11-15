package lotto.domain;

import java.util.HashSet;
import java.util.List;

import static lotto.message.ErrorMessage.*;
import static lotto.instance.Setting.*;

public class Validation {

    public static void validNumber(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER);
        } catch (Exception e) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }
    }

    public static void validPurchase(int input) throws IllegalArgumentException {
        if (input % BASIC_AMOUNT != 0) {
            throw new IllegalArgumentException(CANNOT_DIVIDE_BY_BASIC_AMOUNT);
        }
    }

    public static void validWinning6Numbers(String[] split) throws IllegalArgumentException {
        if (split.length != NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException(CANNOT_SEPARATE);
        }
    }

    public static void validWinningRepetition(String[] split) throws IllegalArgumentException {
        HashSet<String> removeDuplication = new HashSet<>(List.of(split));
        if (removeDuplication.size() != NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException(REPETITION_WINNING);
        }
    }

    public static void validBonusRepetition(int bonus, List<Integer> winning) throws IllegalArgumentException {
        if (winning.contains(bonus)) {
            throw new IllegalArgumentException(REPETITION_BONUS);
        }
    }

    public static void validRange(int number) throws IllegalArgumentException {
        if ((number < START_RANGE) || (number > END_RANGE)) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }
//이름 바꾸기
    public static void validRange(List<Integer> numbers) throws IllegalArgumentException {
        for (int number : numbers) {
            if ((number < START_RANGE) || (number > END_RANGE)) {
                throw new IllegalArgumentException(OUT_OF_RANGE);
            }
        }
    }

    public static void noDuplication(List<Integer> numbers) {
        HashSet<Integer> removeDuplication = new HashSet<>(numbers);
        if (removeDuplication.size() != numbers.size()) {
            throw new IllegalArgumentException(REPETITION_LOTTO_NUMBERS);
        }
    }

    public static void inRange(List<Integer> numbers){
        if (numbers.size() != NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException(TOO_MUCH_NUMBERS);
        }
    }
}
