# Stratio Wars Code test

## PROBLEM
Stratio needs help, we have intercepted a list of encrypted coordinates from the death star, in
order to restablish the peace in the interplanetary system Stratio needs you to find out the targets
positions.

Our engineers have discovered the decrypt algorithm so we need you to:

- Develop the algorithm
- Develop tests
- Expose an API Rest to allow 1..n entries, define your own input and output format

## Info 

### Input 

We have a list with uuids in this format, feel free to choose the input method to your program

    galaxy   - quadrant - starsystem1 - starsystem2 - planet 
    8 digits - 4 digits - 4 digits    - 4 digits    - 12 digits

Examples:

    2952410b-0a94-446b-8bcb-448dc6e30b08
    6f9c15fa-ef51-4415-afab-36218d76c2d9
    2ab81c9b-1719-400c-a676-bdba976150eb
    21141920-0791-42f2-a753-43a4eb209370
    72c2f1e3-8bb4-4fdd-831b-80462d8b915a
    b099861d-0311-47a7-9254-9a95f9f94eba
    d562acda-0e21-41e3-b163-ea9d3c1f9408
    0384eaab-2a16-44a7-97a5-fd9566565f45
    98c01aca-46ea-44d6-8032-f072530ede5b
    9a1e227e-9bf3-4430-84a9-8d3da7d96074
    
## Decrypt function

1. Galaxy
    - Sum the HEX value of each char, output in decimal
2. Quadrant
    - Max HEX value of the stream, output in decimal
3. Star system
    - Comparation of the third and fourth group of digits, get the MAX value for each position
    - Sum the HEX value of each char of the previous comparation, output in decimal
4. Planet
    - Order descending and if exists repeated chars, only get 1 of the repeated char
    - i.e: dddaa942 > da942
    
## Output

For the example input:

    2952410b-0a94-446b-8bcb-448dc6e30b08
    6f9c15fa-ef51-4415-afab-36218d76c2d9
    2ab81c9b-1719-400c-a676-bdba976150eb

A list of coordinates with the next format:

    22-10-42-edcb86430
    73-15-46-dc9876321
    64-9-35-edba976510

# Notes

Solution provided for input

    2952410b-0a94-446b-8bcb-448dc6e30b08
    22-10-42-edcb86430

is invalid

# About the solution

The solution made is developed using the following technologies:

- Scala
- Mavevn
- Akka Http
- Scalatest
- Scalactic

To check the solution you can run the tests bundled with the solutions. The packages **ValidationTest** and **Blackbox** runs the provided example using the Rest API and just using Scala code respectively.

## Rest API Format

The program expose the following endpoints:

- [http://localhost:3000/v1/](http://localhost:3000/v1/): to check if you can reach the program API
- [http://localhost:3000/v1/decode](http://localhost:3000/v1/decode): to decode encrypted coordinates
    -  **GET**: You must made a `GET` request do this endpoint using the field values, in which you **MUST** provide the coordinates that you want to decode separated by commas.The output will be a JSON array wih the decoded solutions. Examples:
    ```
    Petition: http://localhost:3000/v1/decode?values=6f9c15fa-ef51-4415-afab-36218d76c2d9
    Response: [73-15-46-dc9876321]
    
    Petition: http://localhost:3000/v1/decode?values=6f9c15fa-ef51-4415-afab-36218d76c2d9,2ab81c9b-1719-400c-a676-bdba976150eb
    Response: [73-15-46-dc9876321,64-9-35-edba976510]
    ```
    
## How to run the tests
    
To run the all the tests inside the project just use

    mvn test
    
## Running the program

If you want to run the example you must run the class `src/main/scala/diegoreico/RestApi/WebServer.scala`. You can do that using maven

    mvn scala:run -DmainClass=diegoreico.RestApi.WebServer
    
You should see the following terminal output:

    Server online at http://127.0.0.1:3000/v1
    Press RETURN to stop...





