package lotto.domain;

import java.util.List;
import lotto.model.Lotto;

public class MakeLotteriesFactory {

    private final MakeLotteriesService makeLotteriesService;

    public MakeLotteriesFactory(String input){
        PurchaseService purchaseService = new PurchaseService();
        purchaseService.parsePurchaseInput(input);
        makeLotteriesService = new MakeLotteriesService(purchaseService.getPurchaseAmount());
    }

    public List<Lotto> getLotteries(){
        return makeLotteriesService.getLotteries();
    }
}
