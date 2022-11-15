package lotto.controller;

import lotto.controller.io.LottoReader;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.info.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static lotto.domain.info.Price.SINGLE_PRICE;

public class LottoManager {
    private final LottoReader reader;

    public LottoManager(final LottoReader reader) {
        this.reader = reader;
    }

    public void guideLottoGame(final Player player) {
        payPrice(player);
        publishLotto(player);
        enterNumbers(player);
        enterBonus(player);
    }
    public void setPlayerResult(final Player player) {
        List<Rank> ranksFromPlayer = LottoMachine.getRanksFromPlayer(player);
        player.setResults(ranksFromPlayer);
    }

    private void payPrice(final Player player) {
        System.out.println("구입 금액을 입력해주세요.");
        int amount = reader.readAmount();
        player.setAmount(amount);
    }

    private void enterNumbers(final Player player) {
        System.out.println("당첨 번호를 입력해주세요.");
        Set<Integer> lottoNumber = reader.readLottoNumber();
        player.setPlayersLottoNumber(lottoNumber);
    }

    private void enterBonus(final Player player) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = reader.readBonus();
        player.setBonus(bonus);
    }

    public void publishLotto(final Player player) {
        int amount = player.getAmount();
        List<Lotto> lottoList = getLottoList(amount);
        player.setLottos(lottoList);
    }

    public List<Lotto> getLottoList(final int amount) {
        int count = getCountFromAmount(amount);
        List<Lotto> lottos = new ArrayList<>();

        addLottos(lottos, count);
        return lottos;
    }

    private int getCountFromAmount(final int amount) {
        int count = amount / SINGLE_PRICE.getPrice();
        System.out.println(count + "개를 구매했습니다.");
        return count;
    }

    private void addLottos(final List<Lotto> lottos, final int count) {
        for (int i = 0; i < count; i++) {
            Lotto lotto = LottoMachine.publishLotto();
            System.out.println(lotto);

            lottos.add(lotto);
        }
    }
}
