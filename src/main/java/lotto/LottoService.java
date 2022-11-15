package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoService {
    UserInterface userInterface = new UserInterface();
    List<Lotto> lottos;

    public void purchaseLottos() {
        this.lottos = new ArrayList<>();
        int numberOfLottos = userInterface.getPrice() / 1000;
        IntStream.range(0,numberOfLottos).forEach(i -> {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
            this.lottos.add(lotto);
        });
    }
}
