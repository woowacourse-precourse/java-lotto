package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGroup {
    private List<Lotto> lotteries = new ArrayList<>();


    public Lotto createLotto() {
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        this.lotteries.add(lotto);

        return lotto;
    }

    public List<Lotto> getAllLotteryTickets() {
        return this.lotteries;
    }

    public void addLotto(Lotto lotto) {
        this.lotteries.add(lotto);
    }

}
