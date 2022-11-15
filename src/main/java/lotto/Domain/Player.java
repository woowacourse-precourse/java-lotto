package lotto.Domain;

import Utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private int money;
    private int lottoCount;
    private Lotto winningNumber;
    private int bonusNumber;
    private List<Lotto> lottos;

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Integer> getWinningNumber() {
        return this.winningNumber.getLottoNumbers();
    }

    public void setWinningNumber(List<Integer> lotto) {
        this.winningNumber = new Lotto(lotto);
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public void setBonusNumber(int bonusBall) {
        this.bonusNumber = bonusBall;
    }

    public int getLottoCount() {
        return this.lottoCount;
    }

    public void setLottoCount(int money) {
        final int THOUSAND_WON = 1000;
        this.lottoCount = money / THOUSAND_WON;
    }
    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public void setLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(RandomUtils.getRandomLottoNumber()));
        }
        this.lottos = lottos;
    }

    public List<String> getLottosToOutput() {
        return this.lottos.stream()
                .map(value -> value.getLottoNumbers().toString())
                .collect(Collectors.toList());
    }
}
