# Challenge de MercadoLibre

_Esta app expone una API REST para calcular la posicion de una Spaceship con respecto a dos o más satelites mediante trilateracion, y desencripta el mensaje emitido por los satelites_

## 🛠️

* [Java 11](https://www.oracle.com/ar/java/technologies/javase-jdk11-downloads.html)  
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Spring](https://spring.io/) - Framework
* [H2](https://www.h2database.com/html/main.html) - Base de Datos

## Insomnia/Postman proyect 🚀

En esta ubicación se podrá encontrar el archivo .JSON que se podrá importar en INSOMNIA y POSTMAN para probar la API

```
https://github.com/SebastianVelo/FuegoDeQuasar-api/blob/main/src/main/resources/fuegodequasar.json
```

## API 🚀

### USER

**PUT**

* **POST**

```
https://fuegodequasar-ml.herokuapp.com/topsecret/
```
```
{
	"satellites": [
		{
			"name": "kenobi",
			"distance": 1200.0,
			"message":[
					"este",
					"",
					"",
					"mensaje",
					""
				]
		},
		{
			"name": "skywalker",
			"distance": 125,
			"message": [
					"",
					"es",
					"",
					"",
					"secreto"
				]
		},
		{
			"name": "sato",
			"distance": 142.8,
			"message":[
					"",
					"",
					"un",
					"",
					""
				]
		}
	]
}
```
