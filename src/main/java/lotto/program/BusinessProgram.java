package lotto.program;

import java.util.ArrayList;
import java.util.List;
import lotto.vo.Lotto;
import lotto.utils.Converter;
import lotto.utils.Generator;

public class BusinessProgram {

    public List<Lotto> generateUserLotto(int money) {
        int ticket = Converter.moneyToTicket(money);
        return generateLottoByTicket(ticket);
    }

    private List<Lotto> generateLottoByTicket(int ticket) {
        List<Lotto> userLotto = new ArrayList<>();
        for (int index = 0; index < ticket; index++) {
            new Lotto(Generator.makeRandomLottoNumbers());
        }
        return userLotto;
    }
}
