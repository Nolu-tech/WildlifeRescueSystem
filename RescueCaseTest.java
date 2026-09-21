package wildliferescuesystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RescueCaseTest {

    @Test

    public void testInjuredAnimalCost() {

        InjuredAnimalRescue rescue = new InjuredAnimalRescue(

                "TEST001",

                "Test Animal",

                "Johannesburg",

                "Broken leg",

                5000

        );

        assertEquals(5000, rescue.calculateCost(), 0.01);

    }

    @Test

    public void testInjuredAnimalPriority() {

        InjuredAnimalRescue rescue = new InjuredAnimalRescue(

                "TEST002",

                "Test Animal",

                "Johannesburg",

                "Broken leg",

                5000

        );

        assertEquals("High", rescue.getPriority());

    }

    @Test

    public void testStatusUpdate() {

        InjuredAnimalRescue rescue = new InjuredAnimalRescue(

                "TEST003",

                "Test Animal",

                "Johannesburg",

                "Broken leg",

                5000

        );

        rescue.setStatus("In Progress");

        assertEquals("In Progress", rescue.getStatus());

    }

    @Test

    public void testOrphanedAnimalCost() {

        OrphanedAnimalRescue rescue = new OrphanedAnimalRescue(

                "TEST004",

                "Baby Animal",

                "Pretoria",

                4,

                3000,

                3000,

                4000

        );

        assertEquals(10000, rescue.calculateCost(), 0.01);

    }

    @Test

    public void testEndangeredSpeciesCost() {

        EndangeredSpeciesRescue rescue = new EndangeredSpeciesRescue(

                "TEST005",

                "Elephant",

                "Kruger National Park",

                "Critically Endangered",

                8000,

                5000,

                4200

        );

        assertEquals(17200, rescue.calculateCost(), 0.01);

    }

}