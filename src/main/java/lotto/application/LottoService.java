package lotto.application;

import lotto.presentation.dto.PurchaseAmount;

public class LottoService {
    private static final int UNIT=1000;
    private static final LottoService instance=new LottoService();
    private LottoService(){}
    public static LottoService getInstance(){
        return instance;
    }

    public Integer countingLotto(PurchaseAmount purchaseAmount){
        return purchaseAmount.getAmount()/UNIT;
    }
}
