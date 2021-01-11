# FICmail

Proxecto obxectivo da práctica de validación automática: sistema de correo electrónico

## Descrición do sistema

Estamos ante un simplificado sistema de correo electrónico que se quere poñer en produción. Como responsable de tomar a decisión sobre se a implementación está lista, debes validar a lóxica proporcionada.

Non dispós de documentación técnica algunha, alén da descrición dos requisitos funcionais de alto nivel que se reflectiron de xeito pouco formal ao principio do proxecto. Esa especificación indica o seguinte:

* O sistema debe permitir manexar o correo electrónico dunha persoa, así como un conxunto de servizos de arquivado de correo, de xeito que sexa posible explorar, ler e arquivar correos electrónicos, realizar procuras neles e xestionar os arquivadores de
correo.
* Un correo electrónico (`Mensaje`) debe ser un arquivo de texto plano (`Texto`) cunha marca de lectura, marca que debe ser editable (debe poderse marcar un correo electrónico como lido ou non lido segundo se queira). Os correos electrónicos poderán organizarse en carpetas, que á súa vez poderán estar contidas noutras carpetas.
* As mensaxes poden levar cabeceiras asociadas, isto é, pares nome/valor (como por exemplo "`Asunto`"/"`Ola`" ou "`Destinatario`"/"`persoa@udc.es`"). Loxicamente, a presencia de cabeceiras afecta tanto ao tamaño como ao aspecto da mensaxe á que acompañan.
* As mensaxes poden tamén levar un ou varios arquivos adxuntos, afectando a súa presencia tanto ao tamaño como ao aspecto da mensaxe á que acompañan. De feito, debe poder ser posible empregar mensaxes completas como anexos (reenvíos).
* A operación de procura consultará o contido dos correos electrónicos. As procuras realizadas sobre carpetas funcionarán recursivamente, e o resultado consistirá nas mensaxes para as que o seu contido (arquivo asociado) responde ao criterio de procura.
* Debe implementarse a posibilidade de limitar a cantidade de resultados devoltos se o volume de resultados obtidos fose moi elevado.
* A operación de exploración só funciona sobre carpetas, mais nese caso non funcionará recursivamente.
* Un servizo de arquivado de correo (`Archivador`) debe permitir almacenar correos electrónicos sempre que o seu espazo dispoñible o faga posible. Co fin de proporcionar un servizo de arquivado de correo escalable, os arquivadores poden organizarse xerarquicamente de forma que un arquivador sobrecargado (isto é, sen espazo dispoñible) podería delegar a responsabilidade do arquivado dun correo noutro arquivador. Os servizos de arquivado tratarán carpetas e mensaxes sen distinción.
* Debe implementarse a posibilidade de que os servizos de arquivado inclúan un servizo
de log que rexistre por saída estándar información sobre as peticións recibidas

O sistema inclúe unha interface de usuario, mais o obxectivo principal non é validar esta, xa que a interface real que se usará será unha interface web proporcionada por un terceiro fabricante. Porén, podes empregala para familiarizarte co funcionamento da implementación que debes validar.

## Herramientas para la realización de tests
### CheckStyle
Se usa la herramienta [CheckStyle](https://checkstyle.sourceforge.io/) para realizar pruebas estáticas estructurales de caja blanca, analizando el código e informando de los posibles errores o mejoras para adherirse a estándares de codificación.

Para generar reports con este análisis y sus resultados (ubicados en target/site/checkstyle.html):
```
mvn checkstyle:checkstyle
```

Para realizar un análisis sin generar el report pero mostrando todos los resultados y errores (pudiendo resultar en un fallo en la build):
```
mvn checkstyle:check
```

### SpotBugs
La herramienta [SpotBugs](https://spotbugs.github.io/), con la que se podrán realizar pruebas dinámicas de caja blanca. Realiza análisis en el código para buscar posibles bugs o patrones que posiblemente sean errores.
Se han configurado también excepciones a este análisis en [spotbugs_ignore.xml](spotbugs_ignore.xml).

Para generar reports podemos usar el siguiente goal:
```
mvn spotbugs:spotbugs
```

O usar el siguiente para hacer que la build falle en caso de que encuentre algun bug:
```
mvn spotbugs:check
```

También tenemos la herramienta gráfica, que muestra los mismos resultados para el análisis:
```
mvn spotbugs:gui
```

### JETM
La herramienta [JETM](http://jetm.void.fm/), para realizar pruebas no funcionales dinámicas de caja negra, realizando análisis de rendimiento en determinadas partes del código.
Para esto se usa su librería y se añaden marcadores en partes del codigo para mostrar las estadísticas de rendimiento entre ellos.

Para poder ver los resultados se pueden ejecutar los tests que acceden a esas partes del código, y se mostrarán en el resultado, por ejemplo con:
```
mvn test
```

### PiTest
Se usa [PiTest](https://pitest.org/) para ganar confianza en la calidad de los tests, a través de pruebas de mutación sobre estos.
Para este caso se han configurado las clases y tests sobre los que nos interesa realizar estas pruebas.

De esta forma podemos usar el siguiente comando, que realizará las pruebas y mostrará los resultados obtenidos como reports en target/pit-reports/, con una carpeta por cada análisis.
```
mvn org.pitest:pitest-maven:mutationCoverage
```
