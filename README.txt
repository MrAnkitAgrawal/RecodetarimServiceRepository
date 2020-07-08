How to Deploy:
--------------
1. Download package (jar file) https://github.com/MrAnkitAgrawal/RecodetarimServiceRepository/tree/master/Artifacts
2. Open Command Prompt and run below command (Java 8 must be configured on server)
java -jar -DSERVER_PORT=8181 -DMYSQL_HOST=localhost -DMYSQL_PORT=3306 -DSCHEMA=recodetarim_schema -DMYSQL_USER=mysqluser -DMYSQL_PASSWD=password recodetarim-service-1.0.jar
(Replace parameters with appropriate values)


How to Verify
--------------
1. Open POSTMAN
2. Verify below GET and POST Endpoints:
GET http://localhost:8181/recodetarim/forms
GET http://localhost:8181/recodetarim/formsdetay
GET http://localhost:8181/recodetarim/cari
GET http://localhost:8181/recodetarim/formsdegerlendime/{id}
GET http://localhost:8181/recodetarim/formsdegerlendime
POST http://localhost:8181/recodetarim/formsdegerlendime
{
    "formsDegerlendirmeGenel": {
        "fisNo": 2,
        "formNo": 1,
        "yururlulukTarihi": "0001-01-03",
        "revizeNoTarih": "0001-01-03",
        "adiSoyadi": "",
        "adres": "",
        "faaliyetAdresi": "",
        "kapsamAltKapsam": "",
        "kontrolor": "",
        "proje": "",
        "kontrolTarihi": "0001-01-03"
    },
    "formsDegerlendirmes": [
        {
            "formsDetayId": 8,
            "deger": "e"
        },
        {
            "formsDetayId": 12,
            "deger": "flase"
        }
    ]
}

SOURCE CODE:
------------
1. Location: https://github.com/MrAnkitAgrawal/RecodetarimServiceRepository/tree/master/recodetarim-service
2. Prerequiste:
	2.1 Configure Apache Maven 3.6.3 and Java 8
