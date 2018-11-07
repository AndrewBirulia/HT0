package HTO;


import java.util.ArrayList;

public class Building {
    private String nameofroom;
    private ArrayList<Room> r = new ArrayList<>();

    private int increase = 0;

    public Building(String name) {
        this.nameofroom = name;
    }

    public void addRoom(String name, int square, int numberofwindow)  {
        Room room[] = new Room[10];
        room[increase] = new Room(name, square, numberofwindow);
        r.add(room[increase]);
        increase++;
    }

    public Room getRoom(String nameofroom) {
        for (int i = 0; i < r.size(); i++) {
            if (nameofroom == r.get(i).getnameofroom()) {
                return r.get(i);
            }
        }
        return r.get(1);
    }

    public void check() throws NotEnoughIlluminanceException, IlluminanceTooMuchException, SpaceUsageTooMuchException {
        for (int i = 0; i < r.size(); i++) {
            r.get(i).checkLamp();
            r.get(i).checkSquare();
        }
        describe();
    }

    public void describe()  {
        System.out.println(this.nameofroom);
        for (int i = 0; i < r.size(); i++) {
            System.out.println("Room's name - " + r.get(i).getnameofroom());
            System.out.print("Illuminancy = " + r.get(i).getillumination());
            if(r.get(i).getamountofwindow()==1) {
                System.out.print("(" + r.get(i).getamountofwindow() + " window");
                System.out.print(",lamps ");
                r.get(i).describeLamp();
            }
            if(r.get(i).getamountofwindow()>1 && r.get(i).getamountofwindow()<5) {
                System.out.print("(" + r.get(i).getamountofwindow() + " window");
                System.out.print(",lamps ");
                r.get(i).describeLamp();
            }
            if(r.get(i).getamountofwindow()>4) {
                System.out.print("(" + r.get(i).getamountofwindow() + " window");
                System.out.print(",lamps ");
                r.get(i).describeLamp();
            }
            System.out.println("\nSquare of room = " + r.get(i).getsquareofroom());
            System.out.println("Square of furniture = " + r.get(i).getsquarelimit());
            System.out.println("Furniture: ");
            r.get(i).describeFurniture();
            System.out.println();
        }

    }

}
