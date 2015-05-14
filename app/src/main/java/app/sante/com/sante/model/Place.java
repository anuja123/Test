package app.sante.com.sante.model;

/**
 * Created by anakade on 4/26/2015.
 */

public class Place {

    /*private int ID;
    private String address;
    private String desc;
    private String logo_url;
    private String name;
    private String type;*/ //TODO Change to enum.

    public static String name;
    public static  String costSymbol;

    public Place(String name, String cost) {
        this.name = name ;
        this.costSymbol  = cost ;
    }

    public String toString() {
        return name + "####" + costSymbol +"\n";
    }


}
