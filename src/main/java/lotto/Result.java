package lotto;

import java.util.ArrayList;
import java.util.List;

public class Result {


    public void lottoResult(List<Integer> lotto,) {
        Price price = new Price();

        Number num = new Number();
        Lotto lotto = new Lotto(num.getWinningNumberList());

       for(int i=0; i< price.getLottoTickets(); i++){
           Generator generator =new Generator();
           Match match = new Match(lotto.getLottoNumbers(), generator.getlottoNumbers(), num.getBonusNumber());

       }

    }
}
