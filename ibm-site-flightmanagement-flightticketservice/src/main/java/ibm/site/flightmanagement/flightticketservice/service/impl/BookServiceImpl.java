package ibm.site.flightmanagement.flightticketservice.service.impl;

import ibm.site.flightmanagement.flightticketservice.mapper.BookMapper;
import ibm.site.flightmanagement.flightticketservice.service.IBookService;
import ibm.site.flightmanagement.flightticketservice.vo.BookVO;
import ibm.site.flightmanagement.flightticketservice.vo.HotelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookVO> queryBookList(String hotelName) {
        return bookMapper.queryBookList(hotelName);
    }

    @Override
    public List<HotelVO> queryHotelList() {
        return bookMapper.queryHotelList();
    }

    @Override
    public void save(String hotelNo, String roomType, String bookDateStart, String bookDateEnd) {
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("hotelNo",hotelNo);
        //根据hotelNo 加上roomType 查询 room_type_no
        String roomTypeNo = bookMapper.queryRoomTypeNo(hotelNo,roomType);
        paramMap.put("roomTypeNo",roomTypeNo);
        paramMap.put("bookDateStart",bookDateStart);
        paramMap.put("bookDateEnd",bookDateEnd);
        paramMap.put("userNo","00000001");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String bookNo = formatter.format(new Date());
        bookNo +=  (int)((Math.random() * 9 + 1) * 10000);
        paramMap.put("bookNo",bookNo);
        paramMap.put("deleteFlag","1");
        bookMapper.save(paramMap);
    }

    @Override
    public void delete(String bookNo) {
        bookMapper.delete(bookNo);
    }

}
