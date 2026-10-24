# Parking Lot Backend

In-memory parking lot system demonstrating layered architecture and Strategy / Factory patterns. All plain Java. 0 AI aside from this Readme.

## Architecture

```
Controller → Service → Repository (in-memory)
                ↓
         Strategy + Factory
```

- **Controller** — accepts/returns DTOs; does not expose domain models
- **Service** — business rules (issue ticket, allocate slot, create bill)
- **Repository** — generic `InMemoryRepository<T>` keyed by id
- **Strategies** — slot allocation and fee calculation, selected via factories

## Domain

| Entity | Role |
|--------|------|
| `ParkingLot` | Floors, gates, allowed vehicles, strategy choices |
| `ParkingFloor` / `ParkingSlot` | Capacity; slot typed by `VehicleType` |
| `Gate` / `Operator` | Entry/exit; operator issues ticket or bill |
| `Vehicle` / `Ticket` | Vehicle identity; open stay with entry time + slot |
| `Bill` / `Payment` | Exit fee and payment record |

## Flows

**Issue ticket (entry)**  
Operator + vehicle details → validate entry gate → find/create vehicle → allocate free slot (strategy) → mark slot `TAKEN` → save ticket.

**Create bill (exit)**  
Ticket + exit operator → validate → compute fee (strategy) → save bill.  
*(Payment and freeing the slot are modeled but not fully wired in `Main` yet.)*

## Strategies

**Slot allocation** (`SlotAllocationStrategies`)  
- `RANDOM` — pick a free slot matching vehicle type (factory-backed)

**Fee calculation** (`FeeCalculationStrategies`)  
- `HOURLY` — rate × hours by vehicle type  
- `FIXED` — flat fee

Add a new strategy by implementing the interface and registering it in the factory enum.

## Run

Requires JDK 17+ (or whatever your IDE is set to). From the project root:

```bash
# IntelliJ: run src/Main.java
# Or compile and run manually:
javac -d out $(find src -name "*.java")
java -cp out Main
```

`Main` seeds sample data via `DataGenerator` (1 lot, 2 floors, 4 slots, entry/exit gates + operators), then issues tickets through `TicketController`.

## Project layout

```
src/
  Controllers/     TicketController
  Services/        TicketService, BillService, VehicleService
  Repository/      InMemoryRepository
  Models/          Domain + enums
  DTOs/            Issue ticket request/response
  Strategies/      Slot allocation & fee calculation
  DataGenerator.java
  Main.java
```
