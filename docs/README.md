# 로또
## 구성 예시
![img.png](img.png)

<br/>

## 기능 구현 목록
### 로또 용지 - Lotto
- [x] 지정된 번호로 로또를 생성한다. - Lotto#generateLotto
- [x] 중복되지 않는 6개의 랜덤번호를 생성한다. - generateRandomNumbers
- [x] 생성된 로또를 검증한다. - validate
  - 로또 번호의 숫자 범위는 1~45까지이다. - validateRange
  - 1개의 로또를 발행할 때 번호가 중복되면 안된다. - validateDuplicate
  - 총 6개의 숫자를 뽑는다. - validateSize
  - 잘못된 값이 들어온 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다. 
- [x] 저장된 로또 번호를 오름차순으로 정렬한다.
### 구매자 - Buyer
- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다. - buyLotto
- [x] 로또 구입 금액을 입력 받는다. - inputSeedMoney
  - [x] 로또 구입 안내 문구를 출력한다. - printInputSeedMoney
  - [x] 로또 구입 금액을 검증한다. - validateSeedMoney
    - 입력된 금액은 숫자(int)로만 이루어져있어야 한다.
    - 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다. -> Store에서 처리
    - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.
- [x] 당첨 내역을 출력한다. - checkPrize
  - [x] 당첨 통계 확인 ... - requestPrizeToStore
  - [x] 당첨 내역 출력 - printPrize
- [x] 수익률을 출력한다. - checkRate
  - [x] 수익률 계산하기 = 최종수익 / 구매가격 - calcRate
  - [x] 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%) - roundRate
  - [x] 수익률 출력하기.. format: 총 수익률은 n%입니다. - printRate
### 로또 가게 - Store
- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다. - sellLotto
  - [x] 로또 1장의 가격은 1,000원이다. - validateInputMoney
  - [x] 로또를 발행한다. - issueLotto
  - [x] 로또 번호는 오름차순으로 정렬하여 보여준다. - sortLotto
  - [x] 발행한 로또 수량 및 번호를 출력한다. - printLottoInform
- [x] 당첨 확인: 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역을 반환 - checkPrize
  - [x] 보너스 번호가 있는지 확인한다. - hasBonusNumber
  - [x] 당첨번호와 몇개나 일치하는지 확인한다. - countMatchingNumbers
- [x] 외부에서 전달받은 1등번호와 보너스번호를 저장하는 기능 - setWinningLotto, setBonusNumber
  - [x] 전달받은 번호들이 있는지 확인
  - [x] 전달받은 1등번호와 보너스번호가 중복되지않는지 확인
### 상품 정보 - Prize
- [x] 등수별 상품 정보를 담아둔다. 
  - 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
      - 1등: 6개 번호 일치 / 2,000,000,000원
      - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
      - 3등: 5개 번호 일치 / 1,500,000원
      - 4등: 4개 번호 일치 / 50,000원
      - 5등: 3개 번호 일치 / 5,000원
- [x] 일치하는 숫자갯수를 제시하면 몇 등인지 반환해준다.
### 로또 결과 - LottoResult
- [x] 당첨된 로또 결과(당첨내역)를 기록한다.
- [x] 당첨 내역이 올바른지 검증
- [x] 전체 당첨 금액을 반환한다.
- [x] 특정 등수에 몇개 당첨되었는지 반환한다.
### 관리자 - Admin
- [x] 당첨 번호와 보너스 번호를 입력받는다. - inputGameNumbers
  - [x] 입력 받은 번호를 store에 설정한다.
  - [x] 당첨 번호를 입력받는다. - inputWinningNumbers
    - [x] 번호는 쉼표(,)를 기준으로 구분한다. - splitSeparator
    - [x] 입력받은 String을 Int로 변환한다.
    - [x] 당첨 번호 입력시 "당첨 번호를 입력해주세요." 메세지가 표시된다. - printInputWinningNumbers
  - [x] 보너스 번호를 입력 받는다. - inputBonusNumber
      - [x] 보너스 번호 입력시 "보너스 번호를 입력해주세요." 메세지가 표시된다. - printInputBonusNumber
  - [x] 당첨 번호를 검증한다. - validateGameNumbers
    - [x] 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 - validateWinningNumbersInput, 숫자들에 대해서는 Lotto에서 검증
      - 입력은 숫자와 쉼표 형태로 이루어져 있다.
    - [x] 숫자형태의, 중복되지 않는 보너스 번호 1개를 뽑는다. - validateBonusNumber
    - [x] 입력된 번호들이 전부 중복되면 안된다.

<br/>

## 체크 사항
### 요구 사항
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- Java Enum을 적용한다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
- [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
