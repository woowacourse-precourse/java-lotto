package lotto;

import java.util.List;

import static lotto.User.*;

public class Comparator {
    List<Integer> answerCount;
    boolean bonus = false;

    public void clearCount(){
        answerCount = List.of(0, 0, 0, 0, 0, 0);
        bonus = false;
    }

    public void compareWin(Lotto userLotto, Lotto answerLotto){
        compareLottoNumber(userLotto, answerLotto);
        compareBonusNumber(userLotto, answerLotto);
    }

    private void compareBonusNumber(Lotto userLotto, Lotto answerLotto) {
        if(userLotto.getNumbers().contains(answerLotto.getBonusNumber())){
            bonus = true;
        }
    }

    private void compareLottoNumber(Lotto userLotto, Lotto answerLotto) {
        for(int i=0; i<LOTTO_LEN; i++){
            if(userLotto.getNumbers().get(i).equals(answerLotto.getNumbers().get(0))){
                answerCount.set(i, 1);
            }
        }
    }

}
