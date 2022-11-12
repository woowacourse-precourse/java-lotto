package lotto.domain;

import java.util.List;

public class LottoProcess {
    private final List<List<Integer>> lottos;
    private final List<Integer>winningNumbers;
    private final int bonusNumber;

    public LottoProcess(List<List<Integer>> lottos, List<Integer> winningNumbers,int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers=winningNumbers;
        this.bonusNumber=bonusNumber;
    }

    public int compareWinningNumbers(List<Integer> lotto, List<Integer> winningNumbers){
        int countMachingNumber=0;

        for(int number : lotto){
            if(winningNumbers.contains(number)) countMachingNumber++;
        }

        return countMachingNumber;
    }

}
