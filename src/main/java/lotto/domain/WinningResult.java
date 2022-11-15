package lotto.domain;

import java.util.HashMap;

public class WinningResult {
    private static final int DEFAULT_CORRECT=0;
    private static final int BONUS_CHECK_COUNT=5;
    private HashMap<Result, Integer> result;

    public WinningResult(){
        HashMap<Result, Integer> result=new HashMap<>();
        for(Result value : Result.values()){
            result.put(value, DEFAULT_CORRECT);
        }
        this.result=result;
    }
    public void calcCorrectCountLottos(UserLotto lottos, WinningLotto winningLotto){
        for(Lotto lotto : lottos.getLottos()){
            int correctCnt=calcCorrectLotto(lotto, winningLotto);
            boolean correctBonus=isCorrectBonus(correctCnt, lotto, winningLotto);
        }
    }
    public int calcCorrectLotto(Lotto lotto, WinningLotto winningLotto){
        int count=0;
        for(Integer number : lotto.getLotto()){
            if(winningLotto.getLottoNumbers().contains(number)){
                count++;
            }
        }
        return count;
    }
    public boolean isCorrectBonus(int correctCnt, Lotto lotto, WinningLotto winningLotto){
        if(correctCnt==BONUS_CHECK_COUNT){
            return lotto.getLotto().contains(winningLotto.getBonus());
        }
        return false;
    }
}
