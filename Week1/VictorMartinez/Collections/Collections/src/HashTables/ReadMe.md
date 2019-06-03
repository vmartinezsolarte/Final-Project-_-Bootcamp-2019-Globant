# Resultados : HashMap vs TreeMap

#### Se enlistan los Tiempos con los que se compararon las tareas realizadas. Se recuerda una vez más que se utilizaron Integer, String, auxObject como estructuras de datos en este ejercicio.

|AddingElement |FindElement| 
| ----- |  -------|
|Integer : HashMap and TreeMap |Integer : HashMap and TreeMap |
|Time Integer HashMap : 19 us    |Time Integer HashMap : 75 us|
|Time Integer TreeMap : 6 us     |Time Integer TreeMap : 56 us|
|       ------                   |  ---                      |  
|String : HashMap and TreeMap   |String : HashMap and TreeMap|
|Time String HashMap : 14 us    |Time String HashMap : 16 us|
|Time String TreeMap : 4 us     |Time String TreeMap : 8 us|
|       -----                   |           ---  |
|Object : HashMap and TreeMap   |Object : HashMap and TreeMap|
|Time Object HashMap : 20 us    |Time Object HashMap : 10 us|
|Time Object TreeMap : 7 us     |Time Object TreeMap : 16 us|
|          ---                  |     ---  | 
|End Test                       |End Test|
|     ----- |  -------|



|IterateThroughCollection |RemoveElement |
|----- |  -------|
|Integer : HashMap and TreeMap   |Integer : HashMap and TreeMap|
|Time Integer HashMap : 248 ms   |Time Integer HashMap : 33 us|
|Time Integer TreeMap : 261 ms   |Time Integer TreeMap : 117 us|
|   ------    |    ----    |
|String : HashMap and TreeMap    |String : HashMap and TreeMap|
|Time String HashMap : 47  ms    |Time String HashMap : 13 us|
|Time String TreeMap : 29  ms    |Time String TreeMap : 17 us|
|       --------  |   -----        |
|Object : HashMap and TreeMap    |Object : HashMap and TreeMap|
|Time Object HashMap : 282 ms    |Time Object HashMap : 14 us|
|Time Object TreeMap : 336 ms    |Time Object TreeMap : 83 us|
|      -------                   |    ----- |
|End Test                        | End Test |


