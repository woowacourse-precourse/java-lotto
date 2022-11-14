package lotto.publisher;

import java.util.ArrayList;
import java.util.List;

public class LottoStorage {

    private static final List<Lotto> publishedLottos = new ArrayList<>();

    private LottoStorage() {

    }


    public static void registerLottos(Lotto lotto) {
        publishedLottos.add(lotto);
    }

    public static List<Lotto> getAllLottos() {
        return publishedLottos;
    }

}
