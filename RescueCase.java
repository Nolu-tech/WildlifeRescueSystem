package wildliferescuesystem;

public abstract class RescueCase {

    private String caseId;

    private String animalName;

    private String location;

    private String status;

    public RescueCase(String caseId, String animalName, String location) {

        this.caseId = caseId;

        this.animalName = animalName;

        this.location = location;

        this.status = "Pending";

    }

    public String getCaseId() {

        return caseId;

    }

    public String getAnimalName() {

        return animalName;

    }

    public String getLocation() {

        return location;

    }

    public String getStatus() {

        return status;

    }

    public void setStatus(String status) {

        this.status = status;

    }

    public abstract double calculateCost();

    public abstract String getPriority();

    public void displayCase() {

        System.out.println("Case ID: " + caseId);

        System.out.println("Animal: " + animalName);

        System.out.println("Location: " + location);

        System.out.println("Status: " + status);

        System.out.println("Priority: " + getPriority());

        System.out.println("Cost: R" + calculateCost());

    }

}

