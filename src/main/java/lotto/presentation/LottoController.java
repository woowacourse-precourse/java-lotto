package lotto.presentation;

import lotto.application.LottoService;
import lotto.application.ViewService;
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
    }
    public void inputWinnerNumberInformation(){
        viewService.printInputWinnerNumberInformation();
    }
    public void saveWinnerNumber(WinnerNumber winnerNumber){

    }
    public void purchasedLotto(){
        lottoService.purchasedLotto();
    }
    public void printCountLotto(){
        viewService.printCountLotto();
    }
    public void printPurchasedLotto(){
        viewService.printPurchasedLotto();
    }
}
