How to Deploy:
--------------
1. Download package (jar file) https://github.com/MrAnkitAgrawal/RecodetarimServiceRepository/tree/master/Artifacts
2. Open Command Prompt and run below command (Java 8 must be configured on server)
java -jar -DSERVER_PORT=8181 -DMYSQL_HOST=localhost -DMYSQL_PORT=3306 -DSCHEMA=recodetarim_schema -DMYSQL_USER=mysqluser -DMYSQL_PASSWD=password recodetarim-service-1.0.jar
(Replace parameters with appropriate values)

Login Implementation:
---------------------
Request:
---------
POST http://localhost:8181/recodetarim/user
{
    "kod": "PKT",
    "sifre": "1234"
}

Response:
---------
Success:
200 OK
{
    "kod": "PKT",
    "ad": "PAKETLEME",
    "soyad": "DEPARTMANI"
}

Failure:
401 Unauthorized

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

Request:
--------
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
            "formsDetayId": 5,
            "deger": "t"
        },
        {
            "formsDetayId": 12,
            "deger": "true"
        }
    ],
    "signature": "<base64 encoded string>",
    "formsDegerlendirmeImzas": [
        {
            "imageId": "ImageName",
            "image": "<base64 encoded string>"
        },
        {
           "imageId": "ImageName",
           "image": "<base64 encoded string>"
        }
    ]
}

Response:
---------
{
    "formsDegerlendirmeGenel": {
        "id": 43,
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
            "id": 73,
            "formsDetayId": 5,
            "deger": "t",
            "genelId": 43
        },
        {
            "id": 74,
            "formsDetayId": 12,
            "deger": "true",
            "genelId": 43
        }
    ],
    "signature": "<base64 encoded string>",
    "formsDegerlendirmeImzas": [
        {
            "imageId": "ImageName",
            "image": "<base64 encoded string>"
        },
        {
            "imageId": "ImageName",
            "image": "<base64 encoded string>"
        }
    ]
}

SOURCE CODE:
------------
1. Location: https://github.com/MrAnkitAgrawal/RecodetarimServiceRepository/tree/master/recodetarim-service
2. Prerequiste:
	2.1 Configure Apache Maven 3.6.3 and Java 8
	

DataBase Tables for Signature and Images:
-----------------------------------------
create table formsdegerlendirmeimza (
	id int(10) unsigned NOT NULL AUTO_INCREMENT,
	image_id varchar(255),
	image MEDIUMBLOB,
	genel_id int(11) DEFAULT NULL,   
	primary key (id)
);

create table formsdegerlendirmeresim (
	id int(10) unsigned NOT NULL AUTO_INCREMENT, 
	signature MEDIUMBLOB, 
	genel_id int(11) DEFAULT NULL,
	primary key (id)
);
