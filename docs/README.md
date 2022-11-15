## 기능 목록

**로또 구입**

- [x] 로또 구입 금액을 입력 받는다. `Purchase`
    - [x] 입력값이 숫자가 아니면 예외 처리한다. `Purchase#validateInputType()`
    - [x] 구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외 처리한다. `Purchase#verifyUnitOfBudget()`
    - [x] 구입 금액이 1,000원보다 작으면 예외 처리한다. `Purchase#verifyMinimumBudget()`
- [x] 구입 금액을 1,000원으로 나누어 발행할 로또 수를 구한다. `Purchase#calculateTicketNumber()`

**로또 발행**

- [x] 구입한 로또 수 만큼 랜덤으로 숫자를 생성한다. `Player#createAllPlayerNumbers(ticketNumber)`
    - [x] 로또 번호는 오름차순으로 정렬한다. `Player#sortInAscendingOrders()`

**당첨 번호 생성**

- [x] 6개의 당첨 번호를 입력받는다. `InputView#getInput()`
    - [x] 당첨번호 입력값에서 공백을 모두 제거한다. `Util#removeSpace()`
    - [x] 쉼표를 기준으로 구분한다. `Lotto#separateStringByComma()`
    - [x] 구분된 당첨번호의 개수가 6개가 아니면 예외 처리한다. `Lotto#validate()`
    - [x] 구분된 당첨번호가 1~45 사이의 숫자가 아니면 예외 처리한다. `Util#verifyRangeOfLottoNumber()`
    - [x] 중복되는 숫자가 있으면 예외 처리한다. `Lotto#validate()`
- [x] 보너스 번호 1개를 입력받는다. `Bonus`
    - [x] 보너스 번호가 1~45 사이의 숫자가 아니면 예외 처리한다. `Util#verifyRangeOfLottoNumber()`
- [x] 보너스 번호가 당첨번호와 중복되면 예외 처리한다. `Bonus#validateDuplicates()`

**로또 결과 계산**

- [x] 당첨 번호, 나의 번호, 보너스 번호를 입력받는다. `LottoResult`
- [x] 나의 번호와 당첨번호 중 겹치는 개수를 구한다. `LottoResult#calculateMatch()`
- [x] 나의 번호에 보너스 번호가 포함되는 지 구한다. `LottoResult#hasBonusNumber()`

**로또 순위 계산**

- [x] 겹치는 번호 개수, 보너스 여부로 순위를 구한다. `PlayerRanking#findPlayerRanking()`

**당첨 통계 계산**

- [x] 나의 당첨 내역을 받아 각 순위별 개수를 구한다. `Statistics`
- [x] 당첨 통계를 출력한다. `OutputView#printStatistics()`

**수익률 계산**

- [x] 상금 총액을 로또 총액으로 나누어 수익률을 구한다. `Yield#calculateYield()`
- [x] 수익률을 소수 둘째 자리에서 반올림해 출력한다. `Util#formatYield()`


- [x] 입출력 시에 함께 요구사항의 문구를 함께 출력한다. `Outputview`
- [x] 예외 처리 시에 [ERROR]와 함께 에러 문구를 출력한다. `OutputView#printErrorMessage()`


## 프로그래밍 요구사항

- [x] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [x] else 예약어 및 switch/case를 쓰지 않는다.
- [x] Java Enum을 적용한다.
- [x] 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - [x] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    - [x] 단위 테스트 작성이 익숙하지 않다면 test/java/lotto/LottoTest를 참고하여 학습한 후 테스트를 구현한다.
- [x] 값을 하드코딩하지 않는다.
- [x] 클래스는 상수, 멤버 변수, 생성자, 메소드 순으로 작성한다.
- [x] 변수 이름에 자료형은 사용하지 않는다.
- [x] Java 버전이 11인지 확인한다.
- [x] 외부 라이브러리를 사용하지 않는다.
- [x] Java 코드 컨벤션 가이드를 준수하며 프로그래밍한다.
    - [x] 블럭 들여쓰기: +4 스페이스
    - [x] 열 제한: 120
    - [x] 들여쓰기 지속은 최소 +8 스페이스
    - [x] 수직 빈 줄
- [x] indent depth를 3이 넘지 않도록 구현한다.
- [x] 3항 연산자를 쓰지 않는다.
- [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만든다.
- [x] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

## 체크 리스트

- [x] 요구 사항에 명시된 출력값 형식을 지킨다.
- [x] 모든 테스트가 성공하는지 확인한다.
- [x] Pull Request에 회고록을 작성한 링크를 함께 보낸다.
- [x] 지원 플랫폼에서 과제를 제출한다.
- [x] 테스트를 작성하는 이유에 대해 나의 경험을 토대로 정리해본다.
