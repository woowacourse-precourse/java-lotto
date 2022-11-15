package lotto;

import java.util.List;

public class WinningResult {

    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;
    private View view;

    public WinningResult(View view) {

        this.first = 0;
        this.second = 0;
        this.third = 0;
        this.fourth = 0;
        this.fifth = 0;

        this.view= view;

    }

    public void compareLotto(List<Lotto> lottos,List<Integer> lotto,int bonus_number){

        for(int i=0;i<lottos.size();i++){
            int cnt=0;
            cnt+=lottos.get(i).rightNumberCheck(lotto);
            cnt+=lottos.get(i).rightBonusNumberCheck(bonus_number);
            winningRank(cnt);
        }
    }

    public void winningRank(int cnt){
        if(cnt==6) first++;
        if(cnt==15)second++;
        if(cnt==5)third++;
        if(cnt==4)fourth++;
        if(cnt==3)fifth++;
    }

    public void showWinningResult(){
        view.showMessage("---");
        view.showMessage("3개 일치 (5,000원) - "+fifth+"개");
        view.showMessage("4개 일치 (50,000원) - "+fourth+"개");
        view.showMessage("5개 일치 (1,500,000원) - "+third+"개");
        view.showMessage("5개 일치, 보너스 볼 일치 (30,000,000원) - "+second+"개");
        view.showMessage("6개 일치 (2,000,000,000원) - "+first+"개");

        //showYield();
    }





}
