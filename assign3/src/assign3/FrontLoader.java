package assign3;

import assign3.Tractor;

public class FrontLoader extends Tractor {

    double loaderWidth;     // in cm
    double loaderCap;       // in cm^3


    public FrontLoader() {
        loaderWidth = 188.0616;
        loaderCap =  120000;
        super.setMake("Cat");
        super.setModel("906M");
        super.setPower(54.4361);
        super.setFuelType("diesel");
        super.setFuelCap(51.86014);
        super.setFuelLoad(super.getFuelCap()*0.9);
        super.setFuelEff(3.5);
        super.setRange(super.estRange());
        super.setPrice(90000);

    }

    public double getLoaderWidth() {
        return loaderWidth;
    }

    public void setLoaderWidth(double loaderWidth) {
        this.loaderWidth = loaderWidth;
    }

    public double getLoaderCap() {
        return loaderCap;
    }

    public void setLoaderCap(double loaderCap) {
        this.loaderCap = loaderCap;
    }

    @Override
    public String toString() {
        String line = "--------------------------------------------------------------------------------------------------------------------------------\n";
        String title = "    Make       Model    Power    Fuel Type      Fuel Cap     Fuel Load    Fuel Efficiency     Range   Price     ID       Owner\n";
        String output = String.format("%1$12s %2$7s %3$7.1f %4$12s %5$13.1f %6$12.1f %7$13.2f %8$16.2f %9$6.1fk %10$5d %11$12s \n"
                ,super.getMake(), super.getModel(),super.getPower(), super.getFuelType(), super.getFuelCap(), super.getFuelLoad(),super.getFuelEff(),super.getRange(),super.getPrice()/1000,super.getTractorID(),super.getOwnerID());


        return title+ output+ line;
    }
}
