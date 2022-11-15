package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.Check;
import lotto.exception.CustomException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {

    private List<Lotto> playerLottos;
    private int buyMoney;

    public HashMap<LottoResult, Integer> compareLottos(List<Lotto> playerLottos, List<Integer> pickLotto, int pickPlusLotto) {
        HashMap<LottoResult, Integer> lottoResults = new HashMap<>();

        for (Lotto playerLotto : playerLottos) {
            List<Integer> playerLottoNumbers = playerLotto.getNumbers();
            LottoResult confirmLottoResult = confirmLotto(pickLotto, pickPlusLotto, playerLottoNumbers);
            putLottoResults(lottoResults, confirmLottoResult);
        }

        return lottoResults;
    }

    private LottoResult confirmLotto(List<Integer> pickLotto, int pickPlusLotto, List<Integer> playerLottoNumbers) {
        int sameCount = 0;
        boolean samePlusLotto = false;

        for (Integer playerLottoNumber : playerLottoNumbers) {
            if (pickLotto.contains(playerLottoNumber)) sameCount++;
            if (pickPlusLotto == playerLottoNumber) samePlusLotto = true;
        }

        LottoResult lottoResult = new LottoResult(sameCount, samePlusLotto);
        return lottoResult;
    }

    private void putLottoResults(HashMap<LottoResult, Integer> lottoResults, LottoResult confirmLottoResult) {
        int sameCount = confirmLottoResult.getSameCount();
        if (sameCount < 3) return;
        if (sameCount != 5) confirmLottoResult.setSamePlusLotto(false);
        lottoResults.put(confirmLottoResult, lottoResults.getOrDefault(confirmLottoResult, 0) + 1);
    }

    public List<Lotto> buyLotto(int buyMoney) {
        setBuyMoney(buyMoney);
        playerLottos = publishRandomNumbers();
        return playerLottos;
    }

    private void setBuyMoney(int buyMoney) {
        Check check = new Check();
        if (check.haveRest(buyMoney)) {
            throw new IllegalArgumentException(CustomException.HAVEREST.getMessage());
        }
        this.buyMoney = buyMoney;
    }

    private List<Lotto> publishRandomNumbers() {
        List<Lotto> playerLottos = new ArrayList<>();

        while (buyMoney >= 1000) {
            List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(uniqueNumbers);
            playerLottos.add(lotto);
            buyMoney -= 1000;
        }

        return playerLottos;
    }

    public void printPublishLotto() {
        int size = playerLottos.size();
        System.out.println(size+ "개를 구매했습니다.");

        playerLottos.forEach(Lotto::ascendingSort);
        playerLottos.stream().map(Lotto::getNumbers).forEach(System.out::println);
    }

    public void printRankYield(HashMap<LottoResult, Integer> lottoResults, int buyMoney) {
        System.out.println("당첨 통계\n" + "---");
        long yield = 0;
        float yieldF = 0;

        setLottoResultsRank(lottoResults);

        for (Rank rank : Rank.values()) {
            System.out.println(rank.getMessage());
            yield += rank.getMoney() * rank.getAmount();
        }
        yieldF = (float) yield / buyMoney * 100;
        System.out.println("총 수익률은 "+ String.format("%.1f", yieldF) + "%" + "입니다.");
    }

    private void setLottoResultsRank(HashMap<LottoResult, Integer> lottoResults) {
        for (LottoResult lottoResult : lottoResults.keySet()) {
            int sameCount = lottoResult.getSameCount();
            boolean samePlusLotto = lottoResult.isSamePlusLotto();
            setRankAmount(sameCount, samePlusLotto, lottoResults.get(lottoResult));
        }
    }

    private void setRankAmount(int sameCount, boolean samePlusLotto, int amount) {
        for (Rank rank : Rank.values()) {
            if (sameCount == rank.getMatchCnt() && samePlusLotto == rank.isHavePlusLotto()) {
                rank.setAmount(amount);
                break;
            }
        }
    }

}
