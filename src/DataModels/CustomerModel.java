
package DataModels;

public class CustomerModel extends BaseDataModel{
    private String _customerName;
    private int _active;

    public String getCustomerName() {
        return _customerName;
    }

    public void setCustomerName(String _customerName) {
        this._customerName = _customerName;
    }

    public int getActive() {
        return _active;
    }

    public void setActive(int _active) {
        this._active = _active;
    }
    
}
