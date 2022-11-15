# 미션 - 로또

## MVC 모델을 적용한 기능 설명

아래 규칙을 지키며 MVC 패턴을 적용하려 노력했습니다.

- [x] Model 내부에 Controller와 View에 관련된 코드가 있으면 안 된다.
- [x] View는 내부에 Model의 코드만 있을 수 있고, Controller의 코드가 있으면 안 된다.
- [x] View가 Model로부터 데이터를 받을 때는, 사용자마다 다르게 보여줘야 하는 데이터에 대해서만 받아야 한다.
- [x] Controller 내부에는 Model과 View의 코드가 있어도 된다.
- [x] View가 Model로부터 데이터를 받을 때, 반드시 Controller에서 받아야 한다.

### Model (domain)

- Purchase 모델

    - 총 구매액`totalBudget`을 받아 구매할 로또 티켓 수`ticketNumber`를 계산한다. `Purchase#calculateTicketNumber`
    - 구매한 로또 티켓 수를 반환한다. `Purchase#getTicketNumber`

- Player 모델

    - 구매한 티켓 수`ticketNumber`를 입력받아 그 수만큼 사용자의 로또 번호를 랜덤으로 생성한다. `Player#createAllPlayerNumbers`
    - 모든 사용자 로또 번호`allPlayerNumbers`를 반환한다. `Player#getAllPlayerNumbers`

- Lotto 모델

    - "1,2,3,4,5,6"과 같이 쉼표로 구분된 `numbers`를 입력값으로 받는다.
    - 입력값의 유효성을 검증한다. `Lotto#validate`
    - 입력값을 통해 생성된 6개의 당첨 번호`winningNumbers`를 반환한다. `Lotto#getWinningNumbers`

- Bonus 모델

    - 하나의 숫자`input`를 입력받는다.
    - 입력값의 유효성을 검증한다. `Bonus#validateBonusNumber`
    - `Lotto` 모델과 `Bonus` 모델을 통해 생성된 7개의 숫자 중 중복되는 숫자가 있는지 확인한다. `Bonus#validateDuplicates`
    - 입력값을 통해 생성된 1개의 보너스 번호`bonusNumber`를 반환한다. `Bonus#getBonusNumber`

- LottoResult 모델

    - `winningNumbers`, `bonusNumber`, `allPlayerNumbers`를 입력값으로 받는다.
    - `winningNumbers`와 `allPlayerNumbers`를 비교해 일치하는 숫자의 개수`match`를 계산한다. `LottoResult#calculateMatch`
    - `bonusNumber`와 `allPlayerNumbers`를 비교해 보너스 숫자를 가지고 있는지 여부`hasBonus`를 판정한다. `LottoResult#hasBonusNumber`
    - 위에서 나온 결과를 구매한 티켓의 개수만큼 반복해 리스트에 차례대로 저장한다.
    - 각 사용자 로또 번호들이 갖고 있는 `match`의 수를 리스트`matches`로 만들어 반환한다. `LottoResult#getMatches`
    - 각 사용자 로또 번호들의 `hasBonus`의 수를 리스트`hasBonusMatches`로 만들어 반환한다. `LottoResult#getBonusMatches`

- Rank 모델

    - 각 순위와 `match, hasBonus, cashPrize, count, printMessage`를 함께 관리한다.
    - 새로운 게임을 시작할 때 `count`를 초기화한다. `Rank#initializeRankCount`
    - `count`를 증가시킨다. `Rank#addCount`
    - 각 필드를 반환한다. `Rank#getMatch` `Rank#getHasBonus` `Rank#getCashPrize` `Rank#getCount` `Rank#getPrintMessage`

- PlayerRanking 모델

    - `LottoResult` 모델에서 반환한 `matches`, `hasBonusMatches`를 입력값으로 받는다.
    - 입력값을 `Rank`(Enum)의 인스턴스 변수인 `match`, `hasBonus`와 비교해 각 최종 순위를 찾는다. `PlayerRanking#findPlayerRanking`
    - 최종 순위를 구매한 티켓의 개수만큼 반복해 리스트`playerRankings`에 자례대로 저장한다. `PlayerRanking#setPlayerRankings`
    - 사용자의 티켓 별 최종 순위를 저장한 리스트`playerRankings`를 반환한다. `PlayerRanking#getPlayerRankings`

- Statistics 모델

    - 사용자의 티켓 별 최종 순위를 저장한 리스트`rankings`를 입력받는다.
    - `Rank`(Enum)의 `count` 필드를 모두 0으로 초기화한다. `Statistics#initializeCountsInRank`
    - `rankings` 리스트를 바탕으로 `Rank`(Enum)의 `count` 필드에 사용자의 당첨 통계를 집계한다. `Statistics#aggregateRankingStatistics`
    - 당첨 통계를 반영한 `Rank`를 리스트 형태로 반환한다. `Statistics#getStatistics`

