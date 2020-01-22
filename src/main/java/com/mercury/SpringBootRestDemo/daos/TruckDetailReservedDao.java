package com.mercury.SpringBootRestDemo.daos;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mercury.SpringBootRestDemo.beans.MyTruckDetail;
import com.mercury.SpringBootRestDemo.beans.TruckDetailReserved;

public interface TruckDetailReservedDao extends JpaRepository<TruckDetailReserved, Integer> {
	List<TruckDetailReserved> findAllByOrderByStartdate();

	List<TruckDetailReserved> findAllByStartdateBetweenOrEnddateBetween(Date picUpDate0, Date returnDate0,
			Date pickUpDate1, Date returnDate1);

	// List<TruckDetailReserved> findAllByStartdateAfterOrEnddateBefore(Date
	// returnDate, Date pickUpDate);
	@Query("select distinct t.truckDetail from TruckDetailReserved t where t.startdate between :pickUpDate and :returnDate or t.enddate between :pickUpDate and :returnDate")
	List<MyTruckDetail> findAllTruckReservedBetween(@Param("pickUpDate") Date pickUpDate,
			@Param("returnDate") Date returnDate);

	// @Query(value = "select t1.amount from (select TRUCKMODELID, count(*) as
	// amount from TRUCKDETAIL_RESERVED group by TRUCKMODELID) t1 where
	// t1.TRUCKMODELID = :truckmodelid", nativeQuery=true)
	// int reserverdModelCount(@Param("truckmodelid") int truckmodelid);
	@Query(value = "select t1.amount  from (select TRUCKMODELID, count(*) as amount  from TRUCKDETAIL_RESERVED t"
			+ " where t.STARTDATE BETWEEN :pickUpDate and :returnDate "
			+ "OR t.ENDDATE BETWEEN :pickUpDate and :returnDate "
			+ "group by TRUCKMODELID) t1 where t1.TRUCKMODELID= :truckmodelid", nativeQuery = true)
	Integer reserverdModelCount(@Param("pickUpDate") Date pickUpDate, @Param("returnDate") Date returnDate, @Param("truckmodelid") int truckmodelid);
	
	List<TruckDetailReserved> findAllByTruckDetail(MyTruckDetail truckDetail);
}


