# 미션 - 로또
## 기능 목록
- [x] 로또 숫자 발행
  - [x] 1~45 중복되지 않는 6개의 숫자 고르기
- [x] 당첨 번호 입력 받기
  - [x] 입력 받을 때 중복되지 않는 6개 숫자인지 확인
- [x] 보너스 번호 입력 받기
  - [x] 당첨 번호와 중복되지 않는지 확인
- [x] 구입 금액 입력 받기
  - [x] 구입 금액에 해당하는 만큼 로또 발행
  - [x] 로또 수량 및 번호 출력
  - [x] 각 로또 번호 오름차순으로 정렬
- [x] 당첨 내역을 출력
  - [x] 발행된 로또 숫자와 구입 로또 비교
- [x] 수익률 출력
  - [x] 수익률 계산(소수점 둘째 자리에서 반올림)
- [x] 예외 사항 처리
  - [x] 사용자가 숫자 외의 값을 입력한 경우
  - [x] 사용자가 숫자와 콤마(,)외의 값을 입력한 경우
  - [x] 구입 금액 입력 시 1,000원으로 나누어 떨어지지 않는 경우

## 클래스 구현
기능 구현 전 정리하기 위해 클래스 목록을 작성했다. 
## domain 부분
### Game 패키지
#### 1. Lotto 클래스
- 로또 인스턴스 변수(당첨 번호, 보너스 번호)
- 당첨 번호 6개를 입력했는지 확인하는 함수
- 당첨 번호 6개가 중복되지 않는지 확인하는 함수
- 보너스 번호가 당첨 번호와 중복되지 않는지 확인하는 함수
- 보너스 번호 저장하는 함수
- 당첨 번호가 로또 범위를 벗어나지 않았는지 확인하는 함수
- 보너스 번호가 로또 범위를 벗어나지 않았는지 확인하는 함수

#### 2. LottoString 클래스
- 당첨 번호 6개만 입력해 주세요.
- 당첨 번호가 중복되지 않게 입력해 주세요.
- 당첨 번호와 보너스 번호가 중복되지 않게 입력해 주세요.

#### 3. CreateLotto 클래스
- 발행한 로또 인스턴스 변수
- 로또 숫자 발행하는 함수
  - 1~45범위의 중복되지 않는 6개의 숫자 고르기
- 각 로또 번호 오름차순으로 정렬하는 함수
- 로또 인스턴스 get 함수

#### 4. WinLotto 클래스
- 당첨 통계 초기화하는 함수
- 당첨 로또 숫자와 발행된 로또 비교하는 함수
- 보너스 번호와 발행된 로또 비교하는 함수
- 발행된 로또들 당첨 확인하는 함수 
- 당첨금 더하는 함수
- 수익률 계산하는 함수

#### 5. Ranking 클래스
- 당첨 내역에 대한 enum
- 일치하는 개수에 따른 등수 찾는 함수
- 변수에 대한 getter
- 당첨 통계 앞 문구에 대한 toString함수

### Player 패키지
#### 1. Player 클래스
- 발행한 로또 목록, 구입한 금액, 당첨 통계, 수익률 인스턴스 변수
- 발행한 로또 목록, 구입한 금액, 당첨 통계, 수익률 getter, setter
- 입력받은 금액만큼 로또 발행하는 함수
- 입력받은 금액이 1,000원으로 나누어 떨어지지 않는지 확인하는 함수
#### 2. PlayerString 클래스
- 구입 금액 입력 시 1,000원으로 나누어 떨어지지 않습니다. 

## controller 부분
### controller 패키지
#### 1. LottoController 클래스
- start함수: 로또 구입하고 당첨번호, 보너스 번호 입력하고 당첨 확인해서 당첨통게와 수익률 출력하는 함수
- 로또 구입하는 함수
- 당첨번호, 보너스 번호 입력하는 함수
- 당첨 확인하는 함수

## view 부분
### view 패키지
#### 1. InputView 클래스
- 구입 금액을 입력받는 함수
- 당첨 번호를 입력받는 함수
- 보너스 번호를 입력받는 함수
- 사용자가 숫자 외의 값을 입력했는지 확인하는 함수
- 숫자와 ,로만 이루어져있는지 확인하는 함수
- ,로 구분된 문자열을 int형 리스트로 변환하는 함수

#### 2. InputString 클래스
- 구입 금액을 입력해 주세요.
- 당첨 번호를 입력해 주세요.
- 보너스 번호를 입력해 주세요.
- 사용자가 숫자 외의 값을 입력한 경우 숫자만 입력해 주세요.
- 숫자와 ,외의 값을 입력한 경우 숫자와 ,만 입력해 주세요.

#### 3. OutputView 클래스
- 구입한 로또 수량 출력하는 함수
- 구입한 로또 번호 출력하는 함수
- 당첨 통계 출력하는 함수
- 수익률 출력하는 함수

#### 4. OutputString 클래스
- 구입한 로또 수량 출력
- 당첨 통계 출력
- 수익률 출력

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
