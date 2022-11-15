package lotto.service;

import lotto.domain.WinPrize;

import java.util.EnumMap;
import java.util.stream.Collectors;

public class LottoPrizeRecordingService {

    private EnumMap<WinPrize, Long> prizeRecording;
    private long totalPrizeMoney;

    public LottoPrizeRecordingService() {
        this.prizeRecording = new EnumMap<>(WinPrize.class);
    }

    public void setPrizeRecording(WinPrize winPrize) {
        if (!winPrize.equals(WinPrize.NOTHING)) {
            prizeRecording.put(winPrize, prizeRecording.getOrDefault(winPrize, 0L) + 1);
        }
    }

    public EnumMap<WinPrize, Long> getPrizeRecording() {
        return prizeRecording;
    }

    public long getTotalPrizeMoney() {
        return totalPrizeMoney;
    }

    public void setTotalPrizeMoney() {
        totalPrizeMoney = prizeRecording.keySet().stream().map(
                        (key) -> key.getPrice() * prizeRecording.get(key))
                .collect(Collectors.toList())
                .stream()
                .reduce(0L, Long::sum);
    }

    public double getPrizeRate(long purchaseMoney) {
        setTotalPrizeMoney();

        return (double) totalPrizeMoney / purchaseMoney;
    }
}
