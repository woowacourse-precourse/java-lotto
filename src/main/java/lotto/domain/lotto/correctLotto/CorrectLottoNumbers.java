package lotto.domain.lotto.correctLotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.util.Validate;

import java.util.List;

public class CorrectLottoNumbers {
    private final String WARM = "[ERROR] ";
    private final String WARM_CORRECT_LOTTO_NUMBERS_SIZE = WARM + "로또 당첨 번호는 7개이어야 합니다.";
    private final int CORRECT_LOTTO_NUMBER_SIZE = 7;
    private final int BONUS_INDEX = 6;
    private final int COUNT_INITIAL_VALUE = 0;
    private final int COUNT_BRANCH_VALUE = 6;


    private final List<LottoNumber> correctLottoNumbers;

    private final LottoNumber bonusNumber;

    public CorrectLottoNumbers(List<LottoNumber> correctLottoNumbers) {
        validate(correctLottoNumbers);
        checkDuplicatedNumber(correctLottoNumbers);
        this.correctLottoNumbers = correctLottoNumbers;
        this.bonusNumber = correctLottoNumbers.get(BONUS_INDEX);
    }

    private void validate(List<LottoNumber> numbers) {
        Validate.validateSize(numbers, WARM_CORRECT_LOTTO_NUMBERS_SIZE,
                (lottoNumbers) -> lottoNumbers.size() != CORRECT_LOTTO_NUMBER_SIZE);
    }

    private void checkDuplicatedNumber(List<LottoNumber> lottoNumbers) {
        Validate.validateDuplicateNumber(lottoNumbers,
                (baseSize, compareLottoNumbers) -> baseSize != compareLottoNumbers.size());
    }

    public Ranking compareLottoNumber(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int count = COUNT_INITIAL_VALUE;
        boolean isContainBonus = false;

        for (Integer lottoNumberValue : lottoNumbers) {
            LottoNumber lottoNumber = new LottoNumber(lottoNumberValue);
            count = isContainCorrectNumber(count, lottoNumber);
        }

        if (count == COUNT_BRANCH_VALUE) {
            isContainBonus = this.isContainBonus(lottoNumbers);
        }

        return Ranking.makeRanking(count, isContainBonus);
    }

    private int isContainCorrectNumber(int count, LottoNumber lottoNumber) {
        List<LottoNumber> baseCorrectLottoNumbers = this.correctLottoNumbers;
        if (baseCorrectLottoNumbers.contains(lottoNumber)) {
            count++;
        }
        return count;
    }

    private boolean isContainBonus(List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(this.bonusNumber.getLottoNumber())) {
            return true;
        }
        return false;
    }
}