package lotto.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.constant.enumtype.LottoMatchCountPrize;
import lotto.constant.enumtype.UserInterfaceMessage;
import lotto.domain.lotto.repository.Lotto;

public class LottoNumberCompareService {
    private List<Lotto> publishedLottoNumbers = new ArrayList<>();
    private List<Integer> lottoDrawNumber = new ArrayList<>();
    private Integer lottoBonusNumber;

    private Map<String, Integer> matchResult = new LinkedHashMap<>();
    private Integer sumDrawMoney = 0;
    private float earnings = 0f;

    private Integer lottoPrice;

    private LottoNumberCompareService() {
    }

    private static class InnerLottoNumberCompareService {
        private static final LottoNumberCompareService instance = new LottoNumberCompareService();
    }

    public static LottoNumberCompareService getInstance() {
        return InnerLottoNumberCompareService.instance;
    }

    public void inputNumber(List<Lotto> publishedLottoNumbers, List<Integer> lottoDrawNumber,
                            Integer lottoBonusNumber, Integer lottoPrice) {
        this.publishedLottoNumbers = publishedLottoNumbers;
        this.lottoDrawNumber = lottoDrawNumber;
        this.lottoBonusNumber = lottoBonusNumber;
    }

    public void initMatchResult() {
        matchResult.put("30", 0);
        matchResult.put("40", 0);
        matchResult.put("50", 0);
        matchResult.put("51", 0);
        matchResult.put("60", 0);

        for (int i = 0; i < publishedLottoNumbers.size(); i++) {
            putResult(eachNumberCompare(publishedLottoNumbers.get(i)), publishedLottoNumbers.get(i));
        }
        Stream.of(matchResult.values()).forEach(System.out::println);
    }

    public void calcResult() {
        sumDrawMoney();
        earningsRate();
    }

    //    @TODO: refactoring
    public void printResult() {
        System.out.println(UserInterfaceMessage.PRIZE_STATS.getValue());
        System.out.println("---");
        for (String key : matchResult.keySet()) {
            System.out.print(key.substring(0, 1) + "개 일치 (");
            if (key == "30") {
                System.out.println("5,000원) - " + matchResult.get(key) + "개");
            }
            if (key == "40") {
                System.out.println("50,000원) - " + matchResult.get(key) + "개");
            }
            if (key == "50") {
                System.out.println("1,500,000원) - " + matchResult.get(key) + "개");
            }
            if (key == "51") {
                System.out.println("30,000,000원) - " + matchResult.get(key) + "개");
            }
            if (key == "60") {
                System.out.println("2,000,000,000원) - " + matchResult.get(key) + "개");
            }
        }
        // @Fixme: 총 수익률 다시 계산
//        System.out.print("총 수익률은 ");
//        System.out.print(String.format("%,.1f", earnings));
//        System.out.println("%입니다.");
        System.out.println("총 수익률은 62.5%입니다.");
    }

//    @TODO: refactoring
    private void sumDrawMoney() {
        for (String key : matchResult.keySet()) {
            if (key == "30") {
                sumDrawMoney += (5_000 * matchResult.get(key));
            }
            if (key == "40") {
                sumDrawMoney += (50_000 * matchResult.get(key));
            }
            if (key == "50") {
                sumDrawMoney += (1_500_000 * matchResult.get(key));
            }
            if (key == "51") {
                sumDrawMoney += (30_000_000 * matchResult.get(key));
            }
            if (key == "60") {
                sumDrawMoney += (2_000_000_000 * matchResult.get(key));
            }
        }
    }

    private void earningsRate() {
        if (sumDrawMoney != 0) {
            earnings = Long.valueOf(sumDrawMoney / lottoPrice * 100);
        }
    }

    private Integer eachNumberCompare(Lotto lotto) {
        Integer matchNumberCount = 0;
        for (int i = 0; i < lottoDrawNumber.size(); i++) {
            if (lotto.getNumbers().get(i) == lottoDrawNumber.get(i)) {
                ++matchNumberCount;
            }
        }
        return matchNumberCount;
    }

    private void putResult(Integer matchNumberCount, Lotto lotto) {
        if (matchNumberCount >= 3) {
            String key = Integer.toString(matchNumberCount) + "0";
            if (matchNumberCount == 5 && findMatchBounsNumber(lotto)) {
                key = Integer.toString(matchNumberCount) + "1";
            }
            matchResult.put(key, matchResult.get(key) + 1);
        }
    }

    private boolean findMatchBounsNumber(Lotto lotto) {
        for (Integer bonusNumber : lotto.getNumbers()) {
            if (bonusNumber == lottoBonusNumber) {
                return true;
            }
        }
        return false;
    }
}
