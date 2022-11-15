package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    static int quantityOfLotto(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    static void validateEnoughMoney(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입금액이 부족합니다.");
        }
    }

    static void validateChangeIsZero(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 남는 금액이 존재합니다.");
        }
    }

    static void validateBonusNumbers(List<Integer> lottoNumbers, int bonusNumber) {
        validateNumber1To45(bonusNumber);
        exceptDuplicatedNumber(lottoNumbers, bonusNumber);
    }

    static void validateNumber1To45(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45)
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45까지의 숫자입니다.");
    }

    static void exceptDuplicatedNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 중복된 숫자입니다.");
    }

    static Set<List<Integer>> generateUniqueLottoTickets(int numberOfTickets) {
        Set<List<Integer>> existentTicket = new HashSet<>();
        int numberOfGeneratedTickets = 0;
        while (numberOfGeneratedTickets < numberOfTickets) {
            List<Integer> generatedTicket = generateRandomLottoTicket();
            if (existentTicket.contains(generatedTicket))
                continue;
            existentTicket.add(generatedTicket);
            numberOfGeneratedTickets++;
        }
        return existentTicket;
    }

    static List<Integer> generateRandomLottoTicket() {
        List<Integer> LottoTicket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return sortRandomLottoTicket(LottoTicket);
    }

    static List<Integer> sortRandomLottoTicket(List<Integer> LottoTicket) {
        Collections.sort(LottoTicket);
        return LottoTicket;
    }

    static Map<Integer, Integer> checkTotalRank(Set<List<Integer>> lottoTickets, List<Integer> lottoNumbers, int bonusNumber) {
        Map<Integer, Integer> totalRank = new HashMap<>();
        initializeTotalRank(totalRank);
        for (List<Integer> lottoTicket : lottoTickets) {
            int winNumberCount = checkWinningLottoTicket(lottoTicket, lottoNumbers);
            boolean winBonusNumber = checkBonusNumber(lottoTicket, bonusNumber);
            totalRank = addRank(totalRank, checkWinRank(winNumberCount, winBonusNumber));
        }
        return totalRank;
    }

    static Map<Integer, Integer> initializeTotalRank(Map<Integer, Integer> totalRank) {
        for (int rank = 1; rank <= 5; rank++) {
            totalRank.put(rank, 0);
        }
        return totalRank;
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

    static Map<Integer, Integer> addRank(Map<Integer, Integer> totalRank, int winRank) {
        if (winRank == 0)
            return totalRank;
        int count = totalRank.get(winRank);
        totalRank.put(winRank, count + 1);
        return totalRank;
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