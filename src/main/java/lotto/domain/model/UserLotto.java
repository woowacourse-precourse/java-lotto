package lotto.domain.model;

import static lotto.utils.Advice.PurchaseValidator.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.utils.LottoGenerator;

public class UserLotto {

    private final List<Lotto> userLotto;

    public UserLotto(List<Lotto> userLotto) {
        this.userLotto = userLotto;
    }

    public UserLotto(String pay) {
        validate(pay);
        this.userLotto = IntStream.rangeClosed(1, Integer.parseInt(pay) / MINIMUM_ORDER)
                .mapToObj(count -> new Lotto(LottoGenerator.makeLotto())).collect(Collectors.toList());
    }

    public static void validate(String pay) {
        checkConsistNumber(pay);
        checkReminder(pay);
    }

    public List<Lotto> getUserLotto() {
        return userLotto;
    }
}
