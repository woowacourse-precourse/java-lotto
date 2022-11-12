package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.util.ConversionArrayToList;

public class DrawLottoService {
    Map<Integer, Integer> correctNumberCount = new HashMap<>();
    ConversionArrayToList conversionArrayToList = new ConversionArrayToList();

    List<Integer> winingCount = new ArrayList<>();

    private int correctCount;

    private double reward;

    public int countBuyingLotto(int amount) {
        return amount / 1000;
    }

    public List<Integer> getListToWiningNumber(String winingLottoNUmber) {
        String[] numbers = winingLottoNUmber.split(",");
        List<Integer> winingNumber = conversionArrayToList.stringArrayToIntegerList(numbers);
        return winingNumber;
    }

    public void compareLottoToWiningLotto(List<Integer> winingLotto, Lotto myLotto, int bonusNumber) {
        correctCount = 0;
        for (int i = 0; i < winingLotto.size(); i++) {
            if (myLotto.getLotto().contains(winingLotto.get(i))) {
                correctCount++;
            }
        }
        isFirstWiningLotto();
        isSecondWiningLotto(myLotto.getLotto(), bonusNumber);
        correctNumberCount.put(correctCount, correctNumberCount.getOrDefault(correctCount, 0) + 1);
    }

    private void isFirstWiningLotto() {
        if (correctCount == 6) {
            correctCount++;
        }
    }

    private void isSecondWiningLotto(List<Integer> myLotto, int bonusNumber) {
        if (correctCount == 5) {
            if (myLotto.contains(bonusNumber)) {
                correctCount++;
            }
        }
    }

    public void setWiningCount() {
        for (int i = 3; i <= 7; i++) {
            winingCount.add(correctNumberCount.getOrDefault(i, 0));
        }
    }

    public List<Integer> getWiningCount() {
        return winingCount;
    }

    public void setReward() {
        for (Rank i : Rank.values()) {
            reward += correctNumberCount.getOrDefault(i.getCorrectCount(), 0) * i.getPrice();
        }
    }

    public double getRevenue(int buyAmountLotto) {
        return ((reward) / buyAmountLotto) * 100;
    }
}
