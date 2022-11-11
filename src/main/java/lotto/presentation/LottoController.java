package lotto.presentation;

import lotto.application.LottoService;
import lotto.application.ViewService;
import lotto.presentation.dto.PurchaseAmount;

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
    public void countPurchasedLotto(PurchaseAmount purchaseAmount){
        lottoService.saveCountLotto(purchaseAmount);
    }
    public void purchaseLotto(){
        lottoService.purchasedLotto();
        viewService.printCountLotto();
        viewService.printPurchasedLotto();
    }
}
