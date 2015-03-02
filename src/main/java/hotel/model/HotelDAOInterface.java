
package hotel.model;

import java.util.List;

/**
 *
 * @author dworgolet
 */
public interface HotelDAOInterface extends DAOInterface {
    
    public abstract Hotel getHotelById(int hotelId)throws Exception;
    public abstract List<Hotel> getAllHotels()throws Exception;
    public abstract int deleteHotelRecord(int pk, String colNames, String values)throws Exception;
    public abstract int updateHotelRecord(int pk, String colName, String values)throws Exception;
    public abstract int insertHotelRecord(List<String> colNames, List values)throws Exception;       
}
