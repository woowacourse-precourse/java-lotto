package lotto;

import lotto.machine.LottoChecker;
import lotto.machine.LottoKiosk;
import lotto.machine.WinningNumberMaker;

public class Application {
    public static void main(String[] args) {
        LottoKiosk lottoKiosk = new LottoKiosk();
        WinningNumberMaker winningNumberMaker = new WinningNumberMaker();
        try {
            Customer customer = new Customer();
            customer.insertMoney(lottoKiosk);
            lottoKiosk.sellLotto(customer);
            winningNumberMaker.make();
            LottoChecker lottoChecker = new LottoChecker(winningNumberMaker.getWinningNumbers(),
                    winningNumberMaker.getBonusNumber());
            customer.insertLottos(lottoChecker);
            lottoChecker.printResult();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
