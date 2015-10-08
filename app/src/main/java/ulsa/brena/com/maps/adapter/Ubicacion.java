package ulsa.brena.com.maps.adapter;

/**
 * Created by DanielBrena on 08/10/15.
 */
public class Ubicacion {
    private String name;
    private String lat;
    private String lng;

    public Ubicacion(String name, String lat, String lng) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
