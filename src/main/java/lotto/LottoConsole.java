package lotto;

public class LottoConsole {
    public LottoConsole() {
        Input input = new Input();
        Output output = new Output();
        Validator validator = new Validator();
    }

    public Integer getPurchaseAmount() {
        String purchaseAmount = input.getPurchaseAmount();
        return validator.getPurchaseAmountAfterValidation(purchaseAmount);
    }

    public Integer getWinningLottoNumbers() {
        String winningLottoNumbers = input.getWinningLottoNumbers();
        return validator.getWinningLottoNumbersAfterValidation(winningLottoNumbers);
    }

    public Integer getBonusLottoNumber() {
        String bonusLottoNumber = input.getBonusLottoNumber();
        return validator.getBonusLottoNumberAfterValidation(bonusLottoNumber);
    }
}
