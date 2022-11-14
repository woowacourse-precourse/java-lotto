# 3주차 미션 로또

## 3주차 학습 목표

- 클래스(객체)를 분리하는 연습
- 도메인 로직에 대한 단위 테스트를 작성하는 연습

---

## domain 기능 목록

### 1. Lotto

- [x] 당첨 번호 생성 - Lotto()

### 2. UserLotto

- [x] 구매 개수만큼 로또를 생성 - createUserLotto()

### 3. LottoService

- [x] 구매 금액을 입력받은 뒤 구매할 수 있는 로또 개수 반환 - getLottoAmount()
- [x] 당첨 번호와 로또 번호를 비교하여 같은 숫자의 개수 반환 - countMatchNumber()
- [x] 보너스 번호와 로또 번호를 비교하여 보너스 번호 당첨 여부 반환 - checkBonusNumber()
- [x] 각 로또의 당첨 번호 개수와 보너스 번호 당첨 여부를 종합해 결과 생성 - createLottoResult()
- [x] 수익률 계산 - calculatePercent()

### 4. LottoController
- [x] 로또 번호를 입력받아 초기화 시킨다 - initLotto()
- [x] 로또 구매개수만큼 사용자 로또를 초기화 시킨다 - initUserLotto()
- [x] 보너스 번호를 입력받아 초기화 시킨다 - initBonusNumber()
- [x] 위 기능목록들을 이용하여 전체적인 이벤트를 진행한다 - start()

---

## UI 기능 목록

### LottoInput

- [x] 로또 구매 금액을 입력받는다, 1,000원 단위로 나누어져야 한다 - readMoney()
- [x] 당첨 번호를 입력받는다, 당첨 번호는 쉼표로 구분되어야 한다 - readWinningNumber()
- [x] 보너스 번호를 입력받는다 - readBonusNumber()

### LottoOutput

- [x] 사용자의 로또 번호들을 출력한다 - printUserLotto()
- [x] 당첨 내용을 출력한다 - printLottoResult()
- [x] 수익률을 출력한다, 소수점 둘째 자리에서 반올림한다 - printPercent()
- [x] 예외 사항 시 에러 문구를 출력한다, 에러 문구는 [ERROR]로 시작해야 한다 - Messages

### InputValidator

#### 모든 예외는 사용자의 입력에서 비롯된다 판단하여 UI 부분에서 예외 처리를 하기로 결정

1. 입력한 로또 구매금액에 대한 예외 사항 검사

- [x] 구매금액이 1,000단위가 아닌 경우 - validateInputMoney()
- [x] 1,000원 미만의 금액을 입력받았을 때 - validateInputMoney()
- [x] 입력이 숫자가 아닌 경우 - validateStringInputIsNumeri()

2. 입력한 당첨 번호에 대한 예외 사항 검사

- [x] 입력이 숫자가 아닌 경우 - validateListInputIsNumeric()
- [x] 숫자의 범위가 1 ~ 45가 아닌 경우 - validateInputRange()
- [x] 입력 숫자가 6개가 아닌 경우 - validateInputSize()

3. 입력한 보너스 번호에 대한 예외 사항 검사

- [x] 입력이 숫자가 아닌 경우 - validateStringInputIsNumeri()
- [x] 입력 숫자의 범위가 1 ~ 45가 아닌 경우 - validateInputRange()
- [x] 입력한 보너스 번호와 당첨 번호들 중 중복이 있는 경우 - validateInputBonusNumber()






