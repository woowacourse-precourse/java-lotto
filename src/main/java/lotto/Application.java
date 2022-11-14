package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class Application {
    static Domain domain = new Domain();
    static Ui ui = new Ui();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            process();
        }catch (IllegalArgumentException e){
            ui.exceptionMessageUi(e);
        }
    }



    private static void process() {
        ui.inputMoneyOutUi();
        int purchaseMoney = domain.inputMoneyException(Console.readLine());
        ui.numberOfPurchaseUi(purchaseMoney);
        List<Lotto> lottoList = buyLotto(purchaseMoney);
        ui.digitInputUi();
        List<Integer> luckyNums = domain.inputDigitException();
        ui.bonusInputUi();
        int bonus = domain.inputBonusException(luckyNums);
        Lotto lotto = new Lotto(luckyNums);
        HashMap<Integer, Integer> winNumbers = lotto.gameConfirm(lottoList,bonus);
        Integer totalProfit = lotto.totalProfit(winNumbers);
        double percent = lotto.percentToProfit(purchaseMoney, totalProfit);
        ui.lottoOutputUi(winNumbers, percent);
    }




    public static List<Lotto> buyLotto(int purchaseMoney){
        return digitPick(purchaseMoney/1000);
    }



    private static List<Lotto> digitPick(int purchaseAmount){
        List<Lotto> lottoNums = new ArrayList<>();
        while (lottoNums.size()!=purchaseAmount){
            lottoNums.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            ui.randomPickUi(lottoNums.get(lottoNums.size()-1).getNumbers());
        }
        return lottoNums;
    }


}
