package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private String price;

    public LottoGenerator(String price) {
        haveOnlyNumbers(price);
        divideByThousand(price);
        this.price = price;
    }

    public List<List<Integer>> issueLotto() {
        List<List<Integer>> totalLottoNumbers = new ArrayList<>();
        int totalAmount = Integer.parseInt(price) / 1000;

        for (int count = 0; count < totalAmount; count++) {
            totalLottoNumbers.add(createLottoNumbers());
        }

        return totalLottoNumbers;
    }

    public List<Integer> createLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(sortLottoNumbers);
        return sortLottoNumbers;
    }

    private void haveOnlyNumbers(String price) {
        final String numberRegex = "[0-9]+";
        if (!price.matches(numberRegex)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자만 입력하세요");
        }
    }

    private void divideByThousand(String price) {
        if (Integer.parseInt(price) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 1000원 단위로 입력하세요.");
        }
    }

}

