package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem {
    WinningLotto winningLotto;
    User user;
    int []prize;
    long winMoney;
    Problem(){
        printInputGuide();
        this.user=new User();
        this.prize=new int[5];
        this.winMoney=0;
    }

    void printInputGuide(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    void startProblem(){
        setUserLotto();
        setWinningLotto();
        findResult();
    }

    private void setUserLotto(){
        this.user.inputMoney();
        this.user.setLottoQuantity();
        this.user.printLottoQunantity();
        this.user.buyingLotto();
        this.user.printAllBuyingLotto();
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
        addPrize();
    }

    void addPrize(){
        winMoney+=prize[0]*200000000l;
        winMoney+=prize[1]*30000000l;
        winMoney+=prize[2]*1500000l;
        winMoney+=prize[3]*50000l;
        winMoney+=prize[4]*5000l;
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
        int index=6-winCount;
        if(winCount==5){
            if(!lotto.getNumbers().contains(this.winningLotto.bonusNumber)){
                index++;
            }
        }
        else if(winCount>5){
            index++;
        }

        prize[index]++;
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
