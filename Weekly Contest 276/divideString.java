public String[] divideString(String s, int k, char fill) {
        
        //		System.out.println(s.length());
		int len = s.length();
		String[] res;
		if(s.length()%k != 0) {
			res = new String[(s.length()/k)+1];
		}else {
			res = new String[(s.length()/k)];
		}
//		String[] res = new String[(s.length()/k)+1];
		int i = 0;
		while(s.length() > k){
			String temp = s.substring(0, k);
			s = s.substring(k, s.length());
			res[i] = temp;
			i++;
			
		}
		res[res.length - 1] = s;
		if(s.length()%k != 0) {
			String toFill = "" + fill;
			res[res.length - 1] = res[res.length - 1] + toFill.repeat(res.length*k - len);
		}
		for(int j = 0;j < res.length;j++) {
			System.out.println(res[j]);
		}
		return res;
 }
