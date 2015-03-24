package hotel.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class HotelService {
    
    private final HotelDAOInterface dao;
    private DB_AccessorStrategy db;


    
    public HotelService(DB_AccessorStrategy db) {
       dao = new  HotelDAO(db);
    }
    
    
    public void updateHotelRecord(int pk, String field, String value){
        dao.updateHotelRecord(pk, field, value);
    }
    
    
    public void deleteHotelRecord(int pk){
        dao.deleteHotelRecord(pk);
    }
    
    public List<Hotel> findAllHotels(){
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
