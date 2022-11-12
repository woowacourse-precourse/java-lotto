package lotto.user.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static final int UNIT_MONEY = 1000; // 단위 100원
    private final int inputMoney;
    private int purchaseAmount;
    private int ticketAmount;
    private List<List<Integer>> lottos;

    public User(int inputMoney) {
        this.inputMoney = inputMoney;
        this.lottos = new ArrayList<>();
    }

    public void setLottos(List<Integer> lottoNumbers) {
        lottos.add(lottoNumbers);
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }

}