package lotto;

import java.util.List;

public class LottoController {

    private LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public int getOrderQuantity(int orderPrice) {
        return lottoService.getOrderQuantity(orderPrice);
    }

    public List<Lotto> createLottos(int orderQuantity) {
        return lottoService.createLottos(orderQuantity);
    }


}
