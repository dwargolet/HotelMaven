
package hotel.model;

//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author Daniel
// */
//public class HotelService {
//    
//   // private HotelDAOInterface dao;
//    private HotelDAOInterface dao;
////    private DB_AccessorStrategy db;
////    private String url;
////    private String driver;
////    private String username;       
////    private String password;
//    
//    public HotelService(DB_AccessorStrategy db){
//        dao = new HotelDAO(db);
//    }
////    public HotelService(DB_Accessor db, String url, String driver, String username, String password) {
////        this.db = db;
////        this.url = url;
////        this.driver = driver;
////        this.username = username;
////        this.password = password;
////    }
//
//    
////    public HotelService(HotelDAOInterface dao) {
////        this.dao = dao;
////    }
//    
////    public HotelService(HotelDAOInterface dao) {
////        this.dao = dao;
////    }
//    
//    
//    public void updateHotelRecord(int pk, String field, String value)throws Exception{
//        dao.updateHotelRecord(pk, field, value);
//    }
//    
//    
//    public void deleteHotelRecord(int pk)throws Exception{
//        dao.deleteHotelRecord(pk);
//    }
//    
//    public List<Hotel> getAllHotels()throws Exception{
//       // List<Hotel>hotels = dao.findAllHotels();
////        for(Hotel h : hotels){
////            System.out.println(h);
////        }
//        return dao.getAllHotels();
//    }
//    
//    public void insertHotelRecord(Hotel hotel)throws Exception{
////        List<String> colNames = new ArrayList<>();
////        List values = new ArrayList();
////        colNames.add("hotel_name");
////        colNames.add("street_address");
////        colNames.add("city");
////        colNames.add("state");
////        colNames.add("postal_code");
////        colNames.add("notes");
////        
////        values.add(name);
////        values.add(address);
////        values.add(city);
////        values.add(state);
////        values.add(zip);
////        values.add(notes);
//                
//        dao.insertHotelRecord(hotel);
//    }
//    
//    public Hotel getHotelById(int hotelId)throws Exception{
//       return dao.getHotelById(hotelId);
//    }
//    
//}

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class HotelService {
    
   // private HotelDAOInterface dao;
    private HotelDAOInterface dao;
    private DB_AccessorStrategy db;
    private String url;
    private String driver;
    private String username;       
    private String password;
    
//    public HotelService(){
//        dao = new HotelDAO(db, url, driver, username, password);
//    }
    public HotelService(DB_AccessorStrategy db, String url, String driver, String username, String password) {
        this.db = db;
        this.url = url;
        this.driver = driver;
        this.username = username;
        this.password = password;
    }

    
//    public HotelService(HotelDAOInterface dao) {
//        this.dao = dao;
//    }
    
//    public HotelService(HotelDAOInterface dao) {
//        this.dao = dao;
//    }
    
    
    public void updateHotelRecord(int pk, String field, String value){
        dao.updateHotelRecord(pk, field, value);
    }
    
    
    public void deleteHotelRecord(int pk){
        dao.deleteHotelRecord(pk);
    }
    
    public List<Hotel> findAllHotels(){
       // List<Hotel>hotels = dao.findAllHotels();
//        for(Hotel h : hotels){
//            System.out.println(h);
//        }
        return dao.findAllHotels();
    }
    
    public void insertHotelRecord(String name, String address, String city, String state,
            String zip, String notes){
        List<String> colNames = new ArrayList<>();
        List values = new ArrayList();
        colNames.add("hotel_name");
        colNames.add("street_address");
        colNames.add("city");
        colNames.add("state");
        colNames.add("postal_code");
        colNames.add("notes");
        
        values.add(name);
        values.add(address);
        values.add(city);
        values.add(state);
        values.add(zip);
        values.add(notes);
                
        dao.insertHotelRecord(colNames, values);
    }
    
//    public static void main(String[] args) {
//        HotelDAOInterface d = new HotelDAO();
//        HotelService h = new HotelService();
//        
//        h.insertHotelRecord("Wutang", "ODB St", "Shaolin", "NY", "12432", "");
//        
//        System.out.println(h.findAllHotels());
//    }
}
