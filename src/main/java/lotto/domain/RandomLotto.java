package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RandomLotto {

    private PurchaseLotto purchaseLotto;
    private List<List<Integer>> listOfListLotto;
    public int purchaseAmount;
    public int purchaseCount;

    public RandomLotto() throws IllegalArgumentException {
        this.purchaseLotto = new PurchaseLotto();
        this.purchaseCount = purchaseLotto.getPurchaseCount();
        this.purchaseAmount = purchaseLotto.getPurchaseAmount();
        this.listOfListLotto = new ArrayList<>();
        CreateLotto();
    }

    // 금액만큼 로또 번호 생성
    private void CreateLotto() {
        for(int i = 0; i < purchaseCount; i++) {
            TotalLottoList(createRandomList());
        }
    }

    // 6개의 난수 생성
    private List<Integer> createRandomList() {
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }

    // 전체 로또번호 저장
    private void TotalLottoList(List<Integer> randomList) {
        randomList = randomList.stream().sorted().collect(Collectors.toList());
        listOfListLotto.add(randomList);
    }

    // 전체 로또번호 리스트들 get
    public List<List<Integer>> getRandomLists() {
        return listOfListLotto;
    }

    // 로또구매금액 get
    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    // 로또구매횟수 get
    public int getPurchaseCount() {
        return purchaseCount;
    }

}
