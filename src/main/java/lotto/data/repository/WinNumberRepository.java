package lotto.data.repository;

import java.util.HashMap;
import java.util.Optional;
import lotto.data.entity.WinNumber;

public class WinNumberRepository {

    private static WinNumberRepository instance;

    private WinNumberRepository() {}

    public static WinNumberRepository getInstance() {
        if (instance == null) {
            assignNewInstance();
        }
        return instance;
    }

    private static void assignNewInstance() {
        synchronized (WinNumberRepository.class) {
            instance = new WinNumberRepository();
        }
    }

    private final HashMap<Long, WinNumber> winNumberRepository = new HashMap<>();
    private Long currentRoundId = 0L;

    public Optional<WinNumber> findById(Long id) {
        return Optional.ofNullable(winNumberRepository.getOrDefault(id, null));
    }

    public void save(WinNumber winNumber) {
        Long roundId = winNumber.getRoundId();
        winNumberRepository.put(roundId, winNumber);
        currentRoundId++;
    }

    public Long getCurrentRoundId() {
        return currentRoundId;
    }


}
