package lotto;

import java.util.HashSet;
import java.util.List;

public class Validator {

    public boolean isBetween1And45(Integer number) {
        return 1 <= number && number <= 45;
    }

    public boolean isContainDuplicateNumber(List<Integer> numbers) {
        return new HashSet(numbers).size() != numbers.size();
    }

    public boolean isAllDigit(String string) {
        return string.chars()
                .mapToObj(e -> (char) e)
                .allMatch(Character::isDigit);
    }

    public boolean isProperNumbersLineFormat(String string, String delimiter) {
        long count = string.chars()
                .mapToObj(e -> (char) e)
                .filter(e -> e.equals(delimiter.charAt(0)))
                .count();
        boolean validFormat = string.chars()
                .mapToObj(e -> (char) e)
                .allMatch(e -> Character.isDigit(e) || e.equals(delimiter.charAt(0)));
        return count == 5L && validFormat;
    }
}