### View

- InputView

    - User에게 입력값을 받는다. `InputView#getInput`

- OutputView

    - 예외 상황 발생 시 에러 문구를 출력한다. `OutputView#printErrorMessage`
    - 총 구매액`totalBudget` 입력 문구를 출력한다. `OutputView#printCashInput`
    - 구매하는 티켓의 개수`ticketNumber`를 출력한다. `OutputView#printTicketNumber`
    - 당첨 번호 입력 문구를 출력한다. `OutputView#printWinningNumberInput`
    - 보너스 번호 입력 문구를 출력한다. `OutputView#printBonusNumberInput`
    - 사용자의 모든 로또 번호`allPlayerNumbers`를 구매한 티켓 수`ticketNumber` 만큼 반복해 출력한다. `OutputView#printAllPlayerNumbers`
    - 사용자의 당첨 통계를 출력한다. `OutputView#printStatistics`
    - 사용자의 수익률을 출력한다. `OutputView#printYield`

### Controller

- LottoController

    - 로또를 구매한다. `LottoController#purchaseLottoTickets`
    - 사용자의 로또 번호를 생성해 로또를 발행한다. `LottoController#publishPlayerNumbers`
    - 당첨 번호와 보너스 번호를 결정한다. `LottoController#determineWinningNumbersAndBonusNumber`
    - 사용자의 로또 당첨 결과를 집계한다. `LottoController#aggregateStatisticResults`
    - 사용자의 수익률을 계산한다. `LottoController#calculateYield`

---

## 🔍 진행 방식

- 미션은 **기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항** 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

## 📮 미션 제출 방법

- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
    - GitHub을 활용한 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고해
      제출한다.
- GitHub에 미션을 제출한 후 [우아한테크코스 지원](https://apply.techcourse.co.kr) 사이트에 접속하여 프리코스 과제를 제출한다.
    - 자세한 방법은 [제출 가이드](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse#제출-가이드) 참고
    - **Pull Request만 보내고 지원 플랫폼에서 과제를 제출하지 않으면 최종 제출하지 않은 것으로 처리되니 주의한다.**

## 🚨 과제 제출 전 체크 리스트 - 0점 방지

- 기능 구현을 모두 정상적으로 했더라도 **요구 사항에 명시된 출력값 형식을 지키지 않을 경우 0점으로 처리**한다.
- 기능 구현을 완료한 뒤 아래 가이드에 따라 테스트를 실행했을 때 모든 테스트가 성공하는지 확인한다.
- **테스트가 실패할 경우 0점으로 처리**되므로, 반드시 확인 후 제출한다.

### 테스트 실행 가이드

- 터미널에서 `java -version`을 실행하여 Java 버전이 11인지 확인한다. 또는 Eclipse 또는 IntelliJ IDEA와 같은 IDE에서 Java 11로 실행되는지 확인한다.
- 터미널에서 Mac 또는 Linux 사용자의 경우 `./gradlew clean test` 명령을 실행하고,   
  Windows 사용자의 경우  `gradlew.bat clean test` 명령을 실행할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.

```
BUILD SUCCESSFUL in 0s
```

---

## 🚀 기능 요구 사항

로또 게임 기능을 구현해야 한다. 로또 게임은 아래와 같은 규칙으로 진행된다.

```
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
```

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.

### 입출력 요구 사항

#### 입력

- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.

```
14000
```

- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.

```
1,2,3,4,5,6
```

- 보너스 번호를 입력 받는다.

```
7
```

#### 출력

- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.

```
8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]
```

- 당첨 내역을 출력한다.

```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```

- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)

```
총 수익률은 62.5%입니다.
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

```
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```

#### 실행 결과 예시

```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

---

## 🎯 프로그래밍 요구 사항

- JDK 11 버전에서 실행 가능해야 한다. **JDK 11에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

### 추가된 요구 사항

- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- Java Enum을 적용한다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    - 단위 테스트 작성이 익숙하지 않다면 `test/java/lotto/LottoTest`를 참고하여 학습한 후 테스트를 구현한다.

### 라이브러리

- [`camp.nextstep.edu.missionutils`](https://github.com/woowacourse-projects/mission-utils)에서 제공하는 `Randoms` 및 `Console`
  API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

#### 사용 예시

```java
List<Integer> numbers=Randoms.pickUniqueNumbersInRange(1,45,6);
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
