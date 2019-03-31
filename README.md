# PrizyPricer
The Prizy Pricer App

## create Survey request
http://localhost:8080/product/createSurvey
{
	"product": {
		"id": 5
	},
	"priceByUser": "4500",
	"notes": "Nikhil iPhone X"
}

## Read ProductSurvey by bar code 
http://localhost:8080/product/readProductByCode/?id=126
{
  "barCode": 126,
  "description": "Samgung s7",
  "avgPrice": 3250.0,
  "lowestPrice": 6500.0,
  "highestPrice": 6500.0,
  "idealPrice": 3900.0,
  "noOfPrices": 2,
  "instructions": null
}

#create Product url and Payload

http://localhost:8080/product/createProduct
{
	"barCode": 13,
	"name": "Apple Phone",
	"discription": "Iphone X"
}

## Read All Product Response::

[
   {
    "id": 21,
    "barCode": 12,
    "name": "Samsung Phone",
    "discription": "Samgung s7"
  },
  {
    "id": 22,
    "barCode": 13,
    "name": "Apple Phone",
    "discription": "Iphone X"
  }
]

## Read Product by id

http://localhost:8080/product/readProduct/?id=5

Response::
{
  "id": 5,
  "barCode": 126,
  "name": "Samsung Phone",
  "discription": "Samgung s7"
}





