package hotel.model;
import java.sql.DriverManager;
import java.util.*;
import java.sql.SQLException;


/**
 *
 * @author dworgolet
 */
public class HotelDAO implements HotelDAOInterface{

   
    
    private DB_AccessorStrategy db;
    private String url;
    private String driver;
    private String username;       
    private String password;
            
    public HotelDAO() {
    }

    public HotelDAO(DB_AccessorStrategy db) {
        if(db == null){
            throw new IllegalArgumentException();
        } 
        this.db = db;
    }
    
    
    
    
//    
//    @Override
//    public Hotel findHotelById(int hotelId){
//        db.openConnection(driver, url, username, password);
//        
//        Map r;
//        
//
//        r = db.getRecordById("HOTEL", "HOTEL_ID", hotelId);
//
//        
//        Hotel h = new Hotel();
//        h.setHotelId(new Long(r.get("hotel_id").toString()));
//        h.setHotelName(r.get("hotel_name").toString());
//        h.setStreetAddress(r.get("street_address").toString());
//        h.setCity(r.get("city").toString());
//        h.setZip(r.get("postal_code").toString());
//        
//        
//        h.setState(r.get("state").toString());
//        return h;
//        
//    }
    
    
    @Override
    public List<Hotel> findAllHotels(){
        db.openConnection(driver, url, username, password);

        List<Map<String, Object>> records = db.getRecords("hotel");
        List<Hotel>hotels = new ArrayList<>();
        Hotel h = null;
        for(Map m : records){
            h = new Hotel();
            h.setHotelId(Integer.valueOf(m.get("hotel_id").toString()));
            h.setHotelName(m.get("hotel_name").toString());
            h.setStreetAddress(m.get("street_address").toString());
            h.setCity(m.get("city").toString());
            h.setState(m.get("state").toString());
            h.setZip(m.get("postal_code").toString());
            String s = "";
            try{
                s = m.get("notes").toString();
            }catch(NullPointerException e){
                s = "";
            }
            h.setNotes(s);
            hotels.add(h);
        }
        return hotels;
    }
    
    @Override
    public int insertHotelRecord(List<String> colNames, List values){
          
        db.openConnection(driver, url, username, password);    
        int updates = db.insertRecord("hotel", colNames, values);
        return updates;
    }
    
    
    @Override
    public int deleteHotelRecord(int pk){
        db.openConnection(driver, url, username, password);
        int updates = db.deleteRecord("Hotel", "hotel_id", pk);
        
        return updates;
    }

    @Override
    public int updateHotelRecord(int pk, String colNames, String values){
        
        int updates;
        db.openConnection(driver, url, username, password);
        updates = db.updateRecord("hotel", "hotel_id", pk, colNames, values);
   
        return updates;
    }
    
    
    @Override
    public DB_AccessorStrategy getDb() {
        return db;
    }

    @Override
    public void setDb(DB_AccessorStrategy db) {
        this.db = db;
    }
    
    
//    public static void main(String[] args) throws SQLException {
//        HotelDAO dao = new HotelDAO();
//
//        
//        List<Hotel> records = dao.findAllHotels();
//        
//        System.out.println("Found Hotel records...\n");
//        System.out.println(records);
//        
//       
//    }
    
    
}

