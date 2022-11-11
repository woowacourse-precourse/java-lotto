package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private static final String BUY_LOTTO_NUMBER = "개를 구매했습니다.";

    private List<List<Integer>> lottos;

    private Store() {
        lottos = new ArrayList<>();
    }

    public void drawLottoNumber() {

    }

    public void showLotto() {
    }


}
