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

public class Controller {

    public int inputUserMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputUser = Console.readLine();
        return Integer.parseInt(inputUser);
    }

    public List<Integer> inputLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] inputWinning = (Console.readLine()).split(",");
        List<Integer> inputWinningNumbers = Arrays.stream(inputWinning).map(Integer::parseInt).collect(Collectors.toList());
        return inputWinningNumbers;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputUser = Console.readLine();
        return Integer.parseInt(inputUser);
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
        Util util = new Util();
        for (int i = 0; i < totalLottoNumbers.size(); i++) {
            int key = util.compareWinningNumber(totalLottoNumbers.get(i).getNumbers(), winningNumbers);
            if (key == 5 && util.compareBonusNumber(totalLottoNumbers.get(i).getNumbers(), bonusNumber))
                totalResult.put("Bonus", totalResult.get("Bonus") + 1);
            if (totalResult.containsKey(Integer.toString(key)))
                totalResult.put(Integer.toString(key), totalResult.get(key) + 1);
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

}
