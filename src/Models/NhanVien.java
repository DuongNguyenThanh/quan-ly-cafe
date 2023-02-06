package Models;

public class NhanVien {
    private int salary;
    private String idStaff, fName, lName, dob, gender, address, pos;
    public NhanVien()
    {
        idStaff = "";
        fName = "";
        lName = "";
        dob = "";
        gender = "";
        address = "";
        salary = 0;
        pos = "";
    }

    public NhanVien(String idStaff, String fName, String lName, String dob, String gender, String address, int salary, String pos) {
        this.salary = salary;
        this.idStaff = idStaff;
        this.fName = fName;
        this.lName = lName;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.pos = pos;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }
    
}