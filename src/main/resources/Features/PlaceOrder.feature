Feature: PlaceOrder Functionality

Scenario Outline:  place order test cases with different data providers
  Given user is on Place Order page
  When user enters place order data "<name>" "<country>" "<city>" "<card>" "<month>" "<year>"
  And clicks Purchase
  Then a place order message should be displayed accourding to "<Input>"
Examples:
| name        | country | city  | card            | month | year |Input|
| Nasser Ali  | Egypt   | Cairo | 5162659515495   | 05    | 2025 |   Valid data  |
|             |         |       |                 |       |      |     All empty |
| 111111      | 54848   | 8878  | mkkjgtfrf       | mnjnj  | kjjj | Invalid formats |
| nasser      |         |       | 5162659515495   |       |      |Some fields missing  |
