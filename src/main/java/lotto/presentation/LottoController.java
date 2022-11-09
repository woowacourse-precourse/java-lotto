package lotto.presentation;

import lotto.application.LottoService;
import lotto.application.MessageService;
import lotto.presentation.dto.PurchaseAmount;

public class LottoController {
    private static final LottoController instance=new LottoController();
    private final LottoService lottoService;
    private final MessageService messageService;
    private LottoController(){
        lottoService=LottoService.getInstance();
        messageService=MessageService.getInstance();
    }
    public static LottoController getInstance(){
        return instance;
    }
    public void run(){
        messageService.inputPurchaseAmountInformationMessage();
    }
    public void buyLotto(PurchaseAmount purchaseAmount){

    }
}
