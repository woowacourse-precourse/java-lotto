package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Problem {
    WinningLotto winningLotto;
    User user;
    Map<Prize,Integer> winResult;
    long winMoney;
    Problem(){
        printInputGuide();
        this.user=new User();
        this.winMoney=0;
        initializeWinResult();
    }
    void initializeWinResult(){
        this.winResult=new EnumMap<Prize, Integer>(Prize.class);

        for(Prize prize:Prize.values()){
            winResult.put(prize,0);
        }
    }

    void printInputGuide(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    void startProblem(){
        setUserLotto();
        setWinningLotto();
        findResult();
        calculateResult();
        printAnswer();
    }

    void printAnswer(){
        printAnswerComment();
        printAllPrizeNumber();
        printYield();
    }

    void printYield(){
        double yield=calculateYield();
        System.out.println("총 수익률은 "+String.format("%.1f",yield)+"%입니다.");
    }

    double calculateYield(){
        double money=Double.parseDouble(user.money);
        return winMoney/money*100;
    }

    void printAllPrizeNumber(){
        for(Prize prize:Prize.values()){
            System.out.println(prize.getPrintCondition()+" ("+prize.getPrintWinMoney()+"원) - "+winResult.get(prize)+"개");
        }
    }

    void printAnswerComment(){
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private void setUserLotto(){
        this.user.inputMoney();
        this.user.setLottoQuantity();
        this.user.printLottoQunantity();
        this.user.buyingLotto();
        this.user.printAllBuyingLotto();
    }

    void calculateResult(){
        for(Prize key:winResult.keySet()){
            winMoney+=(key.getWinMoney()*winResult.get(key));
        }
    }

    private void setWinningLotto(){
        printWinningNumberInputGuide();
        inputWinningNumber();
        printBonusNumberGuide();
        inputBonusNumber();
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

    void addPrizeResult(Prize win){
        winResult.put(win,winResult.get(win)+1);
    }

    Prize checkWinBonus(Lotto lotto){
        Prize win=Prize.THIRD;
        if(lotto.getNumbers().contains(winningLotto.bonusNumber)){
            win=Prize.SECOND;
        }
        return win;
    }

    private void printWinningNumberInputGuide(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private void inputWinningNumber(){
        String []numbers=Console.readLine().split(",");
        this.winningLotto=new WinningLotto(convertNumbers(numbers));
    }
    private List<Integer> convertNumbers(String[] inputNumbers){
        List<Integer> numbers=new ArrayList<>();

        for(String number :inputNumbers){
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }

    private void printBonusNumberGuide(){
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    private void inputBonusNumber(){
        int bonusNumber=Integer.parseInt((Console.readLine()));
        this.winningLotto.inputBonusNumber(bonusNumber);
    }
}
