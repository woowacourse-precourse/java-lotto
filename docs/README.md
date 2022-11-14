## 로또 게임

### 게임의 규칙

로또 게임 기능을 구현한다. 규칙은 아래와 같다.

- 로또 번호의 범위 : 1~45
- 로또 번호의 조건 : 6개의 중복되지 않는 수
- 당첨 번호의 조건 : 7개의 중복되지 않는 수(6개는 일반 번호, 1개는 보너스 번호)
- 당첨 조건 : 1등부터 5등
    - 1등 : 6개 일반번호 일치 → 20억원
    - 2등 : 5개 일반번호 + 1개 보너스 번호 → 3천만원
    - 3등 : 5개 일반번호 일치 → 150만원
    - 4등 : 4개 일반번호 일치 → 5만원
    - 5등 : 3개 일반번호 일치 → 5천원

### 입출력

- 로또 구입 금액 입력 : 1000원단위로 입력, 아닐경우 예외처리
- 당첨 일반번호 입력 : 쉼표를 기준으로 입력
- 당첨 보너스번호 입력 : 하나만 입력
- 발행받은 로또 수량 및 번호 출력 : 로또번호 오름차순으로 출력
- 당첨 내역 출력 : 5,4,3,2,1등 순 + 당첨 로또 출력
- 수익률 출력 : 둘째 자리에서 반올림

### 예외 처리

- 로또 구입 금액 → 1000단위가 아님
- 일반 당첨번호 입력 → ,로 나누었을 때, 숫자가 6개가 아님
- 일반 당첨번호 입력, 보너스 당첨번호 입력 → 숫자가 아님
- 일반 당첨번호 입력, 보너스 당첨번호 입력 → 각 숫자가 범위를 벗어남

## 기능 목록
//TODO: README 재작성
최종 결과가 나올 때 까지 어떤 기능을 거쳐가야할지 순서대로 기능을 생각해본다.

- [x]  Lotto
- [x]  WinnerLotto
- [x]  TotalWinnerLotto

- [x]  로또 구입 금액 입력 메시지를 출력한다. OutputUI#printMessage()
- [x]  당첨 일반 번호 입력 메시지를 출력한다. OutputUI#printMessage()
- [ ]  당첨 보너스 번호 입력 메시지를 출력한다. OutputUI#printMessage()
- [ ]  발행 받은 로또 용지를 출력한다. OutputUI#printLottos()
- [ ]  당첨로또의 갯수를 출력한다. OutputUI#printWinnerResult()
- [ ]  수익률을 출력한다. OutputUI#printReturnRate()

- [x]  로또 구입 금액을 입력받는다. InputUI#getMoney()
- [x]  당첨 번호를 입력받는다. Input#getLottoNumbers()
    - [x]  당첨 일반 번호를 입력받는다. InputUI#getNormalNumbers()
    - [x]  당첨 보너스번호를 입력받는다. InputUI#getBonusNumber()

- [ ]  1000원 단위인지 검증한다. Validator#validateMoney()
- [ ]  당첨 일반 번호를 검증한다. Validator#validateNormalNumbers()
- [ ]  당첨 보너스 번호를 검증한다. Validator#validateBonusNumber()

- [ ]  발행할 로또 갯수만큼 로또 용지를 발급한다. LottoMachine#createLottoWithMoney()
    - [ ]  로또 용지를 발급한다. LottoMachine#createLotto()

- [ ]  구입한 로또의 당첨 결과를 계산한다. RaffleMachine#countWinner()
    - [ ]  당첨 일반 번호가 몇개 있는지 확인한다. RaffleMachine#countNormalNumbers()
    - [ ]  당첨 보너스 번호가 포함되어 있는지 확인한다. RaffleMachine#countBonusNumber()
- [ ]  구입한 로또의 등수를 계산한다. RaffleResultCalculator#decideRank()
- [ ]  수익률을 계산한다. RaffleResultCalculator#calculateStatics()

- [ ]  로또 프로세스의 전반적인 흐름을 관리한다. LottoController#startLotto()