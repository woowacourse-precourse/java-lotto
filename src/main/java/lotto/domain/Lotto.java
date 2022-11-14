package lotto.domain;

import lotto.setting.WinningEnum;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public WinningEnum getRank(List<Integer> lottoNumber, int correctCount){
        int correctNumberCount = countCorrectNumbers(lottoNumber);
        boolean isCorrectBonusNumber = isCorrectBonusNumber(correctCount);

        return WinningEnum.getWinning(correctNumberCount, isCorrectBonusNumber);
    }

    public int countCorrectNumbers(List<Integer> lottoNumbers){
        int correctNumber = 0;

        for(Integer bought: lottoNumbers){
            if(numbers.contains(bought)){
                correctNumber++;
            }
        }
        return correctNumber;
    }

    public boolean isCorrectBonusNumber(int correctCount){
        if(numbers.contains(correctCount)){
            return true;
        }
        return false;
    }
}
