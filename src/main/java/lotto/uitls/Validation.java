package lotto.uitls;

public class Validation {
    private static final int LOTTO_PRICE = 1_000;

    public boolean hasNonDigitCharacter(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    public boolean isDividedByLottoPrice(int purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE == 0;
    }

    public boolean isPossiblePrice(int purchaseAmount) {
        return purchaseAmount > 0;
    }
}
