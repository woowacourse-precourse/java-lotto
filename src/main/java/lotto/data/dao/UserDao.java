package lotto.data.dao;

import java.util.List;
import java.util.Optional;
import lotto.data.entity.LottoBundle;
import lotto.data.repository.LottoBundleRepository;
import lotto.data.repository.WinNumberRepository;

public class UserDao {
    private final LottoBundleRepository lottoBundleRepository;
    private final WinNumberRepository winNumberRepository;

    public UserDao() {
        lottoBundleRepository = LottoBundleRepository.getInstance();
        winNumberRepository = WinNumberRepository.getInstance();
    }

    public Long getCurrentRoundId() {
        return winNumberRepository.getCurrentRoundId();
    }

    public void insertLottoBundle(LottoBundle lottoBundle) {
        lottoBundleRepository.save(lottoBundle);
    }

    public List<LottoBundle> selectLottoBundles(Long userId) {
        Optional<List<LottoBundle>> selectedLottoBundles = lottoBundleRepository.findById(userId);
        if (selectedLottoBundles.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 해당 ID의 구매 내역이 존재하지 않습니다.");
        }
        return selectedLottoBundles.get();
    }
}
