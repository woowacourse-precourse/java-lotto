package lotto;
import java.util.Collections;
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
            answer.add(new Lotto(makeRandomNumbers()));
        }
        return answer;
    }
    private static List<Integer> makeRandomNumbers(){
        List<Integer> numbers = new LinkedList<>();
        while(numbers.size()<6){
            int randomnumber = Randoms.pickNumberInRange(1,45);
            if(numbers.contains(randomnumber))
                continue;
            numbers.add(randomnumber);
        }
        Collections.sort(numbers);
        return numbers;
    }
}
