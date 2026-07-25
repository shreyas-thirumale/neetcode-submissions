class TimeMap {
    private Map<String, List<Store>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            List<Store> temp = map.get(key);
            temp.add(new Store(value, timestamp));
            map.put(key, temp);
        } else {
            List<Store> temp = new ArrayList<>();
            temp.add(new Store(value, timestamp));
            map.put(key, temp);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Store> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;
        String ret = "";
        while (left <= right) {
            int mid = (left + right) / 2;
            int time = list.get(mid).timestamp;
            String st = list.get(mid).val;
            if (time == timestamp) return st;
            else if (time < timestamp) {
                ret = st;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ret;
    }
}

class Store {
    String val;
    int timestamp;
    public Store(String str, int time) {
        val = str;
        timestamp = time;
    }
}
