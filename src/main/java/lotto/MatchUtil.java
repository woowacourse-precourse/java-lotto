package lotto;

import java.util.List;

public class MatchUtil {
    private int cnt,length=Constant.LOTTO_SIZE;
    public int matchWinningNumber(List<Integer> lotto, List<Integer> userNum){
        cnt = 0;
        for(int i=0;i<length;i++){
            if(lotto.get(i).equals(userNum.get(i))){
                cnt++;
            }
        }
        return cnt;
    }

    public int matchBonusNumber(List<Integer> lotto, int bonusNum){
        cnt = 0;
        for(int i=0;i<length;i++){
            if(lotto.get(i).equals(bonusNum)){
                cnt++;
            }
        }
        return cnt;
    }
}
