package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            LottoMetadata metadata = new LottoMetadata.Builder().build();
            LottoSystem system = new StdIOLottoSystem(metadata);
            Integer payment = system.askFeeFromUser();
            List<Lotto> lottos = system.purchaseMultipleLotto(payment);
            system.showMultipleLotto(lottos);
            system.setNumbersByUser();
            system.announceResult(lottos);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
