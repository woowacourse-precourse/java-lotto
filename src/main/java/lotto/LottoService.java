package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class LottoService {
    UserInterface userInterface = new UserInterface();
    List<Lotto> lottos;

    public void purchaseLottos() {
        this.lottos = new ArrayList<>();
        System.out.println("구입금액을 입력해 주세요.");
        int numberOfLottos = userInterface.getPrice() / 1000;
        System.out.println(numberOfLottos + "개를 구매했습니다.");
        IntStream.range(0,numberOfLottos).forEach(i -> {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            randomNumbers.sort(Comparator.naturalOrder());
            Lotto lotto = new Lotto(randomNumbers);
            this.lottos.add(lotto);
        });
    }
    public void printLottos() {
        lottos.forEach(Lotto::printLotto);
    }
}
