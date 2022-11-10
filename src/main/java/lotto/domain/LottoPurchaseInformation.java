package lotto.domain;

import java.util.ArrayList;

public class LottoPurchaseInformation {
    private static final int THOUSAND = 1000;
    private final int NUMBER_OF_TICKETS;
    private ValueValidation valueValidator = new ValueValidation();
    private ArrayList<Lotto> lottoTickets = new ArrayList<>();
    private LottoGenerator lottoGenerator = new LottoGenerator();


    public LottoPurchaseInformation(int purchaseAmount){
        valueValidator.checkDividedByThousand(purchaseAmount);
        NUMBER_OF_TICKETS = purchaseAmount/THOUSAND;
    }

    public void generateLottoTickets(){
        for(int i = 0; i < NUMBER_OF_TICKETS; i++){
            Lotto lotto = new Lotto(lottoGenerator.generateLottoNumbers());
            lottoTickets.add(lotto);
        }
    }



}
