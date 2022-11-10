package lotto.domain.machine;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.number.LottoNumberGenerator;

public class LottoMachine {
    
    public List<Lotto> buy(Integer amount) {
        validate(amount);
        return publish(getCount(amount));
    }
    
    private List<Lotto> publish(Integer count) {
        List<Lotto> result = new ArrayList<>();
        
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.randomLottoNumberList());
            result.add(lotto);
        }
        
        return result;
    }
    
    private int getCount(Integer amount) {
        return amount / LottoMachineEnum.LOTTO_PRICE.getValue();
    }
    
    private void validate(Integer amount) {
        if (amount % LottoMachineEnum.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException();
        }
    }
}
