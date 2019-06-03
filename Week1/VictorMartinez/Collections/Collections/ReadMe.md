# COLLECTIONS: Composición del proyecto.

#### Se muestran tres archivos; ArrayList_LinkedList y HashTables dónde se hacen las comparaciones de rendimiento correspondientes.
#### La carpeta LIST sólo guarda un primer intento del ejercicio y por consiguiente se puede ignorar.

## ArrayList vs LinkedList : Conclusiones
		- Agregando Datos. El LinkedList es súper eficiente agregando datos. En promedio resultaba 6 o 7 veces más rápido que el ArrayList.

		- Insertando Datos. El ArrayList resultó más rápido insertando datos, llegando a requerir casi que un 10% menos del tiempo-.

		- Quitando Datos. El ArrayList removió el dato central más rápido. Esto debido a que la disposición de los datos lineal le favorece más al ArrayList quién dispusiera los datos de manera cercana, contraria a las referencias del LinkedList.

		- Iterando A través de la Colección. ArrayList mostró que resulta más potente a la hora de recorrer los datos.

		- Ordenando los datos. ArrayList mostró ser superior organizando los datos. Sin embargo, a medida que los objetos se vuelven complejos, los tiempos tienden a ser parecidos.


## HashMap vs TreeMap  :  Conclusiones
		- Agregando un elemento. El TreeMap resultó tres veces más rápido al agregar un elemento que el método mostrado por el HashMap.

		- Encontrando un elemento. El TreeMap mostró la fortaleza buscando un elemento por su nombreClave. Sin embargo hay que tener en cuenta la complejidad del objeto. Este puede disminuir su desempeño.

		- Iterar a través de la Colección. EL HashMap mostró tener una ventaja respecto al TreeMap consistiendo en la forma en la que se recorren sus elementos almacenados. 

		- Remover un elemento. El treeMap resultó menos eficiente a la hora de eliminar un dato. Esto debido a que la búsqueda del dato resulta más compleja que cuando se realiza con un HashMap.



### Aditional : HackerRank - Ransom Note

###### Se muestran dos soluciones al ejercicio de HackerRank, dónde se utiliza HashMap y otra solución básica. 
	
