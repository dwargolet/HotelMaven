package hotel.model;

/**
 *
 * @author Daniel
 */
public interface DAOInterface {      
    public abstract void setDb(DB_AccessorStrategy db);
    public abstract DB_AccessorStrategy getDb();
}
