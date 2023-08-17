package ibm.site.flightmanagement.flightticketservice.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class BookVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 预定编号
     */
    private String bookNo;

    /**
     * 酒店名称
     */
    private String hotelName;

    /**
     * 酒店编号
     */
    private String hotelNo;

    /**
     * 房间类型
     */
    private String roomType;

    /**
     * 房间价钱
     */
    private BigDecimal roomPrice;

    /**
     * 预定开始日期
     */
    private String bookDateStart;

    /**
     * 预定结束日期
     */
    private String bookDateEnd;

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public BigDecimal getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(BigDecimal roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getBookDateStart() {
        return bookDateStart;
    }

    public void setBookDateStart(String bookDateStart) {
        this.bookDateStart = bookDateStart;
    }

    public String getBookDateEnd() {
        return bookDateEnd;
    }

    public void setBookDateEnd(String bookDateEnd) {
        this.bookDateEnd = bookDateEnd;
    }

    public String getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(String hotelNo) {
        this.hotelNo = hotelNo;
    }
}
