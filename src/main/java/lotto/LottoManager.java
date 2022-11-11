package lotto;

import java.util.List;

public class LottoManager {
    public List<Integer> GenerateLottoNumbers() {
        return List.of(1,2,3,4,5,6);
    }

    public int GenerateBonusNumber() {
        return 1;
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
