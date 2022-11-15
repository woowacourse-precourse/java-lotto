package lotto.domain;

import lotto.model.*;
import java.util.Map;

public class Controller {
    private User user;
    private WinningLotto winLotto;
    private Map<Prize,Integer> winResult;
    private long winnings;

    Setting setting;
    Result result;

    public Controller(){
        setting=new Setting();
    }
    public void setUserLotto(){
        user=setting.userLotto();
    }

    public void setWinningLotto(){
        winLotto=setting.winningLotto();
    }

    public void calculateResult(){
        result=new Result(user,winLotto);
        winResult=result.prizeLotto();
        winnings=result.calculateWinnings();
    }

    public void printResult(){
        printAllPrizeNumber();
        printYield();
    }
    private void printAllPrizeNumber(){
        for(Prize prize:Prize.values()){
            System.out.println(prize.getPrintCondition()+" ("+prize.getPrintWinMoney()+"원) - "+winResult.get(prize)+"개");
        }
    }

    private void printYield(){
        double yield=calculateYield();
        System.out.println("총 수익률은 "+String.format("%.1f",yield)+"%입니다.");
    }

    private double calculateYield(){
        double money=Double.parseDouble(user.getMoney());
        return winnings/money*100;
    }
}
