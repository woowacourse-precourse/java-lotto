# 로또 게임

<br>

## 기능 목록

<br>

- 사용자 입력 기능
  - [O] 사용자에게 구입금액을 입력받는다. - InputUserMoney#InputMoney()
  - [O] 구입 금액 만큼 1-45숫자중 중복되지 않는 6개의 숫자를 생성한다. - UserNumberGenerator#createRandomNumbers()

<br>

- 당첨 번호 입력 기능
  - [O] 1-45 범위의 숫자 중 중복되지 않는 6개의 당첨번호를 입력받는다. - InputCorrectNumberGenerator#createInputCorrectNumber()
  - [O] 1-45 범위의 숫자 중 당첨번호와 중복되지 않는 보너스 번호를 입력받는다. - BonusNumberGenerator#createBonusNumber()

<br>

- 생성숫자와 당첨숫자 비교 기능
  - [O] 구입한 내역의 숫자와 당첨숫자 비교 결과를 반환합니다.(보너스숫자제외) - CompareNumber#jugementNumber()
  - [O] 보너스숫자를 포함한 결과를 리스트에 담아 반환합니다. - CompareNumberWithBonus#jugementNumberWithBonus()

<br>

- 당첨 내용 계산 및 출력 기능
  - [O] 구매한 개수를 출력합니다. - PrintInputMoneyGenerator#printInputMoney()
  - [O] 구입 한 번호를 리스트 형식으로 모두 출력합니다. - UserNumberGenerator#createRandomNumbers()
  - [O] 당첨 통계 내역을 출력합니다. - PrintWinnerStatisticsGenerator#printWinner()
  - [O] 수익률을 구매비용과 당첨비용을 계산합니다. - EarningRateGenerator#printEarningRate()
  - [O] 수익률을 % 형식으로 출력합니다. - CalculateTotalEarningGenerator#calculateTotalEarning()

<br>


## 🚀 기능 상세 기술
<br>

