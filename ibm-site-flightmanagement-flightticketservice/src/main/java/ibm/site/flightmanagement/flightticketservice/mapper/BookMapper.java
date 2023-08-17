package ibm.site.flightmanagement.flightticketservice.mapper;

import ibm.site.flightmanagement.flightticketservice.vo.BookVO;
import ibm.site.flightmanagement.flightticketservice.vo.HotelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {

    public List<BookVO> queryBookList(@Param("hotelName") String hotelName);

    public  List<HotelVO> queryHotelList();

    public void save(Map<String, String> paramMap);

    public String queryRoomTypeNo(@Param("hotelNo") String hotelNo, @Param("roomType")String roomType);

    public void delete(@Param("bookNo") String bookNo);
}
