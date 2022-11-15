package lotto.domain.myLotto;

import lotto.exception.LottoException;
import lotto.setting.Setting;
import lotto.setting.WinningEnum;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public WinningEnum getRank(List<Integer> lottoNumber, int correctCount){
        int correctNumberCount = countCorrectNumbers(lottoNumber);
        boolean isCorrectBonusNumber = isCorrectBonusNumber(correctCount);

        return WinningEnum.getWinning(correctNumberCount, isCorrectBonusNumber);
    }

    private int countCorrectNumbers(List<Integer> lottoNumbers){
        int correctNumber = 0;

        for(Integer bought: lottoNumbers){
            if(numbers.contains(bought)){
                correctNumber++;
            }
        }
        return correctNumber;
    }

    private boolean isCorrectBonusNumber(int correctCount){
        if(numbers.contains(correctCount)){
            return true;
        }
        return false;
    }

    private void validate(List<Integer> numbers) {
        validateInputLottoNumberIsTotal(numbers);
        validateInputNumberIsBetween(numbers);
        validateInputNumberHaveSame(numbers);
    }

    private void validateInputLottoNumberIsTotal(List<Integer> numbers){
        if (numbers.size() != Setting.LOTTO_PICK_NUMBER) {
            throw new LottoException(Setting.LOTTO_PICK_NUMBER+"개의 로또 번호를 입력해야합니다.");
        }
    }

    private void validateInputNumberIsBetween(List<Integer> numbers){
        for(Integer number : numbers){
            validateInputNumberIsBetween(number);
        }
    }

    private void validateInputNumberIsBetween(int number){
        if(number < Setting.LOTTO_MIN_NUMBER || number > Setting.LOTTO_MAX_NUMBER){
            throw new LottoException("번호는 "+Setting.LOTTO_MIN_NUMBER+"부터 "+ Setting.LOTTO_MAX_NUMBER +" 사이의 숫자여야 합니다.");
        }
    }

    private void validateInputNumberHaveSame(List<Integer> numbers){
        List<Integer> tmp = new ArrayList<>();
        for(Integer number : numbers){
            if(tmp.contains(number)) {
                throw new LottoException("중복된 숫자는 사용할 수 없습니다.");
            }
            else {
                tmp.add(number);
            }
        }
    }
}
