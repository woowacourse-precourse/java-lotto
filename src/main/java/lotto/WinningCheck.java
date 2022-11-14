package lotto;

import java.util.List;

public class WinningCheck {

    List<Lotto> lottoList;
    List<Integer> winningNumbers;
    int bonusNumber;

    public WinningCheck(List<Lotto> lottList, List<Integer> winningNumbers, int bonusNumber) {
        this.lottoList = lottList;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void winningCheck() {
        for(Lotto lotto : lottoList) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int matchCount = getMathCount(lottoNumbers);
        }
    }

    public int getMathCount(List<Integer> lottoNumbers) {
        int count = 0;
        for(int lottoNum : lottoNumbers) {
            if(winningNumbers.contains(lottoNum))
                count += 1;
        }
        return count;
    }

}
