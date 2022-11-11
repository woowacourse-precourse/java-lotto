package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseInformation {
    private static final int THOUSAND = 1000;
    private ValidationInDomain validator = new ValidationInDomain();
    private List<Lotto> lottoTickets = new ArrayList<>();
    private LottoGenerator lottoGenerator = new LottoGenerator();
    private int numberOfTickets;
    private int purchaseAmount;
    private int totalWinningAmount = 10000;
    private double rateOfReturn;


    public LottoPurchaseInformation(int purchaseAmount){
        validator.checkDividedByThousand(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.numberOfTickets = this.purchaseAmount/THOUSAND;
    }
    public List<Lotto> getLottoTickets(){
        return lottoTickets;
    }

    public void generateLottoTickets(){
        for(int i = 0; i < numberOfTickets; i++){
            Lotto lotto = new Lotto(lottoGenerator.generateLottoNumbers());
            lottoTickets.add(lotto);
        }
    }

    public void calculateRateOfReturn(){
        double tmp = ((double)totalWinningAmount/purchaseAmount)*1000;
        rateOfReturn = Math.round(tmp)/10.0;
    }

    public double getRateOfReturn(){
        return rateOfReturn;
    }



}
