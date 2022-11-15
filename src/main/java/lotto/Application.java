package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    // 1.로또 구입
    static int buyLotto() {

        int price = 1000;

        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        int sheets = money / price;

        return sheets;
    }

    // 2.로또 발행
    static void createLotto(int sheets,List<Lotto> lottos) {
        System.out.println("8개를 구매했습니다.");

        for(int idx=0; idx<sheets; idx++) {
            List<Integer> lottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(lottoNums));
            lottos.get(idx).getLottoNumbers();
        }
    }

    // 3.당첨 번호 입력
    static void createWinningNums(List<Integer> winningNums) {
        System.out.print("당첨 번호를 입력해 주세요.");

        String nums = Console.readLine();
        List<String> letters = new ArrayList<String>(Arrays.asList(nums.split(",")));

        for (int idx = 0; idx < letters.size(); idx++) {
            int num = Integer.parseInt(letters.get(idx));
            winningNums.add(num);
        }
    }

    // 4.보너스 번호 입력
    static int createBonusNum() {

        int bonusNum = 0;

        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNum = Integer.parseInt(Console.readLine());

        return bonusNum;
    }

    // 8.최종 당첨 결과
    static void getLottoResult(List<Integer> lottosResult, int countResult, int countBonus) {

        if(countResult == 6 || countBonus == 5) {
            lottosResult.set(countResult,lottosResult.get(countResult)+1);
            return;
        }

        countResult += countBonus;

        if(countResult >= 3) {
            if(countResult == 6) {
                lottosResult.set(0,lottosResult.get(0)+1);
                return;
            }

            lottosResult.set(countResult,lottosResult.get(countResult)+1);
            return;
        }
    }

    // 당첨 결과
    static List<Integer> getLottoResultAll(List<Lotto> lottos, List<Integer>winningNums, int bonusNum) {

        List<Integer> lottosResult = new ArrayList<>(List.of(0,0,0,0,0,0,0));
        for(int idx=0; idx<lottos.size(); idx++) {

            int countResult = 0;
            int countBonus = 0;

            countResult = lottos.get(idx).getLottoResult(winningNums,countResult);
            countBonus = lottos.get(idx).getIncludingBonus(bonusNum);

            getLottoResult(lottosResult,countResult,countBonus);
        }

        return lottosResult;
    }

    public static void main(String[] args) {

        List<Lotto> lottos = new ArrayList<>();
        List<Integer> winningNums = new ArrayList<>();
        List<Integer> lottosResult = new ArrayList<>();

        // 로또 구입
        int sheets = buyLotto();

        // 로또 발행
        createLotto(sheets,lottos);

        // 당첨 번호
        createWinningNums(winningNums);

        // 보너스 번호
        int bonusNum = createBonusNum();

        // 당첨 결과
        lottosResult = getLottoResultAll(lottos,winningNums,bonusNum);

        System.out.println(lottosResult);
    }
}

// 기능 요구 사항
// 1. docs/README.md에 작성

// 프로그래밍 요구 사항
// 1.JDK 11 버전에서 실행 가능
// 2.프로그램 실행의 시작점은 Application의 main()
// 3.build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용 금지
// 4.Java 코드 컨벤션 가이드를 준수하며 프로그래밍
// 5.프로그램 종료 시 System.exit()를 호출 금지
// 6.프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공 확인
// 7.프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동 금지
// 8.indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현 (2까지만 허용)
//   예를 들어 while문 안에 if문이 있으면 들여쓰기는 2
//   힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하는 것
// 9.3항 연산자를 쓰기 금지
// 10.함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들기
// 11.JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인

// 추가된 요구 사항
// 1.함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현
// 2.함수(또는 메서드)가 한 가지 일만 잘 하도록 구현
// 3.else 예약어를 쓰지 않기
//   힌트: if 조건절에서 값을 return하는 방식으로 구현하면 가능
//   else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 금지
// 4.Java Enum을 적용
// 5.도메인 로직에 단위 테스트를 구현 (단, UI(System.out, System.in, Scanner) 로직은 제외)
// 6.핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현
// 7.단위 테스트 작성이 익숙하지 않다면 test/java/lotto/LottoTest를 참고하여 학습한 후 테스트를 구현

// 라이브러리
// 1.camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현
// 2.Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용
// 3.사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용

// Lotto 클래스
// 1.제공된 Lotto 클래스를 활용해 구현
// 2.Lotto에 매개 변수가 없는 생성자를 추가 금지
// 3.numbers의 접근 제어자인 private을 변경 금지
// 4.Lotto에 필드(인스턴스 변수)를 추가 금지
// 5.Lotto의 패키지 변경은 가능

// 과제 진행 요구 사항
// 1.미션은 java-lotto 저장소를 Fork & Clone해 시작
// 2.기능을 구현하기 전 docs/README.md에 구현할 기능 목록을 정리해 추가
// 3.Git의 커밋 단위는 앞 단계에서 docs/README.md에 정리한 기능 목록 단위로 추가
// 4.커밋 메시지 컨벤션 가이드를 참고해 커밋 메시지를 작성
// 5.과제 진행 및 제출 방법은 프리코스 과제 제출 문서를 참고