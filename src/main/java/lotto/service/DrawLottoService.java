package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.util.ConversionArrayToList;

public class DrawLottoService {
    Map<Integer, Integer> correctNumberCountMap = new HashMap<>();
    ConversionArrayToList conversionArrayToList = new ConversionArrayToList();

    List<Integer> winingCount = new ArrayList<>();

    public int countBuyingLotto(int amount) {
        return amount / 1000;
    }

    public List<Integer> getListToWiningNumber(String winingLottoNUmber) {
        String[] winingNUmber = winingLottoNUmber.split(",");
        List<Integer> winingNumberList = conversionArrayToList.stringArrayToIntegerList(winingNUmber);
        return winingNumberList;
    }

    public void compareLottoToWiningLotto(List<Integer> winingLotto, Lotto myLotto, int bonusNumber) {
        int correctCount = 0;
        for (int i = 0; i < winingLotto.size(); i++) {
            if (myLotto.getLotto().contains(winingLotto.get(i))) {
                correctCount++;
            }
        }
        if (correctCount == 6) {
            correctCount++;
        }
        if (correctCount == 5) {
            if (myLotto.getLotto().contains(bonusNumber)) {
                correctCount++;
            }
        }
        correctNumberCountMap.put(correctCount, correctNumberCountMap.getOrDefault(correctCount, 0) + 1);
    }
}
