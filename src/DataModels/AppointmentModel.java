
package DataModels;

public class AppointmentModel extends BaseDataModel{
    private String _title;
    private String _description;
    private String _location;
    private String _contact;
    private String _type;
    private String _url;

    public String getTitle() {
        return _title;
    }

    public void setTitle(String _title) {
        this._title = _title;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String _description) {
        this._description = _description;
    }

    public String getLocation() {
        return _location;
    }

    public void setLocation(String _location) {
        this._location = _location;
    }

    public String getContact() {
        return _contact;
    }

    public void setContact(String _contact) {
        this._contact = _contact;
    }

    public String getType() {
        return _type;
    }

    public void setType(String _type) {
        this._type = _type;
    }

    public String getUrl() {
        return _url;
    }

    public void setUrl(String _url) {
        this._url = _url;
    }
}
