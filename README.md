Traccia Esercizio RPG CRUD System
Obiettivo

Creare un sistema CRUD per un gioco di ruolo con funzionalità base ed avanzate.
Struttura Database Base

Characters (Relazione 1:N con Inventory)
SQL
- id (PK)
- name
- level
- class (guerriero, mago, arciere, etc.)
- experience
- health
- mana
- created_at
- updated_at


  CharacterStats (Relazione 1:1 con Character)
  SQL
- character_id (PK, FK)
- strength
- dexterity
- intelligence
- wisdom
- charisma
- constitution
- updated_at


  Inventory (Relazione N:1 con Character)
  SQL
- id (PK)
- character_id (FK)
- item_id (FK)
- quantity
- slot_position
  ￼- is_equipped


  Items (Relazione N:N con Characters attraverso Inventory)
  SQL
- id (PK)
- name
- type (weapon, armor, potion, etc.)
- rarity
- level_requirement
- description
- base_stats (JSON/Object con statistiche)
  Operazioni CRUD Base da Implementare
  Characters
  CREATE: Creazione nuovo personaggio
  READ: Visualizzazione dettagli personaggio
  UPDATE: Modifica statistiche/livello personaggio
  DELETE: Eliminazione personaggio
  Inventory
  CREATE: Aggiungere item all'inventario
  READ: Visualizzare inventario
  UPDATE: Modificare quantità/posizione items
  DELETE: Rimuovere items dall'inventario
  Items
  CREATE: Creare nuovo item
  READ: Visualizzare dettagli item
  UPDATE: Modificare statistiche item
  DELETE: Eliminare item dal sistema
  Funzionalità Extra da Implementare
  Sistema di Livelli
  Calcolo esperienza
  Level up automatico
  Aggiornamento statistiche al level up


  Sistema di Equipaggiamento
  ￼Equip/Unequip items
  Verifica requisiti di livello
  Calcolo statistiche totali con equipment
  Sistema di Inventario Avanzato
  Gestione slot inventario
  Stack di items
  Sorting e filtri


  API Endpoints da Creare
  Characters
  GET    /api/characters
  GET    /api/characters/{id}
  POST   /api/characters
  PUT    /api/characters/{id}
  DELETE /api/characters/{id}
  Inventory
  GET    /api/characters/{id}/inventory
  POST   /api/characters/{id}/inventory
  PUT    /api/characters/{id}/inventory/{itemId}
  DELETE /api/characters/{id}/inventory/{itemId}
  Items
  GET    /api/items
  GET    /api/items/{id}
  POST   /api/items
  PUT    /api/items/{id}
  DELETE /api/items/{id}
  Endpoints Funzionalità Extra
  POST   /api/characters/{id}/levelup
  POST   /api/characters/{id}/equip/{itemId}
  POST   /api/characters/{id}/unequip/{itemId}
  GET    /api/characters/{id}/stats/total
  Validazioni da Implementare
  Characters
  ￼Nome univoco
  Classe valida
  Livello tra 1 e 100
  Statistiche base non negative
  Items
  Nome univoco
  Tipo valido
  Requisiti di livello validi
  Statistiche non negative
  Inventory
  Slot validi
  Quantità positive
  Verifica spazio disponibile
  Richieste Tecniche
  Implementare gestione errori appropriata
  Aggiungere validazioni input
  Implementare paginazione per le liste
  Aggiungere sorting e filtering base
  Documentare le API
  Bonus (Opzionali)
  Aggiungere sistema di ricerca
  Implementare caching
  Aggiungere logging delle operazioni
  Implementare soft delete
  Aggiungere sistema di versioning per gli items
  Parte 2 (Opzionale per Dopo)
  Sistema di combattimento
  Sistema di missioni
  Middleware per controlli avanzati
  Interceptor per logging e statistiche
  Sistema di achievement
  ￼Concentrati prima sulla parte CRUD e assicurati che tutte le operazioni base funzionino correttamente. La Parte 2 può essere implementata successivamente come estensione del sistema.
