package lotto.Service;

import java.util.List;

public interface LottoService {

    void priceValidate(int price);
    List<Integer> generateRandomNum(int count);

}
