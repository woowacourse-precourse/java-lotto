package lotto.controller;

import lotto.model.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.*;

public class LottoController {
    public static void start() {
        purchase();
    }

    public static void purchase() {
        int purchaseAmount = Input.inputPurchaseAmount();
        LottoAmount amount = new LottoAmount(purchaseAmount);
        int quantity = amount.quantityOfLotto(purchaseAmount);
        LottoTickets tickets = new LottoTickets(collectUniqueLottoTickets(quantity));

        Output.printQuantityOfLotto(quantity);
        Output.printLottoTickets(tickets.getTickets());

        drawLots(tickets);
    }

    public static void drawLots(LottoTickets tickets) {
        Lotto lottoNumbers = Input.inputLottoNumbers();
        int bonusNumber = Input.inputBonusNumber();
        LottoRank rank = checkTotalRank(tickets, lottoNumbers, bonusNumber);

        Output.printTotalRank(rank.getRank());
    }

    static Set<List<Integer>> collectUniqueLottoTickets(int numberOfTickets) {
        Set<List<Integer>> existentTicket = new HashSet<>();
        int numberOfGeneratedTickets = 0;
        while (numberOfGeneratedTickets < numberOfTickets) {
            LottoTicket generatedTicket = new LottoTicket();
            if (existentTicket.contains(generatedTicket.getTicket()))
                continue;
            existentTicket.add(generatedTicket.getTicket());
            numberOfGeneratedTickets++;
        }
        return existentTicket;
    }

    static LottoRank checkTotalRank(LottoTickets lottoTickets, Lotto lottoNumbers, int bonusNumber) {
        LottoRank rank = new LottoRank();
        for (List<Integer> lottoTicket : lottoTickets.getTickets()) {
            int winNumberCount = checkWinningLottoTicket(lottoTicket, lottoNumbers.getLotto());
            boolean winBonusNumber = checkBonusNumber(lottoTicket, bonusNumber);
            rank.addRank(rank, checkWinRank(winNumberCount, winBonusNumber));
        }
        return rank;
    }

    static int checkWinningLottoTicket(List<Integer> lottoTicket, List<Integer> lottoNumbers) {
        int winningNumberCount = 0;
        for (int eachNumber : lottoTicket) {
            if (lottoNumbers.contains(eachNumber))
                winningNumberCount++;
        }
        return winningNumberCount;
    }

    static boolean checkBonusNumber(List<Integer> lottoTicket, int bonusNumber) {
        for (int eachNumber : lottoTicket) {
            if (eachNumber == bonusNumber)
                return true;
        }
        return false;
    }

    static int checkWinRank(int winNumberCount, boolean winBonusNumber) {
        if (winNumberCount == 6)
            return 1;
        if (winNumberCount == 5 && winBonusNumber)
            return 2;
        if (winNumberCount == 5)
            return 3;
        if (winNumberCount == 4)
            return 4;
        if (winNumberCount == 3)
            return 5;
        return 0;
    }
}
