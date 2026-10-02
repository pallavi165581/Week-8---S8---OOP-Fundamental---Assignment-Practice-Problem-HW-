# Week 8 - S8 Assignment Problems

Inheritance & runtime polymorphism — each problem has an abstract base type,
subclasses that override the calculation, and a polymorphic array processed
in one uniform loop with no type checks at processing time.

## Problems

1. `CanteenBillingCounter` — STUDENT 10% off / STAFF 5% off / GUEST +Rs 10
2. `ParkingChargeCalculator` — BIKE flat rate / CAR tiered / TRUCK min Rs 100
3. `HostelElectricityBill` — SINGLE / SHARED (split by occupants) / AC +Rs 200
4. `FestivalBonusCalculator` — FULLTIME 10% / PARTTIME 5% / INTERN fixed Rs 2000
5. `StreamingPlanRenewal` — plan validity days via `LocalDate.plusDays()`

## Run

Each program reads from stdin:

```bash
javac *.java
printf "3\nSTUDENT 200\nSTAFF 300\nGUEST 150\n" | java CanteenBillingCounter
```
