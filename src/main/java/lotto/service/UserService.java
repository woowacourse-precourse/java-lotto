package lotto.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lotto.data.dto.LottoBundleDto;
import lotto.data.dto.LottoDto;
import lotto.data.entity.Lotto;
import lotto.data.entity.LottoBundle;
import lotto.data.repository.LottoBundleRepository;
import lotto.data.repository.WinNumberRepository;
import lotto.type.LottoResultType;

public class UserService {

    private final LottoBundleRepository lottoBundleRepository;
    private final WinNumberRepository winNumberRepository;

    public UserService() {
        lottoBundleRepository = LottoBundleRepository.getInstance();
        winNumberRepository = WinNumberRepository.getInstance();
    }

    /**
     * 로또 묶음을 구매합니다.
     */
    public void purchaseLottoBundle(LottoBundleDto lottoBundleDto) {
        Long ownerId = lottoBundleDto.getOwnerId();
        Long roundId = winNumberRepository.getCurrentRoundId();
        List<Lotto> lottos = lottoBundleDto.getLottos().stream()
                .map(LottoDto::getNumbers)
                .map(Lotto::new)
                .collect(Collectors.toList());
        LottoBundle lottoBundle = new LottoBundle(ownerId, roundId, lottos);
        lottoBundleRepository.save(lottoBundle);
    }

    /**
     * 구매한 로또들 중 각 당첨이 몇 개인지 알려줍니다.
     */
    public HashMap<LottoResultType, Integer> getMyResult(Long userId) {
        HashMap<LottoResultType, Integer> lottoResults = new HashMap<>();
        Optional<List<LottoBundle>> selectedLottoBundles = lottoBundleRepository.findById(userId);
        if (selectedLottoBundles.isEmpty()) {
            throw new NullPointerException();
        }
        List<LottoBundle> lottoBundles = selectedLottoBundles.get();
        Long roundId = lottoBundles.get(0).getRoundId();
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
