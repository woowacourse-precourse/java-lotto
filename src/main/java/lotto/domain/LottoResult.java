package lotto.domain;

import java.util.List;

public class LottoResult {
    public LottoProperties lotteryCheck(Lotto currentLotto,Lotto awardLotto, int bonusNumber){
        int correct = numberCheck(currentLotto,awardLotto);
        LottoProperties lottoProperties = LottoProperties.findType(correct);
        if (lottoProperties == LottoProperties.LOTTO_THIRDWINNER && isBonusCorrect(currentLotto.getNumbers(),bonusNumber)){
            lottoProperties = LottoProperties.LOTTO_SECONDWINNER;
        }
        return lottoProperties;
    }
    public int numberCheck(Lotto currentLotto,Lotto awardLotto){
        int correct = 0;
        int i =0;
        int j =0;
        while (i<currentLotto.getNumbers().size() && j<awardLotto.getNumbers().size()) {
            if (currentLotto.getNumbers().get(i) == awardLotto.getNumbers().get(j)) {
                correct++;
                i++;
                j++;
                continue;
            }
            if (currentLotto.getNumbers().get(i) < awardLotto.getNumbers().get(j)) {
                i++;
                continue;
            }
            if (currentLotto.getNumbers().get(i) > awardLotto.getNumbers().get(j)) {
                j++;
                continue;
            }
        }
        return correct;
    }
    public Boolean isBonusCorrect(List<Integer> numbers, int bonusNumber){
        for(int i =0;i<numbers.size();i++){
            if (bonusNumber==numbers.get(i)){
                return true;
            }
        }
        return false;
    }
}
