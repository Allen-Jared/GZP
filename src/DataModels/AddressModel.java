
package DataModels;

public class AddressModel extends BaseDataModel {
    private String _address;
    private String _address2;
    private String _postalCode;
    private String _phone;

    public String getAddress() {
        return _address;
    }

    public void setAddress(String _address) {
        this._address = _address;
    }

    public String getAddress2() {
        return _address2;
    }

    public void setAddress2(String _address2) {
        this._address2 = _address2;
    }

    public String getPostalCode() {
        return _postalCode;
    }

    public void setPostalCode(String _postalCode) {
        this._postalCode = _postalCode;
    }

    public String getPhone() {
        return _phone;
    }

    public void setPhone(String _phone) {
        this._phone = _phone;
    }
   
}
