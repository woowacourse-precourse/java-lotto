package lotto.model;

public class User {
    private int purchaseAmount;
    private static final int LOTTO_PRICE = 1000;

    public User(String purchaseAmount){
        validate(purchaseAmount);
        this.purchaseAmount = Integer.parseInt(purchaseAmount);
    }

    private void validate(String purchaseAmount){
        validateNumeric(purchaseAmount);
        validateOverThousand(purchaseAmount);
        validateUnit(purchaseAmount);
    }

    private void validateNumeric(String purchaseAmount){
        boolean isNumeric = purchaseAmount.chars().allMatch(Character::isDigit);
        if (!isNumeric){
            throw new IllegalArgumentException("[ERROR] 구입 금액으로 숫자만 입력해야 합니다.");
        }
    }

    private void validateOverThousand(String purchaseAmount){
        if (Integer.parseInt(purchaseAmount) < LOTTO_PRICE){
            throw new IllegalArgumentException("[ERROR] 최소 1,000원 이상의 금액을 입력해야 합니다.");
        }
    }

    private void validateUnit(String purchaseAmount){
        if (Integer.parseInt(purchaseAmount) % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
