package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InputView {
    public static int lottoPurchaseMoney = 0;
    public final int PRICE_PER_LOTTO = 1000;

    public List<Integer> lottoResult = Arrays.asList(0,0,0,0,0);
    public List<List<Integer>> allLottoNumber = new ArrayList<>();


    public void validateMoneyInput(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또를 구매하시려면 천원 단위의 금액만 가능합니다.");
        }
    }

    /*
    inputView 에 존재하여야 하는 메소드
    1. 로또 구입 금액 입력
    2. 당첨 번호 입력
    3. 보너스 번호 입력
     */
    public int inputLottoPurchaseMoney() {
        lottoPurchaseMoney = Integer.parseInt(Console.readLine());
        validateMoneyInput(lottoPurchaseMoney);
        return lottoPurchaseMoney;
    }

    // 얘는 LottoTickets 클래스에
    public int getLottoTickets(int money) {
        return lottoPurchaseMoney / PRICE_PER_LOTTO;
    }

    // 당첨번호 입력 메소드이므로 WinningLotto 클래스로
    public List<Integer> createWinningNumber() {
        String inputNumbers = Console.readLine();
        List<Integer> winningNumbers = new ArrayList<>();
        for (String value : inputNumbers.split(",")) {
            winningNumbers.add(Integer.parseInt(value));
        }
        return winningNumbers;
    }

    // 보너스 번호 입력하는 메소드이므로 inputview에
    public int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    // 한 게임의 로또 번호를 자동으로 생성해서 Integer List를 반환
    public List<Integer> createLottoOneGameNumber() {
        List<Integer> oneGameNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return oneGameNumbers;
    }

    // 로또 게임 횟수 만큼 로또 번호를 랜덤하게 발행하는 메소드
    public List<List<Integer>> createAllGameLottoNumber(int ticket) {
        allLottoNumber = new ArrayList<>();
        for (int i = 0; i < ticket; i++) {
            allLottoNumber.add(createLottoOneGameNumber());
        }
        return allLottoNumber;
    }

    // 로또 번호, 당첨 번호, 보너스 번호를 입력받아 등수를 확인함
    public void compareWinningNumber(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        if(lottoNumbers.contains(bonusNumber)){
            List <Integer> result = lottoNumbers.stream()
                    .filter(lottoNumber -> winningNumbers.stream().noneMatch(Predicate.isEqual(lottoNumber)))
                    .collect(Collectors.toList());
            judgeLottoRank(result, bonusNumber);
        }
        if(!lottoNumbers.contains(bonusNumber)){
            List <Integer> result = lottoNumbers.stream()
                    .filter(lottoNumber -> winningNumbers.stream().noneMatch(Predicate.isEqual(lottoNumber)))
                    .collect(Collectors.toList());
            judgeLottoRank(result, bonusNumber);
        }
    }

    // 몇 개 맞췄는지 확인하고 보너스 번호의 유무를 받아서 2등 당첨의 경우를 고려함
    private void judgeLottoRank(List<Integer> result, int bonusNumber) {
        if (result.size() == 0) {
            lottoResult.set(0, lottoResult.get(0)+1);
        }
        if (result.size() == 1 && result.contains(bonusNumber)) {
            lottoResult.set(1, lottoResult.get(1)+1);
        }
        if (result.size() == 1 && !result.contains(bonusNumber)) {
            lottoResult.set(2, lottoResult.get(2)+1);
        }
        if (result.size() == 2) {
            lottoResult.set(3, lottoResult.get(3)+1);
        }
        if (result.size() == 3) {
            lottoResult.set(4, lottoResult.get(4)+1);
        }
    }

    // 당첨 결과를 통해 총 수익을 계산하는 메소드
    public int calculrateLottoEarningMoney(List<Integer> lottoResult) {
        int earningMoney = 0;
        earningMoney += lottoResult.get(0) * 2000000000;
        earningMoney += lottoResult.get(1) * 30000000;
        earningMoney += lottoResult.get(2) * 1500000;
        earningMoney += lottoResult.get(3) * 50000;
        earningMoney += lottoResult.get(4) * 5000;
        return earningMoney;
    }

    // 로또 구입 금액과 수익을 계산하여 수익률을 반환함
    public String calculrateLottoEarningRate(int earningMoney, int purchaseMoney) {
        double earningRate = (double) earningMoney / purchaseMoney * 100;
        String stringFormatResult = String.format("%.1f", earningRate);
        return stringFormatResult;
    }



}
