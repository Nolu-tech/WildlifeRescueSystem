package wildliferescuesystem;

public class InjuredAnimalRescue extends RescueCase {

    private String injuryType;

    private double treatmentCost;

    public InjuredAnimalRescue(String caseId, String animalName, String location,

            String injuryType, double treatmentCost) {

        super(caseId, animalName, location);

        this.injuryType = injuryType;

        this.treatmentCost = treatmentCost;

    }

    public String getInjuryType() {

        return injuryType;

    }

    public double getTreatmentCost() {

        return treatmentCost;

    }

    @Override

    public double calculateCost() {

        return treatmentCost;

    }

    @Override

    public String getPriority() {

        return "High";

    }

    @Override

    public void displayCase() {

        super.displayCase();

        System.out.println("Injury Type: " + injuryType);

        System.out.println("----------------------------");

    }

}

