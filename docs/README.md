## Features

---

- 로또 구입 금액을 입력 받는다.
  - inputMoney 메소드
      - 문자열을 입력을 받고 checkInput 메소드를 호출하여 올바른 입력인지 확인한다.
      - checkInput 메소드가 실행된 후 반환된 money 를 반환한다.
      - 이 과정에서 예외가 발생하면 `IllegalArgumentException`과 함께 에러메시지를 출력한다.
  - checkInput 메소드
      - 입력받은 문자열을 정수로 변환한다.
      - 변환된 정수가 1000으로 나누어 떨어지는지 확인한다.

- 당첨 번호를 입력받는다. 번호는 쉼표(,)를 기준으로 구분한다.
  - inputLottoNumber 메소드
    - 문자열을 입력받는다.
    - 입력받은 문자열을 쉼표(,) 기준으로 구분한 문자열배열로 저장한 뒤, `createLotto`메소드를 호출하여 로또를 생성한다.
    - 예외가 발생할 시 `IllegalArgumentException`과 함께 에러메시지를 출력한다.
  - createLotto 메소드
    - `inputLottonumber`메소드에서 생성된 문자열배열에서 순서대로 정수로 변환하여 lottoList에 저장한다.
    - lottoList를 오름차순으로 정렬시킨 뒤 해당 리스트의 유효성을 검사하기 위해 `checkValidityOfLotto`메소드를 호출한다.
    - 예외가 발생할 시 `IllegalArgumentException`를 발생시킨다.
  - checkValidityOfLotto 메소드
    - 로또 리스트의 길이가 6인지 확인한다.
    - 로또 리스트가 오름차순으로 정렬되어 있기 때문에, 인접한 두 값이 같은지 확인하여 중복된 값이 있는지 판별한다.
    - 예외가 발생할 시 `IllegalArgumentException`를 발생시킨다.

- 보너스 번호를 입력 받는다.
  - inputBonusNumber 메소드
    - 문자열을 입력받는다.
    - 입력된 값을 정수로 변환한다.
    - `checkBonusNumber`메소드를 호출하여 입력된 정수가 적합한지 확인한다.
    - 예외가 발생할 시 `IllegalArgumentException`과 함께 에러메시지를 출력한다.
  - checkBonusNumber 메소드
    - 입력받은 정수가 `inputLottoNumber`에서 생성된 로또의 값들과 중복되지 않는지 확인한다.
    - 예외가 발생할 시 `IllegalArgumentException`를 발생시킨다.
---
