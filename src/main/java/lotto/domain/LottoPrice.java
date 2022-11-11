package lotto.domain;

import static lotto.constant.NumberConstant.LOTTO_MIN_PRICE;

public class LottoPrice {
    private final int lottoPrice;

    public LottoPrice(int lottoPrice){
        this.lottoPrice = lottoPrice;
    }

    public int lottoTicketCount(){
        return lottoPrice/LOTTO_MIN_PRICE;
    }

    public int getLottoPrice(){
        return this.lottoPrice;
    }

}
