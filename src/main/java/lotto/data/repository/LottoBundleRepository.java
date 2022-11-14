package lotto.data.repository;

import java.util.HashMap;
import java.util.Optional;
import lotto.data.entity.LottoRound;

public class LottoBundleRepository {

    private static LottoBundleRepository instance;

    public static LottoBundleRepository getInstance() {
        if (instance == null) {
            assignNewInstance();
        }
        return instance;
    }

    private static void assignNewInstance() {
        synchronized (LottoBundleRepository.class) {
            instance = new LottoBundleRepository(0L);
        }
    }

    private final HashMap<Long, LottoRound> lottoBundleRepository = new HashMap<>();

    private LottoBundleRepository(Long initRoundId) {
        lottoBundleRepository.put(initRoundId, new LottoRound(initRoundId));
    }

    public Optional<LottoRound> findById(Long roundId) {
        return Optional.ofNullable(lottoBundleRepository.getOrDefault(roundId, null));
    }

    public void createNewColumn(Long roundId) {
        lottoBundleRepository.put(roundId, new LottoRound(roundId));
    }
}
