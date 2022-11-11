package view;

import java.util.Arrays;
import java.util.HashSet;

public class Valid {
    private static final int unitPrice = 1000;

    public static boolean isNotMultiple(int price) {
        boolean isNotMultiple = false;
        if(price % unitPrice != 0) {
            isNotMultiple = true;
        }
        return isNotMultiple;
    }

    public static boolean hasRepeatNumber(String[] answer) {
        boolean hasRepeatNumber = false;
        HashSet<String> answerSet = new HashSet<>(Arrays.asList(answer));
        if (answer.length - answerSet.size() != 0) {
            hasRepeatNumber = true;
        }
        return hasRepeatNumber;
    }

    public static boolean isOverRange(String[] answer) {
        boolean answerOverRange = false;
        for (String s : answer) {
            int number = Integer.parseInt(s);
            if(number < 1 || number > 45) {
                answerOverRange = true;
            }
        }
        return answerOverRange;
    }

    public static boolean enterNumberOverLength(String[] answer) {
        boolean overLength = false;
        if (answer.length != 6) {
            overLength = true;
        }
        return overLength;
    }

    public static boolean checkValidAnswer(String[] enterAnswer) {
        boolean isValid = false;
        if (hasRepeatNumber(enterAnswer) || enterNumberOverLength(enterAnswer)
                || isOverRange(enterAnswer)) {
            isValid = true;
        }
        return isValid;
    }

    public static boolean numberOverLength(String bonus) {
        boolean overLength = false;
        if (bonus.length() != 1) {
            overLength = true;
        }
        return overLength;
    }

    public static boolean isRepeatWithAnswer(String bonus, String[] answer) {
        boolean isRepeat = false;
        for (int i = 0; i < answer.length; i++) {
            if (bonus == answer[i]) {
                isRepeat = true;
            }
        }
        return isRepeat;
    }

    public static boolean isOverRangeValue(String bonus) {
        boolean overRange = false;
        if(Integer.parseInt(bonus) < 1 || Integer.parseInt(bonus) > 45) {
            overRange = true;
        }
        return overRange;
    }

    public static boolean checkValidBonus(String bonus, String[] answer) {
        boolean isValid = false;
        if (numberOverLength(bonus) || isRepeatWithAnswer(bonus, answer)
                || isOverRangeValue(bonus)) {
            isValid = true;
        }
        return isValid;
    }
}
