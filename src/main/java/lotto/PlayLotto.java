package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayLotto {
    public List<List<Integer>> playLottoTicketCount(Integer ticketCount) {
        List<List<Integer>> allLottoNumber = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            CreateLotto createLotto = new CreateLotto();
            Collections.sort(createLotto.createRandomBall());
            allLottoNumber.add(createLotto.createRandomBall());
        }
        return allLottoNumber;
    }

}
