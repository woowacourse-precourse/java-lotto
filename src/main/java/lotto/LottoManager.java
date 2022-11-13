package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoManager {
    // 로또 구입 금액
    int money;
    // 로또 갯수
    int lottoCount;

    List<Lotto> lottoList;

    List<Integer> winningNumber;

    // 전체 동작을 구현하는 메소드
    public void run() {
        insertMoneyUI();
        createLottoUI();
        insertWinningNumberUI();
    }


    // 로또 구입 금액 입력이 유효한지 확인
    // 1. 숫자가 아닌 값 입력 시
    // 2. 1,000원 단위가 아닌 값 입력 시
    public void validateInsertMoney(String stringMoney) {
        try {
            money = Integer.parseInt(stringMoney);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력했습니다.");
        }

        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 자연수 값이여야 합니다.");
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
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
        List<Integer> numberList = pickUniqueNumbersInRange(1, 45, 6);

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
    }

    // 당첨 번호 입력값 검증을 하는 메소드
    // 1. ,로 구분하였을 때 6자리가 아닌 경우
    // 2. - 각 구분된 값들이 1~45의 자연수가 아닌 경우
    public void validateWinningNumber(String stringWinningNumber) {
        String splitList[] = stringWinningNumber.split(",");

        if (splitList.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 6개를 입력해야 합니다.");
        }

        for (String stringNumber : splitList) {
            try {
                int intNumber = Integer.parseInt(stringNumber);

                if (!(1 <= intNumber && intNumber <= 45)) {
                    throw new IllegalArgumentException("[ERROR] 각 당첨 번호는 1~45 자연수여야 합니다.");
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("[ERROR] 각 당첨 번호는 1~45 자연수여야 합니다.");
            }
        }
    }

    public void duplicateWinningNumberCheck(String stringWinningNumber) {
        List<String> splitList = Arrays.asList(stringWinningNumber.split(","));

        List<String> uniqueList = splitList.stream().distinct().collect(Collectors.toList());
        if (uniqueList.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 각 당첨 번호는 중복되지 않는 값이여야 합니다.");
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
    }

    // 당첨 번호를 입력받는 UI 메소드
    public void insertWinningNumberUI() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String stringWinningNumber = readLine();
        insertWinningNumber(stringWinningNumber);
    }
}
