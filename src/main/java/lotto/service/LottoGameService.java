package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGameService {

    public List<Lotto> pickLottos(int ticketCnt) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i=0; i<ticketCnt; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(numbers));
            OutputView.printLottoNumbers(sortAscending(numbers));
        }
        return lottoList;
    }

    private List<Integer> sortAscending(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public Map<Prize, Integer> compareWinningLotto(List<Lotto> lottoList, Lotto winningLotto, int bonusNumber) {
        Map<Prize, Integer> prizeMap = Prize.initializeMap();
        for (Lotto userLotto : lottoList) {
            int binggoCnt = sizeIntersection(userLotto.getNumbers(), winningLotto.getNumbers());
            Prize prizeType = Prize.getMatchPrize(binggoCnt, checkBonusBinggo(userLotto, bonusNumber));
            plusPrizeCount(prizeMap, prizeType);
        }
        return prizeMap;
    }

    private boolean checkBonusBinggo(Lotto userLotto, int bonusNumber) {
        if (userLotto.getNumbers().contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    private int sizeIntersection(List<Integer> userLottoNumbers, List<Integer> winningLottoNumbers) {
        Set<Integer> numberSet = userLottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .collect(Collectors.toSet());
        return new ArrayList<>(numberSet).size();
    }

    private void plusPrizeCount(Map<Prize, Integer> prizeCountMap, Prize prize) {
        int count = prizeCountMap.get(prize);
        prizeCountMap.put(prize, count+1);
    }

}
