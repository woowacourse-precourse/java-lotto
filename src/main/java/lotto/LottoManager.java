package lotto;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;


public class LottoManager {
    final static int winningMoney[] = WinningStatus.getMoneyList();
    // 로또 구입 금액
    int money;
    // 로또 갯수
    int lottoCount;

    // 로또 리스트
    List<Lotto> lottoList;

    // 당첨 번호 리스트
    List<Integer> winningNumber;

    // 보너스 번호
    int bonusNumber;

    // 당첨 통계
    Map<Integer, Integer> winningStatistic;

    // 수익률
    double rateOfReturn;

    // 전체 동작을 구현하는 메소드
    public void run() {
        // 금액 투입 UI
        insertMoneyUI();
        // 로또 생성 UI
        createLottoUI();
        // 당첨번호 입력 UI
        insertWinningNumberUI();
        // 보너스 번호 입력 UI
        insertBonusNumberUI();
        // 당첨 체크 UI
        winningCheckUI();
        // 수익률 체크 UI
        rateOfReturnUI();
    }


    // 로또 구입 금액 입력이 유효한지 확인
    // 1. 숫자가 아닌 값 입력 시
    // 2. 1,000원 단위가 아닌 값 입력 시
    public void validateInsertMoney(String stringMoney) {
        try {
            money = Integer.parseInt(stringMoney);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아닌 값을 입력했습니다.");
            throw new NoSuchElementException("[ERROR] 숫자가 아닌 값을 입력했습니다.");
        }

        if (money <= 0) {
            System.out.println("[ERROR] 자연수 값이여야 합니다.");
            throw new NoSuchElementException("[ERROR] 자연수 값이여야 합니다.");
        }

        if (money % 1000 != 0) {
            System.out.println("[ERROR] 1,000원 단위로 입력해야 합니다.");
            throw new NoSuchElementException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }
    }

    // 로또 구입 금액 입력받기
    public void insertMoney(String stringMoney) {
        validateInsertMoney(stringMoney);

        this.money = Integer.parseInt(stringMoney);
    }

    // 사용자로부터 로또 구입 금액 입력받는 UI 메소드
    public void insertMoneyUI() {
        System.out.println("구입 금액을 입력해 주세요.");
        String stringMoney = readLine();
        System.out.println();
        insertMoney(stringMoney);
    }

    // 로또 리스트를 생성하는 메소드
    public void createLottoList() {
        // 로또 배열 생성
        lottoList = new ArrayList<>();
        // lottoCount 만큼 로또 생성
        for (int i = 0; i < this.lottoCount; i++) {
            createLotto();
        }
    }

    // 로또 번호를 생성하는 메소드
    public void createLotto() {
        // 1~45 랜덤 번호 6개 생성
        ArrayList<Integer> numberList = new ArrayList<>(pickUniqueNumbersInRange(1, 45, 6));

        // 랜덤 번호 오름차순 정렬
        numberList.sort((o1, o2) -> o1 - o2);

        lottoList.add(new Lotto(numberList));
    }

    // 구입 금액으로 부터 로또 갯수를 계산하는 메소드
    public void calcLottoCount() {
        // 1000원 단위이므로 항상 나누어 떨어진다.
        this.lottoCount = money / 1000;
    }

