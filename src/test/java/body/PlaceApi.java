package body;

import java.util.ArrayList;
import java.util.List;

import pojo.GetPlaceDetails;
import pojo.Location;

public class PlaceApi {

	public GetPlaceDetails AddPlaceBody(){
		 GetPlaceDetails gpd=new GetPlaceDetails();
	        gpd.setAccuracy(50);
	        gpd.setAddress("29, side layout, cohen 09");
	        gpd.setLanguage("French-IN");
	        gpd.setWebsite("http://google.com");
	        Location l=new Location();
	        l.setLat(-38.383494);
	        l.setLng(33.427362);
	        gpd.setLocation(l);
	        gpd.setPhone_number("(+91) 983 893 3937");
	        gpd.setName("Frontline house");
	        List<String> typeslist=new ArrayList<String>();
	        typeslist.add("shoe park");
	        typeslist.add("shop");
	        gpd.setTypes(typeslist);
	        return gpd;
		

	}

}
