package lotto.model;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    public static final int DEFAULT_STATUS_COUNT_VALUE = 0;
    public static final int ADD_ONE_COUNT = 1;
    public static final int RANDOM_START_INCLUSIVE = 0;
    public static final String LOTTO_RESULT_DELIMITER = "\n";
    public static final String LOTTO_RESULT_TYPE = "{0} - {1}개";
    private final List<Lotto> lottoNumbers;
    private final EnumMap<LottoStatus, Integer> lottoStatusQuantity;

    public LottoNumbers() {
        this.lottoNumbers = new ArrayList<>();
        this.lottoStatusQuantity = new EnumMap<>(LottoStatus.class);
        Arrays.stream(LottoStatus.values())
                .forEach(lottoStatus -> lottoStatusQuantity.putIfAbsent(lottoStatus, DEFAULT_STATUS_COUNT_VALUE));
    }

    void addLotto(Lotto lotto) {
        lottoNumbers.add(lotto);
    }

    void addRandomLotto(int n) {
        IntStream.range(RANDOM_START_INCLUSIVE, n)
                .forEach(k -> addLotto(Lotto.CreatRandomLotto()));
    }

    void addAllStatus(Lotto targetLotto, int bonusNumber) {
        lottoNumbers.stream()
                .map(lotto -> lotto.matchLotto(targetLotto, bonusNumber))
                .forEach(this::addStatus);
    }

    void addStatus(LottoStatus lottoStatus) {
        lottoStatusQuantity.replace(lottoStatus, lottoStatusQuantity.get(lottoStatus) + ADD_ONE_COUNT);
    }

    int getProfitSum() {
        return lottoStatusQuantity.entrySet().stream()
                .map(entry -> entry.getKey().getProfit() * entry.getValue())
                .reduce(Integer::sum).orElse(DEFAULT_STATUS_COUNT_VALUE);
    }

    String getPurchaseDetails() {
        return lottoNumbers.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    String getResult(Lotto targetLotto, int bonusNumber) {
        addAllStatus(targetLotto, bonusNumber);
        return lottoStatusQuantity.entrySet().stream()
                .filter(lottoStatusEntry -> !lottoStatusEntry.getKey().equals(LottoStatus.MATCH_UNSATISFIED))
                .map(lottoStatusEntry -> MessageFormat.format(LOTTO_RESULT_TYPE,
                        lottoStatusEntry.getKey().getDescription(),
                        lottoStatusEntry.getValue()))
                .collect(Collectors.joining(LOTTO_RESULT_DELIMITER));
    }

    int getLottoQuantity() {
        return lottoNumbers.size();
    }

    int getStatusCount(LottoStatus lottoStatus) {
        return lottoStatusQuantity.getOrDefault(lottoStatus, DEFAULT_STATUS_COUNT_VALUE);
    }

    boolean contains(Lotto lotto) {
        return lottoNumbers.contains(lotto);
    }
}
