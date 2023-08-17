package ibm.site.flightmanagement.flightticketservice.vo;

import java.io.Serializable;

public class HotelVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 酒店名称
     */
    private String hotelName;

    /**
     * 酒店编号
     */
    private String hotelNo;

    /**
     * 酒店图片url
     */
    private String hotelUrl;


    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(String hotelNo) {
        this.hotelNo = hotelNo;
    }

    public String getHotelUrl() {
        return hotelUrl;
    }

    public void setHotelUrl(String hotelUrl) {
        this.hotelUrl = hotelUrl;
    }
}
