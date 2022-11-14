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
import lotto.type.ExceptionType;

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
        if (isRoundFinished(roundId)) {
            throw ExceptionType.FINISHED_ROUND.getException();
        }
        lottoBundles.add(lottoBundle);
        userIdMapper.put(ownerId, lottoBundles);
    }

    private boolean isRoundFinished(Long roundId) {
        return !roundId.equals(winNumberRepository.getCurrentRoundId());
    }

    public List<LottoBundle> selectLottoBundles(LottoQueryDto lottoQueryDto) {
        Long roundId = lottoQueryDto.getRoundId();
        Long userId = lottoQueryDto.getUserId();
        HashMap<Long, List<LottoBundle>> userIdMapper = getLottoRound(roundId).getUserIdMapper();
        List<LottoBundle> lottoBundles = userIdMapper.getOrDefault(userId, null);
        if(isNull(lottoBundles)) {
            throw ExceptionType.NULL_PURCHASE.getException();
        }
        return lottoBundles;
    }

    private boolean isNull(List<LottoBundle> lottoBundles) {
        return lottoBundles == null;
    }

    private LottoRound getLottoRound(Long roundId) {
        Optional<LottoRound> selectedLottoRound = lottoBundleRepository.findById(roundId);
        if (selectedLottoRound.isEmpty()) {
            throw ExceptionType.NULL_ROUND.getException();
        }
        return selectedLottoRound.get();
    }
}
