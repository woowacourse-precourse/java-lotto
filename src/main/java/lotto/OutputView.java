package lotto;

public class OutputView {

    public void showLottoNumbers(Player player) {
        System.out.println(player.playerLotto.size() + "개를 구매했습니다.");
        int lottoCount = player.playerLotto.size();
        for (int idx=0; idx<lottoCount; idx++) {
            Lotto lotto = player.playerLotto.get(idx);
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public void showBonusNumber(Player player, int idx) {
        System.out.println(player.playerLotto.get(idx).getBonusNumber());
    }
}
