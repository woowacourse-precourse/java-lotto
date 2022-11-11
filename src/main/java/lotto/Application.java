package lotto;

import lotto.domain.Buyer;
import lotto.domain.Money;
import lotto.service.LottoService;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Buyer buyer = new Buyer();
        LottoService lottoService = new LottoService();
        System.out.println("구입금액을 입력해 주세요.");
        String input = buyer.inputMoney();
        List<Lotto> lottos = lottoService.publishLotto(new Money(input).getLottoCount());
        System.out.println(lottos.size() + "개를 구매하였습니다.");
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }
}
