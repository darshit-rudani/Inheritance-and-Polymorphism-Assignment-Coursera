package mooc.vandy.java4android.buildings.logic;

import org.junit.Test;

import java.lang.reflect.Field;

import io.magnum.autograder.junit.Rubric;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

public class UnitTests {
    private static final long TIMEOUT = 100;

    @Rubric(
            value = "testBuildingArea",
            goal = "The goal of this evaluation is to testBuildingArea",
            points = 1.0,
            reference = "This Test fails when: The Building area miscalculated"
    )
    @Test(timeout = TIMEOUT)
    public void testBuildingArea() {
        Building office = new Building(200, 400, 600, 560);
        assertEquals(80000, office.calcBuildingArea());
    }

    @Rubric(
            value = "testBuildingLotArea",
            goal = "The goal of this evaluation is to testBuildingLotArea",
            points = 1.0,
            reference = "This Test fails when: The Building lot area miscalculated"
    )
    @Test(timeout = TIMEOUT)
    public void testBuildingLotArea() {
        Building office = new Building(200, 400, 600, 560);
        assertEquals(336000, office.calcLotArea());
    }

    @Rubric(
            value = "testBuildingSetAndGet",
            goal = "The goal of this evaluation is to testBuildingSetAndGet",
            points = 2.0,
            reference = "This Test fails when: 1 or more of the Building.Set/Get had a problem"
    )
    @Test(timeout = TIMEOUT)
    public void testBuildingSetAndGet() {
        //int length, int width, int lotLength, int lotWidth
        Building b1 = new Building(10, 20, 30, 40);
        assertEquals(10, b1.getLength());
        assertEquals(20, b1.getWidth());
        assertEquals(30, b1.getLotLength());
        assertEquals(40, b1.getLotWidth());
        b1.setLength(1);
        b1.setWidth(2);
        b1.setLotLength(3);
        b1.setLotWidth(4);
        assertEquals(1, b1.getLength());
        assertEquals(2, b1.getWidth());
        assertEquals(3, b1.getLotLength());
        assertEquals(4, b1.getLotWidth());
    }

    // OFFICE TESTS

    @Rubric(
            value = "testOfficeString",
            goal = "The goal of this evaluation is to testOfficeString",
            points = 1.0,
            reference = "This Test fails when: The Office toString() method is incorrect"
    )
    @Test
    public void testOfficeString() throws Exception {
        int i = Office.getTotalOffices() + 1;
        int count = i + 10;

        for (; i <= count; i++) {
            new Office(20, 40, 56, 60);
        }

        String expected = "Business: unoccupied (total offices: " + (count + 1) + ")";
        assertEquals(expected, (new Office(1, 1, 1, 1)).toString().trim());
    }

    @Rubric(
            value = "testOfficeArea",
            goal = "The goal of this evaluation is to testOfficeArea",
            points = 1.0,
            reference = "This Test fails when: The Office area miscalculated - check class hierarchy"
    )
    @Test(timeout = TIMEOUT)
    public void testOfficeArea() {
        Office office = new Office(200, 400, 600, 560, "Bridgestone/Firestone", 100);
        assertEquals(80000, office.calcBuildingArea());
    }

    @Rubric(
            value = "testOfficeLotArea",
            goal = "The goal of this evaluation is to testOfficeLotArea",
            points = 1.0,
            reference = "This Test fails when: The Office lot area miscalculated - check class hierarchy"
    )
    @Test(timeout = TIMEOUT)
    public void testOfficeLotArea() {
        Office office = new Office(200, 400, 600, 560, "Bridgestone/Firestone", 100);
        assertEquals(336000, office.calcLotArea());
    }

    @Rubric(
            value = "testOfficeConstructor",
            goal = "The goal of this evaluation is to testOfficeConstructor",
            points = 1.0,
            reference = "This Test fails when: The Office doesn't have 0 default parking spots"
    )
    @Test(timeout = TIMEOUT)
    public void testOfficeConstructor() {
        Office emptyOffice = new Office(20, 40, 56, 60);

        assertEquals(0, emptyOffice.getParkingSpaces());
    }

    @Rubric(
            value = "testSetSpaces",
            goal = "The goal of this evaluation is to testSetSpaces",
            points = 1.0,
            reference = "This Test fails when: The Number of parking spaces was set incorrectly"
    )
    @Test(timeout = TIMEOUT)
    public void testSetSpaces() {
        Office caterpillar = new Office(200, 400, 560, 600, "Caterpillar");
        caterpillar.setParkingSpaces(100);
        assertEquals(100, caterpillar.getParkingSpaces());
    }

