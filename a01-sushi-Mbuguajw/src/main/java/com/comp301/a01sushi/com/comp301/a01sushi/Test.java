package com.comp301.a01sushi;

public class Test {

    public static void main(String[] args) throws IllegalArgumentException {

        AvocadoPortion avocado = new AvocadoPortion(1);
        RicePortion rice = new RicePortion(2);
        CrabPortion crab = new CrabPortion(2);
        SeaweedPortion otherAvocado = new SeaweedPortion(0.05);
        SeaweedPortion otherOtherAvocado = new SeaweedPortion(0.02);

        IngredientPortion[] testing = {avocado, rice, crab, otherAvocado, otherOtherAvocado};
        Roll roll = new Roll("testing", testing);

        for(int i = 0; i < roll.getIngredients().length; i++) {
            System.out.println("ingredient: " + roll.getIngredients()[i].getName());
            System.out.println("ingredient: " + roll.getIngredients()[i].getAmount());

        }
    }
}
