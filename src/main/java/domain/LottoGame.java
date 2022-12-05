package domain;

import util.LottoPoint;
import lotto.Lotto;
import lotto.LottoList;
import lotto.WinningLotto;
import org.assertj.core.util.Sets;
import util.WinningStatus;

import java.util.List;
import java.util.Set;

public class LottoGame {
    private final Result result;
    private Player player;
    private WinningLotto winningLotto;

    public LottoGame(Result result) {
        this.result = result;
    }

    public Player getPlayer() {
        return player;
    }

    public Result getResult() {
        return result;
    }

    public void buy(long amount) {
        player = Player.of(amount);
    }


    public void setWiningLotto(List<Integer> numbers) {
        winningLotto = WinningLotto.of(numbers);
    }

    public void setBonnusNumber(int number) {
        winningLotto.setBonnusNumber(number);
    }

    /**
     * 구매한 로또 로또 담청번호와 비교하는 함수
     */
    public void checkLotto() {
        LottoList lottoList = player.getLottoList();
        Set<Integer> winningNumbers = Sets.newHashSet(winningLotto.getNumbers());

        for (Lotto lotto : lottoList.getLottos()) {
            int point = getEachLottoPoint(lotto, winningNumbers);

            if (point < WinningStatus.THREE.getCorrectPoint()) {
                continue;
            }

            WinningStatus status = WinningStatus.getWinningStatusWithPoint(point);
            player.addTotalMoney(status.getWinningMoney());
            result.addCount(status.getPointIndex());
        }
    }

    /**
     * 로또 당첨 포인트 계산,
     * 5개가 일치하지 않을 때 보너스 포인트 맞으면, 보너스 볼 취소
     * @param lotto
     * @return
     */
    private int getEachLottoPoint(Lotto lotto, Set<Integer> winningNumbers) {
        Set<Integer> lottoNumbers = Sets.newHashSet(lotto.getNumbers());
        int point = 0;

        for (Integer number: lottoNumbers) {
            point += getPoint(winningNumbers, number);
        }

        if (!isFiveBonnus(point)) {
            point %= LottoPoint.BONNUS_POINT.getPoint();
        }
        return point;
    }

    /**
     * 값이 포함되어 있으면 포인트를 반납
     * @return
     */
    private int getPoint(Set<Integer> winningNumber, int lottoNumber) {
        if (winningNumber.contains(lottoNumber)) {
            return LottoPoint.CORRECT_POINT.getPoint();
        }

        if (lottoNumber == winningLotto.getBonnusNumber()) {
            return LottoPoint.BONNUS_POINT.getPoint();
        }

        return LottoPoint.WRONG_POINT.getPoint();
    }

    private boolean isFiveBonnus(int point) {
        if (isFivePoint(point)) {
            return true;
        }

        return false;
    }

    private boolean isFivePoint(int point) {
        return (point % LottoPoint.BONNUS_POINT.getPoint()) == WinningStatus.FIVE.getCorrectPoint();
    }

    public double getProfit() {
        return result.getProfit(player.getAmount());
    }
}
