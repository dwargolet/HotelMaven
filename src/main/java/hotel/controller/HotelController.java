package hotel.controller;

import hotel.model.Hotel;
import hotel.model.DB_AccessorStrategy;
import hotel.model.DB_Mysql;
import hotel.model.HotelDAO;
import hotel.model.HotelService;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;
import listener.HotelSessionListener;

/**
 *
 * @author Daniel
 */
public class HotelController extends HttpServlet {
   private static String RESULT_PAGE = "/Views/database.jsp";  
   private static final String ACTION_DELETE = "delete";
   private static final String ACTION_EDIT = "edit";
   private static final String ACTION_CREATE = "create";
   
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        HotelSessionListener sl = new HotelSessionListener();
        
        
//        String driver = request.getServletContext().getInitParameter("driver");
//        String url = request.getServletContext().getInitParameter("url");
//        String password = request.getServletContext().getInitParameter("password");        
//        String username = request.getServletContext().getInitParameter("userName");
//        String dbStrat = request.getServletContext().getInitParameter("dbStrategy");
//        
//        
//        
//        String name;
//        String address;
//        String city;
//        String state;
//        String zip;
//        String notes;
//        
//        Class cons = Class.forName(dbStrat);
//        Constructor constructor = cons.getConstructor(new Class[]{String.class,String.class,String.class,String.class});
//        DB_AccessorStrategy db = (DB_AccessorStrategy)constructor.newInstance(driver,url,username,password);
//        
//        HotelService hs = new HotelService(db);
//        
//        
//        RequestDispatcher view;
//        String action = request.getParameter("action");
//
//        
//        
//        if(request.getParameter("action") != null){
//            if(action.equals(ACTION_CREATE))
//            {
//                
////                name = request.getParameter("hotelName");
////                address = request.getParameter("hotelAddress");
////                city = request.getParameter("hotelCity");
////                zip = request.getParameter("hotelZip");
////                state = request.getParameter("hotelState");
////                notes = request.getParameter("hotelNote");
//                Hotel h = new Hotel();
//                
//                h.setHotelName(request.getParameter("hotelName"));
//                request.setAttribute("hotelName", "test");
//                h.setCity(request.getParameter("hotelCity"));
//                h.setState(request.getParameter("hotelState"));
//                h.setZip(request.getParameter("hotelZip"));
//                h.setStreetAddress(request.getParameter("hotelAddress"));
//         
//                h.setNotes(request.getParameter("hotelNote"));
//                
//                hs.insertHotelRecord(h);
////                List<String> colNames = new ArrayList<>();
////                List values = new ArrayList();
//                
////                colNames.add("hotel_name");
////                colNames.add("street_address");
////                colNames.add("city");
////                colNames.add("state");
////                colNames.add("postal_code");
////                colNames.add("notes");
////
////                values.add(name);
////                values.add(address);
////                values.add(city);
////                values.add(state);
////                values.add(zip);
////                values.add(notes);
////                
////                hs.insertHotelRecord(colNames, values);
//            }
//        else if(action.equals(ACTION_DELETE))
//            {
//                String stringPk = request.getParameter("hotelId");
//                int pk = Integer.parseInt(stringPk); 
//                hs.deleteHotelRecord(pk);
//            }
//        else if(action.equals(ACTION_EDIT))
//            {
//                String stringPk = request.getParameter("hotelId");
//                int pk = Integer.parseInt(stringPk);
//
//                name = request.getParameter("hotelName");
//                address = request.getParameter("hotelAddress");
//                city = request.getParameter("hotelCity");
//                zip = request.getParameter("hotelZip");
//                state = request.getParameter("hotelState");
//                notes = request.getParameter("hotelNote");
//                
//                hs.updateHotelRecord(pk, "hotel_name", name);
//                hs.updateHotelRecord(pk, "street_address", address);
//                hs.updateHotelRecord(pk, "city", city);
//                hs.updateHotelRecord(pk, "state", state);
//                hs.updateHotelRecord(pk, "postal_code", zip);
//                hs.updateHotelRecord(pk, "notes", notes);     
//            }
//            
//        view = request.getRequestDispatcher(RESULT_PAGE);
//        view.forward(request, response);
//        
//        }
        String username = request.getServletContext().getInitParameter("username");
        String password = request.getServletContext().getInitParameter("password");
        String url = request.getServletContext().getInitParameter("url");
        String driver = request.getServletContext().getInitParameter("driver");
        
        
        String name;
        String address;
        String city;
        String state;
        String zip;
        String notes;
                     
        
        DB_AccessorStrategy db = new DB_Mysql();
        HotelDAO dao = new HotelDAO(db, url, driver,username, password);
        RequestDispatcher view;
        
        String action = request.getParameter("action");

        if(request.getParameter("action") != null){
            if(action.equals(ACTION_CREATE))
            {
                
                name = request.getParameter("hotelName");
                address = request.getParameter("hotelAddress");
                city = request.getParameter("hotelCity");
                zip = request.getParameter("hotelZip");
                state = request.getParameter("hotelState");
                notes = request.getParameter("hotelNote");
                
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
        else if(action.equals(ACTION_DELETE))
            {
                String stringPk = request.getParameter("hotelId");
                int pk = Integer.parseInt(stringPk); 
                dao.deleteHotelRecord(pk);
            }
        else if(action.equals(ACTION_EDIT))
            {
                String stringPk = request.getParameter("hotelId");
                int pk = Integer.parseInt(stringPk);

                name = request.getParameter("hotelName");
                address = request.getParameter("hotelAddress");
                city = request.getParameter("hotelCity");
                zip = request.getParameter("hotelZip");
                state = request.getParameter("hotelState");
                notes = request.getParameter("hotelNote");
                
                dao.updateHotelRecord(pk, "hotel_name", name);
                dao.updateHotelRecord(pk, "street_address", address);
                dao.updateHotelRecord(pk, "city", city);
                dao.updateHotelRecord(pk, "state", state);
                dao.updateHotelRecord(pk, "postal_code", zip);
                dao.updateHotelRecord(pk, "notes", notes);     
            }
        }
                List<Hotel> records = dao.findAllHotels();
                request.setAttribute("hotelList", records);
                
                String sessionCount = Integer.toString(sl.getTotalSessions());
                request.setAttribute("activeSessionCount", sessionCount);
                
                view = request.getRequestDispatcher(RESULT_PAGE);
        
                view.forward(request, response);
    }
        
   
 // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           processRequest(request, response);
       } catch (Exception ex) {
           Logger.getLogger(HotelController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           processRequest(request, response);
       } catch (Exception ex) {
           Logger.getLogger(HotelController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
