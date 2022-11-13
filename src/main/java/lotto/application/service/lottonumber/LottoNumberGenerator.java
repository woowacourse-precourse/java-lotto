package lotto.application.service.lottonumber;

import java.util.List;

public interface LottoNumberGenerator {

    List<List<Integer>> generateLottoNumber(int purchaseNumber);
}
