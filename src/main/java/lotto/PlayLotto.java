package lotto;

import java.util.ArrayList;
import java.util.List;

public class PlayLotto {
    CreateLotto createLotto = new CreateLotto();
    public List<List<Integer>> playLottoTicketCount(Integer TicketCount) {
        List<List<Integer>> allLottoNumber = new ArrayList<>();
        for (int i = 0; i < TicketCount; i++) {
            allLottoNumber.add(createLotto.createRandomBall());
        }
        return allLottoNumber;
    }

}
