package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static final Integer LOTTO_PRICE = 1000;
    
    public List<Lotto> buy(Integer amount) {
        validate(amount);
        return publish(getCount(amount));
    }
    
    private List<Lotto> publish(Integer count) {
        List<Lotto> result = new ArrayList<>();
        
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(new ArrayList<>(LottoNumberGenerator.randomLottoNumberList()));
            result.add(lotto);
        }
        
        return result;
    }
    
    private int getCount(Integer amount) {
        return amount / LottoMachine.LOTTO_PRICE;
    }
    
    private void validate(Integer amount) {
        if (amount % LottoMachine.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
