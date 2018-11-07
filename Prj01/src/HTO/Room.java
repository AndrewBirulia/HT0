package HTO;

import java.util.ArrayList;

public class Room {
	
    private String nameofroom;
    private int amountofwindow;
    private int squarebounds;
    private int illumination;
    private int squareofroom;
    private final int illuminationmin = 300;
    private final int illuminationmax = 4000;
    private ArrayList<Lamp> l = new ArrayList<>();
    private ArrayList<Item> f = new ArrayList<>();
    public Room(String nameOfRoom, int squareOfRoom, int numberOfWindow) {
        this.nameofroom = nameOfRoom;
        this.squareofroom = squareOfRoom;
        this.amountofwindow = numberOfWindow;
        this.illumination += numberOfWindow * 700;
    }

    public String getnameofroom() {
        return nameofroom;
    }

    public void setnameofroom(String nameofroom) {
        this.nameofroom = nameofroom;
    }

    public float getsquareofroom() {
        return squareofroom;
    }

    public void setsquareofroom(int squareoflimit) {
        this.squareofroom = squareoflimit;
    }

    public int getamountofwindow() {
        return amountofwindow;
    }

    public void setamountofwindow(int amountofwindow) {
        this.amountofwindow = amountofwindow;
    }

    public int getillumination() {
        return illumination;
    }

    public float getsquarelimit() {
        return squarebounds;
    }
    public void add(Lamp lamp) {
        l.add(lamp);
        this.illumination += lamp.getIllumination();
    }

    public void add(Table table) {
        this.squarebounds += table.getSQUARE();
        f.add(table);
    }
    public void add(Sofa sofa) {
        this.squarebounds += sofa.getSQUARE();
        f.add(sofa);
    }
    public void checkLamp() throws NotEnoughIlluminanceException, IlluminanceTooMuchException {
        if (this.illumination < illuminationmin) {
            throw new NotEnoughIlluminanceException("Not enough illuminance");
        }
        if (this.illumination > illuminationmax) {
            throw new IlluminanceTooMuchException("Too much illuminance");
        }
    }

    public void describeLamp() {
        for (int i = 0; i < l.size(); i++) {
            if(i != l.size()-1)
            System.out.print(l.get(i).getIllumination() + ", ");
            if(l.size() - 1 == i){
                System.out.print(l.get(i).getIllumination() + ") ");
            }
        }
    }
    public void describeFurniture() {
        if(f.size()==0){
            System.out.println("There is no furniture");
        }
        for (int i = 0; i < f.size(); i++) {
            System.out.print(f.get(i).getNAME() + " " + f.get(i).getSQUARE() + "ì^2"+ "\n");
        }
    }
    public void checkSquare() throws SpaceUsageTooMuchException {
        if (this.squareofroom * 0.7 < this.squarebounds) {
            throw new SpaceUsageTooMuchException("Too much square");
        }
    }

   




}
