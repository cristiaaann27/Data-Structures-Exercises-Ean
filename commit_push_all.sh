#!/bin/bash

# Directorio principal
MAIN_DIR="C:\Users\cnust\Downloads\Talleres_Estructura"

# Cambia al directorio principal
cd "$MAIN_DIR" || exit

# Itera sobre cada subdirectorio
for TALLER in */; do
    # Quita la barra final del nombre del directorio
    TALLER_NAME="${TALLER%/}"

    # Cambia al directorio del taller
    cd "$TALLER_NAME" || exit

    # Añade todos los archivos
    git add .

    # Realiza el commit
    git commit -m "add $TALLER_NAME"

    # Envía los cambios al repositorio remoto
    git push -u origin main

    # Regresa al directorio principal
    cd ..

done
