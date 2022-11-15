#로또 미션

## 기능 목록

### 로또를 구매한다.
  - [x] 로또 구매 금액을 입력한다. - **InputView**#sendMoney()
    - [x] 로또 구매 금액을 검증한다. - **InputValidator**#validateMoney()
        - 금액은 1000의 배수여야한다.
  - [x] 금액을 전달받아 로또를 구매한다. - **LottoService**#buy()
    - [x] 로또를 생성한다 - **LottoGenerator**#createLotto()
  - [x] 구매한 로또들의 정보(갯수, 번호)를 출력한다. - **OutputView**#printLottoBundleInfo()
### 로또 당첨 결과를 확인한다.
  - [x] 로또 당첨 번호를 입력한다. - **InputView**#sendWinningNumbers()
    - [x] 로또 당첨 번호를 검증한다. - **Validator**#validateWinningNumbers()
        - 당첨 번호는 6개의 숫자로 이루어진다.
        - 당첨 번호는 콤마(,)를 통해 구분한다.
        - 각 당첨번호는 1 이상, 45 이하의 정수이다.
  - [x] 보너스 번호를 입력한다. - **InputView**#sendBonusNumber()
    - [x] 보너스 번호를 검증한다. - **Validator**#validateBonusNumber()
        - 보너스 번호는 당첨 번호의 값과 중복되지않는다.
        - 보너스 번호는 1 이상, 45 이하의 정수이다.
  - [x] 내가 구매한 로또의 번호와 당첨번호 및 보너스 번호를 비교한다. - **LottoService**#compareLottoNumbers()
    - [x] 로또 번호와 당첨번호의 일치 갯수를 구한다. - **Lotto**#getNumberOfMatchesByWinningNumbers()
    - [x] 로또 번호에 보너스 번호의 포함 여부를 구한다. - **Lotto**#hasBonusNumber()
    - [x] 당첨번호 일치 갯수와, 보너스 번호 일치 여부로 로또 결과를 생성한다. - **LottoResult**#of()
  - [x] 로또 당첨 결과를 출력한다. - **OutputView**#printLottoResult()
### 수익률을 제공한다.
  - [x] 로또 수익률을 계산한다. - **LottoService**#calculateYield()
  - [x] 로또 수익률을 출력한다 - **OutputView**#printYield()
