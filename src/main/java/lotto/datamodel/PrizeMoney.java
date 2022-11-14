package lotto.datamodel;

import lotto.datamodel.enumdata.Rank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrizeMoney {
    private static final int STANDARD_MONEY = 1000;
    private final List<Integer> prize;

    public PrizeMoney(List<Integer> prize) {
        this.prize = prize;
    }

    public float reward(){
        int frequency;
        float totalPrize = 0;

        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                frequency = Collections.frequency(prize, rank.getAmount());
                totalPrize += ((float)rank.getAmount() / STANDARD_MONEY * frequency);
            }
        }
        return totalPrize;
    }

    public List<String> moneyInformation() {
        List<String> moneyInfo = new ArrayList<>(5);

        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                moneyInfo.add(rank.getInformation());
            }
        }
        return moneyInfo;
    }

    public List<Integer> getFrequency() {
        int winCount = 0;
        List<Integer> winingLotto = new ArrayList<Integer>(5);

        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                winingLotto.add(Collections.frequency(prize, rank.getAmount()));
            }
        }
        return winingLotto;
    }
}
