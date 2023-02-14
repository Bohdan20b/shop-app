package model;

import java.math.BigDecimal;

public class StickerPrinter {
    private static final String INVALID_PRODUCT_NAME = "INVALID_PRODUCT_NAME";
    private static final String INVALID_PRICE = "INVALID_PRICE";
    private static final String WHITESPACE = " ";

    public static String createSticker(String productName, BigDecimal price, float tax) {
        StringBuilder stringBuilder = new StringBuilder();
        if (validateProductName(productName)) {
            stringBuilder.append(productName);
        } else {
            stringBuilder.append(INVALID_PRODUCT_NAME);
        }
        stringBuilder.append(WHITESPACE);
        if (validatePrice(price)) {
            BigDecimal finalPrice = price.multiply(BigDecimal.valueOf(tax)).add(price);
            stringBuilder.append(finalPrice);
        } else {
            stringBuilder.append(INVALID_PRICE);
        }
            return stringBuilder.toString();
    }

    private static boolean validatePrice(BigDecimal price) {
        return price.compareTo(BigDecimal.ZERO) > 0;
    }

    private static boolean validateProductName(String productName) {
        return productName.matches("[a-zA-Z]+");
    }

    public static void main(String[] args) {
        System.out.println(StickerPrinter.createSticker("Milk", BigDecimal.valueOf(666), 0.15f));
    }
}
