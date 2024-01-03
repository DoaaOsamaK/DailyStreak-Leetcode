class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int m = bank[0].length();

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++) {
            int securityDevicesCount = 0;
            for(int j=0;j<m;j++) {
                char ch = bank[i].charAt(j);
                if(ch == '1') securityDevicesCount++;
            }
            if(securityDevicesCount > 0) {
                list.add(securityDevicesCount);
            }
        }

        int floors = list.size();
        int lasers = 0;

        for(int i=1;i<floors;i++) {
            int topFloor =list.get(i);
            int bottomFloor = list.get(i-1);
            lasers += (topFloor * bottomFloor);
        }

        return lasers;
    }
}