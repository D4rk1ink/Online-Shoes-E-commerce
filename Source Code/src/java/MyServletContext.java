
import connentor.Connector;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContext implements ServletContextListener{
    ServletContext context;
    public void contextInitialized(ServletContextEvent contextEvent) {
        Connector.setConnection("host name", "port", "database name", "database user name", "database password");
    }
    public void contextDestroyed(ServletContextEvent contextEvent) {

        System.out.println("Context Destroyed");
    }
}
