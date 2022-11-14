package lotto.domain.entity;

import static lotto.common.message.ExceptionMessage.BONUS_NUMBER_DUPLICATION_MESSAGE;
import static lotto.common.message.ExceptionMessage.ERROR_CODE;
import static lotto.common.message.ExceptionMessage.LOTTO_NUMBER_NOT_IS_DIGIT;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    private Lotto lottoNumbers;
    private int bonusNumber;

    private LottoMachine(String[] lottoNumbersArray, int bonusNumber) {
        lottoNumbersArrayValidation(lottoNumbersArray);
        List<Integer> numbers = ArrayToLottoNumbers(lottoNumbersArray);
        Collections.sort(numbers);
        this.lottoNumbers = new Lotto(numbers);

        bonusNumberValidation(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static LottoMachine of(String[] lottoNumbersArray, int bonusNumber) {
        return new LottoMachine(lottoNumbersArray, bonusNumber);
    }

    public int currentBonusNumber() {
        return bonusNumber;
    }

    public Lotto currentMachineNumbers() {
        return lottoNumbers;
    }

    private List<Integer> ArrayToLottoNumbers(String[] lottoNumbersArray) {
        return Arrays.asList(lottoNumbersArray).stream().map(s -> Integer.parseInt(s)).collect(
            Collectors.toList());
    }

    private void lottoNumbersArrayValidation(String[] lottoNumbersArray) {
        for (String element : lottoNumbersArray) {
            char[] chars = element.toCharArray();
            eachLottoNumberValidation(chars);
        }
    }

    private void eachLottoNumberValidation(char[] chars) {
        for (char aChar : chars) {
            if (!Character.isDigit(aChar)) {
                throw new IllegalArgumentException(LOTTO_NUMBER_NOT_IS_DIGIT);
            }
        }
    }

    private void bonusNumberValidation(int bonusNumber) {
        if (lottoNumbers.currentLottoNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(
                ERROR_CODE + BONUS_NUMBER_DUPLICATION_MESSAGE);
        }
    }
}
