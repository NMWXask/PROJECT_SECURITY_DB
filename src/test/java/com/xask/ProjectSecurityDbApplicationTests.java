package com.xask;

import com.xask.database.entity.Department;
import com.xask.database.util.HibernateUtil;
import lombok.Cleanup;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectSecurityDbApplicationTests {

//	@Test
//	void checkOneToMany() {
//		@Cleanup var session = HibernateUtil.openSession();
//
//		session.beginTransaction();
//
//		var department = session.get(Department.class,1);
//		System.out.println(department.getSecurities());
//
//		session.getTransaction().commit();
//	}

}