    // 로또 생성 UI 메소드
    public void createLottoUI() {
        // 구입할 로또 갯수 계산
        calcLottoCount();

        System.out.printf("%d개를 구매했습니다.\n", this.lottoCount);

        // 로또 리스트 생성
        createLottoList();

        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    // 당첨 번호 입력값 검증을 하는 메소드
    // 1. ,로 구분하였을 때 6자리가 아닌 경우
    // 2. - 각 구분된 값들이 1~45의 자연수가 아닌 경우
    public void validateWinningNumber(String stringWinningNumber) {
        String splitList[] = stringWinningNumber.split(",");

        if (splitList.length != 6) {
            System.out.println("[ERROR] 당첨 번호 6개를 입력해야 합니다.");
            throw new NoSuchElementException("[ERROR] 당첨 번호 6개를 입력해야 합니다.");
        }

        for (String stringNumber : splitList) {
            validateWinningNaturalNumber(stringNumber);
        }
    }


    // 당첨 번호가 1~45사이의 자연수인지 판단
    public void validateWinningNaturalNumber(String stringNumber) {
        try {
            int intNumber = Integer.parseInt(stringNumber);

            if (!(1 <= intNumber && intNumber <= 45)) {
                System.out.println("[ERROR] 각 당첨 번호는 1~45 자연수여야 합니다.");
                throw new NoSuchElementException("[ERROR] 각 당첨 번호는 1~45 자연수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 각 당첨 번호는 1~45 자연수여야 합니다.");
            throw new NoSuchElementException("[ERROR] 각 당첨 번호는 1~45 자연수여야 합니다.");
        }
    }

    // 중복된 값이 있는지 체크
    public void duplicateWinningNumberCheck(String stringWinningNumber) {
        List<String> splitList = Arrays.asList(stringWinningNumber.split(","));

        List<String> uniqueList = splitList.stream().distinct().collect(Collectors.toList());
        if (uniqueList.size() != 6) {
            System.out.println("[ERROR] 각 당첨 번호는 중복되지 않는 값이여야 합니다.");
            throw new NoSuchElementException("[ERROR] 각 당첨 번호는 중복되지 않는 값이여야 합니다.");
        }
    }

    // 당첨 번호를 입력받는 메소드
    public void insertWinningNumber(String stringWinningNumber) {
        // 리스트 생성
        winningNumber = new ArrayList<>();

        // 입력값 체크
        validateWinningNumber(stringWinningNumber);
        duplicateWinningNumberCheck(stringWinningNumber);

        // 당첨번호 리스트에 원소 추가
        List<String> splitList = Arrays.asList(stringWinningNumber.split(","));
        for (String stringNumber : splitList) {
            winningNumber.add(Integer.parseInt(stringNumber));
        }

        // 당첨 번호 오름차순 정렬
        winningNumber.sort((o1, o2) -> o1 - o2);
    }

    // 당첨 번호를 입력받는 UI 메소드
    public void insertWinningNumberUI() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String stringWinningNumber = readLine();
        System.out.println();
        insertWinningNumber(stringWinningNumber);
    }


    // 보너스 번호 입력값 검증을 하는 메소드
    public void validateInsertBonusNumber(String stringBonusNumber) {
        try {
            int bonusNumber = Integer.parseInt(stringBonusNumber);

            if (!(1 <= bonusNumber && bonusNumber <= 45)) {
                System.out.println("[ERROR] 보너스 번호는 1~45 의 자연수여야 합니다.");
                throw new NoSuchElementException("[ERROR] 보너스 번호는 1~45 의 자연수여야 합니다.");
            }

            if (winningNumber.contains(bonusNumber)) {
                System.out.println("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
                throw new NoSuchElementException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 보너스 번호는 정수를 입력해야 합니다.");
            throw new NoSuchElementException("[ERROR] 보너스 번호는 정수를 입력해야 합니다.");
        }
    }

    // 보너스 번호를 입력받는 메소드
    public void insertBonusNumber(String stringBonusNumber) {
        validateInsertBonusNumber(stringBonusNumber);

        // 보너스 번호 추가
        bonusNumber = Integer.parseInt(stringBonusNumber);
    }

    // 보너스 번호를 입력받는 UI 메소드
    public void insertBonusNumberUI() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String stringBonusNumber = readLine();
        System.out.println();
        insertBonusNumber(stringBonusNumber);
    }

    // 당첨 통계 처리 메소드
    public void statisticalProcessing(int winningCount, boolean isBonus) {
        if (winningCount == 3) {
            winningStatistic.put(WinningStatus.FIFTH.getWinningIntegerValue(), winningStatistic.get(WinningStatus.FIFTH.getWinningIntegerValue()) + 1);
            return;
        }

        if (winningCount == 4) {
            winningStatistic.put(WinningStatus.FOURTH.getWinningIntegerValue(), winningStatistic.get(WinningStatus.FOURTH.getWinningIntegerValue()) + 1);
            return;
        }

        if (winningCount == 5 && isBonus) {
            winningStatistic.put(WinningStatus.THIRD.getWinningIntegerValue(), winningStatistic.get(WinningStatus.THIRD.getWinningIntegerValue()) + 1);
            return;
        }

        if (winningCount == 5) {
            winningStatistic.put(WinningStatus.SECOND.getWinningIntegerValue(), winningStatistic.get(WinningStatus.SECOND.getWinningIntegerValue()) + 1);
            return;
        }

        if (winningCount == 6) {
            winningStatistic.put(WinningStatus.FIRST.getWinningIntegerValue(), winningStatistic.get(WinningStatus.FIRST.getWinningIntegerValue()) + 1);
        }
    }

    public void winningCheck() {
        // 통계 생성
        winningStatistic = new HashMap<>();
        for (int i = 0; i < winningMoney.length; i++) {
            winningStatistic.put(winningMoney[i], 0);
        }
        for (Lotto lotto : lottoList) {
            // 당첨 번호 갯수 체크
            int winningCount = lotto.winningCheck(winningNumber);
            // 보너스 번호 체크
            boolean isBonus = lotto.bonusCheck(bonusNumber);
            // 통계 처리
            statisticalProcessing(winningCount, isBonus);
        }
    }

    // 당첨 통계, 내역 출력 UI 메소드
    public void winningCheckUI() {
        winningCheck();

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (%s) - %d개\n", WinningStatus.FIFTH.getWinningStringValue(), winningStatistic.get(WinningStatus.FIFTH.getWinningIntegerValue()));
        System.out.printf("4개 일치 (%s) - %d개\n", WinningStatus.FOURTH.getWinningStringValue(), winningStatistic.get(WinningStatus.FOURTH.getWinningIntegerValue()));
        System.out.printf("5개 일치 (%s) - %d개\n", WinningStatus.THIRD.getWinningStringValue(), winningStatistic.get(WinningStatus.THIRD.getWinningIntegerValue()));
        System.out.printf("5개 일치, 보너스 볼 일치 (%s) - %d개\n", WinningStatus.SECOND.getWinningStringValue(), winningStatistic.get(WinningStatus.SECOND.getWinningIntegerValue()));
        System.out.printf("6개 일치 (%s) - %d개\n", WinningStatus.FIRST.getWinningStringValue(), winningStatistic.get(WinningStatus.FIRST.getWinningIntegerValue()));
    }

    // 수익률 계산 메소드
    public void calcRateOfReturn() {
        long totalReturn = 0;

        for (Integer key : winningStatistic.keySet()) {
            totalReturn += (long) key * winningStatistic.get(key);
        }

        this.rateOfReturn = (totalReturn / (double) money) * 100;
    }

    // 수익률 UI 메소드
    public void rateOfReturnUI() {
        calcRateOfReturn();

        System.out.printf("총 수익률은 %.1f%%입니다.\n", this.rateOfReturn);
    }
}