    @Rubric(
            value = "testOfficeEquals",
            goal = "The goal of this evaluation is to testOfficeEquals",
            points = 1.0,
            reference = "This Test fails when: The Office equals() is wrong"
    )
    @Test(timeout = TIMEOUT)
    public void testOfficeEquals() {
        Office o1 = new Office(200, 400, 560, 600, "o1");
        Office o2 = new Office(200, 400, 600, 560, "o2");
        assertEquals(o1, o2);
    }

    // HOUSE TESTS

    @Rubric(
            value = "testHouseOwner",
            goal = "The goal of this evaluation is to testHouseOwner",
            points = 1.0,
            reference = "This Test fails when: The House owner was incorrect"
    )
    @Test(timeout = TIMEOUT)
    public void testHouseOwner() {
        House washington = new House(20, 40, 56, 60);
        washington.setOwner("George Washington");
        assertEquals("George Washington", washington.getOwner());
    }

    @Rubric(
            value = "testHousePool",
            goal = "The goal of this evaluation is to testHousePool",
            points = 1.0,
            reference = "This Test fails when: The House class is incorrect with having a pool"
    )
    @Test(timeout = TIMEOUT)
    public void testHousePool() {
        House home = new House(20, 40, 60, 80);
        assertFalse(home.hasPool());
        home.setPool(true);
        assertTrue(home.hasPool());
        home.setPool(false);
        assertFalse(home.hasPool());
    }

    @Rubric(
            value = "testHouseAreas",
            goal = "The goal of this evaluation is to testHouseAreas",
            points = 1.0,
            reference = "This Test fails when: The House area/lot area miscalculated - check class hierarchy"
    )
    @Test(timeout = TIMEOUT)
    public void testHouseAreas() {
        House adams = new House(10, 12, 100, 200, "John Adams");
        assertEquals(120, adams.calcBuildingArea());
        assertEquals(20000, adams.calcLotArea());
    }

    @Rubric(
            value = "testHouseToString",
            goal = "The goal of this evaluation is to testHouseToString",
            points = 1.0,
            reference = "This Test fails when: The House.toString() produced unexpected output"
    )
    @Test(timeout = TIMEOUT)
    public void testHouseToString() {
        House adams = new House(10, 12, 100, 200, "John Adams");
        String str = adams.toString().trim();
        String expected = "Owner: John Adams; has a big open space";
        assertEquals(expected, str);
    }

    @Rubric(
            value = "testHouseEquals",
            goal = "The goal of this evaluation is to testHouseEquals",
            points = 1.0,
            reference = "This Test fails when: The House equals method failed"
    )
    @Test(timeout = TIMEOUT)
    public void testHouseEquals() {
        House jefferson = new House(20, 40, 60, 56, "Thomas Jefferson", true);
        House madison = new House(20, 40, 56, 60, "James Madison", true);
        House h3 = new House(1, 1, 1, 1);
        assertEquals(jefferson, madison);
        assertNotEquals(h3, jefferson);
    }

    // COTTAGE TESTS

    @Rubric(
            value = "testCottageSecondFloor",
            goal = "The goal of this evaluation is to testCottageSecondFloor",
            points = 1.0,
            reference = "This Test fails when: The Two story cottage failed"
    )
    @Test(timeout = TIMEOUT)
    public void testCottageSecondFloor() {
        Cottage c = new Cottage(1, 2, 3, "name", true);
        assertTrue(c.hasSecondFloor());
    }


    @Rubric(
            value = "testCottageSingleFloor",
            goal = "The goal of this evaluation is to testCottageSingleFloor",
            points = 1.0,
            reference = "This Test fails when: The Single story cottage failed"
    )
    @Test(timeout = TIMEOUT)
    public void testCottageSingleFloor() {
        Cottage c = new Cottage(1, 2, 3, "name", false);
        assertFalse(c.hasSecondFloor());
    }

    // NEIGHBORHOOD TESTS

    @Rubric(
            value = "testNeighborhoodArea",
            goal = "The goal of this evaluation is to testNeighborhoodArea",
            points = 1.0,
            reference = "This Test fails when: The Neighborhood area calculation was wrong"
    )
    @Test(timeout = TIMEOUT)
    public void testNeighborhoodArea() {

        House[] house = new House[2];
        Office[] office = new Office[3];
        for (int i = 0; i < 2; ++i) {
            house[i] = new House(i + 1, i + 1, i + 1, i + 1);
        }
        for (int i = 0; i < 3; ++i) {
            office[i] = new Office(i + 1, i + 1, i + 1, i + 1);
        }

        assertEquals(5, Neighborhood.calcArea(house));
        assertEquals(14, Neighborhood.calcArea(office));
    }

    public static void injectValueIntoStaticNamedField(
            Class parentClass, String fieldName, Object fieldValue) throws Exception {
        Field field = parentClass.getDeclaredField(fieldName);
        boolean wasAccessible = field.isAccessible();
        field.setAccessible(true);
        field.set(parentClass, fieldValue);
        field.setAccessible(wasAccessible);
    }
}
