import java.util.HashMap;
import java.util.Set;
class MapHashMatique{
    public static void main(String[] args){
        HashMap<String,String> trackList =new HashMap <String, String>();
        trackList.put("Track1","Lyrics1");
        trackList.put("Track2", "Lyrics2");
        trackList.put("Track3", "Lyrics3");
        trackList.put("Track4", "Lyrics4");
        trackList.put("Track5", "Lyrics5");
        trackList.put("Track6", "Lyrics6");
        Set<String> keys = trackList.keySet();
        System.out.println(trackList.get("Track2"));
        for(String key : keys) {
            System.out.println(key+":"+trackList.get(key));    
        }
    }
}