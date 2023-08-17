package ibm.site.flightmanagement.flightticketservice.service;

import ibm.site.flightmanagement.flightticketservice.vo.BookVO;
import ibm.site.flightmanagement.flightticketservice.vo.HotelVO;

import java.util.List;

public interface IBookService {
    /**
     * 查询预定信息
     * @param hotelName
     * @return
     */
    public List<BookVO> queryBookList(String hotelName);

    /**
     * 查询酒店信息
     * @return
     */
    public List<HotelVO> queryHotelList();

    /**
     * 新增酒店预定信息
     * @param hotelNo
     * @param roomType
     * @param bookDateStart
     * @param bookDateEnd
     */
    public void save(String hotelNo, String roomType, String bookDateStart, String bookDateEnd);

    /**
     * 删除酒店预定信息
     * @param bookNo
     */
    public void delete(String bookNo);
}
