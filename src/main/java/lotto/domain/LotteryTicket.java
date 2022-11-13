package lotto.domain;

import java.util.List;
import java.util.UUID;

public class LotteryTicket extends Lotto {
    private String lotteryId;

    public LotteryTicket(List<Integer> numbers) {
        super(numbers);
        lotteryId = UUID.randomUUID().toString();
    }

    public String getLotteryId() {
        return lotteryId;
    }
}
