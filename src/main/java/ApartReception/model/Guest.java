package ApartReception.model;

import javax.persistence.*;
@Entity(name = "tguest")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private GuestRegister guestRegister;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false, unique = true)
    private String passportNumber;
    @Column(nullable = false)
    private String startVisit;
    @Column(nullable = false)
    private String endVisit;
    @Column(nullable = false)
    private Integer visitDayCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GuestRegister getGuestRegister() {
        return guestRegister;
    }

    public void setGuestRegister(GuestRegister guestRegister) {
        this.guestRegister = guestRegister;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getStartVisit() {
        return startVisit;
    }

    public void setStartVisit(String startVisit) {
        this.startVisit = startVisit;
    }

    public String getEndVisit() {
        return endVisit;
    }

    public void setEndVisit(String endVisit) {
        this.endVisit = endVisit;
    }

    public Integer getVisitDayCount() {
        return visitDayCount;
    }

    public void setVisitDayCount(Integer visitDayCount) {
        this.visitDayCount = visitDayCount;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", guestRegister=" + guestRegister +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", startVisit='" + startVisit + '\'' +
                ", endVisit='" + endVisit + '\'' +
                ", visitDayCount=" + visitDayCount +
                '}';
    }

    public enum GuestRegister {
        YES,
        NO
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Guest) {
            Guest b = (Guest) o;
            return b.id == this.id;

        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}
