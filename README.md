# IO_2021_I8.2_Beta_BI
Building Info Project

____
## Struktura danych
* Lokacja to budynek, poziom, lub pomieszczenie
* Budynek może składać się z poziomów a te z pomieszczeń
* Każda lokalizacja jest charakteryzowana przez:
   ** id – unikalny identyfikator
   ** name – opcjonalna nazwa lokalizacji
* Pomieszczenie dodatkowo jest charakteryzowane przez:
   ** area = powierzchnia w m^2
   ** cube = kubatura pomieszczenia w m^3
   ** heating = poziom zużycia energii ogrzewania (float)
   ** light – łączna moc oświetlenia

____
## Zasady komitowania na repo ! (info dla członków zespołu)

### Nazewnictwo
Ticket - nazwa tasku, również branchu lokalnego developera, który pracuje nad tym taskiem.
Szablon ticketu - **typ/task_ID_taskNameWithCamelCase**

typy:
 * **feature** - w przypadku wprowadzania nowej funkcjonalności.
 * **bugfix**  - w przypadku fixowania bugów.

przykładowa nazwa branchu - **feature/1_addRest**

### Role
* Developer - członek zespołu który pracuje nad projektem. Pracuje na branchu lokalnym, po zrobieniu tasku, puszuje go i robi **Pull Request** - skrótowo **PR**.
* Maintainer - członek zespołu odpowiedzialny za stan repozytorium. Akceptuje/odrzuca **Pull Requesty** na master, rozwiązuje ewentualne konflikty. Również jest developerem.
 
### !!! UWAGA: !!!
Dewelopery nie mogą puszować zmian na główny branch - master. 
Aby wprowadzić swoje zmiany do kodu muszą zrobić z poziomu interfejsu graficznego GitHuba **Pull Request** swojego branchu.
Tylko Maintainer repozytorium może wprowadzać zmiany na master (akceptować Pull Requesty).

Role zespołu:

**Maintainer**
  * Daniel Parkhanovich

**Developerzy:**
  * Dominik Ziębicki
  * Paweł Tomaszewski
  * Daniel Parkhanovich
  * Ivan Bilunyk
