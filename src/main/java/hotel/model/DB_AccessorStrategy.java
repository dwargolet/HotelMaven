package hotel.model;

import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author dworgolet
 * @version 1.00
 */
public interface DB_AccessorStrategy {

public abstract void openConnection() throws Exception;

public abstract void closeConnection() throws SQLException;

public abstract List<Map<String, Object>> getRecords(String table) throws Exception;

public abstract int insertRecord(String table, List<String> colNames, List values)throws Exception;

public abstract int updateRecord(String table, String primaryKey, int pk, String colName, Object value)throws Exception;

public abstract int deleteRecord(String table, String whereString, int pk) throws Exception;

public abstract Map getRecordByID(String table, int pk, Object value) throws Exception;
    
}

    
  
  