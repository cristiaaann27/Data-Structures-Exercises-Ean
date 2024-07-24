
### Ejercicio 2: Distancia entre dos puntos en la tierra

La superficie de la tierra es curva, y la distancia no se puede
hallar utilizando la típica fórmula de distancia cartesiana. Adicionalmente,
los puntos sobre la superficie terrestre se dan en grados tanto para
la latitud como para la longitud de un punto. Como consecuencia de esto,
la distancia entre dos puntos es un poco más complicado que lo normal.

Entonces, dados $(x_1, y_1)$ y $(x_2, y_2)$, las latitudes y longitudes
de dos puntos sobre la superficie terrestre, para hallar la distancia
entre estos dos puntos en kilómetros se halla a partir de la siguiente
fórmula:

$$
\textrm{dist} = 6371.01 \times \arccos{(\sin(t_1) \times \sin(t_2) + \cos(t_1) \times \cos(t_2) \times \cos(g_1 - g_2))}
$$

Donde tenemos que $t_1$ es la conversión a radianes de la latitud $x_1$,
$t_2$ es la conversión a radianes de $x_2$, $g_1$ es la conversión a radianes
de $y_1$ y $g_2$ es la conversión a radianes de $y_2$.