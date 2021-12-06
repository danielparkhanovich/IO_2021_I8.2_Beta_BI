# IO_2021_I8.2_Beta_BI
Building Info Project

____
## Struktura danych
• Lokacja to budynek, poziom, lub pomieszczenie
• Budynek może składać się z poziomów a te z pomieszczeń
• Każda lokalizacja jest charakteryzowana przez:
   o id – unikalny identyfikator
   o name – opcjonalna nazwa lokalizacji
• Pomieszczenie dodatkowo jest charakteryzowane przez:
   o area = powierzchnia w m^2
   o cube = kubatura pomieszczenia w m^3
   o heating = poziom zużycia energii ogrzewania (float)
   o light – łączna moc oświetlenia

____
## Zasady komitowania na repo ! (info dla członków zespołu)

### Nazewnictwo
Ticket - nazwa tasku, również branchu lokalnego developera, który pracuje nad tym taskiem.
Szablon ticketu - **typ/task_ID_taskNameWithCamelCase**

typy:
 • feature - w przypadku wprowadzania nowej funkcjonalności.
 • bugfix  - w przypadku fixowania bugów.

przykładowa nazwa branchu - feature/1_addRest

### Role
• Developer - członek zespołu który pracuje nad projektem. Pracuje na branchu lokalnym, po zrobieniu tasku, puszuje go i robi **Pull Request** - skrótowo **PR**.
• Maintainer - członek zespołu odpowiedzialny za stan repozytorium. Akceptuje/odrzuca **Pull Requesty** na master, rozwiązuje ewentualne konflikty. Również jest developerem.
 
!!! Dewelopery nie mogą puszować zmian na główny branch - master. 
**UWAGA:** Aby wprowadzić swoje zmiany do kodu muszą zrobić z poziomu interfejsu graficznego GitHuba **Pull Request** swojego branchu.
Tylko Maintainer repozytorium może wprowadzać zmiany na master. !!!

Role zespołu:

**Maintainer**
  o Daniel Parkhanovich

**Developerzy:**
  o Dominik Ziębicki
  o Paweł Tomaszewski
  o Daniel Parkhanovich
  o Ivan Bilunyk
