# 미션 - 로또

> 복권 구매금액과 당첨번호,보너스번호를 입력하면 그에 맞게 당첨결과 및 수익률을 출력해주는 프로그램

-------
## 목차
- [업데이트 내역](#업데이트-내역)
- [사용예시](#사용예시)
- [기능목록](#기능목록)
    - [사용자 입력](#사용자-입력)
    - [문제 생성](#문제-생성)
    - [문제 해결](#문제-해결)
- [플로우차트](#플로우차트)
- [구현시 유의사항](#구현시-유의사항)
  - [라이브러리](#라이브러리)
  - [Lotto 클래스](#Lotto-클래스)
----
## 업데이트 내역
- 0.2.0
  - README.md 오타 수정 
    - 목차 링크 오류 수정
  - 문제생성 기능 일부 추가
    - 구매개수 출력 기능
    - 개수에 따른 로또번호목록 출력 기능
  - 에러메시지 기능 try-catch문으로 일괄적으로 출력하게끔 수정
- 0.1.1
  - README.md 오타 수정 
- 0.1.0
  - 사용자 입력 기능 추가
    - Problem,User 클래스 추가
- 0.0.1
    - README.md 작성

---
## 사용예시
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
## 기능목록

### 사용자 입력
- [x] `구입금액을 입력해주세요.`라는 문구가 콘솔에 출력된다
- [x] 사용자의 로또구매 금액을 입력받는다.
- [x] 입력 값의 유효성 검증
    - [x] 사용자의 로또구매 금액이 1000원으로 나누어 떨어지는지 확인한다.
    - [x] 예외 사항 발생 처리
        - [x] `IllegalArgumentException`을 발생시킨다.
        - [x] 에러메시지를 출력한다.
      ```
      [ERROR] 구입금액은 1000원 단위이어야 합니다.
      ```
        - [x] 프로그램을 종료한다.
### 문제 생성
- [x] 구매 금액에 따른 구매 개수를 출력한다.
    - [x] 구매개수는 구매금액/1000 이다.
- [x] 구매 금액에 따른 개수만큼의 로또번호 목록을 출력한다.
    - [x] 로또숫자의 범위는 1부터 45까지이다.
    - [x] 로또번호의 개수는 6개여야한다.
    - [x] 로또번호의 출력은 오름차순이어야한다.
- [ ] 사용자의 입력
    - [ ] `당첨 번호를 입력해 주세요.`라는 문구가 콘솔에 출력된다
    - [ ] 당첨번호를 입력받는다. 이때 번호는 쉼표(`,`)로 구분한다.
    - [ ] `보너스 번호를 입력해 주세요.`라는 문구가 콘솔에 출력된다.
    - [ ] 보너스번호를 입력받는다.
- [ ] 입력 값의 유효성 검증
    - [ ] 당첨번호의 개수가 총 6개인지 확인한다.
    - [ ] 당첨번호와 보너스번호의 범위가 1부터 45까지인지를 확인한다.
    - [ ] 입력한 번호들 사이에 중복이 없는지 확인한다.
    - [ ] 예외 사항 발생 처리
        - [ ] `IllegalArgumentException`을 발생시킨다.
        - [ ] 에러메시지를 출력한다.
      ```
      [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
      or
      [ERROR] 입력된 번호의 개수가 6개가 아닙니다.
      or
      [ERROR] 로또 번호는 중복되면 안됩니다.
      ```
        - [ ] 프로그램을 종료한다.
### 문제 해결
- [ ] 각각의 로또번호(6개)와 `문제생성`에서 입력한 당첨번호와 보너스번호(총 7개)를 비교한다.
    - [ ] 당첨번호와 일치하는 번호의 개수를 알수있다.
    - [ ] 보너스 번호와 일치하는것이 있는지 알수있다.
- [ ] 비교 결과에 따라 등수를 구분한다.
    - 등수와 당첨금액은 다음과 같다.
        - 1등: 6개 번호 일치 / 2,000,000,000원
        - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
        - 3등: 5개 번호 일치 / 1,500,000원
        - 4등: 4개 번호 일치 / 50,000원
        - 5등: 3개 번호 일치 / 5,000원
    - [ ] 당첨 등수의 개수와 당첨금액의 총합을 알아야 한다.
### 결과 출력
- [ ] 아래의 문구가 콘솔에 출력된다.
   ``` 
   당첨 통계
   ---
   ``` 
- [ ] 당첨 내역을 출력한다.
    - 예시
  ```
  3개 일치 (5,000원) - 1개
  4개 일치 (50,000원) - 0개
  5개 일치 (1,500,000원) - 0개
  5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
  6개 일치 (2,000,000,000원) - 0개
  ```
- [ ] 수익률을 출력한다.
    - [ ] 수익률은 소수점 둘째자리에서 반올림한다.
    - 예시
  ```
  총 수익률은 62.5%입니다.
  ```

----
## 플로우차트
[![](https://mermaid.ink/img/pako:eNqFU99r2lAU_lcu9ymD6EzizzxstDVtLYw-bA9S7UPQaGUmERehnQqWWpBZmBvKHIvObi114ENmtbOwvyj3-j_sJrmytrAuBHLvOd_5zne-3FuFGT2rQBHmy3LpALyKpzVAnrXUsttE56b9a4GGY4DbJh5-2Ac-3zOwnkKTBR6ZAJ8McPPnvlew7uY2GHs-wcNTe9HCvXNAVmh0-cRDbLiIeNULAtv6iAczgKcm_tJB7TE2m3iwsK3Gc7D7NFn3auJuTW23BjYZjxN_6gDUtdDlApBW6OrCtkzc6gNkvQfoem7fnKFpa9lfAHxj_u1NeZI1IHGpRLGo5OXiWjlfURXNkA4zSsko6BqdZNPF5hjUvsXTMWXz6Geo2cLvLlYd7k4ncW6ZlOQYIhF9naAfXce1q8Z9JQTgAve4Bw5_O0Xfz6iEnAvZolatnBr18Mkx9Yj6s-UAyVgSz_xrqlVf3oFKSf5_8nhPHv-IPK-rXtumJ2HZm9lTiya3nWSCsa1j8uJB_95fwZ8b4K6v7ENP0W3TnneomIRDtZMi3Pb1b6qTdtlxUq8f0QhZqCplVS5kydmuOrE0NA4UVUlDkSyzSk6uFI00TGt1ApUrhv7ySMtA0ShXFBZWSlnZUOIFmdwKFYo5ufiGREuytqfr6gpEtlCswkMoChznF8IxgXyFQIgLRFl4BEUfF-X8XFAQosGwwAdD4WCkzsK3LgPnD4TCsUg0FgxEeD4sxAQWKtmCoZdfeNfRvZX1P1WCnHk?type=png)](https://mermaid-js.github.io/mermaid-live-editor/edit#pako:eNqFU99r2lAU_lcu9ymD6EzizzxstDVtLYw-bA9S7UPQaGUmERehnQqWWpBZmBvKHIvObi114ENmtbOwvyj3-j_sJrmytrAuBHLvOd_5zne-3FuFGT2rQBHmy3LpALyKpzVAnrXUsttE56b9a4GGY4DbJh5-2Ac-3zOwnkKTBR6ZAJ8McPPnvlew7uY2GHs-wcNTe9HCvXNAVmh0-cRDbLiIeNULAtv6iAczgKcm_tJB7TE2m3iwsK3Gc7D7NFn3auJuTW23BjYZjxN_6gDUtdDlApBW6OrCtkzc6gNkvQfoem7fnKFpa9lfAHxj_u1NeZI1IHGpRLGo5OXiWjlfURXNkA4zSsko6BqdZNPF5hjUvsXTMWXz6Geo2cLvLlYd7k4ncW6ZlOQYIhF9naAfXce1q8Z9JQTgAve4Bw5_O0Xfz6iEnAvZolatnBr18Mkx9Yj6s-UAyVgSz_xrqlVf3oFKSf5_8nhPHv-IPK-rXtumJ2HZm9lTiya3nWSCsa1j8uJB_95fwZ8b4K6v7ENP0W3TnneomIRDtZMi3Pb1b6qTdtlxUq8f0QhZqCplVS5kydmuOrE0NA4UVUlDkSyzSk6uFI00TGt1ApUrhv7ySMtA0ShXFBZWSlnZUOIFmdwKFYo5ufiGREuytqfr6gpEtlCswkMoChznF8IxgXyFQIgLRFl4BEUfF-X8XFAQosGwwAdD4WCkzsK3LgPnD4TCsUg0FgxEeD4sxAQWKtmCoZdfeNfRvZX1P1WCnHk)

----
## 구현시 유의사항

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
