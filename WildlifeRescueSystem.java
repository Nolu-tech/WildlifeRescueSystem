package wildliferescuesystem;

import java.util.ArrayList;

import java.util.Scanner;

public class WildlifeRescueSystem {

    private static ArrayList<RescueCase> rescueCases = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        addSampleCases();

        int choice;

        do {

            displayMenu();

            choice = getInt("Enter your choice: ");

            switch (choice) {

                case 1:

                    createNewRescueCase();

                    break;

                case 2:

                    searchRescueCase();

                    break;

                case 3:

                    updateRescueStatus();

                    break;

                case 4:

                    displayAllRescueCases();

                    break;

                case 5:

                    startRescueOperation();

                    break;

                case 6:

                    completeRescueOperation();

                    break;

                case 7:

                    displayRescueSummary();

                    break;

                case 8:

                    System.out.println("Thank you for using Wildlife Rescue System.");

                    break;

                default:

                    System.out.println("Invalid choice. Please enter a number from 1 to 8.");

            }

        } while (choice != 8);

        scanner.close();

    }

    private static void displayMenu() {

        System.out.println();

        System.out.println("=================================");

        System.out.println("       WILDLIFE RESCUE SYSTEM");

        System.out.println("=================================");

        System.out.println("1. Create New Rescue Case");

        System.out.println("2. Search Rescue Case");

        System.out.println("3. Update Rescue Status");

        System.out.println("4. Display All Rescue Cases");

        System.out.println("5. Start Rescue Operation");

        System.out.println("6. Complete Rescue Operation");

        System.out.println("7. Display Rescue Summary");

        System.out.println("8. Exit");

        System.out.println("=================================");

    }

    private static void addSampleCases() {

        InjuredAnimalRescue injured = new InjuredAnimalRescue(

                "IR001",

                "Simba",

                "Johannesburg",

                "Broken leg",

                9500

        );

        OrphanedAnimalRescue orphaned = new OrphanedAnimalRescue(

                "OR001",

                "Leo",

                "Pretoria",

                4,

                3000,

                3000,

                4000

        );

        EndangeredSpeciesRescue endangered = new EndangeredSpeciesRescue(

                "ES001",

                "Tembo",

                "Kruger National Park",

                "Critically Endangered",

                8000,

                5000,

                4200

        );

        rescueCases.add(injured);

        rescueCases.add(orphaned);

        rescueCases.add(endangered);

    }

    private static void createNewRescueCase() {

        System.out.println();

        System.out.println("===== CREATE NEW RESCUE CASE =====");

        String caseId = getText("Enter case ID: ");

        if (findCase(caseId) != null) {

            System.out.println("A rescue case with this ID already exists.");

            return;

        }

        String animalName = getText("Enter animal name: ");

        String location = getText("Enter location: ");

        System.out.println();

        System.out.println("Select rescue type:");

        System.out.println("1. Injured Animal");

        System.out.println("2. Orphaned Animal");

        System.out.println("3. Endangered Species");

        int type = getInt("Enter rescue type: ");

        if (type == 1) {

            String injuryType = getText("Enter injury type: ");

            double treatmentCost = getPositiveDouble("Enter treatment cost: ");

            RescueCase rescue = new InjuredAnimalRescue(

                    caseId,

                    animalName,

                    location,

                    injuryType,

                    treatmentCost

            );

            rescueCases.add(rescue);

            System.out.println("Injured animal rescue case created successfully.");

        } else if (type == 2) {

            int ageInMonths = getPositiveInt("Enter animal age in months: ");

            double feedingCost = getPositiveDouble("Enter feeding cost: ");

            double shelterCost = getPositiveDouble("Enter shelter cost: ");

            double veterinaryCost = getPositiveDouble("Enter veterinary cost: ");

            RescueCase rescue = new OrphanedAnimalRescue(

                    caseId,

                    animalName,

                    location,

                    ageInMonths,

                    feedingCost,

                    shelterCost,

                    veterinaryCost

            );

            rescueCases.add(rescue);

            System.out.println("Orphaned animal rescue case created successfully.");

        } else if (type == 3) {

            String conservationStatus = getText("Enter conservation status: ");

            double specialistCost = getPositiveDouble("Enter specialist cost: ");

            double protectionCost = getPositiveDouble("Enter protection cost: ");

            double monitoringCost = getPositiveDouble("Enter monitoring cost: ");

            RescueCase rescue = new EndangeredSpeciesRescue(

                    caseId,

                    animalName,

                    location,

                    conservationStatus,

                    specialistCost,

                    protectionCost,

                    monitoringCost

            );

            rescueCases.add(rescue);

            System.out.println("Endangered species rescue case created successfully.");

        } else {

            System.out.println("Invalid rescue type.");

        }

    }

    private static void searchRescueCase() {

        System.out.println();

        System.out.println("===== SEARCH RESCUE CASE =====");

        String caseId = getText("Enter case ID to search: ");

        RescueCase rescue = findCase(caseId);

        if (rescue != null) {

            System.out.println("Rescue case found.");

            rescue.displayCase();

        } else {

            System.out.println("Rescue case not found.");

        }

    }

    private static void updateRescueStatus() {

        System.out.println();

        System.out.println("===== UPDATE RESCUE STATUS =====");

        String caseId = getText("Enter case ID: ");

        RescueCase rescue = findCase(caseId);

        if (rescue == null) {

            System.out.println("Rescue case not found.");

            return;

        }

        System.out.println("Current status: " + rescue.getStatus());

        System.out.println("1. Pending");

        System.out.println("2. In Progress");

        System.out.println("3. Completed");

        int choice = getInt("Select new status: ");

        if (choice == 1) {

            rescue.setStatus("Pending");

        } else if (choice == 2) {

            rescue.setStatus("In Progress");

        } else if (choice == 3) {

            rescue.setStatus("Completed");

        } else {

            System.out.println("Invalid status choice.");

            return;

        }

        System.out.println("Status updated successfully.");

        System.out.println("New status: " + rescue.getStatus());

    }

    private static void displayAllRescueCases() {

        System.out.println();

        System.out.println("===== ALL RESCUE CASES =====");

        if (rescueCases.isEmpty()) {

            System.out.println("There are no rescue cases.");

            return;

        }

        for (RescueCase rescue : rescueCases) {

            rescue.displayCase();

        }

    }

    private static void startRescueOperation() {

        System.out.println();

        System.out.println("===== START RESCUE OPERATION =====");

        String caseId = getText("Enter case ID: ");

        RescueCase rescue = findCase(caseId);

        if (rescue == null) {

            System.out.println("Rescue case not found.");

            return;

        }

        if (rescue.getStatus().equals("Completed")) {

            System.out.println("This rescue operation has already been completed.");

            return;

        }

        rescue.setStatus("In Progress");

        System.out.println("Rescue operation started successfully.");

        System.out.println("Case ID: " + rescue.getCaseId());

        System.out.println("Animal: " + rescue.getAnimalName());

        System.out.println("Status: " + rescue.getStatus());

    }

    private static void completeRescueOperation() {

        System.out.println();

        System.out.println("===== COMPLETE RESCUE OPERATION =====");

        String caseId = getText("Enter case ID: ");

        RescueCase rescue = findCase(caseId);

        if (rescue == null) {

            System.out.println("Rescue case not found.");

            return;

        }

        if (rescue.getStatus().equals("Completed")) {

            System.out.println("This rescue operation is already completed.");

            return;

        }

        rescue.setStatus("Completed");

        System.out.println("Rescue operation completed successfully.");

        System.out.println("Case ID: " + rescue.getCaseId());

        System.out.println("Animal: " + rescue.getAnimalName());

        System.out.println("Status: " + rescue.getStatus());

    }

    private static void displayRescueSummary() {

        System.out.println();

        System.out.println("===== RESCUE SUMMARY =====");

        int totalCases = rescueCases.size();

        int pendingCases = 0;

        int inProgressCases = 0;

        int completedCases = 0;

        double totalCost = 0;

        for (RescueCase rescue : rescueCases) {

            totalCost += rescue.calculateCost();

            if (rescue.getStatus().equals("Pending")) {

                pendingCases++;

            } else if (rescue.getStatus().equals("In Progress")) {

                inProgressCases++;

            } else if (rescue.getStatus().equals("Completed")) {

                completedCases++;

            }

        }

        System.out.println("Total Rescue Cases: " + totalCases);

        System.out.println("Pending Cases: " + pendingCases);

        System.out.println("In Progress Cases: " + inProgressCases);

        System.out.println("Completed Cases: " + completedCases);

        System.out.println("Total Rescue Cost: R" + totalCost);

    }

    private static RescueCase findCase(String caseId) {

        for (RescueCase rescue : rescueCases) {

            if (rescue.getCaseId().equalsIgnoreCase(caseId)) {

                return rescue;

            }

        }

        return null;

    }

    private static String getText(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {

                return input;

            }

            System.out.println("Input cannot be blank. Please try again.");

        }

    }

    private static int getInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(scanner.nextLine().trim());

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");

            }

        }

    }

    private static int getPositiveInt(String message) {

        while (true) {

            int value = getInt(message);

            if (value > 0) {

                return value;

            }

            System.out.println("Value must be greater than 0.");

        }

    }

    private static double getPositiveDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                double value = Double.parseDouble(scanner.nextLine().trim());

                if (value > 0) {

                    return value;

                }

                System.out.println("Value must be greater than 0.");

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");

            }

        }

    }

}


