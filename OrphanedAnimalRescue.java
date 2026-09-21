package wildliferescuesystem;

public class OrphanedAnimalRescue extends RescueCase {

    private int ageInMonths;

    private double feedingCost;

    private double shelterCost;

    private double veterinaryCost;

    public OrphanedAnimalRescue(String caseId, String animalName, String location,

            int ageInMonths, double feedingCost, double shelterCost,

            double veterinaryCost) {

        super(caseId, animalName, location);

        this.ageInMonths = ageInMonths;

        this.feedingCost = feedingCost;

        this.shelterCost = shelterCost;

        this.veterinaryCost = veterinaryCost;

    }

    public int getAgeInMonths() {

        return ageInMonths;

    }

    public double getFeedingCost() {

        return feedingCost;

    }

    public double getShelterCost() {

        return shelterCost;

    }

    public double getVeterinaryCost() {

        return veterinaryCost;

    }

    @Override

    public double calculateCost() {

        return feedingCost + shelterCost + veterinaryCost;

    }

    @Override

    public String getPriority() {

        if (ageInMonths <= 6) {

            return "High";

        } else {

            return "Medium";

        }

    }

    @Override

    public void displayCase() {

        System.out.println("----------------------------");

        System.out.println("Orphaned Animal Rescue");

        System.out.println("Case ID: " + getCaseId());

        System.out.println("Animal: " + getAnimalName());

        System.out.println("Location: " + getLocation());

        System.out.println("Age: " + ageInMonths + " months");

        System.out.println("Status: " + getStatus());

        System.out.println("Priority: " + getPriority());

        System.out.println("Feeding Cost: R" + feedingCost);

        System.out.println("Shelter Cost: R" + shelterCost);

        System.out.println("Veterinary Cost: R" + veterinaryCost);

        System.out.println("Total Cost: R" + calculateCost());

        System.out.println("----------------------------");

    }

}
