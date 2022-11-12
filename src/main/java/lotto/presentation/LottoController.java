package lotto.presentation;

import lotto.application.LottoService;
import lotto.application.ViewService;
import lotto.application.dto.WinStat;
import lotto.presentation.dto.BonusNumber;
import lotto.presentation.dto.PurchaseAmount;
import lotto.presentation.dto.WinnerNumber;

public class LottoController {
    private static final LottoController instance=new LottoController();
    private final LottoService lottoService;
    private final ViewService viewService;
    private LottoController(){
        lottoService=LottoService.getInstance();
        viewService = ViewService.getInstance();
    }
    public static LottoController getInstance(){
        return instance;
    }
    public void run(){
        viewService.printInputPurchaseAmountInformation();
    }
    public void purchasedLotto(){
        lottoService.purchasedLotto();
        viewService.printPurchasedLotto();
    }
    public void winStatistics(){
        WinStat winStat=lottoService.winStatistics();
        viewService.printWinStat(winStat);
    }
    public void saveCountLotto(PurchaseAmount purchaseAmount){
        lottoService.saveCountLotto(purchaseAmount);
        viewService.printCountLotto();
    }
    public void saveWinnerNumber(WinnerNumber winnerNumber){
        lottoService.saveWinnerNumber(winnerNumber);
    }
    public void saveBonusNumber(BonusNumber bonusNumber){
        lottoService.saveBonusNumber(bonusNumber);
    }
    public void printInputWinnerNumber(){
        viewService.printInputWinnerNumber();
    }
    public void printInputBonusNumber(){
        viewService.printInputBonusNumber();
    }
}
