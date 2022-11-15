package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    Lotto lotto;
    User user = new User();

    public void run() {
        List<User> userLottoList = new ArrayList<>();
        // 구입 금액 입력
        // 발행 로또 출력
        System.out.println("구매금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        int lottoCount = lottoCount(money);
        // 로또 수량 출력
        // 로또 번호 출력
        printLottoInfo(lottoCount, userLottoList);

        // 당첨 번호 입력 (Lotto)
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> lottoNums = getLottoNums();
        Lotto lottoNumber = new Lotto(lottoNums);
        // 보너스 번호 입력
        System.out.println("보너스 번호를 입력해 주세요");
        int bonusNumber = Integer.parseInt(Console.readLine());

        // 당첨 확인
        // 당첨 통계 출력

        // 일치 항목 출력
        // 수익률 출력
    }

    // 발행 로또 출력
    public int lottoCount(int purchaseAmount) {
        int lottoCount = 0;
        // 1,000원 단위로 나눈다.
        if (purchaseAmount % 1000 == 0) {
            return purchaseAmount / 1000;
        }

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 떨어져야 합니다.");
        }
        return lottoCount;
    }

    // 로또 번호 출력
    public void printLottoInfo(int lottoCount, List<User> userLottoList) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        // 갯수만큼 로또 초기화
        inputUserLottoNumber(lottoCount, userLottoList);
        // 로또 번호 출력
        printLottoNumberList(lottoCount, userLottoList);
    }

    private void printLottoNumberList(int lottoCount, List<User> userLottoList) {
        for (int i = 0; i < lottoCount; i++) {
            System.out.println(userLottoList.get(i).userNumber);
        }
    }

    private void inputUserLottoNumber(int lottoCount, List<User> userLottoList) {
        for (int i = 0; i < lottoCount; i++) {
            userLottoList.add(new User());
        }
    }

    private List<Integer> getLottoNums() {
        String[] lottoNumString = Console.readLine().split(",");
        return convertInteger(lottoNumString);
    }

    private List<Integer> convertInteger(String[] lottoNumString) {
        List<Integer> lottoNums = new ArrayList<>();
        for (String s : lottoNumString) {
            lottoNums.add(Integer.parseInt(s));
        }
        lottoNums.sort(Integer::compareTo);
        return lottoNums;
    }
    public static void main(String[] args) {
        Application app = new Application();
        // TODO: 프로그램 구현
        app.run();
    }
}
