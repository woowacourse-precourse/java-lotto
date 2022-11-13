package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {
    void compare(List<Lotto> lottos, List<Integer> winNumbers, int BonusNumber) {

    }
}

class Judgment {
    int countMatch(Lotto lotto, List<Integer> winNumbers, int BonusNumber) {
        return 0;
    }

    boolean checkBonus() {
        return true;
    }
}

class Statistics {
    Map map;
    boolean bonus;

    Statistics() {
        map = new HashMap();
    }

    void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    void record() {

    }

    Map getMap() {
        return map;
    }

    float getReturn() {
        return 0;
    }

}
