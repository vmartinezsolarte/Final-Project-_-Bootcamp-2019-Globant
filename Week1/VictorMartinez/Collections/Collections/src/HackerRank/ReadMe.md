# HackerRan : Ransom Note Problem

##### Este problema se solucionó mediante HashTables (Archivo NoteMagazine_V2) y también sin éstas estructuras de datos (NoteMagazine).
##### Aunque la solución sin HashTables no aprobó todos los test anónimos de HackerRank, es muy aceptable para ser una primera aproximación a la solución.
##### La solución usando HashTable utiliza los siguientes componentes:
                  - Un HashTable y un cinclo para agregar las palabras del Magazine ("Keys") y el número de veces que se repite ("Value").
                  - Un ciclo para contrastar las palabras del Note contra ésta HashTable, y verificar si existe la palabra o que está disponible n veces.
                  - Un condicional para imprimir si es posible la reproducción de la nota.


####Casos De prueba:
		
			1) Magazine :"give me one grand today night", note:"give one grand today", Answer = "Yes"
			2) Magazine: "two times three is not four", note:"two times two is four", Answer = "No"
			3) Magazine: "ive got a lovely bunch of coconuts", note:"ive got some coconuts", Answer="No"