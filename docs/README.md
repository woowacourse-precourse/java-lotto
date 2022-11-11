# 로또

## 규칙
로또 게임 기능을 구현해야 한다. 로또 게임은 아래와 같은 규칙으로 진행된다.
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
      로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
      로또 1장의 가격은 1,000원이다.
      당첨 번호와 보너스 번호를 입력받는다.
      사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
      사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.

## 기능 목록
- [x] "구입금액을 입력해 주세요."를 출력한다. - ShowMessage#showInputAmountBuy()
- [x] "n개를 구매했습니다."를 출력한다. - ShowMessage#showHowManyBuy(int number)
- [x] 발행한 로또 번호를 "[n, n, n, n, n, n]"의 형식으로 출력한다. - ShowMessage#showLottoNumber(List<List<Integer>> lottoNumbers)
- [x] "당첨 번호를 입력해 주세요."를 출력한다. - ShowMessage#showInputLottoNumber()
- [x] "보너스 번호를 입력해 주세요."를 출력한다. - ShowMessage#showInputBonusNumber()
- [x] "당첨 통계{\n}---"를 출력한다. - ShowMessage#showLottoStatistics()

- [x] "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." - ShowErrorMessage#showOutRangeLottoNumber()
- [x] "[ERROR] 금액은 1,000으로 나누어 떨어져야 합니다."를 출력한다. - ShowErrorMessage#showNotDivide()

- [x] 구입할 수 있는 로또의 개수를 반환 - int lottoCount = Lotto#lottoCount(int number)
- [x] 1 ~ 45까지의 숫자 중 6개의 중복되지 않는 숫자를 뽑는다. - Lotto#createLottoNumbers()
- [x] 구입할 금액만큼 로또 번호를 반복하여 생성 - List<List<Integer>> lottoNumber = Lotto#createLotto()

- [ ] 로또를 구매하기 - Long amount = Lotto#buyLotto()
- [ ] 당첨 확인 - Lotto#lottoCheckWin()

- [ ] 구매한 로또 번호들과 당첨 번호를 비교한다. - Lotto#lottoCompare()
- [ ] 발행한 로또 번호를 오름차순으로 정렬한다. - Lotto#sortLottoNumberAscending(List<Integer> lottoNumber)

- [x] 사용자에게 입력 받고 long으로 반환 int lottoCount = InputLotto#inputValueToLongs()
  - [x] 사용자에게 값을 입력 받는다. String userValue = InputLotto#inputValueOfUser()
  - [x] 문자열을 long으로 변환 - int number = InputLotto#toLongs(String number)
- [ ] 사용자에게 입력을 받고 List로 변환 List<Integer> winNumbers = InputLotto#InputValueToLst()
- [ ] String형식의 번호를 입력 받고 List로 변환 List<Integer> winNumbers = InputLotto#InputStringToLst()
  - [x] 사용자에게 값을 입력 받는다. String userValue = InputLotto#inputValueOfUser()
  - [ ] 문자열을 ,(쉼표)를 기준으로 나누기 - String[] numbers = InputLotto#splitStrings(String numbers)
  - [ ] 당첨 번호 모두를 int로 변환 - List<Integer> winNumbers = InputLotto#allToInts(String[] numbers)
    - [x] 문자열을 long으로 변환 - int number = InputLotto#toLongs(String number)

- [x] 숫자만 입력되었는지 검사한다. - ExceptionHandling#isNumeric(String value)
- [x] 입력한 금액이 1,000원 단위로 나누어떨어지는지 검사한다. - ExceptionHandling#notDivideException(long amount)
- [ ] 입력한 당첨 번호가 입력 규칙에 유효한지 검사한다. - ExceptionHandling#lottoNumberRuleException(String lottoNumber)
  - [ ] 문자열을 ,(쉼표)를 기준으로 나누기 - String[] numbers = InputLotto#splitStrings(String numbers)
  - [x] 문자열을 long으로 변환 - int number = InputLotto#toLongs(String number)
- [ ] 입력한 숫자가 1 ~ 45의 숫자인지 검사한다. - ExceptionHandling#bonusNumberException(int bonusNumber)

### enum으로 처리
- [ ] "3개 일치 (5,000원) - n개"를 출력한다. - WinStatistics#showWinMessage(int number)
- [ ] "4개 일치 (50,000원) - n개"를 출력한다. - WinStatistics#showWinMessage(int number)
- [ ] "5개 일치 (1,500,000원) - n개"를 출력한다. - WinStatistics#showWinMessage(int number)
- [ ] "5개 일치, 보너스 볼 일치 (30,000,000원) - n개"를 출력한다. - WinStatistics#showWinMessage(int number)
- [ ] "6개 일치 (2,000,000,000원) - n개"를 출력한다. - WinStatistics#showWinMessage(int number)

## 예외 처리
- [ ] 로또를 구매하는 금액이 1000으로 나누어지지 않는 경우 || 0이하인 경우 || 숫자가 아닌 경우
- [ ] 로또(보너스) 번호를 입력 받을 때 숫자 범위(1 ~ 45)를 벗어나는 입력을 한 경우 || 숫자가 아닌 경우