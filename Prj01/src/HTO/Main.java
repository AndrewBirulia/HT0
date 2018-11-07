package HTO;

public class Main {
    public static void main(String[] args) {
        try {
            Building building = new Building("Building1");
            building.addRoom("Room1", 100, 4);
            building.getRoom("Room1").add(new Lamp(50));
            building.addRoom("Room2", 75, 3);
            building.getRoom("Room2").add(new Lamp(180));
            building.getRoom("Room2").add(new Sofa("Sofa", 10));
            building.addRoom("Room3", 200, 5);
            building.getRoom("Room3").add(new Table("Table", 4));
            building.check();
        }catch (NotEnoughIlluminanceException notEnoughIlluminance){
            System.out.println(notEnoughIlluminance.getMessage());
        }catch (IlluminanceTooMuchException ex){
            System.out.println(ex.getMessage());
        }catch (SpaceUsageTooMuchException ex1){
            System.out.println(ex1.getMessage());
        }
    }
}
