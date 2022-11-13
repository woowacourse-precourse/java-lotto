package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        LottoShop lottoShop = new LottoShop();
        List<Lotto> lottoList = lottoShop.generateLottoList(lottoShop.buyLotto());

        LottoUser lottoUser = new LottoUser();
        List<List<Integer>> userLottoList = lottoUser.generateUser();

        LottoCalculator lottoCalculator = new LottoCalculator();
        System.out.println(lottoCalculator.checkNumbers(lottoList, userLottoList));
    }
}
