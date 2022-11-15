package lotto.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.data.dao.UserDao;
import lotto.data.dto.LottoBundleDto;
import lotto.data.dto.LottoDto;
import lotto.data.dto.LottoQueryDto;
import lotto.data.entity.Lotto;
import lotto.data.entity.LottoBundle;
import lotto.data.entity.WinNumber;
import lotto.type.LottoResultType;

public class UserService {

    private final UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public void purchaseLottoBundle(LottoBundleDto lottoBundleDto) {
        Long ownerId = lottoBundleDto.getOwnerId();
        Long roundId = userDao.getCurrentRoundId();
        lottoBundleDto.setRoundId(roundId);
        List<Lotto> lottos = lottoBundleDto.getLottos().stream()
                .map(LottoDto::getNumbers)
                .map(Lotto::new)
                .collect(Collectors.toList());
        LottoBundle lottoBundle = new LottoBundle(ownerId, roundId, lottos);
        userDao.insertLottoBundle(lottoBundle);
    }

    public HashMap<LottoResultType, Integer> getMyResult(LottoQueryDto lottoQueryDto) {
        HashMap<LottoResultType, Integer> lottoResults = new HashMap<>();
        Long userId = lottoQueryDto.getUserId();
        Long roundId = lottoQueryDto.getRoundId();
        WinNumber winNumber = userDao.selectWinNumber(roundId);
        List<LottoBundle> lottoBundles = userDao.selectLottoBundles(roundId, userId);
        lottoBundles.stream()
                .map(LottoBundle::getLottos)
                .flatMap(Collection::stream)
                .map(lotto -> this.getEachResult(lotto, winNumber))
                .forEach(result -> lottoResults.put(result, lottoResults.getOrDefault(result, 0) + 1));
        return lottoResults;
    }

    private LottoResultType getEachResult(Lotto lotto, WinNumber winNumber) {
        return Arrays.stream(LottoResultType.values())
                .filter(result -> result.isAcquired(lotto, winNumber))
                .findFirst()
                .get();
    }
}
