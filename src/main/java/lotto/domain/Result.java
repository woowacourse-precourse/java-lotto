package lotto.domain;

import lotto.model.*;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Result {
    public User user;
    public WinningLotto winLotto;
    public Map<Prize,Integer> result;

    public Result(User user,WinningLotto winLotto){
        this.user=user;
        this.winLotto=winLotto;
        initializeResult();
    }

    private void initializeResult(){
        result=new EnumMap<Prize, Integer>(Prize.class);

        for(Prize prize:Prize.values()){
            result.put(prize,0);
        }
    }

    public Map<Prize,Integer> prizeLotto(){
        for(Lotto lotto:user.getLottos()){
            checkPrize(lotto);
        }
        return result;
    }

    public long calculateWinnings(){
        long winnings=0;
        for(Prize key:result.keySet()){
            winnings+=(key.getWinMoney()*result.get(key));
        }
        return winnings;
    }

    public void checkPrize(Lotto lotto){
        Set<Integer> userNumbers=new HashSet<>(lotto.getNumbers());
        Set<Integer> winningNumbers=new HashSet<>(winLotto.getNumbers());

        userNumbers.retainAll(winningNumbers);
        int winCount=userNumbers.size();

        if(winCount>=3){
            winPrize(winCount,lotto);
        }
    }

    private void winPrize(int winCount,Lotto lotto){
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

    private Prize checkWinBonus(Lotto lotto){
        Prize win=Prize.THIRD;
        if(lotto.getNumbers().contains(winLotto.getNumbers())){
            win=Prize.SECOND;
        }
        return win;
    }
    private void addPrizeResult(Prize win){
        result.put(win,result.get(win)+1);
    }
}
