package lotto.data.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.data.dto.LottoBundleDto;

public class LottoBundleRepository {

    private static final List<LottoBundleDto> purchasedLottos = new ArrayList<>();

    public List<LottoBundleDto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public void addPurchasedLotto(LottoBundleDto lottoBundleDto) {
        purchasedLottos.add(lottoBundleDto);
    }

    public void clearRepository() {
        purchasedLottos.clear();
    }


}
