package wildliferescuesystem;

public class EndangeredSpeciesRescue extends RescueCase {

    private String conservationStatus;

    private double specialistCost;

    private double protectionCost;

    private double monitoringCost;

    public EndangeredSpeciesRescue(String caseId, String animalName, String location,

            String conservationStatus, double specialistCost,

            double protectionCost, double monitoringCost) {

        super(caseId, animalName, location);

        this.conservationStatus = conservationStatus;

        this.specialistCost = specialistCost;

        this.protectionCost = protectionCost;

        this.monitoringCost = monitoringCost;

    }

    public String getConservationStatus() {

        return conservationStatus;

    }

    public double getSpecialistCost() {

        return specialistCost;

    }

    public double getProtectionCost() {

        return protectionCost;

    }

    public double getMonitoringCost() {

        return monitoringCost;

    }

    @Override

    public double calculateCost() {

        return specialistCost + protectionCost + monitoringCost;

    }

    @Override

    public String getPriority() {

        return "Critical";

    }

    @Override

    public void displayCase() {

        System.out.println("----------------------------");

        System.out.println("Endangered Species Rescue");

        System.out.println("Case ID: " + getCaseId());

        System.out.println("Animal: " + getAnimalName());

        System.out.println("Location: " + getLocation());

        System.out.println("Conservation Status: " + conservationStatus);

        System.out.println("Status: " + getStatus());

        System.out.println("Priority: " + getPriority());

        System.out.println("Specialist Cost: R" + specialistCost);

        System.out.println("Protection Cost: R" + protectionCost);

        System.out.println("Monitoring Cost: R" + monitoringCost);

        System.out.println("Total Cost: R" + calculateCost());

        System.out.println("----------------------------");

    }

}

