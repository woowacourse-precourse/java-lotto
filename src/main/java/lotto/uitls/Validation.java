package lotto.uitls;

public class Validation {

    public boolean hasNonDigitCharacter(String input) {
        return input.chars().allMatch(Character::isDigit);
    }
}
