## 🚀 기능 요구 사항 정리

<hr>

### 로또 실행 및 통계 관리 LottoManager


<br/>

<hr>

### 사용자의 로또 Lotto

- [ ] 생성 검증 validate()
    - [ ] 리스트의 길이는 6이다.
    - [ ] 각각의 숫자는 1 ~ 45 범위의 자연수이다.


- [ ] 로또 당첨 결과 확인 match()
    - [ ] WinningNumber를 통해 몇 등인지 파악한다.
    - [ ] 결과로 RewardEnum을 반환한다.

- 검토 사항
    - [ ] 제공된 `Lotto` 클래스를 활용해 구현해야 한다.
    - [ ] `Lotto`에 매개 변수가 없는 생성자를 추가할 수 없다.
    - [ ] `numbers`의 접근 제어자인 private을 변경할 수 없다.
    - [ ] `Lotto`에 필드(인스턴스 변수)를 추가할 수 없다.
    - [ ] `Lotto`의 패키지 변경은 가능하다.

<br/>

### 로또 당첨 번호 WinningNumber



<br/>


### 자동 로또 숫자 생성기 NumberGenerator

- 왜 Lotto에 generte()를 쓰지 않았는가?
    - 구현 조건에 외부 라이브러리를 사용하므로 인터페이스와 구현체를 분리해서 의존도를 낮추기 위해 나눔


- [ ] 6자리 로또 번호 generate()
    - [ ] 숫자 범위 1 ~ 45에서 중복 없는 6자리의 수 생성
    - [ ] 반환되는 리스트는 오름차순으로 정렬돼있다.
    - 검토 사항
        - [ ] `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용

<br/>

### 입력 Input

- 왜 다른 Class에 직접 read~~()를 쓰지 않았는가?
    - 구현 조건에 외부 라이브러리를 사용하므로 인터페이스와 구현체를 분리해서 의존도를 낮추기 위해 나눔


- [ ] 금액 입력 readQuantityFromMoney()
    - [ ] 입력 전 `구입금액을 입력해 주세요.`를 출력한다.
    - [ ] 구입 금액은 1장 가격 1,000원 단위로 입력 받는다.
    - [ ] 입력된 값을 1,000으로 나누어 로또 구매 수량 반환
    - 검증 사항
        - [ ] 입력은 항상 자연수이며 1,000으로 나누어 떨어진다.
        - [ ] 예외 사항에 대하여 `IllegalArgumentException`을 발생시킨다.

- [ ] 당첨 번호 입력 readBasicWinningNumber()
    - [ ] 입력 전 `당첨 번호를 입력해 주세요.`를 출력한다.
    - [ ] `,`를 구분자로 1 ~ 45 범위에서 중복 없는 숫자 6자리를 입력 받는다.
    - [ ] 입력된 값을 1,000으로 나누어 로또 구매 수량 반환
    - 검증 사항
        - [ ] `,`를 구분자로 나누었을 때 총 6개의 문자열로 나누어진다.
        - [ ] `,`를 구분자로 나누었을 때 각각의 문자열은 모두 숫자이다.
        - [ ] `,`를 구분자로 나누었을 때 각각의 문자열은 1 ~ 45 범위의 자연수이다.
        - [ ] 예외 사항에 대하여 `IllegalArgumentException`을 발생시킨다.


- [ ] 당첨 번호 입력 readBonusWinningNumber()
    - [ ] 입력 전 `당첨 번호를 입력해 주세요.`를 출력한다.
    - 검증 사항
        - [ ] 입력은 숫자로 이루어져 있음
        - [ ] 예외 사항에 대하여 `IllegalArgumentException`을 발생시킨다.


- 검토 사항
    - [ ] `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용

<br/>

<hr>

### 텍스트 출력 Text


<br/>


    