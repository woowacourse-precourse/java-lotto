package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseInformation {
    private static final int THOUSAND = 1000;
    private final int NUMBER_OF_TICKETS;
    private ValueValidation valueValidator = new ValueValidation();
    private List<Lotto> lottoTickets = new ArrayList<>();
    private LottoGenerator lottoGenerator = new LottoGenerator();


    public LottoPurchaseInformation(int purchaseAmount){
        valueValidator.checkDividedByThousand(purchaseAmount);
        NUMBER_OF_TICKETS = purchaseAmount/THOUSAND;
    }
    public List<Lotto> getLottoTickets(){
        return lottoTickets;
    }

    public void generateLottoTickets(){
        for(int i = 0; i < NUMBER_OF_TICKETS; i++){
            Lotto lotto = new Lotto(lottoGenerator.generateLottoNumbers());
            lottoTickets.add(lotto);
        }
    }



}
