package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.player.Lottos;
import lotto.domain.player.Player;
import lotto.domain.statistic.Rank;
import lotto.domain.winner.LottoWinner;

import static lotto.view.Messages.*;

public class View {
    private Player player;
    private LottoWinner lottoWinner;
    Integer gross = 0;

    public View(Player player, LottoWinner lottoWinner) {
        this.player = player;
        this.lottoWinner = lottoWinner;
    }

    public void inputPrice() {
        System.out.println(INPUT_PRICE.getMessage());
        player.setLottoCount(Console.readLine());
    }

    public void printPurchaseCount() {
        System.out.println();
        System.out.println(String.format(LOTTO_COUNT.getMessage(), player.getLottoCount()));
    }

    public void printLottos(Lottos lottoGame) {
        lottoGame.getLottos()
                .forEach(l -> System.out.println(l.getNumbers()));
    }

    public void inputLottoNumber() {
        System.out.println();
        System.out.println(INPUT_LOTTO_NUMBER.getMessage());
        String input = Console.readLine();
        lottoWinner.setLotto(input);
    }

    public void inputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        String input = Console.readLine();
        lottoWinner.setBonusNumber(input);
    }

    public void printStats() {
        System.out.println();
        System.out.println(PRIZE_STATISTIC.getMessage());
        System.out.println(LINE_STATISTIC.getMessage());
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue;
            }

            Integer playerCorrectCount = player.getCorrectLotto().getOrDefault(rank, 0);
            String contents = String.format(PRIZE_RESULT.getMessage(), rank.getCorrectCount(), rank.getMoneyResult(), playerCorrectCount);

            if (rank == Rank.FIVE_BONUS) {
                contents = String.format(PRIZE_BONUS_RESULT.getMessage(), rank.getCorrectCount(), rank.getMoneyResult(), playerCorrectCount);
            }

            System.out.println(contents);
        }
    }

    public void printGross() {
        System.out.println(String.format(GROSS_RETURN.getMessage(), countGross()));
    }

    private float countGross() {
        player.getCorrectLotto()
                .forEach((r, i) -> calculate(r.getMoney() * i));

        return (float) 100 * gross / player.getPrice();
    }

    private void calculate(int price) {
        gross += price;
    }
}
