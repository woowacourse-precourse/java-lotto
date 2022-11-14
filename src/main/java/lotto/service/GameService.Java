package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.utils.RewardType;


public class GameService {

    public static int winNum;
    public static boolean bonusNum;
    //당첨 내역 및 수익률 출력
    RewardType LottoReward ;
    public int winLotto(Lotto Lotto, User User){
        int count=0;
        for (int i = 0; i<6; i++){
            if (Lotto.contains(User.get_index(i))){
                count+=1;
            }
        }
        return count;
    }

    public int bonusLotto(Lotto Lotto, int bonusNum){
        int count =0;
        for (int i=0; i<6; i++){
            if (Lotto.contains(bonusNum)){
                count+=1;
            }
        }
        return count;
    }


}