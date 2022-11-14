package lotto.vo;

public class LottoPurchaseInfo {

    private final int LOTTO_PRICE = 1000;

    private final int lottoPrice;
    private final int lottoGameCount;

    public LottoPurchaseInfo(String lottoPrice) {
        validateInput(lottoPrice);
        int inputMoney = ConvertStringtoInteger(lottoPrice);
        this.lottoPrice = inputMoney;
        this.lottoGameCount = inputMoney / LOTTO_PRICE;
    }

    public int getLottoPrice() {
        return lottoPrice;
    }

    public int getLottoGameCount() {
        return lottoGameCount;
    }

    private void validateInput(String lottoPrice) {
        if (ConvertStringtoInteger(lottoPrice) % LOTTO_PRICE > 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입은 1,000원 단위로 입력해 주세요");
        } else if (!validateInputIsDigit(lottoPrice)) {
            throw new IllegalArgumentException("[ERROR] 올바른 금액을 입력해주세요.");
        }
    }

    private boolean validateInputIsDigit(String lottoPrice) {
        return lottoPrice.chars().allMatch(Character::isDigit);
    }

    public int ConvertStringtoInteger(String input) {
        return Integer.parseInt(input);
    }


}
