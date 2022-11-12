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
        this.winResult=new EnumMap<Prize, Integer>(Prize.class);
    }

    void printInputGuide(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    void startProblem(){
        setUserLotto();
        setWinningLotto();
        findResult();
        calculateResult();
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
        if(winResult.get(win)==null){
            winResult.put(win,0);
        }
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
