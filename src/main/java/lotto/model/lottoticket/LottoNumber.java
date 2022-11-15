package lotto.model.lottoticket;

import lotto.model.exception.InputException;

import lotto.view.ErrorMessages;

public class LottoNumber {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private final int lottoNumber;

    public LottoNumber(String input) {
        String trimmedInput = input.trim();

        validateLottoNumber(trimmedInput);

        this.lottoNumber = Integer.parseInt(trimmedInput);
    }

    private void validateLottoNumber(String input) {
        try {
            validateLottoNumberRange(input);
        } catch (NumberFormatException nE) {
            try {
                throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER.getErrorMessage());
            } catch (IllegalArgumentException e) {
                throw new InputException(e.getMessage());
            }
        }
    }

    private void validateLottoNumberRange(String input) {
        int castingLottoNumber = Integer.parseInt(input);

        if (castingLottoNumber < START_INCLUSIVE || END_INCLUSIVE < castingLottoNumber) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_RANGE.getErrorMessage());
        }
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }

    @Override
    public String toString() {
        return Integer.toString(this.lottoNumber);
    }

}
