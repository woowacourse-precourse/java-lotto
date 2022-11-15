package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UI {

    public String inputPurchase() {
        System.out.println(Notice.INPUT_PURCHASE.message());
        return readLine();
    }

    public String inputWinningNumber() {
        System.out.println(Notice.INPUT_WINNING_NUMBER.message());
        return readLine();
    }

    public String inputBonusNumber() {
        System.out.println(Notice.INPUT_BONUS_NUMBER.message());
        return readLine();
    }

    public void outputLottoCount() {
        System.out.println(String.format(Notice.LOTTO_COUNT.message(), Game.getLottoCount()));
    }

    public void outputLottoNumbers() {
        for (Lotto lotto : Game.lottos) {
            System.out.println(
                String.format(Notice.LOTTO_NUMBER.message(), lotto.sortedNumbersToString()));
        }
    }

    public void outputWinningStatus() {
        System.out.println(
            String.format(Notice.WINNING_STATUS.message(),
                Game.winningStatus.get(Rank.FIFTH.getMessage()),
                Game.winningStatus.get(Rank.FOURTH.getMessage()),
                Game.winningStatus.get(Rank.THIRD.getMessage()),
                Game.winningStatus.get(Rank.SECOND.getMessage()),
                Game.winningStatus.get(Rank.FIRST.getMessage()))
        );
    }

}
