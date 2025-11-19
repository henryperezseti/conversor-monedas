# 🪙 Conversor de Monedas en Java  

Un proyecto en Java que permite convertir entre diferentes monedas utilizando la API de ExchangeRate-API.  
Incluye un menú interactivo en consola, historial de conversiones y soporte para múltiples monedas.

---

## 📌 Características principales

✔ Conversión entre las siguientes monedas:  
- USD ⇄ ARS  
- USD ⇄ BRL  
- USD ⇄ COP  

✔ Integración con **ExchangeRate-API**  
✔ Historial de conversiones dentro de la aplicación  
✔ Registro con **fecha y hora** usando `java.time`  
✔ Manejo de errores en solicitudes HTTP  
✔ Código organizado usando un servicio (`HistorialService`)  

---

## 🛠 Tecnologías utilizadas

- **Java 17+**
- `HttpClient` (Java estándar)
- **Gson** para parsear JSON
- API pública: **https://www.exchangerate-api.com/**
- Patrón de registro con `LocalDateTime`

---

## 📂 Estructura del proyecto

src/
│
├── ConversorApp.java // Menú principal y flujo de la aplicación
├── ConsultaMoneda.java // Cliente HTTP que consulta la API
├── Moneda.java // Record que representa la respuesta JSON
└── HistorialService.java // Manejo del historial de conversiones

yaml
Copiar código

---

## ▶️ Ejecución del Programa

Ejecuta el archivo principal:

java ConversorApp

yaml
Copiar código

Verás un menú como:

Sea bienvenido/a al Conversor de Moneda =]

Dólar ==> Peso argentino

Peso argentino ==> Dólar

Dólar ==> Real brasileño

Real brasileño ==> Dólar

Dólar ==> Peso colombiano

Peso colombiano ==> Dólar

Ver historial

Salir

Elija una opción válida:

yaml
Copiar código

---

## 🔄 Ejemplo de conversión

Si eliges la opción **1 (USD → ARS)** y colocas un monto, verás:

El valor 50.0 [USD] corresponde al valor final de >>> 43900.0 [ARS]

yaml
Copiar código

🔥 Además, se guarda automáticamente en el historial:

2025-02-15 14:33:10 | 50.0 USD => 43900.0 ARS

yaml
Copiar código

---

## 📜 Historial de conversiones

Selecciona la opción **7** del menú:

************* HISTORIAL DE CONVERSIONES *************
2025-02-15 14:33:10 | 50.0 USD => 43900.0 ARS
2025-02-15 14:35:22 | 100.0 BRL => 18.51 USD

nginx
Copiar código

Si no hay registros:

Aún no has realizado ninguna conversión.

yaml
Copiar código

---

## 🔧 Configuración

### 1. Inserta tu **API KEY** en `ConsultaMoneda.java`:

```java
private static final String API_KEY = "TU_API_KEY_AQUI";
Obtén una gratis en:
👉 https://www.exchangerate-api.com/

🧩 Archivos principales
✔ ConsultaMoneda.java
Se encarga de llamar la API, recibir el JSON y convertirlo a un objeto Moneda.

✔ Moneda.java
Record que representa la estructura JSON:

java
Copiar código
public record Moneda(
    String base_code,
    String target_code,
    double conversion_rate,
    Double conversion_result
) {}
✔ HistorialService.java
Maneja el registro de todas las conversiones realizadas.

✔ ConversorApp.java
Controla el menú, la lógica y la interacción con el usuario.


