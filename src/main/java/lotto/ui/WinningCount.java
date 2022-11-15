package lotto.ui;

import lotto.domain.Winning;

public class WinningCount {
    private static int FIRST;
    private static int SECOND;
    private static int THIRD;
    private static int FOURTH;
    private static int FIFTH;

    public void init(){
        FIRST=0;
        SECOND=1;
        THIRD=2;
        FOURTH=3;
        FIFTH=4;
    }

    public int count(int match, boolean bonus){
        //System.out.println(match);
        if (match==6){
            return FIRST;
        }
        if (match==5) {
            if (bonus) {
                return SECOND;
            }
            return THIRD;
        }
        if (match==4){
            return FOURTH;
        }
        if (match==3){
            return FIFTH;
        }
        return -1;
    }
}

