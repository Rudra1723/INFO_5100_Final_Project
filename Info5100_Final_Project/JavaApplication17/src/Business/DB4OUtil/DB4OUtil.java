package Business.DB4OUtil;

import Business.ConfigureASystem;
import Business.EcoSystem;
import Business.Network.Network;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.util.logging.Level;


/**
 *
 * @author rudrapatel
 */
public class DB4OUtil {

    private static final String DATABASE_FILE_PATH = Paths.get("Databank.db4o").toAbsolutePath().toString();
    private static DB4OUtil databaseManagerInstance;
    private static final Logger LOGGER = Logger.getLogger(DB4OUtil.class.getName());
    
    public synchronized static DB4OUtil getInstance(){
        if (databaseManagerInstance == null){
            databaseManagerInstance = new DB4OUtil();
        }
        return databaseManagerInstance;
    }

    protected synchronized static void shutdown(ObjectContainer connection) {
        if (connection != null) {
            connection.close();
        }
    }

    private ObjectContainer createConnection() {
        try {
            EmbeddedConfiguration databaseConfiguration = Db4oEmbedded.newConfiguration();
            databaseConfiguration.common().add(new TransparentPersistenceSupport());
            databaseConfiguration.common().activationDepth(Integer.MAX_VALUE);
            databaseConfiguration.common().updateDepth(Integer.MAX_VALUE);
            databaseConfiguration.common().objectClass(EcoSystem.class).cascadeOnUpdate(true);

            ObjectContainer databaseConnection = Db4oEmbedded.openFile(databaseConfiguration, DATABASE_FILE_PATH);
            return databaseConnection;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Database connection failed: " + ex.getMessage(), ex);
        }
        return null;
    }

    public synchronized void storeSystem(EcoSystem ecoSystem) {
        ObjectContainer databaseConnection = createConnection();
        if (databaseConnection != null) {
            try {
                databaseConnection.store(ecoSystem);
                databaseConnection.commit();
                LOGGER.info("System data stored successfully");
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, "Failed to store system data: " + ex.getMessage(), ex);
            } finally {
                databaseConnection.close();
            }
        }
    }
    
    public EcoSystem retrieveSystem(){
        ObjectContainer databaseConnection = createConnection();
        EcoSystem ecoSystem = null;
        
        if (databaseConnection != null) {
            try {
                ObjectSet<EcoSystem> ecoSystemSet = databaseConnection.query(EcoSystem.class);
                
                if (ecoSystemSet.size() == 0){
                    ecoSystem = ConfigureASystem.configure();
                    storeSystem(ecoSystem); // Store the new system immediately
                    LOGGER.info("New system configuration created and stored");
                } else {
                    ecoSystem = ecoSystemSet.get(ecoSystemSet.size()-1);
                    LOGGER.info("Existing system configuration retrieved successfully");
                }
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, "Failed to retrieve system data: " + ex.getMessage(), ex);
                LOGGER.info("Creating new system configuration due to database error");
                ecoSystem = ConfigureASystem.configure();
                storeSystem(ecoSystem); // Store the new system immediately
            } finally {
                databaseConnection.close();
            }
        } else {
            LOGGER.warning("Database connection failed, creating new system configuration");
            ecoSystem = ConfigureASystem.configure();
        }
        
        return ecoSystem;
    }
    
    public boolean isDatabaseAccessible() {
        ObjectContainer testConnection = createConnection();
        if (testConnection != null) {
            testConnection.close();
            return true;
        }
        return false;
    }
    
    public void clearDatabase() {
        ObjectContainer databaseConnection = createConnection();
        if (databaseConnection != null) {
            try {
                ObjectSet<EcoSystem> ecoSystemSet = databaseConnection.query(EcoSystem.class);
                for (EcoSystem system : ecoSystemSet) {
                    databaseConnection.delete(system);
                }
                databaseConnection.commit();
                LOGGER.info("Database cleared successfully");
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, "Failed to clear database: " + ex.getMessage(), ex);
            } finally {
                databaseConnection.close();
            }
        }
    }
}
