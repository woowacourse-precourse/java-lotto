package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoRank;
import lotto.domain.ProfitManager;
import lotto.domain.WinningCounter;
import lotto.view.LottoManager;
import lotto.view.LottoPrinter;


public class LottoGame {

    private static final int LOTTO_PRICE = 1000;
    private static int lottoCount;
    private static List<Integer> winningNumbers;

    public void play() {
        LottoManager lottoManager = new LottoManager();
        lottoManager.readPurchaseAmount();
        lottoCount = lottoManager.getLottoCount();
        Lotto[] lotto = new Lotto[lottoCount];
        generateLotto(lottoCount, lotto);
        lottoManager.readWinningNumbers();
        lottoManager.readBonusNumber();
        winningNumbers = lottoManager.getWinningNumbers();
        LottoRank[] rankBoard = getRankBoard(lotto);
        showLottoRankBoard(rankBoard);
        showLottoProfitResult(lottoCount, rankBoard);
    }

    private static LottoRank[] getRankBoard(Lotto[] lotto) {
        LottoRank[] rankBoard = LottoRank.values();
        for (int currentCount = 0; currentCount < lottoCount; currentCount++) {
            WinningCounter winningCounter = new WinningCounter();
            int normalCount = winningCounter.countWinningNormal(
                    lotto[currentCount].getLottoNumbers(), winningNumbers);
            int bonusCount = winningCounter.countWinningBonus(lotto[currentCount].getLottoNumbers(),
                    winningNumbers);
            updateRankBoard(rankBoard, normalCount, bonusCount);
        }
        return rankBoard;
    }

    private static void updateRankBoard(LottoRank[] rankBoard, int normalCount, int bonusCount) {
        for (LottoRank rank : rankBoard) {
            if (rank.checkThirdPlace(normalCount, bonusCount)) {
                break;
            }
            rank.findMatchingRank(normalCount);
        }
    }

    private static LottoPrinter showLottoRankBoard(LottoRank[] rankBoard) {
        LottoPrinter lottoPrinter = new LottoPrinter();
        lottoPrinter.printStatisticMessage();
        for (LottoRank rank : rankBoard) {
            lottoPrinter.printWinningResult(rank);
        }
        return lottoPrinter;
    }

    private static void showLottoProfitResult(int lottoCount, LottoRank[] values) {
        LottoPrinter lottoPrinter = new LottoPrinter();
        ProfitManager profitManager = new ProfitManager();
        int totalEarning = 0;
        for (LottoRank rank : values) {
            totalEarning += profitManager.calculateEarning(rank);
        }
        int purchaseAmount = lottoCount * LOTTO_PRICE;
        double totalProfit = profitManager.calculateProfit(purchaseAmount, totalEarning);
        lottoPrinter.printProfit(totalProfit);
    }

    private static void generateLotto(int lottoCount, Lotto[] lotto) {
        LottoPrinter lottoPrinter = new LottoPrinter();
        for (int currentCount = 0; currentCount < lottoCount; currentCount++) {
            List<Integer> lottoNumber;
            LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
            lottoNumber = lottoNumberGenerator.generate();
            lottoNumber = lottoNumberGenerator.sortAscending(lottoNumber);
            lotto[currentCount] = new Lotto(lottoNumber);
            lottoPrinter.printLottoNumbers(lottoNumber);
        }
    }
}

