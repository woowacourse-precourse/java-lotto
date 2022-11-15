package lotto.data.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import lotto.data.entity.LottoBundle;
import lotto.data.entity.LottoRound;
import lotto.data.entity.WinNumber;
import lotto.data.repository.LottoRoundRepository;
import lotto.data.repository.WinNumberRepository;
import lotto.type.ExceptionType;

public class UserDao {
    private final LottoRoundRepository lottoRoundRepository;
    private final WinNumberRepository winNumberRepository;

    public UserDao() {
        lottoRoundRepository = LottoRoundRepository.getInstance();
        winNumberRepository = WinNumberRepository.getInstance();
    }

    public Long getCurrentRoundId() {
        return (long) lottoRoundRepository.count();
    }

    public void insertLottoBundle(LottoBundle lottoBundle) {
        Long roundId = lottoBundle.getRoundId();
        Long ownerId = lottoBundle.getOwnerId();
        HashMap<Long, List<LottoBundle>> userIdMapper = selectLottoRound(roundId).getUserIdMapper();
        List<LottoBundle> lottoBundles = userIdMapper.getOrDefault(ownerId, new ArrayList<>());
        if (isRoundFinished(roundId)) {
            throw ExceptionType.FINISHED_ROUND.getException();
        }
        lottoBundles.add(lottoBundle);
        userIdMapper.put(ownerId, lottoBundles);
    }

    private boolean isRoundFinished(Long roundId) {
        return !roundId.equals((long) lottoRoundRepository.count());
    }

    public List<LottoBundle> selectLottoBundles(Long roundId, Long userId) {
        HashMap<Long, List<LottoBundle>> userIdMapper = selectLottoRound(roundId).getUserIdMapper();
        List<LottoBundle> lottoBundles = userIdMapper.getOrDefault(userId, null);
        if(lottoBundles == null) {
            throw ExceptionType.NULL_PURCHASE.getException();
        }
        return lottoBundles;
    }

    public LottoRound selectLottoRound(Long roundId) {
        Optional<LottoRound> selectedLottoRound = lottoRoundRepository.findById(roundId);
        if (selectedLottoRound.isEmpty()) {
            throw ExceptionType.NULL_ROUND.getException();
        }
        return selectedLottoRound.get();
    }

    public WinNumber selectWinNumber(Long roundId) {
        Optional<WinNumber> selectedWinNumber = winNumberRepository.findById(roundId);
        if (selectedWinNumber.isEmpty()) {
            throw ExceptionType.NULL_WIN_NUMBER.getException();
        }
        return selectedWinNumber.get();
    }
}
