# userprofileservice
Springboot microservice for user profile

Multiple instances of the same service can be made running
mvn clean install will create a executeable jar file

mvn spring-boot:run

     java -jar target/userprofile-service-1.0.0.jar 8084
	 
User Profile Microservice is registered in Eureka Server, so that other services can discover it on the cloud without the hostname and port number

#CRUD Operations
# Add User
{
    "id": 4,
    "userName": "panp",
    "password": "password",
    "firstName": "Peter",
    "lastName": "Pan",
    "street1": "28 CLAYTON ROAD",
    "street2": "",
    "city": "CLAYTON",
    "state": "VIC",
    "postcode": "3210",
    "country": "AUSTRALIA",
    "phone": "0416182831",
    "email": "peterpan@gmail.com",
    "active": 1,
    "roles": [
        {
            "userId": 4
        }
    ],
    "groups": [
        {
            "id": 3,
            "userId": 4,
            "groupId": 1
        }
    ],
    "organizations": [
        {
            "id": 3,
            "userId": 4,
            "organizationId": 3
        }
    ]
}
# Delete User
# Edit User
{
    "id": 3,
    "userName": "wangd",
    "password": "password",
    "firstName": "Denny",
    "lastName": "Wang",
    "street1": "29 HOLLOWAY STREET",
    "street2": "",
    "city": "ORMOND",
    "state": "VIC",
    "postcode": "3204",
    "country": "AUSTRALIA",
    "phone": "0416182855",
    "email": "dennywang@gmail.com",
    "active": 1,
    "roles": [
        {
            "id": 3,
            "userId": 3,
            "roleId": 1
        }
    ],
    "groups": [
        {
            "id": 3,
            "userId": 3,
            "groupId": 1
        }
    ],
    "organizations": [
        {
            "id": 3,
            "userId": 3,
            "organizationId": 3
        }
    ]
}
# Select User
# Select All Users
