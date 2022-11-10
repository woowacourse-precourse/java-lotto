package lotto;

import lotto.domain.LottoGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View view = new View();
        int price = view.askPrice();
        LottoGenerator lottoGenerator = new LottoGenerator();
        view.buyLottoList(price, lottoGenerator.generateLottoBundle(price));

        
    }
}
