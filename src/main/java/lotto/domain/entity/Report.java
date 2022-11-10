package lotto.domain.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Report {

    private User user;
    private LottoMachine lottoMachine;
    private Map<Integer, Integer> answerMap = new HashMap<>();

    public Report(User user, LottoMachine lottoMachine) {
        this.user = user;
        this.lottoMachine = lottoMachine;
        mapSetting();
        Game();
    }

    private void mapSetting() {
        for (int i = 3; i < 7; i++) {

        }
        answerMap.put(3, 0);
    }

    public static Report of(User user, LottoMachine lottoMachine) {
        return new Report(user, lottoMachine);
    }

    private void Game() {
        Lottos userLottos = user.currentUserLottos();
        List<Lotto> userWholeLottos = userLottos.currentLottos();
    }
}
