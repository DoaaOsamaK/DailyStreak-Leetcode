class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<String>hs=new HashSet<>();
        hs.add(0+" "+0);
        int[]a={0,0};
        for(int i=0;i<path.length();i++){
              if(path.charAt(i)=='N'){
                  a[0]++;
                  if(hs.contains(a[0]+" "+a[1]))return true;
                  hs.add(a[0]+" "+a[1]);
              }
              else if(path.charAt(i)=='E'){
                  a[1]++;
                  if(hs.contains(a[0]+" "+a[1]))return true;
                    hs.add(a[0]+" "+a[1]);
              }
               else if(path.charAt(i)=='W'){
                   a[1]--;
if(hs.contains(a[0]+" "+a[1]))return true;
                     hs.add(a[0]+" "+a[1]);

              }
               else if(path.charAt(i)=='S'){
                  a[0]--;
                  if(hs.contains(a[0]+" "+a[1]))return true;
                    hs.add(a[0]+" "+a[1]);
              }

        }
          return false;
    }
}