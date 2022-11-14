package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Setting {

    User userLotto(){
        User user=new User();
        Comment.inputMoney();
        user.inputMoney();
        user.setLottoQuantity();
        user.printLottoQunantity();
        user.buyingLotto();
        user.printAllBuyingLotto();
        return user;
    }
    WinningLotto winningLotto(){
        WinningLotto winLotto;
        Comment.inputWinningNumber();
        winLotto=inputWinningNumber();
        Comment.inputBonusNumber();
        inputBonusNumber(winLotto);
        return winLotto;
    }

    private WinningLotto inputWinningNumber(){
        String []numbers= Console.readLine().split(",");
        return new WinningLotto(convertNumbers(numbers));
    }

    private List<Integer> convertNumbers(String[] inputNumbers){
        List<Integer> numbers=new ArrayList<>();

        for(String number :inputNumbers){
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }
    private void inputBonusNumber(WinningLotto winLotto){
        int bonusNumber=Integer.parseInt((Console.readLine()));
        winLotto.inputBonusNumber(bonusNumber);
    }
}
