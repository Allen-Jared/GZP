
package DataModels;

import java.sql.Timestamp;

public class BaseDataModel {
    private Timestamp _createDate;
    private String _createdBy;
    private Timestamp _lastUpdate;
    private String _lastUpdateBy;

    public Timestamp getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Timestamp _createDate) {
        this._createDate = _createDate;
    }

    public String getCreatedBy() {
        return _createdBy;
    }

    public void setCreatedBy(String _createdBy) {
        this._createdBy = _createdBy;
    }

    public Timestamp getLastUpdate() {
        return _lastUpdate;
    }

    public void setLastUpdate(Timestamp _lastUpdate) {
        this._lastUpdate = _lastUpdate;
    }

    public String getLastUpdateBy() {
        return _lastUpdateBy;
    }

    public void setLastUpdateBy(String _lastUpdateBy) {
        this._lastUpdateBy = _lastUpdateBy;
    }
    
}
