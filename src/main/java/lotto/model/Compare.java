package lotto.model;

import lotto.model.enumeration.Exception;

import java.util.List;

public class Compare {

    public int[] getResult(int inputMoney, List<List<Integer>> computerRandomNumbers, List<Integer> lottoNumbers, int bonusNumber ) {
        validate(lottoNumbers, bonusNumber);
        int[] result = new int[5];
        int count;

        for (int i = 0; i < (inputMoney/1000) ; i++) {
            count = 0;
            count = getContainingNumber(computerRandomNumbers, lottoNumbers, count, i);

            reflectCountforResult(computerRandomNumbers, bonusNumber, result, count, i);
        }
        return result;
    }

    public int getContainingNumber(List<List<Integer>> computerRandomNumbers, List<Integer> lottoNumbers, int count, int i) {
        for (int j = 0; j < 6 ; j++) {
            if (computerRandomNumbers.get(i).contains(lottoNumbers.get(j))) count++;
        }
        return count;
    }

    private void reflectCountforResult(List<List<Integer>> computerRandomNumbers, int bonusNumber, int[] result, int count, int i) {
        if (count == 3) result[0]++;
        if (count == 4) result[1]++;
        if (count == 5) {
            if (computerRandomNumbers.get(i).contains(bonusNumber)) {
                result[3]++;
            }
            result[2]++;
        }
        if (count == 6) result[4]++;
    }

    private void validate(List<Integer> lottoNumbers, int bonusNumber) {
        validateLength(lottoNumbers);
        validateRange(lottoNumbers, bonusNumber);
        validateDuplication(lottoNumbers);
        validateDuplicationInBonus(lottoNumbers, bonusNumber);
    }

    public void validateLength(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(Exception.INVALID_LOTTO_NUMBER_COUNT.getExceptionMessage());
        }
    }

    public void validateRange(List<Integer> lottoNumbers, int bonusNumber) {
        for (Integer lottoNumber: lottoNumbers) {
            if (lottoNumber < 1 || lottoNumber > 45) {
                throw new IllegalArgumentException(Exception.INVALID_LOTTO_NUMBER_RANGE.getExceptionMessage());
            }
        }

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(Exception.INVALID_BONUS_NUMBER_RANGE.getExceptionMessage());
        }
    }

    public void validateDuplication(List<Integer> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            List<Integer> subNumbers = lottoNumbers.subList(i+1, lottoNumbers.size());
            int lottonumber = lottoNumbers.get(i);
            if (subNumbers.contains(lottonumber)) {
                throw new IllegalArgumentException(Exception.INVALID_LOTTO_NUMBER_DUPLICATION.getExceptionMessage());
            }
        }
    }

    public void validateDuplicationInBonus(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Exception.INVALID_BONUS_NUMBER_DUPLICATION.getExceptionMessage());
        }
    }
}
