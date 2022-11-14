package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class CountLottoNumber {

    private RandomLotto randomLotto;
    private CreateLottoList createLottoList;
    private List<List<Integer>> listOfListLotto;
    private List<Integer> correctCountList;
    private int purchaseCount;
    private int purchaseAmount;
    private List<Integer> winningList;
    private int bonusNumber;
    private CorrectState correctState;

    public CountLottoNumber() throws IllegalArgumentException {
        this.randomLotto = new RandomLotto();
        this.listOfListLotto = randomLotto.getRandomLists();
        this.purchaseCount = randomLotto.getPurchaseCount();
        this.purchaseAmount = randomLotto.getPurchaseAmount();
        this.correctCountList = new ArrayList<>();
        this.correctState = CorrectState.NOTHING;
    }

    // 당첨번호 생성
    public void winningLottoNumber() throws IllegalArgumentException{
        this.createLottoList = new CreateLottoList();
        this.winningList = createLottoList.getWinningLottoList();
    }

    // 보너스번호 생성
    public void bonusLottoNumber() {
        this.bonusNumber = createLottoList.getBonusNumber();
    }

    // 로또리스트들 get
    public List<List<Integer>> getRandomLists() {
        return listOfListLotto;
    }

    // 로또구매횟수 get
    public int getPurchaseCount() {
        return purchaseCount;
    }

    // 로또구매금액 get
    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    // 로또리스트를 한줄씩 비교하여 갯수를 배열에 저장하는 기능
    public List<Integer> correctCountCal() {
        int[] correctListArray = {0,0,0,0,0};
        for (List<Integer> lottoList : listOfListLotto) {
            countWinningNumber(lottoList);
            int index = correctState.getIndex();
            if (correctState != CorrectState.NOTHING) correctListArray[index] += 1;
        }
        return correctArrayToList(correctListArray);
    }

    // 로또리스트에 당첨번호가 있는 갯수를 추출하는 기능
    private void countWinningNumber(List<Integer> lottoList) {
        int count = 0;
        for(int w : winningList) {
            if(lottoList.contains(w)) {
                count += 1;
            }
        }
        setCorrectState(count, lottoList);
    }

    // count에 해당하는 correctState 불러오는 기능
    private void setCorrectState(int count, List<Integer> lottoList) {
        this.correctState = correctState.valueOf(count);
        if(correctState == CorrectState.FIVE_CORRECT) {
            this.correctState = fiveBonusCase(lottoList);
        }
    }

    // 5개 당첨일 때 보너스 번호유무에 따라 correctState를 저장하는 기능
    private CorrectState fiveBonusCase(List<Integer> lottoList) {
        if(!(lottoList.contains(bonusNumber))) {
            return CorrectState.FIVE_CORRECT;
        }
        return CorrectState.FIVE_AND_BONUS_CORRECT;
    }

    // 배열을 리스트에 넣기
    private List<Integer> correctArrayToList(int[] correctListArray) {
        for(int arr : correctListArray) {
            correctCountList.add(arr);
        }
        return correctCountList;
    }



}
