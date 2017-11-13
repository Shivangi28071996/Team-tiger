package com.gw.RealEstate.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.gw.RealEstate.Entity.PersonalDetails;
import com.gw.RealEstate.Entity.PropertyDetails;
import com.gw.RealEstate.Util.hibernateUtil;

@Repository
public class PropertyDAO {

	public List<PersonalDetails> getdetail() {
		// TODO Auto-generated method stub
		Session sess=hibernateUtil.getSessionFactory().openSession();
		sess.beginTransaction();
		List<PersonalDetails> data=sess.createQuery("FROM PersonalDetails").list();
		sess.getTransaction().commit();
		sess.close();
		return data;
	}

	
	public void post(PersonalDetails pd) {
		// TODO Auto-generated method stub
		Session session=hibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		PersonalDetails pd1=new PersonalDetails();
		pd1.setFullname(pd.getFullname());
		pd1.setUsername(pd.getUsername());
		pd1.setEmail(pd.getEmail());
		pd1.setPassword(pd.getPassword());
		pd1.setPhone(pd.getPhone());
		pd1.setStat(pd.getStat());
		session.save(pd1);
		System.out.println("add personal detail successfully");
		session.getTransaction().commit();
		session.close();
	}

	public void update(int id, PersonalDetails pd2) {
		// TODO Auto-generated method stub
		Session session=hibernateUtil.getSessionFactory().openSession();
		 session.beginTransaction();
		 PersonalDetails pd=(PersonalDetails)session.get(PersonalDetails.class, id);
	      pd.setFullname(pd2.getFullname());
	      pd.setUsername(pd2.getUsername());
	      pd.setEmail(pd2.getEmail());
	      pd.setPassword(pd2.getPassword());
	      pd.setPhone(pd2.getPhone());
	      pd.setStat(pd2.getStat());
//	      pd.setPd(pd1);
	      System.out.println("Update Successfully");
	      session.getTransaction().commit();
	      session.close();     
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session=hibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		PersonalDetails pd=(PersonalDetails) session.load(PersonalDetails.class, id);
		session.delete(pd);
		System.out.println("Delete Successfully");
		session.getTransaction().commit();
		session.close();
	}


	public List<PropertyDetails> getdetail1() {
		// TODO Auto-generated method stub
		Session sess=hibernateUtil.getSessionFactory().openSession();
		sess.beginTransaction();
		List<PropertyDetails> data=sess.createQuery("FROM PropertyDetails").list();
		sess.getTransaction().commit();
		sess.close();
		return data;
	}
	
	public void post1(PropertyDetails pd1,int id) {
		// TODO Auto-generated method stub
		Session session=hibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		//System.out.println(pd1.getPd());
		PersonalDetails pd=(PersonalDetails)session.get(PersonalDetails.class, id);
		//pd1.setPd(pd);
		List<PersonalDetails> listpd=session.createQuery("FROM PersonalDetails").list();
		for(int i=0;i<listpd.size();i++){
			PersonalDetails prop=listpd.get(i);
			if(prop==pd){
				pd1.setPd(pd);
			}
		}
		session.save(pd1);
		System.out.println("add property detail successfully");
		session.getTransaction().commit();
		session.close();
	}


	public void update1(PropertyDetails pd1,int id) {
		// TODO Auto-generated method stub
		if(pd1!=null){
		Session session=hibernateUtil.getSessionFactory().openSession();
		System.out.println(pd1);
		Transaction transaction=null;
		try{ 
		transaction=session.beginTransaction();
//		int id=pd1.getPropId();
		PropertyDetails pd2=session.get(PropertyDetails.class,id);
				pd2.setTitle(pd1.getTitle());
				pd2.setPropStatus(pd1.getPropStatus());
				pd2.setType(pd1.getType());
				pd2.setPrice(pd1.getPrice());
				pd2.setArea(pd1.getArea());
				pd2.setRooms(pd1.getRooms());
				pd2.setBathroom(pd1.getBathroom());
				pd2.setAddress(pd1.getAddress());
				pd2.setpostalcode(pd1.getpostalcode());
				pd2.setInfo(pd1.getInfo());
				pd2.setParking(pd1.isParking());
				pd2.setAc(pd1.isAc());
				pd2.setSit(pd1.isSit());
				pd2.setPool(pd1.isPool());
				pd2.setlaundry(pd1.islaundry());
				pd2.setWindow(pd1.isWindow());
				pd2.setHeating(pd1.isHeating());
				pd2.setAlarm(pd1.isAlarm());
				pd2.setGym(pd1.isGym());
				pd2.setName(pd1.getName());
				pd2.setEmail(pd1.getEmail());
				pd2.setPhone(pd1.getPhone());
				session.update(pd2);
				transaction.commit();
	      System.out.println("Update property Successfully");
		}catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		}
		else{
			System.out.println("object is null");
		}
	      
	}
	
	
//	public void delete1(int id) {
//		// TODO Auto-generated method stub
//		Session session=hibernateUtil.getSessionFactory().openSession();
//		Transaction transaction=null;
//		try{ 
//		transaction=session.beginTransaction();
////		int id=pd1.getPropId();
//		PropertyDetails pd2=session.get(PropertyDetails.class,id);
//				session.delete(pd2);
//				transaction.commit();
//	      System.out.println("Delete property Successfully");
//		}catch(HibernateException e){
//			transaction.rollback();
//			e.printStackTrace();
//		}finally{
//			session.close();
//		}
//	}

}
	