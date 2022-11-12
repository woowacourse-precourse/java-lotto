package lotto.service;

import java.util.List;
import lotto.util.ConversionArrayToList;

public class DrawLottoService {

    ConversionArrayToList conversionArrayToList = new ConversionArrayToList();

    public int countBuyingLotto(int amount) {
        return amount / 1000;
    }

    public List<Integer> getListToWiningNumber(String winingLottoNUmber) {
        String[] winingNUmber = winingLottoNUmber.split(",");
        List<Integer> winingNumberList = conversionArrayToList.stringArrayToIntegerList(winingNUmber);
        return winingNumberList;
    }
}
