# 🚀 P000 - Historia Conversacional

## 📖 Descripción

Proyecto desarrollado para el módulo **MP13 - Módulo DUAL** del CFGS de **Desarrollo de Aplicaciones Multiplataforma**.

El objetivo del proyecto es crear una **aventura conversacional de texto**, en la que el jugador puede desplazarse por diferentes zonas, interactuar con objetos y personajes y utilizar un inventario para avanzar en la historia.

La aventura está ambientada en el año **2120**, a bordo de la nave espacial **PiaXXII**, que viaja hacia el planeta **SUMMEM**. Después de sufrir daños en el sistema de propulsión, el capitán Bond deberá recorrer la nave, encontrar los objetos necesarios y reparar los motores para poder continuar la misión.

---

## 🎮 Objetivo del juego

El jugador deberá conseguir reparar los propulsores de la nave y regresar a la sala de mando.

Durante la aventura deberá:

* Explorar diferentes zonas de la nave.
* Recoger y dejar objetos.
* Gestionar un inventario.
* Conseguir una herramienta para reparar los motores.
* Conseguir y utilizar un traje espacial.
* Evitar o distraer a Malien.
* Reparar los propulsores.
* Regresar a la sala de mando.

---

## 🗺️ Zonas

El juego dispone de diferentes zonas conectadas entre sí, entre las cuales se encuentran:

* Dormitorio
* Baños
* Cocina
* Vestuario
* Oficinas
* Taller
* Comedor
* Sala de mando
* Sala de salida exterior
* Propulsores

Cada zona dispone de su propia descripción, objetos e interacciones.

---



## 🎒 Inventario

El jugador dispone de un inventario donde puede almacenar los objetos que encuentra durante la partida.

Los objetos se pueden:

* Recoger de una zona.
* Guardar en el inventario.
* Utilizar.
* Dejar nuevamente en otra zona.

---

## 🧰 Objetos principales

### 🔦 Linterna

La posición de la linterna puede cambiar entre partidas.

Es necesaria para poder encontrar la herramienta dentro del taller.

### 🔧 Herramienta

Se encuentra en el taller.

Permite reparar los propulsores de la nave.

### 🧑‍🚀 Traje espacial

Se encuentra en el vestuario.

Es necesario para poder acceder de forma segura al exterior de la nave.

### 🪪 Tarjeta identificadora

Permite abrir las puertas automáticas de la nave.

La tarjeta personal del capitán se encuentra escondida dentro de las oficinas.

### 🍩 Dónuts

Se encuentran en la cocina.

Sirven para distraer a Malien durante la partida.

---

## 👾 Malien

Malien es un alienígena que se mueve libremente por la nave.

Cada dos movimientos del jugador, Malien también se desplaza por la nave.

El jugador deberá evitar encontrarse con él o utilizar determinados objetos, como los dónuts, para distraerlo.

---

## 🧠 Funcionamiento general

El ciclo principal del juego sigue aproximadamente este flujo:

1. Mostrar la descripción de la zona actual.
2. Mostrar los objetos disponibles.
3. Pedir una orden al jugador.
4. Interpretar la orden.
5. Comprobar si la acción es válida.
6. Ejecutar la acción.
7. Mostrar las consecuencias de la acción.
8. Comprobar las condiciones de victoria o derrota.
9. Continuar la partida.

---

## 🏆 Condición de victoria

Para completar la aventura será necesario:

1. Conseguir los objetos necesarios.
2. Llegar hasta los propulsores.
3. Reparar los motores.
4. Regresar a la sala de mando.

---

## 💀 Condiciones de derrota

La partida puede finalizar si se producen determinadas situaciones relacionadas con Malien u otros eventos del juego.

---

## 🏗️ Estructura del proyecto

```text
src/

├── ...

├── ...

└── ...

README.md
```

> Esta sección se actualizará cuando la estructura definitiva de clases y paquetes esté definida.

---

## 🧩 Programación orientada a objetos

El proyecto está diseñado aplicando conceptos de programación orientada a objetos como:

* Clases y objetos.
* Encapsulación.
* Relaciones entre clases.
* Colecciones.
* Gestión de estados.
* Gestión de excepciones.
* Separación de responsabilidades.

---

## 👥 Autores

Proyecto realizado por:

* **Jairo Lineres**
* **Pol Ibáñez**

---

## 🎓 Contexto académico

**Proyecto:** P000 - Historia Conversacional
**Módulo:** MP13 - Módulo DUAL
**CFGS:** Desarrollo de Aplicaciones Multiplataforma
**Centro:** Escola Pia

---

## 📄 Licencia

Este proyecto ha sido desarrollado con **fines educativos y académicos**.

El código del proyecto está bajo la licencia **MIT**, lo que permite utilizar, modificar y distribuir el código siempre que se mantenga el aviso de copyright y la licencia original.

Copyright © 2026 **Jairo Lineres y Pol Ibáñez**.

Para más información, consulta el archivo `LICENSE` incluido en el repositorio.