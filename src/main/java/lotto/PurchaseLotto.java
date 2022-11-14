package lotto;

import java.util.LinkedList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import ui.PurchasePrint;
import exceptioncase.PurchaseException;
import camp.nextstep.edu.missionutils.Randoms;
public class PurchaseLotto {
    public static List<Lotto> purchaseLotto(){
        int lottocount = inputPurchaseMoney();
        PurchasePrint.checkPurchase(lottocount);
        List<Lotto> purchaselottos = drawLotto(lottocount);
        PurchasePrint.printLottoNumber(purchaselottos);
        return purchaselottos;
    }
    private static int inputPurchaseMoney(){
        PurchasePrint.intputMoney();
        String money = Console.readLine();
        PurchaseException.inputMoneyException(money);
        return Integer.valueOf(money)/1000;
    }
    public static List<Lotto> drawLotto(int lottocount){
        List<Lotto> answer = new LinkedList<>();
        for(int i=0 ;i<lottocount ; i++){
            answer.add(makeRandomNumbers());
        }
        return answer;
    }
    private static Lotto makeRandomNumbers(){
        Lotto lotto;
        while(true){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto = new Lotto(numbers);
            if(lotto.overlapsFind(lotto.getNumbers())){
                break;
            }
        }
        return lotto;
    }
}
