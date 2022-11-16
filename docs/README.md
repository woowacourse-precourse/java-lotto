# 📚 기능목록

## 💭 시스템 출력 - Printer

### 안내문구

- [x] 🖥️ 로또 구매안내 - printInfoMoneyInput
- [x] 🖥️ 로또 결과 입력안내 - printInfoInputResult
- [x] 🖥️ 보너스 번호 입력 안내 - printInfoInputBonus

### 결과출력

- [x] 🖥️ 발행한 로또 출력 printLottoGroup
- [x] 🖥️ 로또 결과 통계 출력 printTotalScore
- [x] 🖥️ 수익률 출력 printMoneyReturn

## 🕹️ 로또 프로그램 - GameManager

- [x] 🗣️ 사용자의 로또 구입금액 입력
- [x] 🗣️ 사용자의 로또 당첨번호 입력
    - [x] 당첨번호를 받는다.
    - [x] 보너스번호를 받는다.

- [x] 입력받은 값을 이용해 로또프로그램을 실행한다. - play
    - [x] 로또 결과 정보를 가지고 있다. - `Lotto`
    - [x] 주어진 금액에 대해 로또를 발행한다. - `Publisher`
    - [x] 당첨 통계를 구한다. - `Checker`
    - [x] 수익률을 구한다. - `MoneyManger`

## 💭 로또 정보 - Lotto

- [x] 로또 정보를 가지고있다.
    - [x] 6자리의 로또 정보를 가진다. - `numbers`
    - [x] 예외처리 - `validateBasicNumber`
        - [x] ⚠️ 6자리 숫자가 아니면 예외
        - [x] ⚠️ 중복된 숫자가 존재하면 예외
        - [x] ⚠️ 숫자가 1 ~ 45 사이의 숫자가 아니면 예외

## 🎲 로또 발행 - Publisher

- [x] 주어진 금액에 해당하는 로또를 발행한다. - getLottoGroup
    - [x] 예외처리 - `validateMoneyInput`
        - [x] ⚠️ 숫자가 아닌값이 존재하면 예외
        - [x] ⚠️ 1000으로 나누어떨어지지 않으면 예외
    - [x] 로또 수량을 구한다. - getLottoCount
    - [x] 로또 번호를 구한다. - getLottoNumber
        - [x] 오름차순으로 정렬한다.

## 📝 당첨 결과값 - LottoResultDto

- [x] 예외처리 - `validateMoneyInput`
    - [x] ⚠️ 당첨번호에 대한 예외 - `validateBasicNumber`
        - [x] ⚠️ 6자리 숫자가 아니면 예외
        - [x] ⚠️ 중복된 숫자가 존재하면 예외
        - [x] ⚠️ 숫자가 1 ~ 45 사이의 숫자가 아니면 예외
    - [x] ⚠️ 보너스 번호에 대한 예외 - `validateBonusNumber`
        - [x] ⚠️ 당첨번호와 중복되면 예외
        - [x] ⚠️ 숫자가 1 ~ 45 사이의 숫자가 아니면 예외

## 🔎 당첨 확인 - Checker

- [x] 사용자가 구매한 로또 번호와 당첨 번호를 비교한다.
    - [x] 1 ~ 5등 통계를 구한다. - getTotalScore
        - [x] 로또 번호들로부터 등수를 저장 - setResultScoreByLottoGroup
            - [x] 로또 번호로부터 등수를 저장 - setResultScoreByLotto
                - [x] 일치하는 번호 개수를 구한다. - getMatchedNumberCount
            - [x] 등수의 count를 올린다. - setScoreCountByPlace
            - [x] 2, 3등의 경우 보너스 번호를 포함하는지 구분한다. - setSecondOrThird
            - [x] 보너스 점수를 포함하는지 여부 확인 - isContainBonusNumber

## 💰 수익률 관리 - MoneyManger

- [x] 수익률을 구한다. - getMoneyReturn
    - [x] 수익률은 소수점 둘째자리에서 반올림한다. - getRoundPrice
    - [x] 반올림된 수익률을 구한다. - getRoundPrice

## ⚠️ 예외 처리 - Validation

- [x] `IllegalArgumentException`을 발생시킨다.
    - [x] 에러문구는 `"[ERROR]"` 로 시작한다.
    - [x] ⚠️ 로또번호에 대해 잘못된값 예외 - validateBasicNumber
    - [x] ⚠️ 보너스번호 대해 잘못된값 예외 - validateBonusNumber
    - [x] ⚠️ 입력 금액에 대해 잘못된 값 예외 - validateMoney

# 📚 참고값 목록

## 🏆 순위별 당첨금 - ResultPrice

- [x] 1등: 6개 번호 일치 / 2,000,000,000원 - `FIRST`
- [x] 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원 - `SECOND`
- [x] 3등: 5개 번호 일치 / 1,500,000원 - `THIRD`
- [x] 4등: 4개 번호 일치 / 50,000원 - `FOURTH`
- [x] 5등: 3개 번호 일치 / 5,000원 - `FIFTH`

## ⚠️ 에러메시지 - ErrorMessage

- [x] 당첨금 - ResultPrice
    - [x] 중복된 숫자 - `DUPLICATED_NUMBER`
    - [x] 1000으로 나누어 떨어지지 않음 - `NOT_DIVIDED_BY_THOUSAND`
    - [x] 1~45 범위외 숫자 - `NUMBER_OUT_OF_RANGE`
    - [x] 올바르지 않은 입력 - `INVALID_FORMAT`

## 🛠 상수값 - LottoCode

- [x] 로또번호 최소값 : 1 - `MIN_LOTTO_NUMBER`
- [x] 로또번호 최대값 : 45 - `MAX_LOTTO_NUMBER`
- [x] 로또번호 개수 : 6 - `COUNT_LOTTO_NUMBER`
- [x] 보너스 번호 개수 : 1 - `COUNT_BONUS_NUMBER`
- [x] 로또 1장 가격 : 1000 - `LOTTO_PRICE`

## 📝 실행결과 예시

```text
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
총 수익률은 62.5%입니다
```