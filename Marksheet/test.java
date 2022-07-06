package Marksheet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test {
	
	public static void main(String[] args) throws Exception {
		//testAdd();
		//testUpdate();
		//testDelete();
		//testGet();
		testSearch();
		//testGetMeritList();
	}

	private static void testGetMeritList() throws Exception {
	
		MarksheetModel model = new MarksheetModel();
		
		List<MarksheetBean> list = model.getMeritList();
		
		Iterator<MarksheetBean> it = list.iterator();
		
		while (it.hasNext()) {
			MarksheetBean mb = (MarksheetBean) it.next();
			
			System.out.print("\t" + mb.getRollno());
			System.out.print("\t" + mb.getName());
			System.out.print("\t" + mb.getPhysics());
			System.out.print("\t" + mb.getChemistry());
			System.out.println("\t" + mb.getMaths());
		}
	}

	private static void testSearch() throws Exception {
	
		MarksheetModel model = new MarksheetModel();
		
		List<MarksheetBean> list = model.search();
		
		Iterator<MarksheetBean> it = list.iterator();
		
		while (it.hasNext()) {
			MarksheetBean mb = (MarksheetBean) it.next();
			
			System.out.print("\t" + mb.getRollno());
			System.out.print("\t" + mb.getName());
			System.out.print("\t" + mb.getPhysics());
			System.out.print("\t" + mb.getChemistry());
			System.out.println("\t" + mb.getMaths());
		}
	}

	private static void testGet() throws Exception {
		
		MarksheetBean mb = new MarksheetBean();
		mb.setRollno("shubh123");
		
		MarksheetModel mm = new MarksheetModel();
		
		List<MarksheetBean> list = mm.testGet(mb);
		
		Iterator<MarksheetBean> it = list.iterator();
		
		while (it.hasNext()) {
			MarksheetBean mb1 = (MarksheetBean) it.next();
			
			System.out.print("\t" + mb1.getRollno());
			System.out.print("\t" + mb1.getName());
			System.out.print("\t" + mb1.getPhysics());
			System.out.print("\t" + mb1.getChemistry());
			System.out.println("\t" + mb1.getMaths());
		}		
	}

	private static void testDelete() throws Exception {
		
		MarksheetBean mb = new MarksheetBean();
		
		MarksheetModel mm = new MarksheetModel();
		
		mb.setRollno("shubh143");
		
		mm.testDelete(mb);
		System.out.println("Deleted");
		
	}

	private static void testUpdate() throws Exception {
		
		MarksheetBean mb = new MarksheetBean();
		
		MarksheetModel mm = new MarksheetModel();
		
		mb.setRollno("shubh123");
		mb.setName("shubh");
		mb.setPhysics(91);
		mb.setChemistry(95);
		mb.setMaths(84);
		
		
		mm.testUpdate(mb);
		System.out.println("updated");
	}

	private static void testAdd() throws Exception {
		
		MarksheetBean mb = new MarksheetBean();
		
		MarksheetModel mm = new MarksheetModel();
		
		
		mb.setRollno("shubhh143");
		mb.setName("utkarsh");
		mb.setPhysics(91);
		mb.setChemistry(48);
		mb.setMaths(84);
		
		mm.testAdd(mb);
		System.out.println("ok");
		
	}
}