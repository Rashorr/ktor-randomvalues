# Ktor-Project: RandomValues
In this project, an HTTP API was developed that can generate random values such as random strings, numbers, and UUIDs.

# Getting Started
This section provides a short introduction 
and shows which steps are necessary to run the project locally in order to start a test query.

# Install the Project
To clone and run this application, you'll need to install Git [Git](https://git-scm.com)

```bash
# Clone this repository
$ git clone https://github.com/Rashorr/ktor-randomvalues
```
# Perform an initial get request
Open the Project in IntelliJ.
Set the host and port in the application.kt as desired. Then start the application.kt

Open Postman or your Browser and perform a get request to the following URL: 

http://localhost:{yourPort}/?r1=10&r2=20

This request generates a random number from the range 10 to 20

```json
[
  {
    "randNumb": 10
  }
]
```

# Parameters for get requests

Get Random Numbers

| Parameter        | Type           | Description  |
| ------------- |:-------------:| -----:|
| r1      | Integer | Specify the first range for the Number |
| r2     | Integer      |   Specify the second range for the Number |
| value | Integer     |    Set how many Numbers should be generated. If this parameter is omitted, 1 is used as the default value. |

The full request to generate a random number can look like this: 

http://localhost:8080/?r1=10&r2=20

Get Random Strings

| Parameter        | Type           | Description  |
| ------------- |:-------------:| -----:|
| length      | Integer | Specify the length of the string |
| charset     | String      |   Specify the charset of the string |
| value | Integer     |    Set how many strings should be generated. If this parameter is omitted, 1 is used as the default value. |

The full request to generate a random string can look like this:

http://localhost:8080/?length=10&charset=sdkjhfskjfhsdfkjh&value=4

Get Random UUIDs

| Parameter        | Type           | Description  |
| ------------- |:-------------:| -----:|
| value | Integer     |    Set how many UUIDs should be generated. If this parameter is omitted, 1 is used as the default value. |

The full request to generate a random UUID can look like this:

http://localhost:8080/?value=10

# How to use this API for your own backend

In this example, a Ktor client is used to use the API. 
A detailed description of the setup of a ktor client can be found here: [Ktor-Client](https://ktor.io/docs/getting-started-ktor-client.html)

Create a client within the Main.kt file:
```kotlin
suspend fun main() {
    val client = HttpClient(CIO){
    install(ContentNegotiation){
      json()
    }
  }
}
```
To make a request to a specific API URL, we can call a get method. A response will be received as a HttpResponse class object.

```kotlin
suspend fun main() {
    val client = HttpClient(CIO){
    install(ContentNegotiation){
      json()
    }
  }
val response: HttpResponse = client.get("http://localhost:8080/UUID?value=10")
println(response.bodyAsText())
}
```
The code above makes a get request to generate 10 random UUIDs, the response is displayed in the console. For this test request to run, the server must be running at the appropiate URL.
