import org.apache.commons.validator.routines.DoubleValidator;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest {

    public static void main(String[] args){

        System.out.println(getStringValue("2,345,123.001", NumberFormat.getInstance(Locale.US)));
        System.out.println(getStringValue("2,345,123.001", NumberFormat.getInstance(Locale.FRANCE)));
        System.out.println(getStringValue("2020",  NumberFormat.getInstance(Locale.US)));
        System.out.println(getStringValue("2020", NumberFormat.getInstance(Locale.FRANCE)));
        System.out.println(getStringValue("10 U.S.",  NumberFormat.getInstance(Locale.US)));
        System.out.println(getStringValue("10 U.S.", NumberFormat.getInstance(Locale.FRANCE)));
    }

    private static String getStringValue(String originalValue,  NumberFormat targetNumberFormat) {
        try {
            Integer i = Integer.parseInt(originalValue);
            return originalValue;
        } catch (NumberFormatException ex1) {
            try {
                String temp = originalValue.replace(",", "");
                Double number = Double.parseDouble(temp);
                if(temp.indexOf(".") != -1){
                    targetNumberFormat.setMinimumFractionDigits(temp.substring(temp.indexOf("."), temp.length()).length()-1);
                }
                return targetNumberFormat.format(number);
            } catch (NumberFormatException ex2) {
                return originalValue;
            }
        }
    }

    /*
    private static String getStringValue(String originalValue,  NumberFormat targetNumberFormat) {

        Double d  = DoubleValidator.getInstance().validate(originalValue, Locale.US);
        System.out.println(d);

        return originalValue;
       try {
            Integer i = Integer.parseInt(originalValue);
            return originalValue;
        } catch (NumberFormatException ex1) {
            try {
                String temp = originalValue.replace(",", "");
                Double number = Double.parseDouble(temp);
                return targetNumberFormat.format(number);
            } catch (NumberFormatException ex2) {
                return originalValue;
            }
        }
    }
    */

    /*
    private static String getStringValue(String originalValue, NumberFormat numberFormat) {
        try {
            Integer i = Integer.parseInt(originalValue);
            return originalValue;
        } catch (NumberFormatException ex1){
            try {
                Double d = Double.parseDouble(originalValue);
                try {
                    Double number = NumberFormat.getInstance(Locale.US).parse(originalValue).doubleValue();
                    return numberFormat.format(number);
                } catch (ParseException ex2) {
                    return originalValue;
                }
            } catch(NumberFormatException ex3) {
                return originalValue;
            }
        }
    }
    */
}
