package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchasePrice = getPurchasePrice(Console.readLine());
        List<Integer> winningLottoNumbers = getWinningLottoNumbers(Console.readLine());
        Lotto winningLotto = new Lotto(winningLottoNumbers);
        List<Lotto> lottoList = createLottoList(purchasePrice);
        int bonusNumber = getBonusNumber(Console.readLine(), winningLottoNumbers);
        HashMap<String, Integer> history = createHistory(lottoList, winningLotto, bonusNumber);
    }

    public static int getPurchasePrice(String input) {
        validatePurchasePrice(input);
        return Integer.parseInt(input);
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

    public static void validatePurchasePrice(String input) {
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(lotto.Error.INVALID_PRICE.getMessage());
        }
        if (inputNumber % 1000 != 0) {
            throw new IllegalArgumentException(lotto.Error.INVALID_PRICE.getMessage());
        }
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

    public static List<Lotto> createLottoList(int purchasePrice) {
        int range = purchasePrice / 1000;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < range; i++){
            lottoList.add(Lotto.createPurchaseLotto());
        }
        return lottoList;
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
}
