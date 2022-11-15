package lotto;

import java.util.List;

public class WinningResult {

    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    public WinningResult() {

        this.first = 0;
        this.second = 0;
        this.third = 0;
        this.fourth = 0;
        this.fifth = 0;

    }

    public void compareLotto(List<Lotto> lottos,List<Integer> lotto,int bonus_number){

        for(int i=0;i<lottos.size();i++){
            int cnt=0;
            cnt+=lottos.get(i).rightNumberCheck(lotto);
            cnt+=lottos.get(i).rightBonusNumberCheck(bonus_number);
            winnigRank(cnt);
        }
    }

    public void winnigRank(int cnt){
        if(cnt==6) first++;
        if(cnt==15)second++;
        if(cnt==5)third++;
        if(cnt==4)fourth++;
        if(cnt==3)fifth++;
    }

    



}
