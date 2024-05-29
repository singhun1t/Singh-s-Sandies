package com.pluralsight.toppings;

public abstract class PremiumToppings extends Toppings {
    private boolean isExtra;

    private static final double smallMeat = 1.00;
    private static final double mediumMeat = 2.00;
    private static final double largeMeat = 3.00;

    private static final double smallCheese = 0.75;
    private static final double mediumCheese = 1.50;
    private static final double largeCheese = 2.25;

    private static final double smallExtraMeat = 0.50;
    private static final double mediumExtraMeat = 1.00;
    private static final double largeExtraMeat = 1.50;
    private static final double smallExtraCheese = 0.30;
    private static final double mediumExtracheese = 0.60;
    private static final double largeExtraCheese = 0.90;
    public PremiumToppings(String name, double price, boolean isExtra) {
        super(name, 0.0);
        this.isExtra = isExtra;
    }

    @Override
    public double getPricebySize(String size){
        double extraCharge = 0.0;
        double sizeCharge = 0.0;
        if(size.equalsIgnoreCase("small")) {
            if (this instanceof Meat) {
                sizeCharge = smallMeat;

            if (isExtra) {
                extraCharge = smallExtraMeat;
            }
        }
            else if (this instanceof Cheese){
                sizeCharge = smallCheese;
                if(isExtra){
                    extraCharge = smallExtraCheese;
                }
            }
        }
        if(size.equalsIgnoreCase("medium")){
            if(this instanceof Meat){
                sizeCharge = mediumMeat;
                if(isExtra){
                    extraCharge = mediumExtraMeat;
                }
            }
            else if (this instanceof  Cheese){
                sizeCharge = mediumCheese;
                if(isExtra){
                    extraCharge = mediumExtracheese;
                }
            }
        }
        if(size.equalsIgnoreCase("large")){
            if(this instanceof Meat){
                sizeCharge = largeMeat;
                if(isExtra){
                    extraCharge = largeExtraMeat;
                }
            }
            else if (this instanceof  Cheese){
                sizeCharge = largeCheese;
                if(isExtra){
                    extraCharge = largeExtraCheese;
                }
            }
        } else{
            throw new IllegalArgumentException("Invalid size, size can't be " + size);
        }
        return sizeCharge + extraCharge;


    }


}
