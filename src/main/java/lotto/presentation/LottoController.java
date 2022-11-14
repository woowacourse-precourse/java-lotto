package lotto.presentation;

import lotto.application.LottoService;
import lotto.application.ViewService;
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
    public void saveCountLotto(PurchaseAmount purchaseAmount){
        lottoService.saveCountLotto(purchaseAmount);
        viewService.printCountLotto();
    }
    public void purchasedLotto(){
        lottoService.purchasedLotto();
        viewService.printPurchasedLotto();
    }
    public void printInputWinnerNumber(){
        viewService.printInputWinnerNumber();
    }
    public void saveWinnerNumber(WinnerNumber winnerNumber){
        lottoService.saveWinnerNumber(winnerNumber);
    }
    public void printInputBonusNumber(){
        viewService.printInputBonusNumber();
    }
    public void saveBonusNumber(BonusNumber bonusNumber){
        lottoService.saveBonusNumber(bonusNumber);
    }
    public void printWinStatistics(){
        lottoService.winStatistics();
        viewService.printWinStat();
    }
    public void printYield(){
        Double yield=lottoService.calculateYield();
        viewService.printYield(yield);
    }
}
