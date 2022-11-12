package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaser {

    List<Lotto> allLottoOfPurchaser = new ArrayList<>();

    public void setAllLottoOfPurchaser(List<Lotto> allLottoOfPurchaser) {
        this.allLottoOfPurchaser = allLottoOfPurchaser;
    }

    public List<Lotto> getAllLottoOfPurchaser() {
        return allLottoOfPurchaser;
    }

}
