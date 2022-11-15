package lotto;

public class WinningLotto extends Lotto {
    public static final String PARSER = ",";
    private Integer bonusNumber;

    public WinningLotto(String userInput) {
        super(Converter.StringToListInteger(userInput, PARSER));
    }

    public void setBonusNumber(String userInput) {
        Integer bonusNumber = Converter.StringToInteger(userInput);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (!isValidateRange(bonusNumber)) {
            String message = Error.getErrorMessage(Error.Messages.LOTTO_NUMBER_RANGE_ERROR);
            throw new IllegalArgumentException(message);
        }
        if (!isValidateUnique(bonusNumber)) {
            String message = Error.getErrorMessage(Error.Messages.LOTTO_NUMBER_UNIQUE_ERROR);
            throw new IllegalArgumentException(message);
        }
    }

    public boolean isValidateUnique(Integer bonusNumber) {
        return !this.getNumbers().contains(bonusNumber);
    }

}
