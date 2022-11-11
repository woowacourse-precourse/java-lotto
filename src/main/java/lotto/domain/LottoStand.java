package lotto.domain;

public class LottoStand {
    int lottoTicketPrice = 1000;

    public LottoStand() {
    }
    public int salesPerson(int Money){
       int lottoTickes= Money / lottoTicketPrice;
       return lottoTickes;
    }
}
