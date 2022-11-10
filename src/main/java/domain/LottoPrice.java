package domain;

public class LottoPrice {
    private final int lottoPrice;

    public LottoPrice(int lottoPrice){
        this.lottoPrice = lottoPrice;
    }

    public int lottoTicketCount(){
        return lottoPrice/1000;
    }

}
