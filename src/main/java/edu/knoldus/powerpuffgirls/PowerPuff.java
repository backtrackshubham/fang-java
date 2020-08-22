package edu.knoldus.powerpuffgirls;

import java.util.Scanner;
/**
 * 2
 * 2 3
 * 20 30
 */
public class PowerPuff {
    public static void main(String[] args) {
        int ingredients;
        Scanner s = new Scanner(System.in);
        ingredients = Integer.parseInt(s.nextLine());
        String ing = s.nextLine();
        String[] ingArray = ing.split(" ");
        String quantity = s.nextLine();
        String[] quantityArray = quantity.split(" ");
        Long[] ingArr = new Long[ingredients];
        Long[] ingQuArr = new Long[ingredients];

        for (int i = 0; i < ingredients; i++) {
            ingArr[i] = Long.parseLong(ingArray[i]);
            ingQuArr[i] = Long.parseLong(quantityArray[i]);
        }

        System.out.println(calculateSets(ingredients,
                ingArr,
                ingQuArr
        ));
    }

    public static Long calculateSets(int numIng, Long[] numQuantity, Long[] totalIngQuantity) {
        Long minSets = 0L;

        for (int i = 0; i < numIng; i++) {
            if (i == 0) {
                minSets = totalIngQuantity[i] / numQuantity[i];
            } else {
                Long nSet = totalIngQuantity[i] / numQuantity[i];
                minSets = Math.min(nSet, minSets);
            }
        }
        return minSets;
    }
}
