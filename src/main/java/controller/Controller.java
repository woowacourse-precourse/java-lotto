package controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;
import domain.ResultMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static controller.Util.*;

public class Controller {

    public int inputUserMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputValue = Console.readLine();
        validateInteger(inputValue);
        return Integer.parseInt(inputValue);
    }

    public List<Integer> inputLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputValue = Console.readLine();
        validateComma(inputValue);
        String[] inputWinning = (inputValue.split(","));
        List<Integer> inputWinningNumbers = Arrays.stream(inputWinning).map(Integer::parseInt).collect(Collectors.toList());
        return inputWinningNumbers;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonus = Console.readLine();
        validateInteger(inputBonus);
        return Integer.parseInt(inputBonus);
    }

    private List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> createTotalLottoNumber(int lottoCount) {
        List<Lotto> totalLottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            totalLottoNumbers.add(new Lotto(createLottoNumber()));
        }
        return totalLottoNumbers;
    }

    public HashMap<String, Integer> createWinningLotto(List<Lotto> totalLottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        HashMap<String, Integer> totalResult = createWinning();
        for (int i = 0; i < totalLottoNumbers.size(); i++) {
            int key = compareWinningNumber(totalLottoNumbers.get(i).getNumbers(), winningNumbers);
            String convertKey = Integer.toString(key);
            if (key == 5 && compareBonusNumber(totalLottoNumbers.get(i).getNumbers(), bonusNumber))
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

    private int compareWinningNumber(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        List<Integer> sameNumbers = new ArrayList<>();
        sameNumbers.addAll(lottoNumbers);
        sameNumbers.retainAll(winningNumbers);
        return sameNumbers.size();
    }

    private boolean compareBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
