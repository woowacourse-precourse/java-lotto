package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constant.Constant;
import lotto.util.Convertor;
import lotto.util.LottoGenerator;
import lotto.util.PlayerInput;
import lotto.util.WinnerInfo;

/*
 * 로또 게임 로직을 담당하는 클래스
 * 1. 구입 금액에 따른 로또 구매 개수 리턴
 * 2. 구매 개수만큼 로또(보너스 번호 포함) 발행
 * 3. 로또 당첨 결과 리턴
 * 4. 로또 수익률 리턴
 */

public class Service {

    public static int getMoney() {
        Money money = new Money(PlayerInput.getInteger());
        return money.getMoney();
    }

    public static int getLottoAmount(int money) {
        return money / Constant.LOTTO_PRICE;
    }

    public static List<List<Integer>> getLottoNumbers(int lottoAmount) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i++) {
            Lotto lotto = new Lotto(LottoGenerator.generateLottoNumbers());
            lottoNumbers.add(lotto.getNumbers());
        }
        return lottoNumbers;
    }

    public static List<Integer> getBonusNumber(int lottoAmount) {
        List<Integer> bonusNumbers = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i++) {
            BonusNumber bonusNumber = new BonusNumber(LottoGenerator.generateBonusNumber());
            bonusNumbers.add(bonusNumber.getNumber());
        }
        return bonusNumbers;
    }

    public static List<Integer> getWinningLottoNumber() {
        Lotto lotto = new Lotto(PlayerInput.getLottoNumbers());
        return lotto.getNumbers();
    }

    public static int getWinningBonusNumber() {
        BonusNumber bonusNumber = new BonusNumber(PlayerInput.getInteger());
        return bonusNumber.getNumber();
    }

    public static double getProfitRates(int money, int[] lottoResult) {
        double winningAmount = 0;

        for (int i = 0; i < lottoResult.length; i++) {
            winningAmount = lottoResult[i] * WinnerInfo.values()[i].getPrizeInformation();
        }
        return (winningAmount / money) * 100;
    }

    // TODO: 리팩토링 필요
    public static int[] getLottoResult(
            int lottoAmount, List<List<Integer>> lottoNumbers, List<Integer> playerLottoNumbers,
            int playerBonusNumber) {

        int[] result = new int[Constant.WINNER_NUMBER];
        Arrays.fill(result, 0);

        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> lotto = Convertor.ExtractList(lottoNumbers, i);
            int index = getOneLottoResult(lotto, playerLottoNumbers, playerBonusNumber);

            if (index == 0 || index == -1) {
                continue;
            }
            result[index - 1]++;
        }
        return result;
    }

    // TODO: 리팩토링 필요
    private static int getOneLottoResult(
            List<Integer> lottoNumbers, List<Integer> playerLottoNumbers, int playerBonusNumber) {

        List<Integer> intersection = new ArrayList<>(playerLottoNumbers);
        intersection.retainAll(lottoNumbers);

        if (intersection.isEmpty()) {
            return 0;
        }

        if (intersection.size() == Constant.CHECK_BONUS_COUNT) {
            playerLottoNumbers.removeAll(lottoNumbers);

            if (playerLottoNumbers.get(0) == playerBonusNumber) {
                return WinnerInfo.RANK2.getRank();
            }
            return WinnerInfo.RANK3.getRank();
        }

        if (intersection.size() == WinnerInfo.RANK1.getWinningCondition()) {
            return WinnerInfo.RANK1.getRank();
        }

        if (intersection.size() == WinnerInfo.RANK4.getWinningCondition()) {
            return WinnerInfo.RANK4.getRank();
        }

        if (intersection.size() == WinnerInfo.RANK5.getWinningCondition()) {
            return WinnerInfo.RANK5.getRank();
        }
        return -1;
    }
}
