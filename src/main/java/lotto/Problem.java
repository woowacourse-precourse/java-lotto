package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Problem {
    WinningLotto winningLotto;
    User user;
    Problem(){
        printInputGuide();
        this.user=new User();
    }

    void printInputGuide(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    void startProblem(){
        setUserLotto();
        setWinningLotto();
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
