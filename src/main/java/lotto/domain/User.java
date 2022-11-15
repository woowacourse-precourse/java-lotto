package lotto.domain;

import java.util.List;
import lotto.service.LottoService;

public class User {

    private final Integer lottoPrice;
    private final List<List<Integer>> userLottoNumberGroup;

    private LottoService lottoService = new LottoService();

    public User(Integer lottoPrice) {
        this.lottoPrice = lottoPrice;
        this.userLottoNumberGroup = lottoService.issueLottoNumberGroup(lottoPrice);
    }

    public List<List<Integer>> getUserLottoNumberGroup() {
        return userLottoNumberGroup;
    }

    public Integer getLottoPrice() {
        return lottoPrice;
    }
}
