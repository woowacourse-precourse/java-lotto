package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Validators {
    private final static int LOTTERY_LENGTH = 6;
    private final static int RANGE_MIN = 1;
    private final static int RANGE_MAX = 45;

    private final static int PRICE_PER_LOTTERY = 1000;

    private final static Pattern REG_EXP = Pattern.compile("\\D+");
    private final static String DELIMITER = ",";

    private enum Exceptions {
        ONE("로또 번호는 1부터 45사이의 숫자여야 합니다."),
        TWO("구입금액은 1000으로 나누어 떨어지는 숫자여야 합니다."),
        THREE("당첨 번호는 쉼표로 구분된 6개의 숫자들이여야 합니다."),
        FOUR("보너스 번호는 당첨 번호에 없는 숫자여야 합니다.");

        private final String message;

        Exceptions(String message) {
            this.message = message;
        }

        public String getMessages() {
            return message;
        }
    }

    public static void validateBudget(String input) {
        if (!validateBudgetFormat(input) || !validateBudgetNumber(input)) {
            throw new IllegalArgumentException(Exceptions.TWO.getMessages());
        }
    }

    private static boolean validateBudgetFormat(String input) {
        boolean isValid = true;

        if (REG_EXP.matcher(input).find()) {
            isValid = false;
        }

        return isValid;
    }

    private static boolean validateBudgetNumber(String input) {
        boolean isValid = true;
        int budget = Integer.parseInt(input);

        if (budget % PRICE_PER_LOTTERY != 0) {
            isValid = false;
        }

        return isValid;
    }

    public static void validateJackpot(String jackpot) {
        if (!validateJackpotDelimiter(jackpot) || !validateJackpotType(jackpot)) {
            throw new IllegalArgumentException(Exceptions.THREE.getMessages());
        }
    }

    private static boolean validateJackpotDelimiter(String jackpot) {
        boolean isValid = true;

        if (!jackpot.contains(DELIMITER)) {
            isValid = false;
        }

        return isValid;
    }

    private static boolean validateJackpotType(String jackpot) {
        boolean isValid = true;
        List<String> jackpotParts = Arrays.asList(jackpot.split(DELIMITER));

        for (String jackpotPart : jackpotParts) {
            if (REG_EXP.matcher(jackpotPart).find()) {
                isValid = false;
            }
        }

        return isValid;
    }

    public static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTERY_LENGTH) {
            throw new IllegalArgumentException(Exceptions.THREE.getMessages());
        }
    }

    public static void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < RANGE_MIN || number > RANGE_MAX) {
                throw new IllegalArgumentException(Exceptions.ONE.getMessages());
            }
        }
    }

    public static void validateNumbersUniqueness(List<Integer> numbers) {
        for (int i=0; i<numbers.size()-1; i++) {
            if (numbers.get(i) == numbers.get(i+1)) {
                throw new IllegalArgumentException(Exceptions.THREE.getMessages());
            }
        }
    }

    public static void validateBonusType(String bonus) {
        if (REG_EXP.matcher(bonus).find()) {
            throw new IllegalArgumentException(Exceptions.ONE.getMessages());
        }
    }

    public static void validateBonus(int bonus, List<Integer> jackpotFigures) {
        validateBonusRange(bonus);

        validateBonusUniqueness(bonus, jackpotFigures);
    }

    private static void validateBonusRange(int bonus) {
        if (bonus < RANGE_MIN || bonus > RANGE_MAX) {
            throw new IllegalArgumentException(Exceptions.ONE.getMessages());
        }
    }

    private static void validateBonusUniqueness(int bonus, List<Integer> jackpotFigures) {
        for (Integer jackpotFigure : jackpotFigures) {
            if (jackpotFigure == bonus) {
                throw new IllegalArgumentException(Exceptions.FOUR.getMessages());
            }
        }
    }
}
