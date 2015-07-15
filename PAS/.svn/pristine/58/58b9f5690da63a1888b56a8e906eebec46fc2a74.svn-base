/*
*Create by CodeGenerator
*daoTemplate
*M U G I
*/

package co.id.pegadaian.pasg2.dao;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import co.id.pegadaian.pasg2.pojo.TblMenu;

public class TblMenuDAO {
	private Session session;
	
	public TblMenuDAO(Session session){
		this.session = session;
	}
	
	
	public void insert(TblMenu tblmenu){
		session.save(tblmenu);
	}
		
	public void delete(TblMenu tblmenu){
		session.delete(tblmenu);
	}
	
	public void update(TblMenu tblmenu){
		session.update(tblmenu);
	}
//====================================================================	
	public TblMenu getById(BigDecimal  menuId){
		Criteria criteria =null;
		criteria = session.createCriteria(TblMenu.class);
                    if (menuId.doubleValue()>0){criteria.add(Restrictions.eq("menuId", menuId)); 	}

		return (TblMenu)  criteria.uniqueResult();//session.get(TblMenu.class, id);
	}
	
	public List<TblMenu> getAll(){
		return (List<TblMenu>) session.createCriteria(TblMenu.class).list();
	}
	
	
	
	public Long getAllCount(){
		return (Long) session.createCriteria(TblMenu.class).setProjection(Projections.rowCount()).uniqueResult();
	}

	public List<TblMenu> getAll(int start, int rowcount ){
		return (List<TblMenu>) session.createCriteria(TblMenu.class).setFirstResult(start).setMaxResults(rowcount).list();
	}

/*//SESUAIKAN DENGAN KRITERIA*/	
	public Criteria getCriteria(BigDecimal MenuId,String MenuName,BigDecimal ParentId){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Criteria criteria =null;
		criteria = session.createCriteria(TblMenu.class);
                    if (MenuId.doubleValue()>0){criteria.add(Restrictions.eq("menuId", MenuId)); 	}
                    if (MenuName.length()>0){criteria.add(Restrictions.eq("menuName", MenuName)); 	}
                    if (ParentId.doubleValue()>0){criteria.add(Restrictions.eq("parentId", ParentId)); 	}
		
		return criteria;
	}

	public List<TblMenu> getBy(BigDecimal MenuId,String MenuName,BigDecimal ParentId ,int start, int rowcount ){
		Criteria criteria =getCriteria(MenuId,MenuName,ParentId);
		return (List<TblMenu>) criteria.setFirstResult(start).setMaxResults(rowcount).list();
	}
	
	public Long getByCount(BigDecimal MenuId,String MenuName,BigDecimal ParentId, int start, int rowcount  ){
		Criteria criteria =getCriteria(MenuId,MenuName,ParentId);
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public Map<String,Object> getByPerPage(BigDecimal MenuId,String MenuName,BigDecimal ParentId ,int start, int rowcount ){
		Map map = new HashMap<String, Object>();		
		long rowCount =  getByCount(MenuId,MenuName,ParentId,  start,rowcount);//total jumlah row
		List<TblMenu> l = getBy(MenuId,MenuName,ParentId, start,rowcount);//data result nya
		map.put("total", rowCount);
		map.put("rows", l);
		return map;
	}

//==============================REPORT====================================
/** Retrieve by kriteria tanpa batasan row */
	public List<TblMenu> getBy(BigDecimal MenuId,String MenuName,BigDecimal ParentId  ){
		Criteria criteria =getCriteria(MenuId,MenuName,ParentId);
		return (List<TblMenu>) criteria.list();
	}


}