![구현흐름도](https://user-images.githubusercontent.com/109144975/201814058-9541cab2-9739-4a23-9614-97a575a6c707.jpg)

<br>

**핵심기능**
> - 로또 정답 숫자, 보너스 숫자와 로또 발행 숫자를 비교하여 케이스별 로또 결과 출력 기능
> - 수익률을 계산 출력 기능
> - 오입력시 예외처리 기능

<br>

- 사용된 클래스 리스트 (18개)
  - Application
  - BonusNumberCalculatorGenerator
  - BonusNumberGenerator
  - CalculateTotalEarningGenerator
  - CompareNumber
  - CompareNumberWithBonus
  - CorrectNumberGenerator
  - DivideInputMoneyGenerator
  - EarningRateGenerator
  - FinalUserNumberGenerator
  - InputCorrectNumberGenerator
  - InputUserMoney
  - JudgmentBonusNumberGenerator
  - JudgmentInputNumberGenerator
  - Lotto
  - PrintInputMoneyGenerator
  - PrintWinnerStatisticsGenerator
  - UserNumberGenerator

<br>

<br>

---

### Application
메인 함수
<br>

중요 메소드들을 선언하여 핵심기능들을 동작시키는 클래스

<br>

## 구입 금액 숫자를 입력

### InputUserMoney

"구입금액을 입력해주세요." 를 출력합니다.

구입 금액을 readline();로  입력 받습니다.

입력받은 String 형식의 숫자를 int형식으로 반환합니다.

### JudgmentInputNumberGenerator

입력시 숫자로 이루어져있지 않을 경우는 `Character.isDigit` 메서드를 통해 예외처리 하였습니다.

### DivideInputMoneyGenerator

입력된 숫자가 1000으로 나눈 나머지가 존재할 경우 "1000" 단위의 값을 입력해주세요.
문구가 출력되도록 하고 `IllegalArgumentException` 예외를 발생시켰습니다.

### PrintInputMoneyGenerator

inputUserMoney 를 실행시켜 예외 발생될 경우 try catch문을 통해 예외처리를 잡아줍니다.

DivideInputMoneyGenerator 를 실행시켜 예외가 발생될 경우 try catch문을 통해 예외처리를 잡아줍니다.

로또 발행개수를 printf("%d개를 구매했습니다", inputMoney); 를 통해 출력하고
개수를 int 형식으로 반환합니다.

<br>

---

<br>

## 구입한 개수 만큼 로또 발행 및 번호 출력

### UserNumberGenerator

1부터 45까지의 랜덤한 숫자를 pickUniqueNumbersInRange 메서드를 통해 List<Integer> 형식으로 생성합니다.
생성된 List<Integer>을 출력합니다.

### FinalUserNumberGenerator

로또 발행 개수만큼 for문을 돌며 UserNumberGenerator를 실행시켜 반환된 List 결과값을
2차원 List에 저장하여 반환합니다.

<br>

---

<br>

## 로또 정답 숫자, 보너스 숫자 입력

### InputCorrectNumberGenerator
"당첨 번호를 입력해 주세요." 문구를 출력합니다.

입력된 숫자를 readline().split(","); 을 통해 String[] 형식으로 입력받습니다.

입력받은 값을 배열에 int 값으로 변환하여 저장한 후 반환합니다.

### CorrectNumberGenerator
사용자가 잘못된 입력(1-45사이의 숫자가 아닐경우)을 하였을 경우 [ERROR] 문구출력으로 로깅과 함께 
`IllegalArgumentException` 예외를 발생시켰습니다.

### Lotto

CorrectNumberGenerator 를 실행시켜 사용자에게 정답 숫자를 입력받아 List 형식으로 저장합니다.

입력받은 숫자를 Lotto 클래스의 validate 메서드를 통해 size()를 확인하여 아닐 경우 `IllegalArgumentException` 예외를 발생시켰습니다. 

입력받은 올바른 형식을 경우 List<Integet> 형식으로 반환합니다. 

### BonusNumberGenerator

"보너스 번호를 입력해 주세요." 문구를 출력합니다.
사용자에게 readLine(); 으로 입력을 받습니다.

String 을 int 형식으로 변환합니다.

입력된 숫자를 반환합니다. 만약 정답 숫자와 중복된다면 while(true) 문을 통해 정답 숫자와 중복이 아닐때까지 반복합니다.

<br>

---

<br>

## 모든 로또 발행 숫자와 정답 숫자, 보너스 숫자를 비교

### CompareNumber
인자 - (List<Integer> UserPickNumber, List<Integer> CorrectNumber)

인자로 입력된 CorrectNumber(로또 정답 숫자) 와 UserPickNumber(로또 발행 숫자)를 for 문을 통해 비교하며
각 발행 로또 케이스 별로 동일한 숫자의 개수를 returnNumber로 반환합니다. 

### JudgmentBonusNumberGenerator

returnNumber 가 5일 경우 보너스 숫자 포함 여부를 판단하였습니다.
포함한다면 +1 그렇지 않으면 그대로 return 하여 판단합니다.

### BonusNumberCalculatorGenerator

2등과 3등을 가리기 위한 보너스 숫자 계산입니다.
(returnNumber가 클수록 상위 등수 입니다.)

returnNumber 가 5일 경우 JudgmentBonusNumberGenerator 를 실행시켜 케이스별로 +1 실행여부를 판단하여 반환합니다.

1등의 경우 returnNumber가 6이므로 2등과 구별을 위해 returnNumber를 7로 설정하였습니다

### CompareNumberWithBonus

FinalUserNumberGenerator 를 실행시켜 2차원 배열의 로또 발행 숫자를 생성합니다.

Lotto의 CorrectLottoNumber 를 실행시켜 로또 정답 숫자를 생성합니다.

BonusNumberGenerator 를 실행시켜 보너스 숫자를 생성합니다.

BonusNumberCalculatorGenerator 를 실행시켜 생성된 returnNumber를 List<Integer> 형식을 반환합니다.

<br>

---

<br>

## 로또 비교 결과 저장 및 출력

### PrintWinnerStatisticsGenerator

인자 - List<Integer> resultNumber

CompareNumberWithBonus에서 반환된 로또 정답 개수 List<Integer> 를 입력받아 케이스별로 출력합니다.

`Collections.frequency()` 메서드를 통해 정답의 개수를 List에 저장하였습니다.

정답 개수별로 저장된 List<Integer> 을 통해 케이스별로 결과를 출력하였습니다.

### EarningRateGenerator
인자 - List<Integer> resultNumber


총 수익률 계산을 위한 클래스입니다.

int[] 형식으로 각 정답 개수별로 당첨 금액을 넣어 생성하였습니다.

입력된 인자인 resultNumber 을 통해 for문을 돌며 정답 개수별로 당첨 금액을 totalEarningMoney에 더하도록 하였습니다.

int 형의 totalEarningMoney 를 반환합니다.

### CalculateTotalEarningGenerator

tatalEarningMoney를 에 대해 구입금액과 당첨금액을 계산하여 수익률을 출력합니다.

입력된 totalEarningMoney 계산시 int 형으로는 당첨금이 20억이 넘어갈 경우 에러가 발생되어 Long 타입으로 변환하여 계산하도록 하였습니다.

<br>

**구현 흐름도**

> 구입 금액 숫자를 입력 -> 구입한 개수 만큼 로또 발행 및 번호 출력 -> 로또 정답 숫자, 보너스 숫자 입력
> -> 모든 로또 발행 숫자와 정답 숫자, 보너스 숫자를 비교 -> 로또 비교 결과 저장 -> 로또 비교 결과 반환


<br>

## 기능 요구 사항
🚀 기능 요구 사항
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


---------------------------------------------------------------------

# 미션 - 로또

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

- [`camp.nextstep.edu.missionutils`](https://github.com/woowacourse-projects/mission-utils)에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
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
