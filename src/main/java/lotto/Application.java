package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        return convertToNumber(purchaseAmount);
    }

    static int convertToNumber(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 양의 정수여야 합니다.");
        }
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

    static List<Integer> inputLottoNumbers(String numbers) {
        System.out.println("당첨 번호를 입력해 주세요.");
        numbers = Console.readLine();
        return replaceSeparator(numbers);
    }

    static List<Integer> replaceSeparator(String numbers) {
        String[] eachNumbers = numbers.split(",");
        return collectLottoNumbers(eachNumbers);
    }

    static List<Integer> collectLottoNumbers(String[] eachNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int ordinalNumber = 0; ordinalNumber < eachNumbers.length; ordinalNumber++) {
            String eachNumber = eachNumbers[ordinalNumber];
            lottoNumbers.add(convertEachNumbers(eachNumber));
        }
        return lottoNumbers;
    }

    static int convertEachNumbers(String eachNumber) {
        try {
            return Integer.parseInt(eachNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수여야 합니다.");
        }
    }

    static void validateLottoNumbers(List<Integer> lottoNumbers) {
        validateNumber1To45(lottoNumbers);
        exceptDuplicatedNumber(lottoNumbers);
    }

    static void validateNumber1To45(List<Integer> lottoNumbers) {
        for (int eachNumber : lottoNumbers) {
            if (eachNumber < 1 || eachNumber > 45)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45까지의 숫자입니다.");
        }
    }

    static void exceptDuplicatedNumber(List<Integer> lottoNumbers) {
        Set<Integer> existentNumber = new HashSet<>();
        for (int eachNumber : lottoNumbers) {
            if (existentNumber.contains(eachNumber))
                throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 존재합니다.");
            existentNumber.add(eachNumber);
        }
    }

    static int inputBonusNumber(String number) {
        System.out.println("보너스 번호를 입력해 주세요.");
        number = Console.readLine();
        return convertBonusNumber(number);
    }

    static int convertBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수여야 합니다.");
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

    static void printQuantityOfLotto(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    static void printLottoTickets(Set<List<Integer>> lottoTickets) {
        for (List<Integer> lottoTicket : lottoTickets) {
            System.out.println(formLottoTicket(lottoTicket));
        }
    }

    static String formLottoTicket(List<Integer> lottoTicket) {
        List<String> ticket = new ArrayList<>();
        for (Integer eachNumber : lottoTicket) {
            ticket.add(String.valueOf(eachNumber));
        }
        String openBracket = "[";
        String closeBracket = "]";
        String printFormat = String.join(",", ticket);
        return openBracket + printFormat + closeBracket;
    }

    static void printTotalRank(Map<Integer, Integer> totalRank) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + totalRank.get(5) + "개");
        System.out.println("4개 일치 (50,000원) - " + totalRank.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + totalRank.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + totalRank.get(2) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + totalRank.get(1) + "개");
    }

    static void printRateOfReturn(double rateOfReturn) {
        System.out.println(String.format("총 수익률은 .%1f%입니다.", rateOfReturn));
    }

    static long calculateSumOfPrize(Map<Integer, Integer> totalRank) {
        long sumOfPrize = 0;
        sumOfPrize += totalRank.get(1) * 2000000000L;
        sumOfPrize += totalRank.get(2) * 30000000L;
        sumOfPrize += totalRank.get(3) * 1500000L;
        sumOfPrize += totalRank.get(4) * 50000L;
        sumOfPrize += totalRank.get(5) * 5000L;
        return sumOfPrize;
    }

    static double calculateRateOfReturn(long sumOfPrize, int purchaseAmount) {
        double rateOfReturn = (double) sumOfPrize / (double) purchaseAmount;
        return rateOfReturn;
    }
}