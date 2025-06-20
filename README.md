# TetriKotlin

Un juego clásico de Tetris desarrollado para Android con una interfaz moderna y flujo de navegación completo.

## 📱 Características Principales

### 🎮 Juego Tetris Clásico
- Juego de Tetris tradicional con todas las piezas clásicas (I, O, T, S, Z, J, L)
- Sistema de rotación y movimiento fluido
- Eliminación automática de líneas completas
- Incremento progresivo de velocidad por nivel
- Sistema de puntaje basado en líneas eliminadas

### 🎯 Sistema de Navegación
- **Menú Principal**: Pantalla de inicio con opciones claras
- **Pantalla de Juego**: Interfaz de juego optimizada para móviles
- **Game Over**: Pantalla de fin de juego con puntaje final
- **Puntaje Máximo**: Visualización del récord personal

### 🕹️ Controles Intuitivos
- **Mover Izquierda/Derecha**: Botones laterales
- **Rotar**: Botón de rotación para cambiar orientación de piezas
- **Caída Rápida**: Botón para acelerar la caída de piezas
- **Caída Suave**: Las piezas caen automáticamente según el nivel

### 💾 Persistencia de Datos
- Guardado automático del puntaje máximo
- El récord se mantiene entre sesiones de juego

## 🚀 Instalación

### Opción 1: Instalar APK Pre-compilado

Si tienes un APK ya compilado:

1. **Habilitar instalación de fuentes desconocidas** en tu dispositivo Android:
   - Ve a `Configuración > Seguridad > Fuentes desconocidas`
   - Activa la opción para permitir instalación de APKs

2. **Transferir e instalar el APK**:
   - Copia el archivo `app-debug.apk` a tu dispositivo
   - Toca el archivo para instalarlo
   - Sigue las instrucciones en pantalla

### Opción 2: Instalación via ADB (Recomendada para desarrolladores)

#### Requisitos Previos
- Android SDK instalado
- ADB configurado en el PATH del sistema
- Dispositivo Android con depuración USB habilitada

#### Pasos de Instalación

1. **Habilitar Depuración USB** en tu dispositivo:
   ```
   Configuración > Opciones de desarrollador > Depuración USB
   ```
   Si no ves "Opciones de desarrollador":
   ```
   Configuración > Acerca del teléfono > Tocar "Número de compilación" 7 veces
   ```

2. **Conectar dispositivo**:
   - Conecta tu dispositivo Android por USB o WiFi
   - Verifica la conexión:
   ```bash
   adb devices
   ```

3. **Compilar el proyecto** (si es necesario):
   ```bash
   ./gradlew assembleDebug
   ```

4. **Instalar la aplicación**:
   ```bash
   adb install app/build/outputs/apk/debug/app-debug.apk
   ```

5. **Si hay una versión anterior instalada**:
   ```bash
   adb uninstall com.example.tetrisgame
   adb install app/build/outputs/apk/debug/app-debug.apk
   ```

## 🛠️ Desarrollo

### Estructura del Proyecto

```
app/src/main/java/com/example/tetrisgame/
├── MainActivity.kt          # Actividad principal del juego
├── MenuActivity.kt          # Menú principal
├── GameOverActivity.kt      # Pantalla de fin de juego
├── HighScoreActivity.kt     # Pantalla de puntaje máximo
├── CanvasView.kt           # Vista de renderizado del juego
├── Tetromino.kt            # Lógica de las piezas
├── TetrominoGhost.kt       # Pieza fantasma (preview)
├── Level.kt                # Sistema de niveles
├── Falling.kt              # Lógica de caída de piezas
├── MoveLeft.kt             # Control de movimiento izquierda
├── MoveRight.kt            # Control de movimiento derecha
└── Rotate.kt               # Control de rotación
```
