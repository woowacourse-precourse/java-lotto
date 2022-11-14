package lotto.domain;

import static lotto.domain.Rank.*;

public class Calculator {
    private int answerCount = 0;
    private boolean bonus = false;

    public void clearCount(){
        answerCount = 0;
        bonus = false;
    }

    public void checkCount(Lotto userLotto, LottoAnswer lottoAnswer){
        compareLottoNumber(userLotto, lottoAnswer);
        compareBonusNumber(userLotto, lottoAnswer);
    }

    private void compareBonusNumber(Lotto userLotto, LottoAnswer lottoAnswer) {
        if(userLotto.getNumbers().contains(lottoAnswer.getBonusNumber())){
            bonus = true;
        }
    }

    private void compareLottoNumber(Lotto userLotto, LottoAnswer lottoAnswer) {
        for(int i=0; i<LOTTO_LEN.value(); i++){
            if(lottoAnswer.getNumbers().contains(userLotto.getNumbers().get(i))){
                answerCount += 1;
            }
        }
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public boolean isBonus() {
        return bonus;
    }
}
