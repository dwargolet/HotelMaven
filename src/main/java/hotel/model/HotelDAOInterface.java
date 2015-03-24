
package hotel.model;

import java.util.List;

/**
 *
 * @author dworgolet
 */
public interface HotelDAOInterface extends DAOInterface {
    
//    public abstract Hotel getHotelById(int hotelId)throws Exception; 
    public abstract List<Hotel> findAllHotels();
    public abstract int deleteHotelRecord(int pk);
    public abstract int updateHotelRecord(int pk, String colName, String values);
    public abstract int insertHotelRecord(List<String> colNames, List values);
}
