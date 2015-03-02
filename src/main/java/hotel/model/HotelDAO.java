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
//    private String url;
//    private String driver;
//    private String username;       
//    private String password;
            
    public HotelDAO() {
    }

     public HotelDAO(DB_AccessorStrategy db) {
        this.db = db;
    }
    
//    public HotelDAO(DB_Accessor db, String url, String driver, String username, String password) {
//        this.db = db;
//        this.url = url;
//        this.driver = driver;
//        this.username = username;
//        this.password = password;
//    }
    
    
       
    @Override
    public Hotel getHotelById(int hotelId)throws Exception{
        db.openConnection();
        String table = "HOTEL";
        String pk = "hotel_id";
        Map r = null;
        
        
        try {            
            r = db.getRecordByID(table, hotelId, pk);
        } catch (SQLException e) {
            throw new SQLException(e.getMessage(), e);
        } catch (Exception e2){
            throw new Exception(e2.getMessage(), e2);
        }
        

        
        Hotel h = new Hotel();
        h.setHotelId(Integer.valueOf(r.get("hotel_id").toString()));
        h.setHotelName(r.get("hotel_name").toString());
        h.setStreetAddress(r.get("street_address").toString());
        h.setCity(r.get("city").toString());
        h.setZip(r.get("postal_code").toString());
        
        
        h.setState(r.get("state").toString());
        return h;
        
    }
    
    
    @Override
    public List<Hotel> getAllHotels()throws Exception{
        db.openConnection();

        List<Map<String, Object>> records = db.getRecords("hotel");
        List<Hotel>hotels = new ArrayList<>();
        Hotel h;
        
        
        
        
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
    public int insertHotelRecord(List<String> colNames, List values)throws Exception{
          
        db.openConnection();    
        int updates = db.insertRecord("hotel", colNames, values);
        return updates;
    }
    
    
    @Override
    public int deleteHotelRecord(int pk)throws Exception{
        db.openConnection();
        int updates;
        try{
           updates = db.deleteRecord("Hotel", "hotel_id", pk);
        }catch (SQLException e) {
            throw new SQLException(e.getMessage(), e);
        } catch (Exception e2){
            throw new Exception(e2.getMessage(), e2);
        }
        
        return updates;
    
    }
    
    @Override
    public int updateHotelRecord(int pk, String colNames, String values)throws Exception{       
        int updates;
        db.openConnection();
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
    
    
//    public static void main(String[] args) throws Exception {
//        HotelDAO dao = new HotelDAO();
//
//        
//        List<Hotel> records = dao.getAllHotels();
//        
//        System.out.println("Found Hotel records...\n");
//        System.out.println(records);
//        
//       
//    }
    
    
}
