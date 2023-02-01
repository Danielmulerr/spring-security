Summery on the meeting: for incorrect column update during settlement
- for invoice level changes on REMAINING AMOUNT
  - BIP will provide the default value matching the Invoice Amount
  - In cases of successful settlement and partial, the correct REMAINING AMOUNT will have to be provided from Payment app side
- for order level changes in failed scenarios
  - put the ORDER_AMOUNT in ORDER_REMAINING_SETTLE_AMOUNT
  - for account credit we are currently using REMAINING_AC_SETTLE_AMOUNT for this purpose
  - @ Deepak suggested to use ORDER_REMAINING_SETTLE_AMOUNT in this case as well
  - for CREDITCARD we are currently  keeping the TOTAL_CAPTURE_AMOUNT value
  - @ Deepak suggested to make the TOTAL_CAPTURE_AMOUNT zero during this scenario
- for order level changes in refund scenarios
  - keep TOTAL_CAPTURE_AMOUNT and TOTAL_REFUND_AMOUNT independent 
  - calculate the ORDER_REMAINING_SETTLE_AMOUNT as difference of (Order Amount) and (TOTAL_CAPTURE_AMOUNT)
Action point from this meeting:
  - @Deepak to provide additional scenario description on the proposed changes 
  - @Daniel to further analyze the impact of changes on the payment app logic 
  - @Deepak @Prashanth @Sachin @kamesh @Daniel to have a followup Meeting
    - discuss the impact of the proposed value changes on other services that consume the XXSCHL.XXSCHL_ORDER_PAYMENTS and XXSCHL.XXSCHL_INVOICE_SUMMARY
  - @Julie to set up the follow-up meeting 