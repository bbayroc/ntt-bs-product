db.createCollection('Product');
db.Product.insertMany([{
   "_id": 3,
   "idaccount": "11111111",
   "accounttype": "VIP",
   "balance": 5000,
   "idclient": "23703254",
   "currency": "PEN",
   "comission": 5,
   "movementlimit": 5,
   "uniquedayofmovement": 0,
   "_class": "com.example.product.entity.Product"
},{
   "_id": 4,
   "idaccount": "33333333",
   "accounttype": "Ahorro",
   "balance": 4000,
   "idclient": "61462124",
   "currency": "PEN",
   "comission": 0,
   "movementlimit": 5,
   "uniquedayofmovement": 0,
   "_class": "com.example.product.entity.Product"
},{
   "_id": 5,
   "idaccount": "44444444",
   "accounttype": "Plazo Fijo",
   "balance": 10000,
   "idclient": "20356225",
   "currency": "PEN",
   "comission": 0,
   "movementlimit": 1,
   "uniquedayofmovement": 1,
   "_class": "com.example.product.entity.Product"
},{
   "_id": 6,
   "idaccount": "55555555",
   "accounttype": "Cuenta Corriente",
   "balance": 6000,
   "idclient": "82598351",
   "currency": "PEN",
   "comission": 30,
   "movementlimit": 0,
   "uniquedayofmovement": 0,
   "_class": "com.example.product.entity.Product"
},{
   "_id": 8,
   "idaccount": "88888888",
   "accounttype": "PYME",
   "balance": 8000,
   "idclient": "84662894",
   "currency": "PEN",
   "comission": 0,
   "movementlimit": 0,
   "uniquedayofmovement": 0,
   "_class": "com.example.product.entity.Product"
},{
   "_id": 9,
   "idaccount": "9999999",
   "accounttype": "Cuenta Corriente",
   "balance": 7000,
   "idclient": "55021371",
   "currency": "PEN",
   "comission": 30,
   "movementlimit": 0,
   "uniquedayofmovement": 0,
   "_class": "com.example.product.entity.Product"
}]);
db.createCollection('AccountType');
db.AccountType.insertMany(
    [{
       "_id": "627037ebae63dc22e308b7ce",
       "accounttype": "VIP",
       "clienttype": "Personal",
       "minimumbalance": 0,
       "creditcardrequired": true,
       "minimumdailyaverage": 0,
       "_class": "com.example.product.entity.AccountType"
    },{
       "_id": "62703834ae63dc22e308b7cf",
       "accounttype": "PYME",
       "clienttype": "Enterprise",
       "minimumbalance": 0,
       "creditcardrequired": true,
       "minimumdailyaverage": 0,
       "_class": "com.example.product.entity.AccountType"
    },{
       "_id": "627038b6ae63dc22e308b7d0",
       "accounttype": "Cuenta Corriente",
       "clienttype": "Enterprise",
       "minimumbalance": 0,
       "creditcardrequired": false,
       "minimumdailyaverage": 0,
       "_class": "com.example.product.entity.AccountType"
    },{
       "_id": "627038ccae63dc22e308b7d1",
       "accounttype": "Cuenta Corriente",
       "clienttype": "Personal",
       "minimumbalance": 0,
       "creditcardrequired": false,
       "minimumdailyaverage": 0,
       "_class": "com.example.product.entity.AccountType"
    },{
       "_id": "627038e4ae63dc22e308b7d2",
       "accounttype": "Ahorro",
       "clienttype": "Personal",
       "minimumbalance": 0,
       "creditcardrequired": false,
       "minimumdailyaverage": 0,
       "_class": "com.example.product.entity.AccountType"
    },{
       "_id": "627038f0ae63dc22e308b7d3",
       "accounttype": "Plazo Fijo",
       "clienttype": "Personal",
       "minimumbalance": 0,
       "creditcardrequired": false,
       "minimumdailyaverage": 0,
       "_class": "com.example.product.entity.AccountType"
    }]
)
