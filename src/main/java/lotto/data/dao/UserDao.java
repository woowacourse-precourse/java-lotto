package lotto.data.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import lotto.data.dto.LottoQueryDto;
import lotto.data.entity.LottoBundle;
import lotto.data.entity.LottoRound;
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
        Long roundId = lottoBundle.getRoundId();
        Long ownerId = lottoBundle.getOwnerId();
        HashMap<Long, List<LottoBundle>> userIdMapper = getLottoRound(roundId).getUserIdMapper();
        List<LottoBundle> lottoBundles = userIdMapper.getOrDefault(ownerId, new ArrayList<>());
        if (!roundId.equals(winNumberRepository.getCurrentRoundId())) {
            throw new IllegalArgumentException("[ERROR] 해당 회차는 이미 종료되었습니다.");
        }
        lottoBundles.add(lottoBundle);
        userIdMapper.put(ownerId, lottoBundles);
    }

    public List<LottoBundle> selectLottoBundles(LottoQueryDto lottoQueryDto) {
        Long roundId = lottoQueryDto.getRoundId();
        Long userId = lottoQueryDto.getUserId();
        HashMap<Long, List<LottoBundle>> userIdMapper = getLottoRound(roundId).getUserIdMapper();
        List<LottoBundle> lottoBundles = userIdMapper.getOrDefault(userId, null);
        if(lottoBundles == null) {
            throw new IllegalArgumentException("[ERROR] 해당 유저의 구매 이력이 존재하지 않습니다.");
        }
        return lottoBundles;
    }

    private LottoRound getLottoRound(Long roundId) {
        Optional<LottoRound> selectedLottoRound = lottoBundleRepository.findById(roundId);
        if (selectedLottoRound.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 해당 회차가 존재하지 않습니다.");
        }
        return selectedLottoRound.get();
    }
}
