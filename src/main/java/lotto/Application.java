package lotto;

import java.util.Set;

public class Application {
    public static void main(String[] args) {
        try{
        String money=makeNumber.getAmountInput();
        CalculatorMoney calculatorMoney=new CalculatorMoney(money);
        int lottoCount=makeNumber.buyLotto(money);
        allLotto alllotto=new allLotto();
        for(int i=0;i<lottoCount;i++){
        alllotto.addLotto(new Lotto(makeNumber.randomLotto()));}
        alllotto.printAllLotto();
        String winningNumber=makeNumber.getWinningNumber();
        String bonusNumber=makeNumber.getBonusNumber();
        Set<Integer> winner=makeNumber.makeWinningNumber(winningNumber,bonusNumber);
        Judgement judgement=new Judgement();
        judgement.checkWin(winner,alllotto,bonusNumber);
        calculatorMoney.sumWinningMoney(judgement.getResult());
        calculatorMoney.printProfitRate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
}
