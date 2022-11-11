package lotto.uitls;

public class Validation {
    private static final int LOTTO_PRICE = 1_000;

    public void validateLottoPurchaseAmount(String purchaseAmount) {
        if (hasNonDigitCharacter(purchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액에는 숫자 외의 문자가 포함될 수 없습니다.");
        }
        if (!isDividedByLottoPrice(purchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로만 구매할 수 있습니다.");
        }
        if (!isPossiblePrice(purchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 0원 이하의 금액은 입력할 수 없습니다.");
        }
    }

    public boolean hasNonDigitCharacter(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    public boolean isDividedByLottoPrice(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) % LOTTO_PRICE == 0;
    }

    public boolean isPossiblePrice(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) > 0;
    }
}
