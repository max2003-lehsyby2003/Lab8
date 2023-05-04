
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Student /*implements Serializable*/ {
    private static int count = 0;
    private int id;
    private String famil;
    private String imy;
    private String batkiv;
    private LocalDate dataNarodg;
    private String adress;
    private String fakul;
    private String grupa;
    private String telefon;
    private int kurs;

    public Student(String famil, String imy, String batkiv, LocalDate dataNarodg, String adress, String fakul, String grupa, String telefon, int kurs) {
        count++;
        this.id = count;
        this.famil = famil;
        this.imy = imy;
        this.batkiv = batkiv;
        this.dataNarodg = dataNarodg;
        this.adress = adress;
        this.fakul = fakul;
        this.grupa = grupa;
        this.telefon = telefon;
        this.kurs = kurs;
    }
    public Student() {

    }

    @Override
    public String toString() {
        return "Student: " +
                "id= |" + id +'|'+
                ", famil= |" + famil + '|' +
                ", imy= |" + imy + '|' +
                ", batkiv= |" + batkiv + '|' +
                ", dataNarodg= |" + dataNarodg +'|' +
                ", adress= |" + adress + '|' +
                ", fakul= |" + fakul + '|' +
                ", grupa= |" + grupa + '|' +
                ", telefon= |" + telefon + '|' +
                ", kurs= |" + kurs;
    }


    public int getId() {
        return id;
    }

    public String getFamil() {
        return famil;
    }

    public String getImy() {
        return imy;
    }

    public String getBatkiv() {
        return batkiv;
    }

    public LocalDate getDataNarodg() {
        return dataNarodg;
    }

    public String getAdress() {
        return adress;
    }

    public String getFakul() {
        return fakul;
    }

    public String getGrupa() {
        return grupa;
    }

    public String getTelefon() {
        return telefon;
    }

    public int getKurs() {
        return kurs;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFamil(String famil) {
        this.famil = famil;
    }

    public void setImy(String imy) {
        this.imy = imy;
    }

    public void setBatkiv(String batkiv) {
        this.batkiv = batkiv;
    }

    public void setDataNarodg(LocalDate dataNarodg) {
        this.dataNarodg = dataNarodg;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setFakul(String fakul) {
        this.fakul = fakul;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setKurs(int kurs) {
        this.kurs = kurs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                kurs == student.kurs &&
                Objects.equals(famil, student.famil) &&
                Objects.equals(imy, student.imy) &&
                Objects.equals(batkiv, student.batkiv) &&
                Objects.equals(dataNarodg, student.dataNarodg) &&
                Objects.equals(adress, student.adress) &&
                Objects.equals(fakul, student.fakul) &&
                Objects.equals(grupa, student.grupa) &&
                Objects.equals(telefon, student.telefon);
    }



    @Override
    public int hashCode() {
        return Objects.hash(id, famil, imy, batkiv, dataNarodg, adress, fakul, grupa, telefon, kurs);
    }


    public static Student  parse (String str){
        String[] ar = str.split("\\|");

        int kurs = Integer.parseInt(ar[19]);
        LocalDate date= LocalDate.parse(ar[9]) ;
        return new Student(ar[3], ar[5], ar[7], date , ar[11], ar[13], ar[15], ar[17], kurs);
    }

}
