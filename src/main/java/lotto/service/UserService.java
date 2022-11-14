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
        List<LottoBundle> lottoBundles = userDao.selectLottoBundles(lottoQueryDto);
        Long roundId = lottoQueryDto.getRoundId();
        lottoBundles.stream()
                .map(LottoBundle::getLottos)
                .flatMap(Collection::stream)
                .map(lotto -> this.getEachResult(lotto, roundId))
                .forEach(result -> lottoResults.put(result, lottoResults.getOrDefault(result, 0) + 1));
        return lottoResults;
    }

    /**
     * 로또 하나가 특정 회차에 몇 등 당첨인지 알려줍니다.
     */
    private LottoResultType getEachResult(Lotto lotto, Long roundId) {
        return Arrays.stream(LottoResultType.values())
                .filter(result -> result.isAcquired(lotto, roundId))
                .findFirst()
                .get();
    }
}
