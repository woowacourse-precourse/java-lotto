package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String money=makeNumber.getAmountInput();
        int lottoCount=makeNumber.buyLotto(money);
        allLotto alllotto=new allLotto();
        for(int i=0;i<lottoCount;i++){
            alllotto.addLotto(new Lotto(makeNumber.randomLotto()));
        }
        alllotto.printAllLotto();
        String winningNumber=makeNumber.getWinningNumber();
        String bonusNumber=makeNumber.getBonusNumber();


    }
}
