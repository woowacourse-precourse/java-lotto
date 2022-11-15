---

## Lotto Game


### 설명 요약

    - 로또 구입
    - 로또 당첨 내역 및 수익률 출력 후, 게임 종료


<br/>

### 기능 설계

    - Lotto (Class)
        => 로또 입력
        => 유효성 검사
        => 보너스볼 체크
 
    - LottoTickets (Class)
        => 구입한 모든 로또 
        => 결과, 수익률 반환

    - LottoResult (Class)
        => 로또 결과, 수익률 반환

    - ReferenceValue  (Class)
        => Lotto        , Enum 변수 + 기본 조건 변수
        => WinningStats , Enum 변수 + 당첨 통계 변수

    - Record  (Class)
        => EnterMessage , Enum 변수 + 입력 메시지
        => ErrorMessage , Enum 변수 + 에러 메시지
        => ResultMessage, Enum 변수 + 결과 양식 메시지
        => 당첨 통계 계산

    - Game  (Class)
        => 금액 유효성 검사
        => 당첨번호 & 보너스번호
        => 금액만큼 Lotto 입력 & 유효성 검사
        => 보너스 유효성 검사