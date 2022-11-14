package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Problem {
    WinningLotto winningLotto;
    User user;
    Map<Prize,Integer> winResult;
    long winMoney;

    Problem(){
        winMoney=0;
        initializeWinResult();
    }
    void initializeWinResult(){
        winResult=new EnumMap<Prize, Integer>(Prize.class);

        for(Prize prize:Prize.values()){
            winResult.put(prize,0);
        }
    }

    void startProblem(){
        Setting setting=new Setting();
        user=setting.userLotto();
        winningLotto=setting.winningLotto();
        findResult();
        calculateResult();
        printAnswer();
    }

    private void findResult(){
        for(Lotto lotto:user.lottos){
            checkPrize(lotto);
        }
    }

    void checkPrize(Lotto lotto){
        Set<Integer> userNumbers=new HashSet<>(lotto.getNumbers());
        Set<Integer> winningNumbers=new HashSet<>(this.winningLotto.getNumbers());

        userNumbers.retainAll(winningNumbers);
        int winCount=userNumbers.size();

        if(winCount>=3){
            winPrize(winCount,lotto);
        }
    }

    void winPrize(int winCount,Lotto lotto){
        Prize win=null;
        if(winCount==6){
            win=Prize.FIRST;
        }
        else if(winCount==5){
            win=checkWinBonus(lotto);
        }
        else if(winCount==4){
            win=Prize.FOURTH;
        }
        else if(winCount==3){
            win=Prize.FIFTH;
        }
        addPrizeResult(win);
    }

    Prize checkWinBonus(Lotto lotto){
        Prize win=Prize.THIRD;
        if(lotto.getNumbers().contains(winningLotto.bonusNumber)){
            win=Prize.SECOND;
        }
        return win;
    }
    void addPrizeResult(Prize win){
        winResult.put(win,winResult.get(win)+1);
    }

    void calculateResult(){
        for(Prize key:winResult.keySet()){
            winMoney+=(key.getWinMoney()*winResult.get(key));
        }
    }

    void printAnswer(){
        Comment.startPrintAnswer();
        printAllPrizeNumber();
        printYield();
    }

    void printAllPrizeNumber(){
        for(Prize prize:Prize.values()){
            System.out.println(prize.getPrintCondition()+" ("+prize.getPrintWinMoney()+"원) - "+winResult.get(prize)+"개");
        }
    }

    void printYield(){
        double yield=calculateYield();
        System.out.println("총 수익률은 "+String.format("%.1f",yield)+"%입니다.");
    }

    double calculateYield(){
        double money=Double.parseDouble(user.money);
        return winMoney/money*100;
    }
}
