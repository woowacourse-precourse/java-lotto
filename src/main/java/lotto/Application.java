package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        User user = new User(Console.readLine());
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningLottoNumbers = getWinningLottoNumbers(Console.readLine());
        Lotto winningLotto = new Lotto(winningLottoNumbers);
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = getBonusNumber(Console.readLine(), winningLottoNumbers);
//       HashMap<String, Integer> history = createHistory(lottoList, winningLotto, bonusNumber);
//        double yieldRate = getYieldRate(purchasePrice, getProfits(history));
//        printYieldRate(yieldRate);
    }


    public static List<Integer> getWinningLottoNumbers(String input) {
        String[] inputNumbers = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String inputNumber : inputNumbers) {
            validateNumber(inputNumber);
            numbers.add(Integer.parseInt(inputNumber));
        }
        return numbers;
    }

    public static int getBonusNumber(String input, List<Integer> winningLottoNumbers) {
        validateNumber(input, winningLottoNumbers);
        return Integer.parseInt(input);
    }

    public static void validateNumber(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(Error.INVALID_INPUT_VALUE.getMessage());
        }
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException(Error.INVALID_INPUT_VALUE.getMessage());
        }
    }

    public static void validateNumber(String input, List<Integer> winningLottoNumbers) {
        validateNumber(input);
        if (winningLottoNumbers.contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException(Error.INPUT_DUPLICATE.getMessage());
        }
    }

    public static HashMap<String, Integer> createHistory(List<Lotto> lottoList, Lotto winningLotto, int bonusNumber) {
        HashMap<String, Integer> historyMap = initResultMap();
        for (Lotto purchaseLotto : lottoList) {
            int count = compareWinningLottoWithPurchaseLotto(winningLotto, purchaseLotto);
            if (count == 5 && checkBonusNumber(purchaseLotto, bonusNumber)) {
                historyMap.put("5+", historyMap.get("5+") + 1);
                continue;
            }
            if (count >= 3) {
                String key = Integer.toString(count);
                historyMap.put(key, historyMap.get(key) + 1);
            }
        }
        return historyMap;
    }

    public static HashMap<String, Integer> initResultMap() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("3", 0);
        hashMap.put("4", 0);
        hashMap.put("5", 0);
        hashMap.put("5+", 0);
        hashMap.put("6", 0);
        return hashMap;
    }

    public static int compareWinningLottoWithPurchaseLotto(Lotto winningLotto, Lotto purchaseLotto) {
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        List<Integer> purchaseLottoNumbers = purchaseLotto.getNumbers();
        int count = 0;
        for (Integer number : purchaseLottoNumbers) {
            if (winningLottoNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public static boolean checkBonusNumber(Lotto purchaseLotto, int bonusNumber) {
        List<Integer> purchaseLottoNumbers = purchaseLotto.getNumbers();
        return purchaseLottoNumbers.contains(bonusNumber);
    }

    public static double getProfits(HashMap<String, Integer> history) {
        double profits = 0;
        profits += history.get("3") * 5000;
        profits += history.get("4") * 50000;
        profits += history.get("5") * 1500000;
        profits += history.get("5+") * 30000000;
        profits += history.get("6") * 2000000000;
        return profits;
    }

    public static double getYieldRate(int purchasePrice, double profits) {
        return (profits / purchasePrice) * 100;
    }

    public static void printLottoList(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningStats(HashMap<String, Integer> resultMap) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + resultMap.get("3") + "개");
        System.out.println("4개 일치 (50,000원) - " + resultMap.get("4") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + resultMap.get("5") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultMap.get("5+") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + resultMap.get("6") + "개");
    }

    public static void printYieldRate(double yieldRate){
        System.out.println("총 수익률은 "+ yieldRate +"%입니다.");
    }

}
