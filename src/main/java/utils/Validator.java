package utils;

import java.util.Collection;
import java.util.Set;

public class Validator {

    public static class StringValidator {
        public static boolean isNumeric(String word) {
            return word.chars()
                    .allMatch(Character::isDigit);
        }

        public static boolean matchesPattern(String word, String pattern) {
            return word.matches(pattern);
        }
    }

    public static class IntegerValidator {
        public static boolean isDivisibleBy(int dividend, int divisor) {
            return dividend % divisor == 0;
        }

        public static boolean isInBetween(int number, int leftBound, int rightBound) {
            return leftBound <= number && number <= rightBound;
        }
    }

    public static class CollectionValidator {
        public static boolean hasSizeOf(Collection collection, int size) {
            return collection.size() == size;
        }

        public static boolean hasUniqueElementsOnly(Collection collection) {
            return collection.size() == Set.copyOf(collection).size();
        }
    }
}
