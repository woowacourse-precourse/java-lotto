package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        LottoShop lottoShop = new LottoShop();
        lottoShop.generateLottoList(lottoShop.buyLotto());

        LottoUser lottoUser = new LottoUser();

    }
}
