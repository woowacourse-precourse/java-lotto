package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Problem {
    Comment comment;
    WinningLotto winningLotto;
    User user;
    Map<Prize,Integer> winResult;
    long winMoney;

    Problem(){
        comment=new Comment();
        user=new User();
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
        setUserLotto();
        setWinningLotto();
        findResult();
        calculateResult();
        printAnswer();
    }
    private void setUserLotto(){
        comment.inputMoney();
        user.inputMoney();
        user.setLottoQuantity();
        user.printLottoQunantity();
        user.buyingLotto();
        user.printAllBuyingLotto();
    }

    private void setWinningLotto(){
        comment.inputWinningNumber();
        inputWinningNumber();
        comment.inputBonusNumber();
        inputBonusNumber();
    }

    private void inputWinningNumber(){
        String []numbers=Console.readLine().split(",");
        winningLotto=new WinningLotto(convertNumbers(numbers));
    }

    private List<Integer> convertNumbers(String[] inputNumbers){
        List<Integer> numbers=new ArrayList<>();

        for(String number :inputNumbers){
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }

    private void inputBonusNumber(){
        int bonusNumber=Integer.parseInt((Console.readLine()));
        winningLotto.inputBonusNumber(bonusNumber);
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
        comment.startPrintAnswer();
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
