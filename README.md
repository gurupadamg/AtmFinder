# AtmFinder


1. Get http://localhost:8080/api/v1/atms  ( get all Atms')

curl --location --request GET 'http://localhost:8080/api/v1/atms' \
--data-raw ''


2. Get                    (all Atms by city names)
 
 curl --location --request GET 'http://localhost:8080/api/v1/atms/Rijswijk (NB)' \
--data-raw ''
