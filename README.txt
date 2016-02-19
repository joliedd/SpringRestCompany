# README FILE 

The application is a small management service for a Company data. Rest service is developed with Spring and for Client there is a Jquery client and a Spring test class. You can add, edit, delete a company , add a dummy company and also view all companies.

For example, using cURL, you can test the SpringRestCompany API with the following commands:

- Add/Get dummy company:
curl -i -X GET http://localhost:8080/SpringRestCompany/rest/comp/dummy

- Get all companies returned as default content type:
curl -i -X GET http://localhost:8080/SpringRestCompany/rest/comps

- Get all companies returned as xml:
curl -i -X GET http://localhost:8080/SpringRestCompany/rest/comps -H 'Accept:application/xml'

- Get company #1:
curl -i -X GET http://localhost:8080/SpringRestCompany/rest/comp/1

- Delete comp #5:
curl -i -X DELETE http://localhost:8080/SpringRestCompany/rest/comp/delete/5

- Add a new company:
curl -i -X POST -H 'Content-Type: application/json' -d '{"name": "New Company", "address": "str Highway"}' http://localhost:8080/SpringRestCompany/rest/comp/create

- Modify Company #2:
curl -i -X PUT -H 'Content-Type: application/json' -d '{"id": "2", "name": "New Cpmpany", "address": "str Highway"}' http://localhost:8080/SpringRestCompany/rest/comp/update/2