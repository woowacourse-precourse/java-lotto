package lotto.data.repository;

import java.util.HashMap;
import java.util.Optional;
import lotto.data.entity.LottoRound;

public class LottoRoundRepository {

    private static LottoRoundRepository instance;

    public static LottoRoundRepository getInstance() {
        if (instance == null) {
            assignNewInstance();
        }
        return instance;
    }

    private static void assignNewInstance() {
        synchronized (LottoRoundRepository.class) {
            instance = new LottoRoundRepository();
        }
    }

    private final HashMap<Long, LottoRound> lottoRoundRepository = new HashMap<>();

    private LottoRoundRepository() {
        long initId = lottoRoundRepository.size() + 1;
        lottoRoundRepository.put(initId, new LottoRound(initId));
    }

    public Optional<LottoRound> findById(Long id) {
        return Optional.ofNullable(lottoRoundRepository.getOrDefault(id, null));
    }

    public void save(LottoRound lottoRound) {
        lottoRoundRepository.put(lottoRound.getRoundId(), lottoRound);
    }

    public int count() {
        return lottoRoundRepository.size();
    }
}
