import java.util.Random;
public class car{
    //region Vars
    private double amountofgas;
    private double sizeoftank;
    private double mileagepergallon;
    private double milesuntilempty;
    private double totalmiles;
    private double totalmoney;
    private double totalpriceofgas;
    private double pricepergallon;
    //endregion
    //region Getters
    public double getAmountofgas(){
        return  amountofgas;
    }
    public double getSizeoftank() {
        return sizeoftank;
    }
    public double getMileagepergallon() {
        return mileagepergallon;
    }
    public double getMilesuntilempty() {
        return milesuntilempty;
    }
    public double getTotalmiles(){
        return totalmiles;
    }
    public double getTotalmoney(){
        return totalmoney;
    }
    public double getTotalpriceofgas(){
        return totalpriceofgas;
    }
    public double getPricepergallon(){
        return pricepergallon;
    }
    //endregion
    //region Setters
    public void setAmountofgas(double amountofgas) {
        this.amountofgas = amountofgas;
    }
    public void setSizeoftank(double sizeoftank) {
        this.sizeoftank = sizeoftank;
    }
    public void setMileagepergallon(double mileagepergallon) {
        this.mileagepergallon = mileagepergallon;
    }
    public void setMilesuntilempty(double milesuntilempty) {
        this.milesuntilempty = milesuntilempty;
    }
    public void setTotalmiles(double totalmiles){
        this.totalmiles = totalmiles;
    }
    public void setTotalmoney(double totalmoney){
        this.totalmoney = totalmoney;
    }
    public void setTotalpriceofgas(double totalpriceofgas){
        this.totalpriceofgas = totalpriceofgas;
    }
    public void setPricepergallon(double pricepergallon){
        this.pricepergallon = pricepergallon;
    }
    //endregion
    //region car object
    public car(double amountofgas, double sizeoftank, double mileagepergallon, //making of the object in the class
               double milesuntilempty, double totalmoney){
        this.amountofgas = amountofgas;
        this.sizeoftank = sizeoftank;
        this.mileagepergallon = mileagepergallon;
        this.milesuntilempty = milesuntilempty;
        this.totalmiles = 0;
        this.totalmoney = totalmoney;
    }
    //endregion
    //region override toString()
    public String toString(){
        return "Max Tank Level: " + sizeoftank + " gals" + "\n" +
                "Miles per Gallon: " + mileagepergallon + " mi" + "\n" +
                "Gas in Tank: " + amountofgas + " gals" + "\n" +
                "Miles to Empty: " + milesuntilempty + " mi" + "\n" +
                "Cost for Trip: $" + totalmoney + "\n";
    }
    //endregion
    //region total miles
    public void milesDrove(double miles){
        totalmiles += miles;
    }
    //endregion
    //region simulation of driving
    public void driving(double miles){
        milesDrove(miles);
        double gallonsused = miles/mileagepergallon;

        if(miles >= milesuntilempty){
            amountofgas = 0;
            milesuntilempty = 0;
            System.out.print("After ");
            System.out.printf("%.2f", milesuntilempty);
            System.out.println(" miles, You ran out of gas!");

        }

        else{
            amountofgas -= gallonsused;
            milesuntilempty -= miles;
            System.out.print("Money left: ");
            System.out.printf("%.2f", totalmoney);
            System.out.println();
            System.out.print("You drove: ");
            System.out.printf("%.2f", miles);
            System.out.println(" mi");
            System.out.print("Miles to Empty: ");
            System.out.printf("%.2f", milesuntilempty);
            System.out.println(" mi");

        }
    }
    //endregion
    //region filling gas
    public void fillingGas(double fillGas, double pricepergallon){
        double totalprice = 0;
        if (fillGas <= 0) {
            System.out.println("You bought no gas");
        }

        else if(fillGas>=sizeoftank){
            amountofgas = sizeoftank;
            totalprice = sizeoftank * pricepergallon;
        }
        else{
            amountofgas += fillGas;
            totalprice = fillGas * pricepergallon;
        }
        totalpriceofgas += totalprice;
        totalmoney -= totalprice;
        milesuntilempty = amountofgas * mileagepergallon;

        System.out.print("You bought ");
        System.out.printf("%.2f", fillGas);
        System.out.print(" gallons at $");
        System.out.printf("%.2f", pricepergallon);
        System.out.println(" per gallon.");
        System.out.print("It costed: $");
        System.out.printf("%.2f", totalprice);
        System.out.println(" mi");
        System.out.print("Miles to Empty: ");
        System.out.printf("%.2f", milesuntilempty);
        System.out.println(" mi");

    }
    //endregion
}
