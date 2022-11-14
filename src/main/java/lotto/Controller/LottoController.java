package lotto.Controller;

import lotto.Service.LottoService;

public class LottoController {

    public LottoService lottoService = new LottoService();
    public void startLotto() {

        try{
            int purchase = lottoService.getPurchaseAmount();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
