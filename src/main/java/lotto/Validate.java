package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {
    public static void lottoSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자가 6개가 아닙니다.");
        }
    }

    public static void lottoDuplicate(List<Integer> lottoNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        if (nonDuplicateNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }

    public static void bonusNumberBelongsNumber(List<Integer> lottoNumber, Integer bonusNumber) {
        if (lottoNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호와 보너스 번호는 달라야 합니다.");
        }
    }

    public static void number(String input, String bonusNumber) {
        if (!input.matches("^(\\d?,){5}\\d?$")) {
            throw new IllegalArgumentException("[ERROR] 숫자와 ,만 입력해 주세요.");
        }

        if (!bonusNumber.matches("^\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }

    public static void inRangeLottoNumber(Integer lottoNumber) {
        if (lottoNumber >= 1 && lottoNumber <= 45) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
