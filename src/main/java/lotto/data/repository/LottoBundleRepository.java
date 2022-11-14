package lotto.data.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import lotto.data.entity.LottoBundle;

public class LottoBundleRepository {

    private static LottoBundleRepository instance;

    private LottoBundleRepository() {}

    public static LottoBundleRepository getInstance() {
        if (instance == null) {
            assignNewInstance();
        }
        return instance;
    }

    private static void assignNewInstance() {
        synchronized (LottoBundleRepository.class) {
            instance = new LottoBundleRepository();
        }
    }

    private final HashMap<Long, List<LottoBundle>> lottoBundleRepository = new HashMap<>();

    public Optional<List<LottoBundle>> findById(Long id) {
        return Optional.ofNullable(lottoBundleRepository.getOrDefault(id, new ArrayList<>()));
    }

    public void save(LottoBundle lottoBundle) {
        Long ownerId = lottoBundle.getOwnerId();
        List<LottoBundle> lottoBundles = lottoBundleRepository.getOrDefault(ownerId, new ArrayList<>());
        lottoBundles.add(lottoBundle);
        lottoBundleRepository.put(ownerId, lottoBundles);
    }
}
