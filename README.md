# 미션 - 로또

## 기능 목록
***
### 1. 로또 구매
   * 게임 시작 문구 출력 : `구입금액을 입력해 주세요.`
***
### 2. 로또 구입 금액 입력
   * 숫자 입력시 `예외처리` 필요
     * 로또 1장의 가격은 **1,000원**이다.
     * **1,000원으로 나누어 떨어지지 않는 경우** 예외 처리한다.
***
### 3. 사용자가 입력한 금액만큼 로또 구매
   * 로또 몇 개를 구매했는지 출력한다.
     * ex) 8000원치 구매시 `8개를 구매했습니다.`
***
### 4. 로또 뽑기
   * `[숫자1, 숫자2, 숫자3, 숫자4, 숫자5, 숫자6]` 형식으로 출력한다.
   * 로또 번호는 `오름차순`으로 `정렬`하여 보여준다.
     * 로또 번호에 대한 `예외처리` 필요
       * 로또 번호의 **숫자 범위**는 `1~45`까지이다.
***
### 5. 당첨 번호 입력
   * 당첨 번호 입력 문구 출력 : `당첨 번호를 입력해 주세요.`
   * 당첨 번호 6개를 입력한다.
     * 당첨 번호 입력시 `예외처리` 필요
       * **6개의 숫자**만 입력한다.
       * **중복되지 않는 수**를 뽑아야한다.
       * 번호는 `쉼표(,)`를 기준으로 구분한다.
       * 로또의 **숫자 범위**는 `1~45`까지이다.
         * 예외 상황시 에러문구 출력은 아래와 같다.
           * `[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`
***
### 6. 보너스 번호 입력
  * 보너스 번호 입력 문구 출력 : `보너스 번호를 입력해 주세요.`
  * 보너스 번호 1개를 입력한다.
    * 보너스 번호 입력시 `예외처리` 필요
      * **1개의 숫자**만 입력해야한다.
      * 뽑은 당첨 번호와 **중복되지 않는 수**를 뽑는다.
      * 로또의 **숫자 범위**는 `1~45`까지이다.

***

### 7. 당첨 통계
  * 구분선 출력 : `---`
  * 총 몇 개 일치하는지 출력
    * ex)
    * **3개 일치** (5,000원) - `1개` <br>
      **4개 일치** (50,000원) - `0개` <br>
      **5개 일치** (1,500,000원) - `0개` <br>
      **5개 일치**, **보너스 볼 일치** (30,000,000원) - `0개` <br>
      **6개 일치** (2,000,000,000원) - `0개`
  * 총 수익률 출력
    * ex) 총 수익률은 `62.5%`입니다.
    * 수익률은 `소수점 둘째 자리`에서 `반올림`한다. ex) 100.0%, 51.5%, 1,000,000.0%

***

### 공통 예외 상황
* 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 `[ERROR]`로 시작해야 한다.

***

## 🎯 프로그래밍 요구 사항

- `JDK 11` 버전에서 실행 가능해야 한다. **JDK 11에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- `indent(인덴트, 들여쓰기)` `depth`를 `3`이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 `while`문 안에 `if`문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) `depth`를 줄이는 좋은 방법은 `함수`(또는 메서드)를 분리하면 된다.
- `3항 연산자`를 쓰지 않는다.
- 함수(또는 메서드)가 **한 가지 일**만 하도록 최대한 작게 만들어라.
- `JUnit 5`와 `AssertJ`를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

### 추가된 요구 사항

- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- `else` 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 `return`하는 방식으로 구현하면 `else`를 사용하지 않아도 된다.
  - `else`를 쓰지 말라고 하니 `switch/case`로 구현하는 경우가 있는데 `switch/case`도 허용하지 않는다.
- Java `Enum`을 적용한다.
- 도메인 로직에 `단위 테스트`를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
  - `핵심 로직`을 구현하는 코드와 `UI`를 담당하는 로직을 분리해 구현한다.
  - 단위 테스트 작성이 익숙하지 않다면 `test/java/lotto/LottoTest`를 참고하여 학습한 후 테스트를 구현한다.

### 라이브러리

- [`camp.nextstep.edu.missionutils`](https://github.com/woowacourse-projects/mission-utils)에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
  - `Random` 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

#### 사용 예시

```java
List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
```

### Lotto 클래스

- 제공된 `Lotto` 클래스를 활용해 구현해야 한다.
- `Lotto`에 매개 변수가 없는 생성자를 추가할 수 없다.
- `numbers`의 접근 제어자인 private을 변경할 수 없다.
- `Lotto`에 필드(인스턴스 변수)를 추가할 수 없다.
- `Lotto`의 패키지 변경은 가능하다.

```java
public class Lotto {
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
```

---

## ✏️ 과제 진행 요구 사항

- 미션은 [java-lotto](https://github.com/woowacourse-precourse/java-lotto) 저장소를 Fork & Clone해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
  - [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.
