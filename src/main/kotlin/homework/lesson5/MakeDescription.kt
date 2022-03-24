package homework.lesson5

fun makeDescription(car: Car) = "Manufacture: ${car.manufacture}\n" +
                                "Model: ${car.model}\n" +
                                "Body type: ${car.bodyType}\n" +
                                "Price: ${"%.2f".format(car.price / Currency.getExchangeRate())} $\n" +
                                "Fuel Consumption: ${car.fuelConsumption} л."