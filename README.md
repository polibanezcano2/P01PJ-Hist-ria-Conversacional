# 🚀 P000 - Història Conversacional

## 📖 Descripció

Projecte desenvolupat per al mòdul MP13 - Mòdul DUAL del CFGS de Desenvolupament d'Aplicacions Multiplataforma.

L'objectiu del projecte és crear una **aventura conversacional de text**, en la qual el jugador pot desplaçar-se per diferents zones, interactuar amb objectes i personatges i utilitzar un inventari per avançar en la història.

L'aventura està ambientada l'any **2120**, a bord de la nau espacial **PiaXXII**, que viatja cap al planeta SUMMEM. Després de patir danys en el sistema de propulsió, el capità Bond haurà de recórrer la nau, trobar els objectes necessaris i reparar els motors per poder continuar la missió.

---

## 🎮 Objectiu del joc

El jugador haurà d'aconseguir reparar els propulsors de la nau i tornar a la sala de comandament.

Durant l'aventura haurà de:

- Explorar diferents zones de la nau.
- Obrir portes.
- Agafar i deixar objectes.
- Gestionar un inventari.
- Parlar amb iHall.
- Trobar una llanterna.
- Aconseguir una eina per reparar els motors.
- Aconseguir i utilitzar un vestit espacial.
- Evitar o distreure en Malien.
- Reparar els propulsors.
- Tornar a la sala de comandament.

---

## 🗺️ Zones

El joc disposa de diferents zones connectades entre si, entre les quals hi ha:

- Dormitori
- Banys
- Cuina
- Vestuari
- Oficines
- Taller
- Menjador
- Sala de comandament
- Sala de sortida exterior
- Propulsors

Cada zona disposa de la seva pròpia descripció, objectes i interaccions.

---

## ⌨️ Comandes disponibles

El joc interpreta diferents ordres introduïdes pel jugador.

```text
ANAR
AGAFAR
DEIXAR
USAR
ENCENDRE
APAGAR
OBRIR
TANCAR
PARLAR
```

Exemples:

```text
ANAR CUINA
AGAFAR DONUTS
ENCENDRE LLANTERNA
OBRIR PORTA
USAR EINA
PARLAR IHALL
```

---

## 🎒 Inventari

El jugador disposa d'un inventari on pot emmagatzemar els objectes que troba durant la partida.

Els objectes es poden:

- Agafar d'una zona.
- Guardar a l'inventari.
- Utilitzar.
- Deixar novament en una altra zona.

---

## 🧰 Objectes principals

### 🔦 Llanterna

La seva posició canvia entre partides.

iHall coneix la seva ubicació, encara que no sempre proporciona informació correcta.

És necessària per poder trobar l'eina dins del taller.

### 🔧 Eina

Es troba al taller.

Permet reparar els propulsors de la nau.

### 🧑‍🚀 Vestit espacial

Es troba al vestuari.

És necessari per poder accedir de manera segura a l'exterior de la nau.

### 🪪 Targeta identificadora

Permet obrir les portes automàtiques de la nau.

La targeta personal del capità es troba amagada dins de les oficines.

### 🍩 Dònuts

Es troben a la cuina.

Serveixen per distreure en Malien durant la partida.

---

## 👾 Malien

En Malien és un alien que es mou lliurement per la nau.

Cada dos moviments del jugador, en Malien també es desplaça per la nau.

El jugador haurà d'evitar trobar-se amb ell o utilitzar determinats objectes per distreure'l.

---

## 🤖 iHall

iHall és l'ordinador de la nau.

El jugador pot interactuar amb ell mitjançant la comanda:

```text
PARLAR IHALL
```

Pot proporcionar informació sobre:

- La posició de determinats objectes.
- La ubicació d'en Malien.
- Les portes de la nau.

Tot i això, algunes de les seves respostes poden ser incorrectes.

---

## 🧠 Funcionament general

El cicle principal del joc segueix aproximadament aquest flux:

1. Mostrar la descripció de la zona actual.
2. Mostrar els objectes disponibles.
3. Demanar una ordre al jugador.
4. Interpretar l'ordre.
5. Comprovar si l'acció és vàlida.
6. Executar l'acció.
7. Mostrar les conseqüències de l'acció.
8. Comprovar les condicions de victòria o derrota.
9. Continuar la partida.

---

## 🏆 Condició de victòria

Per completar l'aventura serà necessari:

1. Aconseguir els objectes necessaris.
2. Arribar fins als propulsors.
3. Reparar els motors.
4. Tornar a la sala de comandament.

---

## 💀 Condicions de derrota

La partida pot finalitzar si es produeixen determinades situacions relacionades amb en Malien o altres esdeveniments del joc.

---

## 🏗️ Estructura del projecte

```text
src/
├── ...
├── ...
└── ...

README.md
```

> Aquesta secció s'actualitzarà quan l'estructura definitiva de classes i paquets estigui definida.

---

## 🧩 Programació orientada a objectes

El projecte està dissenyat aplicant conceptes de programació orientada a objectes com:

- Classes i objectes
- Encapsulació
- Relacions entre classes
- Col·leccions
- Gestió d'estats
- Gestió d'excepcions
- Separació de responsabilitats

---

## 👥 Autors

Projecte realitzat per:

- Nom Alumne 1
- Nom Alumne 2

---

## 🎓 Context acadèmic

**Projecte:** P000 - Història Conversacional  
**Mòdul:** MP13 - Mòdul DUAL  
**CFGS:** Desenvolupament d'Aplicacions Multiplataforma
**Centre:** Escola Pia
readme.md s'està mostran