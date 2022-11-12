package lotto;

import java.util.EnumMap;

public class LottoPrizeRecordingManager {

    private EnumMap<WinPrize, Long> prizeRecording = new EnumMap<>(WinPrize.class);

    public void setPrizeRecording(WinPrize winPrize) {
        if (!winPrize.equals(WinPrize.NOTHING)) {
            prizeRecording.put(winPrize, prizeRecording.getOrDefault(winPrize, 0L) + 1);
        }
    }

    public EnumMap<WinPrize, Long> getPrizeRecording() {
        return prizeRecording;
    }
}
