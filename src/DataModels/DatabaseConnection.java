package DataModels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabaseConnection {
    private static final String queryVerifyUser = "SELECT active FROM user WHERE userName=? AND password=?";
    private static final String queryGetAllUsers = "SELECT * FROM user";
    private static final String queryGetAllAppointments = "SELECT title, description, contact, customerName, url, location, start, end, type FROM appointment a JOIN customer c on a.customerid = c.customerid;";
    private static final String queryGetMatchingAppointments = "SELECT title, description, contact, customerName, url, location, start, end, type FROM appointment a JOIN customer c on a.customerid = c.customerid WHERE title LIKE ?";  
    private static final String queryGetWeeklyView = "SELECT title, description, contact, customerName, url, location, start, end, type FROM appointment a JOIN customer c on a.customerid = c.customerid LIMIT 7";
    private static final String queryGetMonthlyView = "SELECT title, description, contact, customerName, url, location, start, end, type FROM appointment a JOIN customer c on a.customerid = c.customerid LIMIT 30";
    private static final String queryGetAllCustomers = "SELECT customerId, customerName, active, address, address2, ci.city as 'city', postalCode, phone, co.country as 'country' FROM customer c LEFT JOIN address a ON c.addressid = a.addressId LEFT JOIN city ci ON ci.cityId = a.cityId LEFT JOIN country co ON co.countryId = ci.countryId";
    private static final String queryGetMatchingCustomers = "SELECT customerId, customerName, active, address, address2, a.addressId as 'addressId', ci.city as 'city', postalCode, phone, co.country as 'country' FROM customer c LEFT JOIN address a ON c.addressid = a.addressId LEFT JOIN city ci ON ci.cityId = a.cityId LEFT JOIN country co ON co.countryId = ci.countryId where customerName like ?";  
    private static final String queryGetAllCities = "SELECT * FROM city";
    private static final String queryGetCityById = "SELECT * FROM city WHERE cityId = ?";
    private static final String queryInsertNewCountry = "INSERT INTO country (country, createDate, createdBy, lastUpdate, lastUpdateBy) VALUES (?, ?, ?, ?, ?);";  
    private static final String queryInsertNewCity = "INSERT INTO city (city, countryId, createDate, createdBy, lastUpdate, lastUpdateBy) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String queryInsertNewCustomer = "INSERT INTO customer (customerName, AddressId, active, createDate, createdBy, lastUpdate, lastUpdateBy) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String queryUpdateCustomer = "Update customer SET customerName = ?, AddressId = ?, active = ?, lastUpdate = ?, lastUpdateBy = ? WHERE customerId = ?;";
    private static final String queryGetCountryById = "SELECT country FROM country WHERE countryId = ?;";
    private static final String queryGetCityIdByName = "SELECT cityId FROM city WHERE city = ?;";
    private static final String queryGetLatestCityId = "SELECT cityId FROM city ORDER BY cityId DESC LIMIT 1;";
    private static final String queryGetLatestCustomerId = "SELECT customerId FROM customer ORDER BY customerId DESC LIMIT 1;";
    private static final String queryGetLatestAddressId = "SELECT addressId FROM address ORDER BY addressId DESC LIMIT 1;";
    private static final String queryInsertNewAddress = "INSERT INTO address (address, address2, cityId, postalCode, phone, createDate, createdBy, lastUpdate, lastUpdateBy) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";  
    private static final String queryUpdateAddress = "UPDATE address SET address = ?, address2 = ?, cityId = ?, postalCode = ?, phone = ?, lastUpdate = ?, lastUpdateBy = ? WHERE addressId = ?;";  
    private static final String queryGetAddressById = "SELECT * FROM address WHERE addressId = ?";
    private static final String queryDeleteCustomer = "DELETE FROM customer WHERE customerId = ?";
    private static final String queryDeleteAddress = "DELETE FROM address WHERE addressId = ?";
    
    private static Connection conn = null;

    public static void SetupConnection() {
        final String DB_URL = "jdbc:mysql://52.206.157.109/U03u7K";
        final String DBUSER = "U03u7K";
        final String DBPASS = "53688087006";
        try {
                Class.forName("com.mysql.jdbc.Driver");

                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL, DBUSER, DBPASS);
        } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
        } catch (SQLException ex) {
                ex.printStackTrace();

        }
    }
        
    public static boolean VerifyUser(String userName, String password){
        try{
            PreparedStatement statement = conn.prepareStatement(queryVerifyUser);
            statement.setString(1, userName);
            statement.setString(2, password);

            ResultSet results = statement.executeQuery();


            if (results.next() && results.getByte("active") == 1){
                return true;
            } else {
                return false;
            }
        //TODO: Log statement
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }        
        
    }

    public static ObservableList<UserModel> getAllUsers(){
        ObservableList<UserModel> users = FXCollections.observableArrayList();
        try{
            PreparedStatement statement = conn.prepareStatement(queryGetAllUsers);
            ResultSet results = statement.executeQuery();
            while (results.next()){
                UserModel user = new UserModel();
                user.setUserId(results.getInt("userId"));
                user.setUserName(results.getString("userName"));
                users.add(user);
            };
        } catch (Exception e){
            e.printStackTrace();
        }
        return users;        
    }
    
    public static ObservableList<CustomerModel> getAllCustomers(){
        ObservableList<CustomerModel> customers = FXCollections.observableArrayList();
        try{
            PreparedStatement statement = conn.prepareStatement(queryGetAllCustomers);
            ResultSet results = statement.executeQuery();
            while (results.next()){
                CustomerModel customer = new CustomerModel();
                customer.setCustomerId(results.getInt("customerId"));
                customer.setCustomerName(results.getString("customerName"));
                customer.setActive(results.getInt("active"));
                customer.setPhone(results.getString("phone"));
                String addressValue = String.join(" ", results.getString("address"), results.getString("city"), results.getString("postalCode"), results.getString("country"));
                customer.setAddress(addressValue);
                customers.add(customer);
            };
        } catch (Exception e){
            e.printStackTrace();
        }
        return customers;        
    }
    
    public static ObservableList<CustomerModel> getAllMatchingCustomerNames(String nameToSearch){
        ObservableList<CustomerModel> customers = FXCollections.observableArrayList();
        try{
            PreparedStatement statement = conn.prepareStatement(queryGetMatchingCustomers);
            statement.setString(1, "%" + nameToSearch + "%");
            ResultSet results = statement.executeQuery();
            while (results.next()){
                CustomerModel customer = new CustomerModel();
                customer.setCustomerId(results.getInt("customerId"));
                customer.setCustomerName(results.getString("customerName"));
                customer.setActive(results.getInt("active"));
                customer.setPhone(results.getString("phone"));
                String addressValue = String.join(" ", results.getString("address"), results.getString("city"), results.getString("postalCode"), results.getString("country"));
                customer.setAddress(addressValue);
                customer.setAddressId(results.getInt("addressId"));
                customers.add(customer);
            };
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return customers;        
    }
    
     public static ObservableList<CityModel> getAllCities(){
        ObservableList<CityModel> cities = FXCollections.observableArrayList();
        try{
            PreparedStatement statement = conn.prepareStatement(queryGetAllCities);
            ResultSet results = statement.executeQuery();
            while (results.next()){
                CityModel city = new CityModel();
                city.setCity(results.getString("city"));
                city.setCountryId(results.getInt("countryId"));
                cities.add(city);
            };
            
        } catch (Exception e){
            e.printStackTrace();
        }
        return cities;        
    }
    
    public static int insertNewAddress(AddressModel address){
        try{
            PreparedStatement statement = conn.prepareStatement(queryInsertNewAddress);
            statement.setString(1, address.getAddress());
            statement.setString(2, address.getAddress2());
            statement.setInt(3, address.getCityId());
            statement.setString(4, address.getPostalCode());
            statement.setString(5, address.getPhone());
            statement.setString(6, address.getCreateDate().toString());
            statement.setString(7, address.getCreatedBy());
            statement.setString(8, address.getLastUpdate().toString());
            statement.setString(9, address.getLastUpdateBy());
            statement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }       
        return getLatestAddressId();
    }
    
    public static void updateAddress(AddressModel address){
        try{
            PreparedStatement statement = conn.prepareStatement(queryUpdateAddress);
            statement.setString(1, address.getAddress());
            statement.setString(2, address.getAddress2());
            statement.setInt(3, address.getCityId());
            statement.setString(4, address.getPostalCode());
            statement.setString(5, address.getPhone());
            statement.setString(6, address.getLastUpdate().toString());
            statement.setString(7, address.getLastUpdateBy());
            statement.setInt(8, address.getAddressId());
            statement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }       
    }
    
    public static AddressModel getAddressById(int addressId) {
        AddressModel address = new AddressModel();
        try{
            PreparedStatement statement = conn.prepareStatement(queryGetAddressById);
            statement.setInt(1, addressId);
            ResultSet results = statement.executeQuery();
            while (results.next()){
                address.setAddressId(results.getInt("addressId"));
                address.setAddress(results.getString("address"));
                address.setAddress2(results.getString("address2"));
                address.setCityId(results.getInt("cityId"));
                address.setPostalCode(results.getString("postalCode"));
                address.setPhone(results.getString("phone"));
            };
        } catch (Exception e){
            e.printStackTrace();
        }     
        return address;
    }
    
    private static int getLatestAddressId(){
        int addressId = 0;
        try{
            PreparedStatement statement = conn.prepareStatement(queryGetLatestAddressId);
            ResultSet results = statement.executeQuery();
            while (results.next()){
                addressId = results.getInt("addressId");
            };
        } catch (Exception e){
            e.printStackTrace();
        }     
        return addressId;
    }
    
    public static int insertNewCustomer(CustomerModel customer){
        try{
            PreparedStatement statement = conn.prepareStatement(queryInsertNewCustomer);
            statement.setString(1, customer.getCustomerName());
            statement.setInt(2, customer.getAddressId());
            statement.setInt(3, customer.getActive());
            statement.setString(4, customer.getCreateDate().toString());
            statement.setString(5, customer.getCreatedBy());
            statement.setString(6, customer.getLastUpdate().toString());
            statement.setString(7, customer.getLastUpdateBy());
            statement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }       
        return getLatestCustomerId();
    }
    
    public static void updateCustomer(CustomerModel customer){
        try{
            PreparedStatement statement = conn.prepareStatement(queryUpdateCustomer);
            statement.setString(1, customer.getCustomerName());
            statement.setInt(2, customer.getAddressId());
            statement.setInt(3, customer.getActive());
            statement.setString(4, customer.getLastUpdate().toString());
            statement.setString(5, customer.getLastUpdateBy());
            statement.setInt(6, customer.getCustomerId());
            statement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
     
    public static void deleteAddress(int addressId){
        
        try{
            PreparedStatement statement = conn.prepareStatement(queryDeleteAddress);
            statement.setInt(1, addressId);
            statement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void deleteCustomer(int customerId){
        
        try{
            PreparedStatement statement = conn.prepareStatement(queryDeleteCustomer);
            statement.setInt(1, customerId);
            statement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
            
    private static int getLatestCustomerId(){
        int customerId = 0;
        try{
            PreparedStatement statement = conn.prepareStatement(queryGetLatestCustomerId);
            ResultSet results = statement.executeQuery();
            while (results.next()){
                customerId = results.getInt("customerId");
            };
        } catch (Exception e){
            e.printStackTrace();
        }     
        return customerId;
    }
    
    public static int getCityIdByName(String cityName){
        int cityId = 0;
        try{
            PreparedStatement statement = conn.prepareStatement(queryGetCityIdByName);
            statement.setString(1, cityName);
            ResultSet results = statement.executeQuery();
            while (results.next()){
                cityId = results.getInt("cityId");
            };
        } catch (Exception e){
            e.printStackTrace();
        }     
        return cityId;
    }
    
    public static CityModel getCityById(int cityId) {
        CityModel city = new CityModel();
        try{
            PreparedStatement statement = conn.prepareStatement(queryGetCityById);
            statement.setInt(1, cityId);
            ResultSet results = statement.executeQuery();
            while (results.next()){
                city.setCityId(results.getInt("cityId"));
                city.setCity(results.getString("city"));
                city.setCountryId(results.getInt("countryId"));
            };
        } catch (Exception e){
            e.printStackTrace();
        }     
        return city;
    }
    
    public static ObservableList<String> GetCountryById(int countryId){
        ObservableList<String> countryName = FXCollections.observableArrayList();
        try{
            PreparedStatement statement = conn.prepareStatement(queryGetCountryById);
            statement.setInt(1, countryId);
            ResultSet results = statement.executeQuery();
            while (results.next()){
                String country = results.getString("country");
                countryName.add(country);
            };
        } catch (Exception e){
            e.printStackTrace();
        }     
        return countryName;
    }
    
    public static ObservableList<AppointmentModel> getWeeklyCalendarView(){
        ObservableList<AppointmentModel> appointments = FXCollections.observableArrayList();
        try{
            PreparedStatement statement = conn.prepareStatement(queryGetWeeklyView);
            ResultSet results = statement.executeQuery();
            while (results.next()){
                AppointmentModel appointment = new AppointmentModel();
                appointment.setTitle(String.join(" ", results.getString("title"), "-", results.getString("description")));
                appointment.setContact(results.getString("contact"));
                appointment.setCustomerName(results.getString("customerName"));
                appointment.setLocation(String.join(" ", results.getString("location"), "--", "Start", results.getTimestamp("start").toString(), "-", "End", results.getTimestamp("end").toString(), "--", results.getString("url")));
                appointment.setType(results.getString("type"));
                appointments.add(appointment);
            };
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return appointments;        
    }
    
    public static ObservableList<AppointmentModel> getMonthlyCalendarView(){
        ObservableList<AppointmentModel> appointments = FXCollections.observableArrayList();
        try{
            PreparedStatement statement = conn.prepareStatement(queryGetMonthlyView);
            ResultSet results = statement.executeQuery();
            while (results.next()){
                AppointmentModel appointment = new AppointmentModel();
                appointment.setTitle(String.join(" ", results.getString("title"), "-", results.getString("description")));
                appointment.setContact(results.getString("contact"));
                appointment.setCustomerName(results.getString("customerName"));
                appointment.setLocation(String.join(" ", results.getString("location"), "--", "Start", results.getTimestamp("start").toString(), "-", "End", results.getTimestamp("end").toString(), "--", results.getString("url")));
                appointment.setType(results.getString("type"));
                appointments.add(appointment);
            };
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return appointments;        
    }
    
    public static ObservableList<AppointmentModel> getAllAppointments(){
        ObservableList<AppointmentModel> appointments = FXCollections.observableArrayList();
        try{
            PreparedStatement statement = conn.prepareStatement(queryGetAllAppointments);
            ResultSet results = statement.executeQuery();
            while (results.next()){
                AppointmentModel appointment = new AppointmentModel();
                appointment.setTitle(String.join(" ", results.getString("title"), "-", results.getString("description")));
                appointment.setContact(results.getString("contact"));
                appointment.setCustomerName(results.getString("customerName"));
                appointment.setLocation(String.join(" ", results.getString("location"), "--", "Start", results.getTimestamp("start").toString(), "-", "End", results.getTimestamp("end").toString(), "--", results.getString("url")));
                appointment.setType(results.getString("type"));
                appointments.add(appointment);
            };
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return appointments;        
    }
    
    public static ObservableList<AppointmentModel> getAllMatchingAppointmentTitles(String nameToSearch){
        ObservableList<AppointmentModel> appointments = FXCollections.observableArrayList();
        try{
            PreparedStatement statement = conn.prepareStatement(queryGetMatchingAppointments);
            statement.setString(1, "%" + nameToSearch + "%");
            ResultSet results = statement.executeQuery();
            while (results.next()){
                AppointmentModel appointment = new AppointmentModel();
                appointment.setTitle(String.join(" ", results.getString("title"), "-", results.getString("description")));
                appointment.setContact(results.getString("contact"));
                appointment.setCustomerName(results.getString("customerName"));
                appointment.setLocation(String.join(" ", results.getString("location"), "--", "Start", results.getTimestamp("start").toString(), "-", "End", results.getTimestamp("end").toString(), "--", results.getString("url")));
                appointment.setType(results.getString("type"));
                appointments.add(appointment);
            };
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return appointments;        
    }
}
