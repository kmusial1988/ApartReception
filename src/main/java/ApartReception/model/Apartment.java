package ApartReception.model;

import javax.persistence.*;

@Entity(name = "tapartment")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private ReadyToRent readyToRent;
    @Column(nullable = false, unique = true)
    private String  number;
    @Column(nullable = false )
    private Integer priceForDay;
    @Column(nullable = false)
    private String bedCount;
    @Column(nullable = false)
    private String roomCount;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;
    @Column(nullable = false)
    /*private String freeData;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ReadyToRent getReadyToRent() {
        return readyToRent;
    }

    public void setReadyToRent(ReadyToRent readyToRent) {
        this.readyToRent = readyToRent;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getPriceForDay() {
        return priceForDay;
    }

    public void setPriceForDay(Integer priceForDay) {
        this.priceForDay = priceForDay;
    }

    public String getBedCount() {
        return bedCount;
    }

    public void setBedCount(String bedCount) {
        this.bedCount = bedCount;
    }

    public String getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(String roomCount) {
        this.roomCount = roomCount;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /*public String getFreeData() {
        return freeData;
    }

    public void setFreeData(String freeData) {
        this.freeData = freeData;
    }*/

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", readyToRent=" + readyToRent +
                ", number='" + number + '\'' +
                ", priceForDay='" + priceForDay + '\'' +
                ", bedCount='" + bedCount + '\'' +
                ", roomCount='" + roomCount + '\'' +
                ", address=" + address +
               /* ", freeData='" + freeData + '\'' +*/
                '}';
    }

    public enum ReadyToRent{
        YES,
        NO
    }

}
