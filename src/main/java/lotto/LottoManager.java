package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    public List<Integer> GenerateLottoNumbers() {
        String inputLottoNumbers = Console.readLine();
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : inputLottoNumbers.split(",")) {
            lottoNumbers.add(Integer.valueOf(number));
        }
        return lottoNumbers;
    }

    public int GenerateBonusNumber() {
        String inputBonusNumbers = Console.readLine();
        return Integer.parseInt(inputBonusNumbers);
    }

    public List<Integer> GenerateRandomNumbers() {
        return List.of(1,2,3,4,5,6);
    }

    public int getMoney() {
        return 10000;
    }

    public void sortLottoNumbers(List<Integer> lotto) {
        System.out.println("test");
    }

    public List<List<Integer>> publishLottoForPrice(int money) {
        return List.of(List.of(1,2,3,4,5,6));
    }
}
