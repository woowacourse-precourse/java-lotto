package lotto;

import static lotto.Constant.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rank {
    private final int bonusNumber;
    private final Lotto lottoNumbers;

    public Rank() {
        this.lottoNumbers = UI.getLottoNumbers();
        this.bonusNumber = UI.getBonusNumber();
        validateBonusNumber();
    }

    private void validateBonusNumber() {
        List<Integer> lottoNum = new ArrayList<>(lottoNumbers.getNumbers());
        lottoNum.add(bonusNumber);
        lottoNum = lottoNum.stream()
                           .distinct()
                           .collect(Collectors.toList());

        if (lottoNum.size() != (LOTTO_NUMBER_SIZE + 1)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호와 중복되지 않는 보너스 번호를 입력해주세요.");
        }

        Lotto lottoForUsingMethod = new Lotto(lottoNumbers.getNumbers());
        List<Integer> checkBonus = new ArrayList<>(Arrays.asList(bonusNumber));
        lottoForUsingMethod.isNumbersInRange(checkBonus);
    }



    public void run(User user) {
        int countLotto = 0;
        int countBonus = 0;
        for (Lotto lotto : user.userLotto) {
            List<Integer> userNumbers = lotto.getNumbers();
            countLotto = countMatchedNumbers(userNumbers);
            countBonus = countMatchedWithBonusNumber(userNumbers);
            updateResult(countLotto, countBonus);
        }
    }

    private int countMatchedNumbers(List<Integer> userNumbers) {
        int count = 0;
        List<Integer> targetNumbers = lottoNumbers.getNumbers();
        for (Integer number : userNumbers) {
            if (targetNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private int countMatchedWithBonusNumber(List<Integer> userNumbers) {
        if (userNumbers.contains(bonusNumber)) {
            return 1;
        }
        return 0;
    }

    private void updateResult(int countLotto, int countBonus) {
        if (countLotto < 3) {
            return;
        }
        if ((countLotto != 5) || (countLotto == 5 && countBonus == 0)) {
            Result result = Result.fromLabel(countLotto);
            result.increaseCount();
            return;
        }
        Result result = Result.fromLabel(countLotto + 2);
        result.increaseCount();
    }

    public static double calculateRateOfReturn(int money) {
        double sum = 0;
        for (Result result : Result.values()) {
            sum += result.count() * result.price();
        }
        return (sum * 100) / money;
    }
}

enum Result {
    FIFTH(3, MESSAGE_FIFTH_PRIZE, 0, FIFTH_PRICE),
    FOURTH(4, MESSAGE_FOURTH_PRIZE, 0, FOURTH_PRICE),
    THIRD(5, MESSAGE_THIRD_PRIZE, 0, THIRD_PRICE),
    SECOND(7, MESSAGE_SECOND_PRIZE, 0, SECOND_PRICE),
    FST(6, MESSAGE_FIRST_PRIZE, 0, FIRST_PRICE);

    private final int label;
    private final String text;
    private int count;
    private final int price;

    Result(int label, String text, int count, int price) {
        this.label = label;
        this.text = text;
        this.count = count;
        this.price = price;
    }

    public static Result fromLabel(int targetLabel) {
        return Arrays.stream(Result.values())
                .filter(result -> result.label == targetLabel)
                .findAny()
                .orElseThrow( () -> new IllegalArgumentException("[ERROR] 존재하지 않는 당첨 결과입니다."));
    }

    public void increaseCount() {
        this.count = this.count + 1;
    }

    public String text() { return text; }
    public int count() { return count; }
    public int price() { return price; }
}
