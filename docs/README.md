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
- [x] "n개를 구매했습니다."를 출력한다. - ShowMessage#showHowManyBuy()
- [x] 발행한 로또 번호를 "[n, n, n, n, n, n]"의 형식으로 출력한다. - ShowMessage#showLottoNumber()
- [x] "당첨 번호를 입력해 주세요."를 출력한다. - ShowMessage#showInputLottoNumber()
- [x] "보너스 번호를 입력해 주세요."를 출력한다. - ShowMessage#showInputBonusNumber()
- [x] "당첨 통계{\n}---"를 출력한다. - ShowMessage#showLottoStatistics()

- [x] "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."를 출력한다. - ShowErrorMessage#showOutRangeLottoNumber()
  - [x] "[ERROR] 금액은 1,000으로 나누어 떨어져야 합니다."를 출력한다. - ShowErrorMessage#showNotDivide()
- [x] "[ERROR] 당첨 번호의 개수는 6개여야 합니다."를 출력한다. - ShowErrorMessage#showLottoNumberCount()
- [x] "[ERROR] 당첨 번호는 중복될 수 없습니다."를 출력한다. - ShowErrorMessage#showDuplicateLottoNumber()
- [x] "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."를 출력한다. - ShowErrorMessage#showContainsBonusNumber()

- [x] 구입할 수 있는 로또의 개수를 반환 - Lotto#lottoCount()
- [x] 1 ~ 45까지의 숫자 중 6개의 중복되지 않는 숫자를 뽑는다. - Lotto#createLottoNumbers()
- [x] 구입할 금액만큼 로또 번호를 반복하여 생성하고 오름차순 정렬 - lottoList = Lotto#createLottoList()
  - [x] 구입할 금액만큼 로또 번호를 반복하여 생성 - Lotto#createLottoList()
  - [x] 발행한 로또 번호를 오름차순으로 정렬한다. - Lotto#sortLottoNumberAscending()

- [ ] 로또를 구매하기 - Lotto#buyLotto()
- [ ] 당첨 확인 - Lotto#lottoCheckWin()

- [x] 구매한 로또 번호들과 당첨 번호를 비교한다. - Lotto#lottoCompare()
  - [x] 로또 번호와 당첨 번호를 비교한다. -Lotto#compareLotto()

- [x] 사용자에게 입력 받고 long으로 반환 - InputLotto#inputValueToLongs()
  - [x] 사용자에게 값을 입력 받는다. - InputLotto#inputValueOfUser()
  - [x] 문자열을 long으로 변환 - InputLotto#toLongs()
- [ ] 사용자에게 입력을 받고 List로 변환 - InputLotto#InputValueToLst()
- [ ] String형식의 번호를 입력 받고 List로 변환 - InputLotto#InputStringsToLst()
  - [x] 사용자에게 값을 입력 받는다. - InputLotto#inputValueOfUser()
  - [x] 문자열을 ,(쉼표)를 기준으로 나누기 - InputLotto#splitCommas()
    - [x] 문자열을 long으로 변환 - InputLotto#toLongs()
- [x] 당첨 번호를 입력받고 List<Integer> 형으로 반환 - InputLotto#InputValueSplitCommas()
  - [x] String을 int형으로 변환하는 toInts 메서드 구현 - InputLotto#toInts()
  - [x] List<String>형을 List<Integer>형으로 반환 - InputLotto#toIntList()
- [x] 보너스 번호를 입력 받는다. - InputLotto#inputBonusNumber()

- [x] 숫자만 입력되었는지 검사한다. - ExceptionHandling#isNumeric()
- [x] 입력한 금액이 1,000원 단위로 나누어떨어지는지 검사한다. - ExceptionHandling#notDivide()
  - [x] 문자열을 ,(쉼표)를 기준으로 나누기 - InputLotto#splitStrings()
  - [x] 문자열을 long으로 변환 - InputLotto#toLongs()
- [x] 입력한 숫자가 1 ~ 45의 숫자인지 검사한다. - ExceptionHandling#outRangeLottoNumber()
- [x] 입력한 당첨 번호가 중복인지 검사한다. - ExceptionHandling#removeDuplicateNumber()
- [x] 입력한 보너스 번호가 당첨 번호와 중복인지 검사한다. - ExceptionHandling#containsBonusNumber()

### enum으로 처리
- [ ] "3개 일치 (5,000원) - n개"를 출력한다. - WinStatistics#showWinMessage()
- [ ] "4개 일치 (50,000원) - n개"를 출력한다. - WinStatistics#showWinMessage()
- [ ] "5개 일치 (1,500,000원) - n개"를 출력한다. - WinStatistics#showWinMessage()
- [ ] "5개 일치, 보너스 볼 일치 (30,000,000원) - n개"를 출력한다. - WinStatistics#showWinMessage()
- [ ] "6개 일치 (2,000,000,000원) - n개"를 출력한다. - WinStatistics#showWinMessage()

## 예외 처리
- [x] 로또를 구매하는 금액이 1000으로 나누어지지 않는 경우
- [x] 로또를 구매하는 금액이 0이하인 경우
- [x] 로또를 구매하는 금액이 숫자가 아닌 경우
- [x] 로또(보너스) 번호를 입력 받을 때 숫자 범위(1 ~ 45)를 벗어나는 입력을 한 경우 
- [x] 로또(보너스) 숫자가 아닌 경우
- [x] 로또(보너스) 숫자가 6개가 아닌 경우
- [x] 당첨 번호를 입력 받을 때 중복 숫자가 있는 경우
- [x] 보너스 번호 입력 시 기존 당첨 번호와 중복된 경우