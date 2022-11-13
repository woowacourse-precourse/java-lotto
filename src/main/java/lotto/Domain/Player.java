package lotto.Domain;

import Utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private int money;
    private int lottoCount;
    private Lotto playerLotto;
    private int playerBonusNumber;
    private List<Lotto> lottos;

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Integer> getPlayerLotto() {
        return this.playerLotto.getLottoNumbers();
    }

    public void setPlayerLotto(List<Integer> playerLotto) {
        this.playerLotto = new Lotto(playerLotto);
    }

    public int getPlayerBonusNumber() {
        return this.playerBonusNumber;
    }

    public void setPlayerBonusNumber(int bonusBall) {
        this.playerBonusNumber = bonusBall;
    }

    public int getLottoCount() {
        return this.lottoCount;
    }

    public void setLottoCount(int money) {
        final int THOUSAND_WON = 1000;
        this.lottoCount = money / THOUSAND_WON;
    }

    public void setLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(RandomUtils.getRandomLottoNumber()));
        }
        this.lottos = lottos;
    }

    public List<String> getLottosList() {
        return this.lottos.stream()
                .map(value -> value.getLottoNumbers().toString())
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
