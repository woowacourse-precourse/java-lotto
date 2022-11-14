# 로또 게임

- [x] 로또 구입 금액을 입력한다.
  -[x] 구입 금액 예외 처리 - MoneyInputException.java
    - [x] 입력값이 숫자가 아닐경우 예외 처리한다. - moneyTypeError()
    - [x] 1000원 단위로 나누어 떨어지지 않을 경우 예외 처리한다. - moneyChangeError()
- [x] 금액에 해당하는 만큼 로또 발행한다. (1장 = 1,000원)
  - [x] 로또 번호를 생성한다. - Lotto.java -> buyLotto()
    - [x] 중복 값이 나올 경우 예외 처리 - Lotto.java -> validate()
  - [x] 발행한 로또 수량을 출력한다. - Output.java -> printLotto(), printNumbers()
  - [x] 로또 번호를 출력한다. (오름 차순) - Output.java -> printLotto()
- [x] 당첨 번호를 입력 한다. (쉼표 기준) - winNumInput()
  - [x] 예외 시 처리 - WinNumInputException.java
    - [x] 쉼표로 구분되지 않는 입력 시 예외 처리 - winNumFormatException()
    - [x] 중복 수 입력 시 예외 처리 - winNumDuplicate()
    - [x] 숫자가 아닌 수 입력 시 예외 처리 - winNumTypeError()
    - [x] 범위를 넘어가는 수 입력 시 예외 처리 - winNumRangeError()
    - [x] 6개의 수가 아닐 경우 예외 처리 - winNumSizeError()
- [x] 보너스 번호를 입력 한다. - bonusNumInput()
  - [x] 보너스 번호 예외 처리 - BonusNumException.java
    - [x] 숫자가 아닐 경우 예외 처리 - bonusTypeError()
    - [x] 범위를 넘어가는 수 입력 시 예외 처리 - bonusRangeError()
    - [x] 당첨 번호와 중복 시 예외 처리 - bonusDuplicate()
- [ ] 구매 번호와 당첨 번호를 비교한다. - Result.java -> addResult()
  - [x] 일치하는 번호 갯수를 센다. - Check.java -> matchCnt
  - [x] 해당하는 당첨 금액을 반환한다. - Check.java -> winMoney()
  - [x] 해당하는 당첨 등수를 반환한다. - Result.java ->getCount();
- [x] 당첨 내역을 출력한다. - Result.java -> printResult()
- [x] 수익률을 출력한다. - Result.java -> Calculate()
  - [x] 소수 둘째 자리에서 반올림 
- [ ] 게임 종료.


## 기능 요구 사항

로또 게임 기능을 구현해야 한다. 로또 게임은 아래와 같은 규칙으로 진행된다.

* 규칙
  - 로또 번호의 숫자 범위는 1~45까지이다.
  - 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
  - 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
  - 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
     - 1등: 6개 번호 일치 / 2,000,000,000원
     - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
     - 3등: 5개 번호 일치 / 1,500,000원
     - 4등: 4개 번호 일치 / 50,000원
     - 5등: 3개 번호 일치 / 5,000원
  - 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
  - 로또 1장의 가격은 1,000원이다.
  - 당첨 번호와 보너스 번호를 입력받는다.
  - 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
  - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.

* 입력
  - 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
  - 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
  - 보너스 번호를 입력 받는다.

* 출력
  - 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
  - 당첨 내역을 출력한다.
  - 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
  - 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.


## 프로그래밍 요구 사항

- JDK 11 버전에서 실행 가능해야 한다. JDK 11에서 정상적으로 동작하지 않을 경우 0점 처리한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- Java 코드 컨벤션 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다. 테스트가 실패할 경우 0점 처리한다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- Java Enum을 적용한다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
  - 단위 테스트 작성이 익숙하지 않다면 test/java/lotto/LottoTest를 참고하여 학습한 후 테스트를 구현한다.

* 라이브러리
  - camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
    - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용한다.
    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
  - 사용 예시 
    - e.g. List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

* Lotto 클래스
  - 제공된 Lotto 클래스를 활용해 구현해야 한다.
  - Lotto에 매개 변수가 없는 생성자를 추가할 수 없다.
  - numbers의 접근 제어자인 private을 변경할 수 없다.
  - Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
  - Lotto의 패키지 변경은 가능하다.
    - public class Lotto {
        private final List<Integer> numbers;

        public Lotto(List<Integer> numbers) {
          validate(numbers);
          this.numbers = numbers;
        }

        private void validate(List<Integer> numbers) {
          if (numbers.size() != 6) {
          throw new IllegalArgumentException();
             }
          }

        // TODO: 추가 기능 구현
      }
  
1. indent depth 2 이하로 작성
2. 3항 연산자 사용 금지
3. 테스트 코드로 기능 확인
4. 함수의 길이가 15라인을 넘어가지 않도록 작성
5. 함수는 한 가지 기능을 하도록 구현
6. else/switch,case 문 사용 금지
7. java Enum 적용
8. 도메인 로직에 단위 테스트 구현(UI 로직 제외)


## 과제 진행 요구 사항

- 미션은 java-lotto 저장소를 Fork & Clone해 시작한다.
- 기능을 구현하기 전 docs/README.md에 구현할 기능 목록을 정리해 추가한다.
- Git의 커밋 단위는 앞 단계에서 docs/README.md에 정리한 기능 목록 단위로 추가한다.
  - 커밋 메시지 컨벤션 가이드를 참고해 커밋 메시지를 작성한다.
- 과제 진행 및 제출 방법은 프리코스 과제 제출 문서를 참고한다.