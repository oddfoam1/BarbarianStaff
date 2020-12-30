package main.oddfoam.barbarianstaff.util;

public enum Mode {


    DEFAULT(0, "Default"),
    STAFF(1, "Staff"),
    ADMIN(2, "Admin");

    private String Name;

    private int index;

    Mode(int index, String Name) {

        this.Name = Name;

        this.index = index;


    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}
