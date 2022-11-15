package lotto.validator;

public interface NumericValidator {

    default boolean isNumeric(final String target) {
        return target != null && !target.equals("") && target.chars().allMatch(Character::isDigit);
    }
}
