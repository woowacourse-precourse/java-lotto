package lotto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    private static String result;
    private static String[] str;
    private static List<Integer> winNumber;
    private static int bonusBall;
    private static List<List<Integer>> randomLottoNumbers;

    public LottoGame() {
        result = "";
        str = new String[6];
        winNumber = new ArrayList<>();
        bonusBall = 0;
        randomLottoNumbers = new ArrayList<>();
    }

    public void startGame() {
        try {
            buyLotto();
            createNumbers();
            compareNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // 로또를 얼마나 살 건지?
    private void buyLotto() {
        payMoney();
        createLotto(result);
        for (List<Integer> randomLottoNumber : randomLottoNumbers) {
            System.out.println(randomLottoNumber); // 함수화 시키자
        }
    }
    
    // 몇 천원어치 살 꺼야?
    private void payMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        result = Console.readLine();
        if (result.length() != 4) {
            throw new IllegalArgumentException("[ERROR]");
        } // 클래스 만들어서 리팩토링 해야 됨
        System.out.println(Integer.parseInt(result)/1000 + "개를 구매했습니다.");
    }
    
    // 내가 입력한 금액에 맞게 로또 생성
    private void createLotto(String result) {
        LottoNumbers lottoNumbers = new LottoNumbers(result); // 구입 금액을 기반으로 ~장 생성
        randomLottoNumbers = lottoNumbers.getNumbers(); // 생선된 랜덤 로또값들을 List<List<Integer>>에 get을 이용해 저장
    }
    ////////////////////////////////////////////////////////////////////////

    // 승리, 보너스 숫자를 입력하는 메서드
    private void createNumbers() {
        createWinNumber();
        createBonusNumber();
    }

    // 승리 숫자가 입력하는 메서드,
    private void createWinNumber() {
        str = Console.readLine().split(",");
        winNumber = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            winNumber.add(Integer.parseInt(str[i]));
        }
        Lotto lotto = new Lotto(winNumber); // Exception 체큰

    }

    // 보너스 번호 입력하는 메서드
    private void createBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        bonusBall = Integer.parseInt(Console.readLine());
    }

    // 로또 번호, 승리 숫자를 비교하는 메서드
    private void compareNumber() {
        Manager manager = new Manager();
        manager.inputWinNumbers(randomLottoNumbers, winNumber, bonusBall);
    }
}
