package lotto.model;

import static java.util.stream.Collectors.joining;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    public static final int DEFAULT_STATUS_COUNT_VALUE = 0;
    public static final int ADD_ONE_COUNT = 1;
    public static final int RANDOM_START_INCLUSIVE = 0;
    public static final String LOTTO_RESULT_TYPE = "{0} - {1}개";
    public static final String NEXT_LINE = "\n";
    private final List<Lotto> lottoNumbers;

    LottoNumbers() {
        this.lottoNumbers = new ArrayList<>();
    }

    void addLotto(Lotto lotto) {
        lottoNumbers.add(lotto);
    }

    void addRandomLotto(int n) {
        IntStream.range(RANDOM_START_INCLUSIVE, n)
                .forEach(k -> addLotto(Lotto.CreatRandomLotto()));
    }


    int getProfitSum(Lotto targetLotto, int bonusNumber) {
        return lottoNumbers.stream()
                .map(lotto -> lotto.matchLotto(targetLotto, bonusNumber))
                .mapToInt(LottoStatus::getProfit)
                .sum();
    }

    String getPurchaseDetails() {
        return lottoNumbers.stream()
                .map(Lotto::toString)
                .collect(joining(NEXT_LINE));
    }

    String getResult(Lotto targetLotto, int bonusNumber) {
        EnumMap<LottoStatus, Integer> lottoStatusQuantity = addAllStatus(targetLotto, bonusNumber);
        return lottoStatusQuantity.entrySet().stream()
                .filter(lottoStatusEntry -> !lottoStatusEntry.getKey().equals(LottoStatus.MATCH_UNSATISFIED))
                .map(LottoNumbers::getResultFormat)
                .collect(Collectors.joining(NEXT_LINE));
    }

    private static String getResultFormat(Entry<LottoStatus, Integer> lottoStatusEntry) {
        return MessageFormat.format(LOTTO_RESULT_TYPE,
                lottoStatusEntry.getKey().getDescription(),
                lottoStatusEntry.getValue());
    }

    private EnumMap<LottoStatus, Integer> addAllStatus(Lotto targetLotto, int bonusNumber) {
        EnumMap<LottoStatus, Integer> lottoStatusQuantity = defaultLottoStatusQuantity();
        lottoNumbers.stream()
                .map(lotto -> lotto.matchLotto(targetLotto, bonusNumber))
                .forEach(lottoStatus ->
                        lottoStatusQuantity.replace(lottoStatus, lottoStatusQuantity.get(lottoStatus) + ADD_ONE_COUNT));
        return lottoStatusQuantity;
    }

    private static EnumMap<LottoStatus, Integer> defaultLottoStatusQuantity() {
        EnumMap<LottoStatus, Integer> lottoStatusQuantity = new EnumMap<>(LottoStatus.class);
        Arrays.stream(LottoStatus.values())
                .forEach(lottoStatus -> lottoStatusQuantity.putIfAbsent(lottoStatus, DEFAULT_STATUS_COUNT_VALUE));
        return lottoStatusQuantity;
    }


    int getLottoQuantity() {
        return lottoNumbers.size();
    }


    boolean contains(Lotto lotto) {
        return lottoNumbers.contains(lotto);
    }
}
