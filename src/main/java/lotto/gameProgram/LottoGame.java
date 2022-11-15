package lotto.gameProgram;

import lotto.gameSetting.*;
import lotto.gameResult.*;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class LottoGame {
    static final String BUYING_MESSAGE = "구입금액을 입력해 주세요.";
    static final String WIN_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    static final String RESULT_MESSAGE = "\n당첨 통계\n---";
    static String money;
    static String[] winningNumber;
    static List<Integer> numbers = new ArrayList<>();
    static String bonusNumber;

    void start() {
        System.out.println(BUYING_MESSAGE);
        money = Console.readLine();
        UserInput.moneyCheck(money);
    }

    void buyLotto() {
        System.out.println(BuyingLotto.orderNumber(money));
        BuyingLotto.lottoBundleGenerator(money);
        for(int i=0; i<BuyingLotto.lottoBundle.size(); i++){
            System.out.println(BuyingLotto.lottoBundle.get(i));
        }
    }

    void winNumber() {
        System.out.println(WIN_NUMBER_MESSAGE);
        winningNumber = Console.readLine().split(",");
        UserInput.winningNumberNumberCheck(winningNumber);
    }

    void winNumberCheck() {
        for(int i=0; i<winningNumber.length; i++) {
            numbers.add(Integer.parseInt(winningNumber[i]));
        }

        Lotto lotto = new Lotto(numbers);
        numbers = lotto.winNumber();
    }

    void bonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        bonusNumber = Console.readLine();
        UserInput.bonusNumberCheck(bonusNumber, winningNumber);
    }

    void winningResult() {
        System.out.println(RESULT_MESSAGE);
        int bonus = Integer.parseInt(bonusNumber);
        WinningLotto.winningDetails(BuyingLotto.lottoBundle, numbers, bonus);
        System.out.println(WinningOrderMessage.FIFTH.message() + WinningLotto.fifthClassNumber+"개");
        System.out.println(WinningOrderMessage.FOUFTH.message() + WinningLotto.fourthClassNumber+"개");
        System.out.println(WinningOrderMessage.THIRD.message() + WinningLotto.thirdClassNumber+"개");
        System.out.println(WinningOrderMessage.SECOND.message() + WinningLotto.secondClassNumber+"개");
        System.out.println(WinningOrderMessage.FIRST.message() + WinningLotto.firstClassNumber+"개");
    }
    
    void returnRate() {
        System.out.printf(RateOfReturn.RETURN_MESSAGE,RateOfReturn.returnRate(money));
    }

    public void lottoGame() {
        start();
        buyLotto();
        winNumber();
        winNumberCheck();
        bonusNumber();
        winningResult();
        returnRate();
    } 
}
