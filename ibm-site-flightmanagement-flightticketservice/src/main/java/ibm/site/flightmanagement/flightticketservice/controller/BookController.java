package ibm.site.flightmanagement.flightticketservice.controller;

import ibm.site.flightmanagement.flightticketservice.enumeration.RoomType;
import ibm.site.flightmanagement.flightticketservice.service.IBookService;
import ibm.site.flightmanagement.flightticketservice.vo.BookVO;
import ibm.site.flightmanagement.flightticketservice.vo.HotelVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.math.BigDecimal;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {

    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private IBookService bookService;

    /**
     * 查询酒店预定信息列表
     * @param hotelName
     * @return
     */
    @GetMapping("/queryBookList")
    public List<BookVO> queryBookList(@RequestParam(required = false, name = "hotelName") String hotelName){
        return bookService.queryBookList(hotelName);
    }

    /**
     * 查询酒店信息
     * @return
     */
    @GetMapping("/queryHotelList")
    public List<HotelVO> queryHotelList(){
        return bookService.queryHotelList();
    }

    /**
     * x新增酒店预定
     * @param hotelNo
     * @param roomType
     * @param bookDateStart
     * @param bookDateEnd
     * @return
     */
    @RequestMapping(value = "/save")
    public String save(@RequestParam(required = false, name = "hotelNo") String hotelNo,
                       @RequestParam(required = false, name = "roomType") String roomType,
                       @RequestParam(required = false, name = "bookDateStart") String bookDateStart,
                       @RequestParam(required = false, name = "bookDateEnd") String bookDateEnd){
        bookService.save(hotelNo,roomType,bookDateStart,bookDateEnd);
        return "success";
    }

    /**
     * 删除酒店预定
     * @param bookNo
     * @return
     */
    @RequestMapping(value = "/delete")
    public String delete(@RequestParam(required = true, name = "bookNo") String bookNo){
        bookService.delete(bookNo);
        return "success";
    }
}

