package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class LottoView {
    private Lotto lotto = null;
    private User user = null;

    public void start(){
        purchaseUserLotto();
        printUserLottos();
        inputLotto();
        printStatistics();
        printRateOfReturn();
    }

    public void purchaseUserLotto() throws IllegalArgumentException {
        int purchasePrice = 0;
        try {
            purchasePrice = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요");
        }
        user = new User(purchasePrice);
    }

    private void printUserLottos() {
        int lenUserLottos = user.getUserLottos().size();

        System.out.println(lenUserLottos + "개를 구매했습니다.");
        for (List<Integer> number : user.getUserLottos()) {
            System.out.println(number);
        }
        System.out.println();
    }

    public void inputLotto() throws IllegalArgumentException {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = inputWinningNumber();

        System.out.println("보너스 번호를 입력해 주세요");
        int bonusNumber = inputBonusNumber();

        lotto = new Lotto(numbers, bonusNumber);
    }

    private List<Integer> inputWinningNumber() throws IllegalArgumentException {
        String inputNumbers = Console.readLine();
        List<Integer> numbers = null;
        try {
            numbers = Arrays.stream(inputNumbers.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자,숫자,숫자,숫자,숫자,숫자 형태로 입력해주세요");
        }

        return numbers;
    }

    private int inputBonusNumber() throws IllegalArgumentException {
        int bonusNumber = 0;
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요");
        }

        return bonusNumber;
    }

    public void printStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
        user.setCountRanking(lotto);
        Map<LottoRanking, Integer> countRanking = user.getCountRanking();
        List<LottoRanking> lottoRankings = new ArrayList<>(List.of(LottoRanking.values()));
        Collections.reverse(lottoRankings);
        for (LottoRanking lottoRanking : lottoRankings) {
            int count = countRanking.get(lottoRanking);
            System.out.printf("%s - %d개%n", lottoRanking, count);
        }
    }

    public void printRateOfReturn(){
        System.out.printf("총 수익률은 %s%%입니다.%n", user.caculateRateOfReturn().toString());
    }
}