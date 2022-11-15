package controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;
import view.InputMessage;
import view.ResultMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static controller.Util.*;

public class Controller {

    public int inputMoney() {
        System.out.println(InputMessage.MONEY_MESSAGE);
        String inputValue = Console.readLine();
        validateInteger(inputValue);
        return Integer.parseInt(inputValue);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(InputMessage.WINNING_NUMBERS_MESSAGE);
        String inputValue = Console.readLine();
        validateComma(inputValue);
        String[] inputWinning = (inputValue.split(","));
        List<Integer> inputWinningNumbers = Arrays.stream(inputWinning).map(Integer::parseInt).collect(Collectors.toList());
        return inputWinningNumbers;
    }

    public int inputBonusNumber() {
        System.out.println(InputMessage.WINNING_BONUS_MESSAGE);
        String inputBonus = Console.readLine();
        validateInteger(inputBonus);
        return Integer.parseInt(inputBonus);
    }

    private List<Integer> createNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> createTotalNumbers(int lottoCount) {
        List<Lotto> totalNumbers = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            totalNumbers.add(new Lotto(createNumber()));
        }
        return totalNumbers;
    }

    public HashMap<String, Integer> createWinningResult(List<Lotto> totalNumbers, List<Integer> winningNumbers, int bonusNumber) {
        HashMap<String, Integer> totalResult = createWinning();
        for (int i = 0; i < totalNumbers.size(); i++) {
            int key = compareWinningNumber(totalNumbers.get(i).getNumbers(), winningNumbers);
            String convertKey = Integer.toString(key);
            if (key == 5 && compareBonusNumber(totalNumbers.get(i).getNumbers(), bonusNumber))
                totalResult.put("Bonus", totalResult.get("Bonus") + 1);
            if (totalResult.containsKey(convertKey))
                totalResult.put(convertKey, totalResult.get(convertKey) + 1);
        }
        return totalResult;
    }

    private HashMap<String, Integer> createWinning() {
        HashMap<String, Integer> totalResult = new HashMap<>();
        for (ResultMessage rank : ResultMessage.values()) {
            totalResult.put(rank.getWinningNumber(), 0);
        }
        return totalResult;
    }

    private int compareWinningNumber(List<Integer> Numbers, List<Integer> winningNumbers) {
        List<Integer> sameNumbers = new ArrayList<>();
        sameNumbers.addAll(Numbers);
        sameNumbers.retainAll(winningNumbers);
        return sameNumbers.size();
    }

    private boolean compareBonusNumber(List<Integer> Numbers, int bonusNumber) {
        return Numbers.contains(bonusNumber);
    }
}
