package lotto;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningLotto {
    private static final String AVAILABLE_NUMBERS = "(([1-9])|([1-3][0-9])|(4[0-5]))";
    private static final String REGEX_LOTTO_TO_VALID
            = "^"
            + "(?<n1>" + AVAILABLE_NUMBERS + ")" + ","
            + "(?!(\\k<n1>),)" + "(?<n2>" + AVAILABLE_NUMBERS + ")" + ","
            + "(?!((\\k<n1>)|(\\k<n2>)),)" + "(?<n3>" + AVAILABLE_NUMBERS + ")" + ","
            + "(?!((\\k<n1>)|(\\k<n2>)|(\\k<n3>)),)" + "(?<n4>" + AVAILABLE_NUMBERS + ")" + ","
            + "(?!((\\k<n1>)|(\\k<n2>)|(\\k<n3>)|(\\k<n4>)),)" + "(?<n5>" + AVAILABLE_NUMBERS + ")" + ","
            + "(?!((\\k<n1>)|(\\k<n2>)|(\\k<n3>)|(\\k<n4>)|(\\k<n5>)),)" + "(?<n6>" + AVAILABLE_NUMBERS + ")" + ","
            + "(?!((\\k<n1>)|(\\k<n2>)|(\\k<n3>)|(\\k<n4>)|(\\k<n5>)|(\\k<n6>)))" + "(?<n7>" + AVAILABLE_NUMBERS + ")"
            + "$";

    private static final Pattern patternLotto = Pattern.compile(REGEX_LOTTO_TO_VALID);

    private final List<Integer> primaryNumbers;
    private final Integer bonusNumber;

    public WinningLotto(String numbers) {
        Matcher matcher = patternLotto.matcher(numbers);
        if (!matcher.find()) {
            Logger.error("올바르지 않은 값을 입력 하였습니다: " + numbers);
            throw new IllegalArgumentException();
        }
        primaryNumbers = primaryNumbersOf(matcher);
        bonusNumber = bonusNumberOf(matcher);
    }

    private List<Integer> primaryNumbersOf(Matcher matcher) {
        return Stream.of(matcher.group("n1"),
                        matcher.group("n2"),
                        matcher.group("n3"),
                        matcher.group("n4"),
                        matcher.group("n5"),
                        matcher.group("n6"))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    private Integer bonusNumberOf(Matcher matcher) {
        return Integer.parseInt(matcher.group("n7"));
    }

    public Optional<Prize> evaluateTo(Lotto lotto) {
        Predicate<Prize> pipeMatching = prize -> primaryNumbers.stream()
                .filter(lotto::hasNumber)
                .count() == prize.getNumMatch();

        Predicate<Prize> pipeBonusProcessing = prize -> {
            if (prize.needsBonusNumber()) {
                return lotto.hasNumber(bonusNumber);
            }
            return true;
        };

        return Prize.pickAnyWith(pipeMatching.and(pipeBonusProcessing));
    }
}
