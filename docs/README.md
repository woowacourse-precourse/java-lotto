## 🚀 프로젝트 소개
> 이번 주차는 로또 게임 기능을 구현한다.


### 1. 게임 진행 및 규칙

<details>
    <summary>part 1. 로또 번호 생성</summary>
    <div markdown="1">

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
</details>

<details>
    <summary>part 2. 로또 구매</summary>
    <div markdown="1">

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.
</details>


<details>
    <summary>part 3. 로또 번호 생성 및 추첨</summary>
    <div markdown="1">

- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.


- 로또 번호의 숫자 범위는 1~45까지이다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.


- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  ```
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
  ```
</details>

<br>

### 2. 입출력 요구 사항

<details>
    <summary>입력</summary>
    <div markdown="1">

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
</details>

<details>
    <summary>출력</summary>
    <div markdown="1">

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
</details>

<details>
    <summary>실행 결과 예시</summary>
    <div markdown="1">

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


</details>

<br>

### 3. 과제 요구 조건

<details>
    <summary> <b>사용할 라이브러리 - camp.nextstep.edu.missionutils</b> </summary>
    <div markdown="1">

[`camp.nextstep.edu.missionutils`](https://github.com/woowacourse-projects/mission-utils)에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.

- [x] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.

- [x] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
  

  - 사용 예시
    ```java
    List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    ```
  
<br>

</details>

<details>
    <summary> <b>사용할 클래스 - Lotto</b> </summary>
    <div markdown="1">

- 제공된 `Lotto` 클래스를 활용해 구현해야 한다.

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
  - [x] `Lotto`에 매개 변수가 없는 생성자를 추가할 수 없다.
  - [x] `numbers`의 접근 제어자인 private을 변경할 수 없다.
  - [x] `Lotto`에 필드(인스턴스 변수)를 추가할 수 없다.
  - [x] `Lotto`의 패키지 변경은 가능하다.
  - [x] `제약사항으로 명시된 부분 외에는 자유롭게 코드를 수정할 수 있다.

<br>
</details>

<br><br>


## 📝 프로젝트에서 구현할 기능 목록
> ✔  핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.

> ✔  예외 처리 : IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.

<br>

### 로또 발행
- [x] `UI` : 로또 구입금액 입력
- [x] 로또 구입 금액을 입력받으면, 구입 금액에 해당하는 만큼 로또 발행하기
  - [x] `Exception` : 입력된 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외 처리
- [x] 1~45 범위의 숫자 내에서 중복되지 않는 6개의 숫자 생성하기 (로또 번호는 오름차순으로 정렬)
- [x] `UI` : 발행한 로또 수량 및 번호 출력

<br>

### 당첨번호 추첨
- [x] `UI` : 당첨 번호 6개와 보너스 번호 1개 입력
- [x] 당첨 번호로 로또 생성하기 (예외 처리에 편리)
  - [x] `Exception` : 로또 번호(당첨 번호)가 1~45 범위의 숫자를 넘어가면 예외 처리
  - [x] `Exception` : 로또 번호(당첨 번호)에 중복된 숫자가 있으면 예외 처리
  - [x] `Exception` : 로또 번호(당첨 번호)가 6개가 아닐 경우 예외 처리
- [x]  `Exception` : 로또 번호(당첨 번호)가 숫자 리스트가 아닌 잘못된 입력값일 경우 예외 처리
- [x] `Exception` : 보너스 번호가 1~45 범위의 숫자를 넘어가면 예외 처리
- [x] `Exception` : 보너스 번호가 당첨번호와 중복될 경우 예외 처리
- [x] `Exception` : 보너스 번호가 1개가 아닐 경우 예외 처리
- [x] `Exception` : 보너스 번호가 숫자가 아닌 잘못된 입력값일 경우 예외 처리

<br>

### 당첨 결과 도출
- [x] 사용자가 구매한 로또 번호와 당첨 번호 비교하기
- [ ] 비교한 결과에 맞게 당첨 순위 도출하기
- [ ] 처음 구매한 금액과 비교하여 수익률 계산하기
- [ ] `UI` : 사용자의 당첨 내역 및 수익률 출력
- [ ] 로또 게임 종료

<br><br>

## 🔥 이번 프로젝트의 도전 과제들


### 1️⃣ Documentation
> `docs/README.md`에 작성한다. 

&nbsp; &nbsp;   ✔&nbsp; 프로젝트 소개, 요구사항, 도전 과제, 구현할 기능 목록 등을 상세히 작성해본다.


&nbsp; &nbsp;   ✔&nbsp; 구현할 기능 목록

&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; - 예외 처리도 목록으로 정리해본다. (단, 예외 상황은 시작 단계에서 모두 찾기 힘들기 때문에 기능을 구현하면서 계속 추가)

&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; - 주의 : 클래스, 함수(메서드) 명 등 추후 변경될 수 있는 부분 등을 너무 상세하게 작성하지 않는다.


&nbsp; &nbsp;   ✔&nbsp; 죽은 문서가 아니라 살아있는 문서를 만들기 위해 노력한다.

<br>

### 2️⃣ Commit
&nbsp; &nbsp;   ✔&nbsp; commit 단위 : `docs/README.md`에 작성한 '구현해야 할 기능 목록'의 기능 단위로 커밋한다.

&nbsp; &nbsp;   ✔&nbsp; commit message : AngularJS Git Commit Message Conventions를 준수하여 작성한다.

<br>

### 3️⃣ Java Code Convention
&nbsp; &nbsp;   ✔&nbsp; [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다. 


&nbsp; &nbsp;   ✔&nbsp; indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.

&nbsp; &nbsp;   ✔&nbsp; Java Enum을 적용한다.

&nbsp; &nbsp;   ✔&nbsp; 3항 연산자를 쓰지 않는다.

&nbsp; &nbsp;   ✔&nbsp; 변수 이름에 자료형은 사용하지 않는다.

&nbsp; &nbsp;   ✔&nbsp; else 예약어를 및 switch/case 사용을 지양한다. (if 조건절에서 값을 return하는 방식으로 구현)


&nbsp; &nbsp;   ✔&nbsp; 구현 순서도 코딩 컨벤션이다. 클래스는 상수, 멤버 변수, 생성자, 메서드 순으로 작성한다.

<br>

### 4️⃣ Clean Code
&nbsp; &nbsp;   ✔&nbsp; 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.<br>

&nbsp; &nbsp;   ✔&nbsp; 여러 함수에서 **중복되어 사용되는 코드**가 있다면 **함수 분리**를 고민해 본다.<br>

&nbsp; &nbsp;   ✔&nbsp; 함수(또는 메서드)의 길이가 **15라인**을 넘어가지 않도록 구현한다.

<br>

### 5️⃣  TDD
> 단위 테스트는 JUnit 5와 AssertJ를 이용한다.

- [ ] 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.


- [ ] 도메인 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
  - [ ] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
  - [ ] 단위 테스트 작성이 익숙하지 않다면 `test/java/lotto/LottoTest`를 참고하여 학습한 후 테스트를 구현한다.


- [ ] 테스트코드 작성 후, 테스트를 작성하는 이유에 대해 본인의 경험을 토대로 정리해본다.

  > 
  > 💡 **참고 : 테스트 코드 작성시 좋은 점**
  >  - 기능 점검 가능
  >  - 나의 코드에 대해 빠르게 피드백을 받을 수 있음
  >  - 학습 도구로도 활용 가능

---
