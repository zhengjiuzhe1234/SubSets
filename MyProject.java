

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyProject {
	public static Map<String,List<List<Integer>>> getR( Map<String,List<List<Integer>>> map){
		List<Integer> list=map.get("list").get(0);
		List<List<Integer>> lists=map.get("lists");
		List<List<Integer>> listPrev=new ArrayList<>();
		if(map.get("prev").size()>0){
			listPrev=map.get("prev");
		}
		if(listPrev!=null&&listPrev.size()>0){
			if(listPrev.size()==1){
				
			}else{
				List<List<Integer>> u=new ArrayList<>();
				for(int i=0;i<listPrev.size();i++){
					List<Integer> l=new ArrayList<>();
					l.addAll(listPrev.get(i));
					for(int j=0;j<list.size();j++){
						if(l.get(l.size()-1)<list.get(j)){
							List<Integer> list1=new ArrayList<>();
							list1.addAll(l);
							list1.add(list.get(j));
							lists.add(list1);
							u.add(list1);
						}
					}
					map.put("lists", lists);
				}
				map.put("prev", u);
				getR(map);
			}
			
		}else{
			List<List<Integer>> u=new ArrayList<>();
			for(int i=0;i<list.size();i++){
				List<Integer> l=new ArrayList<>();
				l.add(list.get(i));
				lists.add(l);
				u.add(l);
			}
			map.put("prev", u);
			map.put("lists",lists);
			getR(map);
		}
		return map;
	}
	
	public static void main(String[] args) {
		List<Integer> l=new ArrayList<>();
		Map<String,List<List<Integer>>> map=new HashMap<>();
		List<List<Integer>> m=new ArrayList<>();
		List<List<Integer>> n=new ArrayList<>();
		List<List<Integer>> u=new ArrayList<>();
		map.put("lists",n);
		map.put("prev", u);
		l.add(1);
		l.add(4);
		l.add(6);
		l.add(7);
		l.add(8);
		m.add(l);
		map.put("list", m);
		map=getR(map);
		List<List<Integer>> lists1=map.get("lists");
		List<Integer> l1=new ArrayList<Integer>();
		lists1.add(l1);
		map.put("lists", lists1);
		System.out.println(lists1);
	}
}
